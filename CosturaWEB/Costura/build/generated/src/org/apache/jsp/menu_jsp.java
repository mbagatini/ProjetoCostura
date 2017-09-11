package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <title>Costura</title>\r\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"tema/bower_components/bootstrap/dist/css/bootstrap.min.css\">\r\n");
      out.write("        <!-- Font Awesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"tema/bower_components/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("        <!-- Ionicons -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"tema/bower_components/Ionicons/css/ionicons.min.css\">\r\n");
      out.write("        <!-- Theme style -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"tema/dist/css/AdminLTE.min.css\">\r\n");
      out.write("        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter\r\n");
      out.write("              page. However, you can choose any other skin. Make sure you\r\n");
      out.write("              apply the skin class to the body tag so the changes take effect. -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"tema/dist/css/skins/skin-red.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Font -->\r\n");
      out.write("        <link rel=\"stylesheet\"\r\n");
      out.write("              href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <header class=\"main-header\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Logo -->\r\n");
      out.write("                <a href=\"menu.jsp\" class=\"logo\">\r\n");
      out.write("                    <!-- mini logo for sidebar mini 50x50 pixels -->\r\n");
      out.write("                    <span class=\"logo-mini\"><b>C</b></span>\r\n");
      out.write("                    <!-- logo for regular state and mobile devices -->\r\n");
      out.write("                    <span class=\"logo-lg\"><b>Costura</b></span>\r\n");
      out.write("                </a>\r\n");
      out.write("\r\n");
      out.write("                <!-- Header Navbar: style can be found in header.less -->\r\n");
      out.write("                <nav class=\"navbar navbar-static-top\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Sidebar toggle button-->\r\n");
      out.write("                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Navbar Right Menu -->\r\n");
      out.write("                    <div class=\"navbar-custom-menu\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav\">\r\n");
      out.write("                            <!-- User Account: style can be found in dropdown.less -->\r\n");
      out.write("                            <li class=\"dropdown user user-menu\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                                    <img src=\"dist/img/profile.png\" class=\"user-image\" alt=\"User Image\">\r\n");
      out.write("                                    <span class=\"hidden-xs\">Usuário</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <ul class=\"dropdown-menu\">\r\n");
      out.write("                                    <!-- User image -->\r\n");
      out.write("                                    <li class=\"user-header\">\r\n");
      out.write("                                        <img src=\"dist/img/profile.png\" class=\"img-circle\" alt=\"User Image\">\r\n");
      out.write("                                        <p> Usuário </p>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <!-- Menu Footer-->\r\n");
      out.write("                                    <li class=\"user-footer\">\r\n");
      out.write("                                        <div class=\"pull-left\">\r\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-default btn-flat\">Perfil</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"pull-right\">\r\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-default btn-flat\">Sair</a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </header>\r\n");
      out.write("\r\n");
      out.write("            <!-- Left side column. contains the logo and sidebar -->\r\n");
      out.write("            <aside class=\"main-sidebar\">\r\n");
      out.write("                <!-- sidebar: style can be found in sidebar.less -->\r\n");
      out.write("                <section class=\"sidebar\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Sidebar user panel -->\r\n");
      out.write("                    <div class=\"user-panel\">\r\n");
      out.write("                        <div class=\"pull-left image\">\r\n");
      out.write("                            <img src=\"dist/img/profile.png\" class=\"img-circle\" alt=\"User Image\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"pull-left info\">\r\n");
      out.write("                            <p>Usuário</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- search form -->\r\n");
      out.write("                    <form action=\"#\" method=\"get\" class=\"sidebar-form\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <input type=\"text\" name=\"q\" class=\"form-control\" placeholder=\"Pesquisar...\">\r\n");
      out.write("                            <span class=\"input-group-btn\">\r\n");
      out.write("                                <button type=\"submit\" name=\"search\" id=\"search-btn\" class=\"btn btn-flat\">\r\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <!-- /.search form -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- sidebar menu: : style can be found in sidebar.less -->\r\n");
      out.write("                    <ul class=\"sidebar-menu\" data-widget=\"tree\">\r\n");
      out.write("                        <li class=\"active treeview menu-open\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <i class=\"fa fa-th\"></i> <span>Produtos</span>\r\n");
      out.write("                                <span class=\"pull-right-container\">\r\n");
      out.write("                                    <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <ul class=\"treeview-menu\">\r\n");
      out.write("                                <li><a href=\"produto.jsp\"><i class=\"fa fa-circle-o\"></i>Produtos</a></li>\r\n");
      out.write("                                <li><a href=\"categoria.jsp\"><i class=\"fa fa-circle-o\"></i>Categorias</a></li>\r\n");
      out.write("                                <li><a href=\"tamanho.jsp\"><i class=\"fa fa-circle-o\"></i>Tamanhos</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </section>\r\n");
      out.write("                <!-- /.sidebar -->\r\n");
      out.write("            </aside>\r\n");
      out.write("\r\n");
      out.write("            <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("            <div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.content-wrapper -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- ./wrapper -->\r\n");
      out.write("\r\n");
      out.write("        <!-- jQuery 3 -->\r\n");
      out.write("        <script src=\"tema/bower_components/jquery/dist/jquery.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap 3.3.7 -->\r\n");
      out.write("        <script src=\"tema/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- FastClick -->\r\n");
      out.write("        <script src=\"tema/bower_components/fastclick/lib/fastclick.js\"></script>\r\n");
      out.write("        <!-- AdminLTE App -->\r\n");
      out.write("        <script src=\"tema/dist/js/adminlte.min.js\"></script>\r\n");
      out.write("        <!-- Sparkline -->\r\n");
      out.write("        <script src=\"tema/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js\"></script>\r\n");
      out.write("        <!-- SlimScroll -->\r\n");
      out.write("        <script src=\"tema/bower_components/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n");
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
