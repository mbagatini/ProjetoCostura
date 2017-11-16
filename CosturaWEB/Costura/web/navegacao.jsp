<%-- 
    Document   : navegacao
    Created on : 16/09/2017, 21:29:17
    Author     : Morgana
--%>

<%@page import="entidade.Usuario"%>
<%@page import="apoio.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://downloadicons.net/sites/default/files/scissor-icon-64459.png">
        
        <title>Costura</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    </head>

    <!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
    <!-- the fixed layout is not compatible with sidebar-mini -->
    <body class="hold-transition skin-yellow fixed sidebar-mini">

        <%
            // verifica se tem um atributo login na sessao, se houver vai continuar e mostrar a pagina
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

            if (usuario == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <!-- Site wrapper -->
        <div class="wrapper">

            <!-- Barra superior -->
            <header class="main-header">
                <!-- Logo -->
                <a href="<%= Constantes.PAGINA_MENU%>" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini">S<b>C</b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg">Sistema<b>Costura</b></span>
                </a>

                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="dist/img/user.png" class="user-image" alt="User Image">
                                    <span class="hidden-xs"> <%= usuario.getNome()%> </span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="dist/img/user.png" class="img-circle" alt="User Image">
                                        <p> <%= usuario.getNome()%>  </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <a href="/Costura/Controle?parametro=logout" class="btn btn-default btn-block btn-flat">Sair</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>

            <!-- =============================================== -->

            <!-- Left side column. contains the sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="dist/img/user.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p> <%= usuario.getNome()%> </p>
                            <p><i class="text-success"></i>Bem vindo!</p>
                        </div>
                    </div>

                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">MENU</li>

                        <!-- produtos -->
                        <li class="treeview active">
                            <a href="#">
                                <i class="fa fa-th-large"></i> 
                                <span>Produtos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <!-- produtos -->
                                <li><a href="<%= Constantes.CADASTRO_PRODUTO%>"><i class="fa fa-circle-o"></i> Produtos </a></li>
                                <!-- categorias -->
                                <li><a href="<%= Constantes.CADASTRO_CATEGORIA%>"><i class="fa fa-circle-o"></i> Categorias </a></li>
                                <!-- tamanhos -->
                                <li><a href="<%= Constantes.CADASTRO_TAMANHO%>"><i class="fa fa-circle-o"></i> Tamanhos </a></li>
                            </ul>
                        </li>

                        <!-- clientes -->
                        <li>
                            <a href="<%= Constantes.CADASTRO_CLIENTE %>">
                                <i class="fa fa-users"></i> 
                                <span>Clientes</span>
                            </a>
                        </li>

                        <!-- pedidos -->
                        <li>
                            <a href="<%= Constantes.CADASTRO_PEDIDO %>">
                                <i class="fa fa-cubes"></i> 
                                <span>Pedidos</span>
                            </a>
                        </li>

                        <!-- configuracoes -->
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-gears"></i> 
                                <span>Configurações</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<%= Constantes.CADASTRO_USUARIO%>"><i class="fa fa-user-plus"></i> Usuários </a></li>
                            </ul>
                        </li>
                    </ul>

                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- =============================================== -->

            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>     

        </div>
        <!-- ./wrapper -->

        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
    </body>
</html>