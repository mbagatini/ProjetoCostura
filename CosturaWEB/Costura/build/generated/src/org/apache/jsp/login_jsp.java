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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <title>Costura | Log in</title>\r\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <!-- Font Awesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\r\n");
      out.write("        <!-- Ionicons -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\r\n");
      out.write("        <!-- Theme style -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"dist/css/AdminLTE.min.css\">\r\n");
      out.write("        <!-- iCheck -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/iCheck/square/blue.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Font -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"hold-transition login-page\">\r\n");
      out.write("        <div class=\"login-box\">\r\n");
      out.write("            <div class=\"login-logo\">\r\n");
      out.write("                <p>Sistema <b> Costura </b></p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- /.login-logo -->\r\n");
      out.write("            <div class=\"login-box-body\">\r\n");
      out.write("                <p class=\"login-box-msg\">Autenticação</p>\r\n");
      out.write("\r\n");
      out.write("                <form name=\"login\" method=\"post\" action=\"/Costura/Controle?parametro=login\" onsubmit=\"return validar()\">\r\n");
      out.write("\r\n");
      out.write("                    ");

                        // verifica se o login nao foi validado com sucesso e estiliza os campos
                        boolean falha = false;

                        if (session.getAttribute("falhaLogin") != null) {
                            falha = (boolean) session.getAttribute("falhaLogin");
                        }

                        if (falha) {
                    
      out.write("   \r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group has-error\">\r\n");
      out.write("                        <label class=\"control-label\" for=\"inputError\"><i class=\"fa fa-times-circle-o\"></i> E-mail ou senha não conferem</label>\r\n");
      out.write("                        <input type=\"email\" name=\"email\" class=\"form-control\" id=\"inputError\" placeholder=\"E-mail\" required>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group has-error\">\r\n");
      out.write("                        <input type=\"password\" name=\"senha\" class=\"form-control\" id=\"inputError\" placeholder=\"Senha\" required>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group has-feedback\">\r\n");
      out.write("                        <input type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"E-mail\" required>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group has-feedback\">\r\n");
      out.write("                        <input type=\"password\" name=\"senha\" class=\"form-control\" placeholder=\"Senha\" required>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <!-- /.col -->\r\n");
      out.write("                        <div class=\"col-xs-12 center-block\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-block btn-flat\">Entrar</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /.col -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("                <br>\r\n");
      out.write("                <a href=\"#\">Esqueci minha senha</a><br>\r\n");
      out.write("                <a href=\"register.html\" class=\"text-center\">Registrar-se</a>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.login-box-body -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.login-box -->\r\n");
      out.write("\r\n");
      out.write("        <!-- jQuery 2.2.3 -->\r\n");
      out.write("        <script src=\"plugins/jQuery/jquery-2.2.3.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- iCheck -->\r\n");
      out.write("        <script src=\"plugins/iCheck/icheck.min.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                    $(function () {\r\n");
      out.write("                        $('input').iCheck({\r\n");
      out.write("                            checkboxClass: 'icheckbox_square-blue',\r\n");
      out.write("                            radioClass: 'iradio_square-blue',\r\n");
      out.write("                            increaseArea: '20%' // optional\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
