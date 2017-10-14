<%-- 
    Document   : tamanho
    Created on : 20/09/2017, 09:42:50
    Author     : Morgana
--%>

<%@page import="entidade.Tamanho"%>
<%@page import="apoio.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- adiciona a navegação do aplicativo --%>
    <jsp:include page="navegacao.jsp" />

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
    <%
        Tamanho tamanho = (Tamanho) request.getAttribute("atributo");

        if (tamanho == null) {
            tamanho = new Tamanho();
        }
    %>

    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Tamanhos</h1>
                    <ol class="breadcrumb">
                        <li><a href="<%= Constantes.PAGINA_MENU%>"><i class="fa fa-home"></i> Início</a></li>
                        <li><a href="#">Produtos</a></li>
                        <li class="active">Tamanhos</li>
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
                        <form class="form-horizontal" name="cadastroTamanho" action="/Costura/Controle?parametro=tamanho&manut=ins" method="post">
                            <div class="box-body">
                                <input type="hidden" name="id" value="<%= tamanho.getCodigo()%>">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Tamanho*</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="tamanho" value="<%= tamanho.getTamanho()%>" required placeholder="Tamanho">
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

                    <!-- Adiciona a listagem de tamanhos -->
                    <%@include file = "tamanhoListagem.jsp" %>
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
