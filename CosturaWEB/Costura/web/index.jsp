<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Entrar | Costura</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="styles/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="styles/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="styles/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="styles/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="styles/iCheck/square/blue.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <p><b>Sistema Costura</b></p>
            </div>

            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Entre para continuar</p>

                <form name="login" method="post" action="/Costura/Controle?parametro=login" onsubmit="return validar()">
                    <div class="form-group has-feedback">
                        <input type="email" name="email" class="form-control" placeholder="E-mail" required>
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <input type="password" name="senha" class="form-control" placeholder="Senha" required>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>

                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Lembrar-me
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>

                <a href="#">Esqueci minha senha</a><br>
                <a href="register.html" class="text-center">Registrar-se</a>
                
                <br><br>

                <!-- Link direto para o menu -->
                <div class="row">
                    <div class="col-xs-12">
                        <a href="menu.jsp" class="btn btn-primary btn-block btn-flat">Link direto menu</a>
                    </div>
                </div>

            </div>
        </div>

        <!-- jQuery 3 -->
        <script src="styles/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="styles/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="styles/plugins/iCheck/icheck.min.js"></script>
        <script>
                    $(function () {
                        $('input').iCheck({
                            checkboxClass: 'icheckbox_square-blue',
                            radioClass: 'iradio_square-blue',
                            increaseArea: '20%' // optional
                        });
                    });
        </script>
    </body>

    <!-- Importacao do arquivo de validacao -->

</html>
