package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.UsuarioDAO;
import java.util.ArrayList;
import entidade.Usuario;

public final class usuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/usuarioListagem.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Usuários</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            Usuario usuario = (Usuario) request.getAttribute("ObjUser");

            if (usuario == null) {
                usuario = new Usuario();
            }
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h1>Cadastro de usuários</h1>\r\n");
      out.write("\r\n");
      out.write("        <form name=\"cadastroUsuario\" action=\"/Costura/Controle?parametro=usuario&manut=ins\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( usuario.getCodigo());
      out.write("\">\r\n");
      out.write("            \r\n");
      out.write("            <label>Nome</label>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"text\" name=\"nome\" value=\"");
      out.print( usuario.getNome());
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("\r\n");
      out.write("            <label>E-mail</label>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"email\" name=\"email\" value=\"");
      out.print( usuario.getEmail());
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("\r\n");
      out.write("            <label>Senha</label>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"password\" name=\"senha\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"submit\" name=\"enviar\" value=\"Salvar\">\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Adiciona a listagem de usuários -->\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Costura</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Usuários cadastrados</h1>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Código</th>\n");
      out.write("                <th>Nome</th>\n");
      out.write("                <th>E-mail</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Usuario> usuarios = new UsuarioDAO().consultarTodos();

                for (int i = 0; i < usuarios.size(); i++) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( usuarios.get(i).getCodigo());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( usuarios.get(i).getNome());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( usuarios.get(i).getEmail());
      out.write("</td>\n");
      out.write("                <td><a href=\"/Costura/Controle?parametro=usuario&manut=upd&id=");
      out.print( usuarios.get(i).getCodigo());
      out.write("\">Editar</a></td>\n");
      out.write("                <td><a href=\"/Costura/Controle?parametro=usuario&manut=del&id=");
      out.print( usuarios.get(i).getCodigo());
      out.write("\">Excluir</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
