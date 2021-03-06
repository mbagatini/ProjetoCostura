<%-- 
    Document   : login
    Created on : 13/09/2017, 11:46:24
    Author     : morgana.elis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://downloadicons.net/sites/default/files/scissor-icon-64459.png"> 

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Costura | Log in</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <p>Sistema <b> Costura </b></p>
            </div>

            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Autenticação</p>

                <form name="login" method="post" action="/Costura/Controle?parametro=login">

                    <%
                        // verifica se o login nao foi validado com sucesso e estiliza os campos
                        boolean falha = false;

                        if (session.getAttribute("falhaLogin") != null) {
                            falha = (boolean) session.getAttribute("falhaLogin");
                        }

                        if (falha) {
                    %>   

                    <div class="form-group has-error">
                        <label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i> E-mail ou senha não conferem</label>
                        <input type="email" name="email" class="form-control" id="inputError" placeholder="E-mail" required>
                    </div>

                    <div class="form-group has-error">
                        <input type="password" name="senha" class="form-control" id="inputError" placeholder="Senha" required>
                    </div>

                    <% } else { %>

                    <div class="form-group has-feedback">
                        <input type="email" name="email" class="form-control" placeholder="E-mail" required>
                    </div>

                    <div class="form-group has-feedback">
                        <input type="password" name="senha" class="form-control" placeholder="Senha" required>
                    </div>

                    <%
                        }
                    %>

                    <div class="row">
                        <!-- /.col -->
                        <div class="col-xs-12 center-block">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>

                <br>
                <a href="#">Esqueci minha senha</a><br>
                <a href="#" class="text-center">Registrar-se</a>

            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->

        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
