<%-- 
    Document   : pedido
    Created on : 26/10/2017, 20:51:46
    Author     : Morgana
--%>

<%@page import="dao.ClienteDAO"%>
<%@page import="entidade.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="apoio.Constantes"%>
<%@page import="entidade.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- adiciona a navegação do aplicativo --%>
    <jsp:include page="navegacao.jsp" />

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Select2 -->
        <link rel="stylesheet" href="plugins/select2/select2.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
    </head>

    <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
    <%
        Pedido pedido = (Pedido) request.getAttribute("atributo");

        if (pedido == null) {
            pedido = new Pedido();
        }
    %>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Pedidos</h1>
                    <ol class="breadcrumb">
                        <li><a href="<%= Constantes.PAGINA_MENU%>"><i class="fa fa-home"></i> Início</a></li>
                        <li class="active">Pedidos</li>
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
                        <form class="form-horizontal" name="cadastroCliente" action="/Costura/Controle?parametro=cliente&manut=ins" method="post">
                            <div class="box-body">
                                <input type="hidden" name="id" id="id" value="<%= pedido.getCodigo()%>">

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Cliente*</label>
                                    <div class="col-sm-2">
                                        <!-- select -->
                                        <select class="form-control select2" name="cliente" required style="width: 100%;">
                                            <option value="-1" disabled selected>Selecione</option>

                                            <%
                                                ArrayList<Cliente> clis = new ClienteDAO().consultarTodos();
                                                for (int i = 0; i < clis.size(); i++) {
                                            %>
                                            <option 
                                                value="<%= clis.get(i).getCodigo()%>"  
                                                <%= pedido.getCliente().getCodigo() == clis.get(i).getCodigo() ? "selected" : ""%> >
                                                <%= clis.get(i).getNome() + " - " + clis.get(i).getCnpj() + "" + clis.get(i).getCpf()%> 
                                            </option>
                                            <%  }%>
                                        </select>
                                        <!-- /.select -->
                                    </div>

                                    <label class="col-sm-1 control-label">Data de emissão*</label>
                                    <div class="input-group date col-sm-2">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="datepicker" name="data" value="<%= pedido.getDataEmissao()%>" required>
                                    </div>
                                    
                                    <label class="col-sm-1 control-label">Status*</label>
                                    <div class="col-sm-2">
                                        <!-- select -->
                                        <select class="form-control select2" name="situacao" required>
                                            <option value="-1" disabled selected>Situacao</option>
                                        </select>
                                        <!-- /.select -->
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

                    <!-- Adiciona a listagem -->
                    <%@include file = "pedidoListagem.jsp" %>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Adiciona o footer -->
            <%@include file = "footer.jsp" %>
        </div>
        <!-- ./wrapper -->
    </body>

    <!-- page script -->
    <!-- Select2 -->
    <script src="plugins/select2/select2.full.min.js"></script>
    <!-- InputMask -->
    <script src="plugins/input-mask/jquery.inputmask.js"></script>
    <script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <!-- bootstrap datepicker -->
    <script src="plugins/datepicker/bootstrap-datepicker.js"></script>

    <!-- Page script -->
    <script>
        $(function () {
            //Initialize Select2 Elements
            $(".select2").select2();

            //Money Euro
            $("[data-mask]").inputmask();

            //Date picker
            $('#datepicker').datepicker({
                autoclose: true
            });
        });
    </script>
</html>
