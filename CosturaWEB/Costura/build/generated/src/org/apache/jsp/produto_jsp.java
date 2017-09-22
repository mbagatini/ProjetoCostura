package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.CategoriaDAO;
import entidade.Categoria;
import java.util.ArrayList;
import entidade.Produto;
import entidade.Tamanho;
import apoio.Constantes;
import dao.ProdutoDAO;
import entidade.Produto;
import java.util.ArrayList;

public final class produto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/produtoListagem.jsp");
    _jspx_dependants.add("/footer.jsp");
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
      out.write("\r\n");
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
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");

        Produto produto = (Produto) request.getAttribute("atributo");

        if (produto == null) {
            produto = new Produto();
        }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body class=\"hold-transition skin-red sidebar-mini\">\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("            <div class=\"content-wrapper\">\r\n");
      out.write("                <!-- Content Header (Page header) -->\r\n");
      out.write("                <section class=\"content-header\">\r\n");
      out.write("                    <h1>Produtos</h1>\r\n");
      out.write("                    <ol class=\"breadcrumb\">\r\n");
      out.write("                        <li><a href=\"");
      out.print( Constantes.PAGINA_MENU);
      out.write("\"><i class=\"fa fa-home\"></i> Início</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Produtos</a></li>\r\n");
      out.write("                        <li class=\"active\">Produtos</li>\r\n");
      out.write("                    </ol>\r\n");
      out.write("                </section>\r\n");
      out.write("\r\n");
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
      out.write("                        <!-- /.box-header -->\r\n");
      out.write("                        <!-- form start -->\r\n");
      out.write("                        <form class=\"form-horizontal\" name=\"cadastroProduto\" action=\"/Costura/Controle?parametro=produto&manut=ins\" method=\"post\">\r\n");
      out.write("                            <div class=\"box-body\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( produto.getCodigo());
      out.write("\">\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Referência</label>\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" name=\"referencia\" value=\"");
      out.print( (produto.getReferencia() == 0) ? "" : produto.getReferencia() );
      out.write("\" required placeholder=\"Referência\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Descrição</label>\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"descricao\" value=\"");
      out.print( produto.getDescricao());
      out.write("\" required placeholder=\"Descrição\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Preço</label>\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" name=\"preco\" value=\"");
      out.print( (produto.getPreco() == 0) ? "" : produto.getPreco() );
      out.write("\" required placeholder=\"Preço\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Gênero</label>\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <!-- select -->\r\n");
      out.write("                                        <select class=\"form-control\" name=\"genero\" value=\"");
      out.print( produto.getGenero());
      out.write("\" required placeholder=\"Gênero\">\r\n");
      out.write("                                            <option value=\"0\">Selecione</option>\r\n");
      out.write("                                            <option>Feminino</option>\r\n");
      out.write("                                            <option>Masculino</option>\r\n");
      out.write("                                            <option>Unisex</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                        <!-- /.select -->\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-sm-1 control-label\">Categoria</label>\r\n");
      out.write("                                    <div class=\"col-sm-10\">\r\n");
      out.write("                                        <!-- select -->\r\n");
      out.write("                                        <select class=\"form-control\" name=\"categoria\"  required placeholder=\"Categoria\">\r\n");
      out.write("                                            <option value=\"0\">Selecione</option>\r\n");
      out.write("\r\n");
      out.write("                                            ");

                                                ArrayList<Categoria> cat = new CategoriaDAO().consultarTodos();
                                                for (int i = 0; i < cat.size(); i++) {
                                            
      out.write("\r\n");
      out.write("                                            <option value=\"");
      out.print( cat.get(i).getCodigo());
      out.write('"');
      out.write('>');
      out.print( cat.get(i).getDescricao());
      out.write("</option>\r\n");
      out.write("                                            ");
  }  
      out.write("\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                        <!-- /.select -->\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- /.box-body -->\r\n");
      out.write("                            <div class=\"box-footer\">\r\n");
      out.write("                                <button type=\"submit\" name=\"enviar\" class=\"btn btn-info pull-right\">Salvar</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- /.box-footer -->\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.box -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Adiciona a listagem de tamanhos -->\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <!-- DataTables -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/datatables/dataTables.bootstrap.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-xs-12\">\r\n");
      out.write("            <div class=\"box\">\r\n");
      out.write("                <div class=\"box-header\">\r\n");
      out.write("                    <h3 class=\"box-title\">Listagem</h3>\r\n");
      out.write("                    <div class=\"box-tools pull-right\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\" data-toggle=\"tooltip\" title=\"Minimizar/Maximizar\">\r\n");
      out.write("                            <i class=\"fa fa-minus\"></i></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-header -->\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <table id=\"example1\" class=\"table table-bordered table-striped\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>Referência</th>\r\n");
      out.write("                                <th>Descrição</th>\r\n");
      out.write("                                <th>Preço</th>\r\n");
      out.write("                                <th>Gênero</th>\r\n");
      out.write("                                <th>Categoria</th>\r\n");
      out.write("                                <th>Editar</th>\r\n");
      out.write("                                <th>Excluir</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            ");

                                ArrayList<Produto> produtos = new ProdutoDAO().consultarTodos();

                                for (int i = 0; i < produtos.size(); i++) {
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>");
      out.print( produtos.get(i).getReferencia());
      out.write("</td>\r\n");
      out.write("                                <td>");
      out.print( produtos.get(i).getDescricao());
      out.write("</td>\r\n");
      out.write("                                <td>");
      out.print( produtos.get(i).getPreco());
      out.write("</td>\r\n");
      out.write("                                <td>");
      out.print( produtos.get(i).getGenero());
      out.write("</td>\r\n");
      out.write("                                <td>");
      out.print( produtos.get(i).getCategoria().getDescricao());
      out.write("</td>\r\n");
      out.write("                                <td><a href=\"/Costura/Controle?parametro=categoria&manut=upd&id=");
      out.print( produtos.get(i).getCodigo());
      out.write("\" class=\"fa fa-pencil-square-o\"></a></td>\r\n");
      out.write("                                <td><a href=\"/Costura/Controle?parametro=categoria&manut=del&id=");
      out.print( produtos.get(i).getCodigo());
      out.write("\" class=\"fa fa-trash-o\"></a></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                        <tfoot>\r\n");
      out.write("                        </tfoot>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-body -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("    <!-- DataTables -->\r\n");
      out.write("    <script src=\"plugins/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("    <script src=\"plugins/datatables/dataTables.bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- page script -->\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $(\"#example1\").DataTable();\r\n");
      out.write("            $('#example2').DataTable({\r\n");
      out.write("                \"paging\": true,\r\n");
      out.write("                \"lengthChange\": false,\r\n");
      out.write("                \"searching\": false,\r\n");
      out.write("                \"ordering\": true,\r\n");
      out.write("                \"info\": true,\r\n");
      out.write("                \"autoWidth\": false\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("                </section>\r\n");
      out.write("                <!-- /.content -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.content-wrapper -->\r\n");
      out.write("\r\n");
      out.write("            <!-- Adiciona o footer -->\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <!-- footer -->\n");
      out.write("    <footer class=\"main-footer\">\n");
      out.write("        <div class=\"pull-right hidden-xs\">\n");
      out.write("            <b>Versão</b> 1.0\n");
      out.write("        </div>\n");
      out.write("        <strong>Copyright &copy; 2017 </strong>\n");
      out.write("    </footer>     \n");
      out.write("    <!-- /.footer -->\n");
      out.write("</html>\n");
      out.write("\r\n");
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
