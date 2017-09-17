package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import apoio.Constantes;
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navegacao.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");

            Usuario usuario = (Usuario) request.getAttribute("atributo");

            if (usuario == null) {
                usuario = new Usuario();
            }
        
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body class=\"hold-transition skin-red sidebar-mini\">\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("            <div class=\"content-wrapper\">\r\n");
      out.write("                <!-- Content Header (Page header) -->\r\n");
      out.write("                <section class=\"content-header\">\r\n");
      out.write("                    <h1>Usuários</h1>\r\n");
      out.write("                    <ol class=\"breadcrumb\">\r\n");
      out.write("                        <li><a href=\"");
      out.print( Constantes.PAGINA_MENU);
      out.write("\"><i class=\"fa fa-home\"></i> Início</a></li>\r\n");
      out.write("                        <li class=\"active\">Usuários</li>\r\n");
      out.write("                    </ol>\r\n");
      out.write("                </section>\r\n");
      out.write("                        \r\n");
      out.write("                <!-- Main content -->\r\n");
      out.write("                <section class=\"content\">\r\n");
      out.write("                    <!-- Horizontal Form -->\r\n");
      out.write("                    <div class=\"box box-info\">\r\n");
      out.write("                        <div class=\"box-header with-border\">\r\n");
      out.write("                            <h3 class=\"box-title\">Cadastro</h3>\r\n");
      out.write("                            <div class=\"box-tools pull-right\">\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\" data-toggle=\"tooltip\" title=\"Minimizar/Maximizar\">\r\n");
      out.write("                                    <i class=\"fa fa-minus\"></i></button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /.box-header --> \r\n");
      out.write("                        <!-- form start -->\r\n");
      out.write("                        <form class=\"form-horizontal\" name=\"cadastroUsuario\" action=\"/Costura/Controle?parametro=usuario&manut=ins\" method=\"post\">\r\n");
      out.write("                            <div class=\"box-body\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( usuario.getCodigo());
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Nome</label>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"nome\" value=\"");
      out.print( usuario.getNome());
      out.write("\" required placeholder=\"Nome\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">E-mail</label>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" name=\"email\" value=\"");
      out.print( usuario.getEmail());
      out.write("\" required placeholder=\"E-mail\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Senha</label>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" name=\"senha\" required placeholder=\"Senha\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- /.box-body -->\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"box-footer\">\r\n");
      out.write("                                <button type=\"submit\" name=\"enviar\" class=\"btn btn-info pull-right\">Salvar</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- /.box-footer -->\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.box -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Adiciona a listagem de usuários -->\r\n");
      out.write("                    ");
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
      out.write("        <!-- DataTables -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/datatables/dataTables.bootstrap.css\">\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <div class=\"box\">\n");
      out.write("        <div class=\"box-header\">\n");
      out.write("            <h3 class=\"box-title\">Listagem</h3>\n");
      out.write("            <div class=\"box-tools pull-right\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\" data-toggle=\"tooltip\" title=\"Minimizar/Maximizar\">\n");
      out.write("                    <i class=\"fa fa-minus\"></i></button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.box-header -->\n");
      out.write("\n");
      out.write("        <div class=\"box-body\">\n");
      out.write("            <table id=\"example1\" class=\"table table-bordered table-striped\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Código</th>\n");
      out.write("                        <th>Nome</th>\n");
      out.write("                        <th>E-mail</th>\n");
      out.write("                        <th>Editar</th>\n");
      out.write("                        <th>Excluir</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        ArrayList<Usuario> usuarios = new UsuarioDAO().consultarTodos();

                        for (int i = 0; i < usuarios.size(); i++) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( usuarios.get(i).getCodigo());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( usuarios.get(i).getNome());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( usuarios.get(i).getEmail());
      out.write("</td>\n");
      out.write("                        <td><a href=\"/Costura/Controle?parametro=usuario&manut=upd&id=");
      out.print( usuarios.get(i).getCodigo());
      out.write("\" class=\"fa fa-pencil-square-o\"></a></td>\n");
      out.write("                        <td><a href=\"/Costura/Controle?parametro=usuario&manut=del&id=");
      out.print( usuarios.get(i).getCodigo());
      out.write("\" class=\"fa fa-trash-o\"></a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot>\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.box-body -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.box --> \n");
      out.write("    \n");
      out.write("    <!-- DataTables -->\n");
      out.write("    <script src=\"plugins/datatables/jquery.dataTables.min.js\"></script>\n");
      out.write("    <script src=\"plugins/datatables/dataTables.bootstrap.min.js\"></script>\n");
      out.write("    <!-- page script -->\n");
      out.write("    <script>\n");
      out.write("        $(function () {\n");
      out.write("            $(\"#example1\").DataTable();\n");
      out.write("            $('#example2').DataTable({\n");
      out.write("                \"paging\": true,\n");
      out.write("                \"lengthChange\": false,\n");
      out.write("                \"searching\": false,\n");
      out.write("                \"ordering\": true,\n");
      out.write("                \"info\": true,\n");
      out.write("                \"autoWidth\": false\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </section>\r\n");
      out.write("                <!-- /.content -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.content-wrapper -->\r\n");
      out.write("            \r\n");
      out.write("            <!-- footer -->\r\n");
      out.write("            <footer class=\"main-footer\">\r\n");
      out.write("                <div class=\"pull-right hidden-xs\">\r\n");
      out.write("                    <b>Versão</b> 1.0\r\n");
      out.write("                </div>\r\n");
      out.write("                <strong>Copyright &copy; 2017 </strong>\r\n");
      out.write("            </footer>     \r\n");
      out.write("            <!-- /.footer -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- ./wrapper -->\r\n");
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
