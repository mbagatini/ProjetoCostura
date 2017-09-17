/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controle.ControleCategoria;
import controle.ControleUsuario;
import apoio.Constantes;
import dao.UsuarioDAO;
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
                ControleUsuario.editar(request, response);
            } else if (manutencao.equals("del")) {
                ControleUsuario.excluir(request, response);
            }
        }

        if (parametro.equals("categoria")) {
            if (manutencao.equals("upd")) {
                ControleCategoria.editar(request, response);
            } else if (manutencao.equals("del")) {
                ControleCategoria.excluir(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        System.out.println("Entrei no POST!");

        String parametro = request.getParameter("parametro");
        String manutencao = request.getParameter("manut");

        // AQUI DEVE SER FEITA A VALIDACAO
        // ANTES DE GRAVAR NO BANCO
        if (parametro.equals("login")) {
            validarLogin(request, response);
        }

        if (parametro.equals("usuario")) {
            ControleUsuario.cadastrar(request, response);
        }

        if (parametro.equals("categoria")) {
            ControleCategoria.cadastrar(request, response);
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

    private void validarLogin(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        
        HttpSession sessao = request.getSession();

        if (new UsuarioDAO().consultar(usuario)) {
            // usuario validado: cria coloca seu nome na sessao
            // setando um atributo da sessao
            sessao.setAttribute("usuarioLogado", usuario);
            encaminharPagina(Constantes.PAGINA_MENU, request, response);
        } else {
            // setando um atributo da sessao
            sessao.setAttribute("falhaLogin", true);
            encaminharPagina(Constantes.PAGINA_LOGIN, request, response);
        }
    }

}
