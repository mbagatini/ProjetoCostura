<%-- 
    Document   : usuario
    Created on : 27/08/2017, 19:08:12
    Author     : Morgana
--%>

<%@page import="apoio.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- adiciona a navegação do aplicativo --%>
    <jsp:include page="navegacao.jsp" />

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
        <%
            Usuario usuario = (Usuario) request.getAttribute("atributo");

            if (usuario == null) {
                usuario = new Usuario();
            }
        %>
    </head>
    
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Usuários</h1>
                    <ol class="breadcrumb">
                        <li><a href="<%= Constantes.PAGINA_MENU%>"><i class="fa fa-home"></i> Início</a></li>
                        <li class="active">Usuários</li>
                    </ol>
                </section>
                        
                <!-- Main content -->
                <section class="content">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Cadastro</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Expandir/Contrair">
                                    <i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header --> 
                        <!-- form start -->
                        <form class="form-horizontal" name="cadastroUsuario" action="/Costura/Controle?parametro=usuario&manut=ins" method="post">
                            <div class="box-body">
                                <input type="hidden" name="id" value="<%= usuario.getCodigo()%>">

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Nome*</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="nome" value="<%= usuario.getNome()%>" required placeholder="Nome">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">E-mail*</label>

                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" name="email" value="<%= usuario.getEmail()%>" required placeholder="E-mail">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Senha*</label>

                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" name="senha" required placeholder="Senha">
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" name="enviar" class="btn btn-info pull-right">Salvar</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                    <!-- /.box -->

                    <!-- Adiciona a listagem de usuários -->
                    <%@include file = "usuarioListagem.jsp" %>

                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            
            <!-- Adiciona o footer -->
            <%@include file = "footer.jsp" %>
        </div>
        <!-- ./wrapper -->
    </body>
</html>