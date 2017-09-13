package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Costura | Log in</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("        <!-- Ionicons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"dist/css/AdminLTE.min.css\">\n");
      out.write("        <!-- iCheck -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/iCheck/square/blue.css\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition login-page\">\n");
      out.write("        <div class=\"login-box\">\n");
      out.write("            <div class=\"login-logo\">\n");
      out.write("                <p><b> Sistema Costura </b></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- /.login-logo -->\n");
      out.write("            <div class=\"login-box-body\">\n");
      out.write("                <p class=\"login-box-msg\">Entre para iniciar a sessão</p>\n");
      out.write("\n");
      out.write("                <form name=\"login\" method=\"post\" action=\"/Costura/Controle?parametro=login\" onsubmit=\"return validar()\">\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"E-mail\" required>\n");
      out.write("                        <span class=\"glyphicon glyphicon-envelope form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"password\" name=\"senha\" class=\"form-control\" placeholder=\"Senha\" required>\n");
      out.write("                        <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xs-8\">\n");
      out.write("                            <div class=\"checkbox icheck\">\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"checkbox\"> Lembrar-me\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.col -->\n");
      out.write("                        <div class=\"col-xs-4\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-block btn-flat\">Entrar</button>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.col -->\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <a href=\"#\">Esqueci minha senha</a><br>\n");
      out.write("                <a href=\"register.html\" class=\"text-center\">Registrar-se</a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.login-box-body -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.login-box -->\n");
      out.write("\n");
      out.write("        <!-- jQuery 2.2.3 -->\n");
      out.write("        <script src=\"plugins/jQuery/jquery-2.2.3.min.js\"></script>\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- iCheck -->\n");
      out.write("        <script src=\"plugins/iCheck/icheck.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                    $(function () {\n");
      out.write("                        $('input').iCheck({\n");
      out.write("                            checkboxClass: 'icheckbox_square-blue',\n");
      out.write("                            radioClass: 'iradio_square-blue',\n");
      out.write("                            increaseArea: '20%' // optional\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
