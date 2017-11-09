/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controle.ControleCategoria;
import controle.ControleUsuario;
import apoio.Constantes;
import controle.ControleCliente;
import controle.ControlePedido;
import controle.ControleProduto;
import controle.ControleTamanho;
import dao.ProdutoDAO;
import entidade.Produto;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morgana
 */
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao aaaa aaaaaaaat " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");

        System.out.println("Entrei no GET!");

        String parametro = request.getParameter("parametro");
        String manutencao = request.getParameter("manut");

        if (parametro.equals("logout")) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            response.sendRedirect("login.jsp");
        }

        if (parametro.equals("usuario")) {
            if (manutencao.equals("upd")) {
                encaminharPagina(Constantes.CADASTRO_USUARIO, new ControleUsuario().editar(request), response);
            } else if (manutencao.equals("del")) {
                request.setAttribute("paginaRetorno", Constantes.CADASTRO_USUARIO);
                encaminharPagina(retornaPagina(new ControleUsuario().excluir(request)), request, response);
            }
        }

        if (parametro.equals("produto")) {
            if (manutencao.equals("upd")) {
                encaminharPagina(Constantes.CADASTRO_PRODUTO, new ControleProduto().editar(request), response);
            } else if (manutencao.equals("del")) {
                request.setAttribute("paginaRetorno", Constantes.CADASTRO_PRODUTO);
                encaminharPagina(retornaPagina(new ControleProduto().excluir(request)), request, response);
            }
        }

        if (parametro.equals("categoria")) {
            if (manutencao.equals("upd")) {
                encaminharPagina(Constantes.CADASTRO_CATEGORIA, new ControleCategoria().editar(request), response);
            } else if (manutencao.equals("del")) {
                request.setAttribute("paginaRetorno", Constantes.CADASTRO_CATEGORIA);
                encaminharPagina(retornaPagina(new ControleCategoria().excluir(request)), request, response);
            }
        }

        if (parametro.equals("tamanho")) {
            if (manutencao.equals("upd")) {
                encaminharPagina(Constantes.CADASTRO_TAMANHO, new ControleTamanho().editar(request), response);
            } else if (manutencao.equals("del")) {
                request.setAttribute("paginaRetorno", Constantes.CADASTRO_TAMANHO);
                encaminharPagina(retornaPagina(new ControleTamanho().excluir(request)), request, response);
            }
        }

        if (parametro.equals("cliente")) {
            if (manutencao.equals("upd")) {
                encaminharPagina(Constantes.CADASTRO_CLIENTE, new ControleCliente().editar(request), response);
            } else if (manutencao.equals("del")) {
                request.setAttribute("paginaRetorno", Constantes.CADASTRO_CLIENTE);
                encaminharPagina(retornaPagina(new ControleCliente().excluir(request)), request, response);
            }
        }

        if (parametro.equals("pedido")) {
            if (manutencao.equals("upd")) {
                encaminharPagina(Constantes.CADASTRO_PEDIDO, new ControlePedido().editar(request), response);
            } else if (manutencao.equals("del")) {
                request.setAttribute("paginaRetorno", Constantes.CADASTRO_PEDIDO);
                encaminharPagina(retornaPagina(new ControlePedido().excluir(request)), request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        System.out.println("Entrei no POST!");

        String parametro = request.getParameter("parametro");

        // AQUI DEVE SER FEITA A VALIDACAO
        // ANTES DE GRAVAR NO BANCO
        if (parametro.equals("login")) {
            Usuario user = new ControleUsuario().validarLogin(request, response);

            if (user != null) {
                // usuario validado: cria coloca seu nome na sessao
                // setando um atributo da sessao
                HttpSession sessao = request.getSession();
                // setando um atributo da sessao
                sessao.setAttribute("usuarioLogado", user);
                encaminharPagina(Constantes.PAGINA_MENU, request, response);
            } else {
                // setando um atributo da sessao
                request.setAttribute("falhaLogin", true);
                encaminharPagina(Constantes.PAGINA_LOGIN, request, response);
            }
        }

        if (parametro.equals("usuario")) {
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_USUARIO);
            encaminharPagina(retornaPagina(new ControleUsuario().cadastrar(request)), request, response);
        }

        if (parametro.equals("produto")) {
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_PRODUTO);
            encaminharPagina(retornaPagina(new ControleProduto().cadastrar(request)), request, response);
        }

        if (parametro.equals("categoria")) {
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_CATEGORIA);
            encaminharPagina(retornaPagina(new ControleCategoria().cadastrar(request)), request, response);
        }

        if (parametro.equals("tamanho")) {
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_TAMANHO);
            encaminharPagina(retornaPagina(new ControleTamanho().cadastrar(request)), request, response);
        }

        if (parametro.equals("cliente")) {
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_CLIENTE);
            encaminharPagina(retornaPagina(new ControleCliente().cadastrar(request)), request, response);
        }
        
        if (parametro.equals("pedido")) {
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_PEDIDO);
            encaminharPagina(retornaPagina(new ControlePedido().cadastrar(request)), request, response);
        }
        
        if (parametro.equals("precoProduto")){
            int produto = Integer.parseInt(request.getParameter("codigoProduto"));
            request.setAttribute("paginaRetorno", Constantes.CADASTRO_PEDIDO);
            
            Produto product = (Produto) new ProdutoDAO().consultarId(produto);
            
            System.out.println(product.getPreco());
                    
            //encaminharPagina(retornaPagina(new ControlePedido().cadastrar(request)), request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public static void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }

    private String retornaPagina(boolean flag) {
        String pagina;

        if (flag) {
            pagina = Constantes.PAGINA_SUCESSO;
        } else {
            pagina = Constantes.PAGINA_ERRO;
        }
        return pagina;
    }
}
