<%-- 
    Document   : categoria
    Created on : 02/09/2017, 20:50:07
    Author     : Morgana
--%>

<%@page import="entidade.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%-- Inclui o menu principal --%>
    <%@include file="menu.jsp" %>

    <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
    <%                    
        Categoria categoria = (Categoria) request.getAttribute("atributo");

        if (categoria == null) {
            categoria = new Categoria();
        }
    %>

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Categorias
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-home"></i> Home</a></li>
                        <li><a href="#">Produtos</a></li>
                        <li class="active">Categorias</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <!-- right column -->
                        <div class="col-md-12">
                            <!-- Horizontal Form -->
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Cadastro</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Minimizar/Maximizar">
                                            <i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <!-- form start -->
                                <form class="form-horizontal" name="cadastroCategoria" action="/Costura/Controle?parametro=categoria&manut=ins" method="post">
                                    <div class="box-body">
                                        <input type="hidden" name="id" value="<%= categoria.getCodigo()%>">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">Descrição</label>

                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="descricao" value="<%= categoria.getDescricao()%>" required placeholder="Descrição">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.box-body -->
                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-default">Cancelar</button>
                                        <button type="submit" name="enviar" class="btn btn-info pull-right">Salvar</button>
                                    </div>
                                    <!-- /.box-footer -->
                                </form>
                            </div>
                            <!-- /.box -->
                        </div>
                        <!--/.col  -->
                    </div>
                    <!-- /.row -->
                </section>
                <!-- /.content -->

                <!-- Adiciona a listagem de usuários -->
                <%@include file = "categoriaListagem.jsp" %>
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
    </body>
</html>
