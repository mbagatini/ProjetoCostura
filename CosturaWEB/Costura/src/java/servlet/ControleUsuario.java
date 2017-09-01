/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsuarioDAO;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Morgana
 */
public class ControleUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        System.out.println("Entrei no GET!");

        String parametro = request.getParameter("parametro");
        System.out.println("Parametro: " + parametro);
        
        if (parametro.equals("upd")) {
            int id = Integer.parseInt(String.valueOf(request.getParameter("id")));

            Usuario usuario = (Usuario) new UsuarioDAO().consultarId(id);

            request.setAttribute("ObjUser", usuario);

            encaminharPagina("usuario.jsp", request, response);
        }

        if (parametro.equals("del")) {
            int id = Integer.parseInt(String.valueOf(request.getParameter("id")));

            String retorno = new UsuarioDAO().excluir(id);

            request.setAttribute("paginaOrigem", "usuario.jsp");
            
            if (retorno == null) {
                encaminharPagina("sucesso.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        System.out.println("Entrei no POST!");

        String parametro = request.getParameter("parametro");
        
        // AQUI DEVE SER FEITA A VALIDACAO
        // ANTES DE GRAVAR NO BANCO

        if (parametro.equals("ins")) {
            
            Usuario u = new Usuario();

            u.setNome(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("senha"));

            String retorno = new UsuarioDAO().salvar(u);

            if (retorno == null) {
                encaminharPagina("sucesso.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        } else if (parametro.equals("del")) {
            
            Usuario u = new Usuario();

            int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
            u.setId(id);
            u.setNome(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("senha"));

            String retorno = new UsuarioDAO().excluir(u.getId());

            if (retorno == null) {
                encaminharPagina("sucesso.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }

}