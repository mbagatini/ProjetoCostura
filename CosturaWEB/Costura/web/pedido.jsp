<%-- 
    Document   : pedido
    Created on : 26/10/2017, 20:51:46
    Author     : Morgana
--%>

<%@page import="dao.TamanhoDAO"%>
<%@page import="entidade.Tamanho"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="entidade.Produto"%>
<%@page import="java.text.SimpleDateFormat"%>
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
                    <div class="row">
                        <div class="col-md-12">
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
                                        <div class="form-group">
                                            <input type="hidden" name="id" id="id" value="<%= pedido.getCodigo()%>">

                                            <label class="col-sm-1 control-label">Cliente*</label>
                                            <div class="col-sm-4">
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

                                            <label class="col-sm-2 control-label">Data de emissão*</label>
                                            <div class="col-sm-2">
                                                <div class="input-group date ">
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-calendar"></i>
                                                    </div>
                                                    <input type="text" class="form-control pull-right" id="datepicker" name="data" 
                                                           value="<%= new SimpleDateFormat("dd/MM/yyyy").format(pedido.getDataEmissao())%>" required>
                                                </div>
                                            </div>

                                            <label class="col-sm-1 control-label">Status*</label>
                                            <div class="col-sm-2">
                                                <!-- select -->
                                                <select class="form-control" name="situacao" required>
                                                    <option class="label-warning" value="<%= Constantes.PEDIDO_SITUACAO_RECEBIDO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_RECEBIDO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_RECEBIDO)%></option>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_EM_PRODUCAO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_EM_PRODUCAO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_EM_PRODUCAO)%></option>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_FINALIZADO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_FINALIZADO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_FINALIZADO)%></option>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_CANCELADO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_CANCELADO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_CANCELADO)%></option>
                                                </select>
                                                <!-- /.select -->
                                            </div>
                                        </div>

                                        <br>

                                        <div class="box-group">
                                            <div class="col-sm-12" style="width:100%; height:250px; overflow:auto;">
                                                <table class="table table-striped table-hover" id="produtos">
                                                    <tr>
                                                        <th>Produto</th>
                                                        <th>Tamanho</th>
                                                        <th>Quantidade</th>
                                                        <th>Valor</th>
                                                        <th>Subtotal</th>
                                                        <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents"> </th>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <a class="btn btn-block btn-default" onclick="Javascript:addRow()">
                                                    <i class="fa fa-plus"></i> Adicionar um produto
                                                </a>
                                            </div>

                                            <label class="col-sm-8 control-label">Valor total </label>
                                            <label class="col-sm-1">0,00</label>

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
                        </div>
                    </div>
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

                                                    function addRow() {

                                                        var table = document.getElementById("produtos");
                                                        var rowCount = table.rows.length;
                                                        var row = table.insertRow(rowCount);

                                                        row.insertCell(0).innerHTML = getHTML('produto');
                                                        row.insertCell(1).innerHTML = getHTML('tamanho');
                                                        row.insertCell(2).innerHTML = getHTML('quantidade');
                                                        row.insertCell(3).innerHTML = getHTML('preco');
                                                        row.insertCell(4).innerHTML = getHTML('subtotal');
                                                        row.insertCell(5).innerHTML = getHTML('remover');

                                                        $(".select2").select2();

                                                    }
                                                    ;

                                                    function deleteRow(obj) {

                                                        var index = obj.parentNode.parentNode.rowIndex;
                                                        var table = document.getElementById("produtos");
                                                        table.deleteRow(index);

                                                    }
                                                    ;

                                                    function atualizaPreco(obj) {

                                                        var index = obj.parentNode.parentNode.rowIndex;
                                                        var table = document.getElementById("produtos");

                                                        table.rows[index].cells[3].innerHTML = getHTML('preco');

                                                        alert("entrei aquiiiii");

                                                    }
                                                    ;

                                                    function getHTML(campo) {

                                                        var html;

                                                        switch (campo) {
                                                            case 'produto':
                                                                html = '<select class="form-control select2" id="produto" required style="width: 100%;" onChange="atualizaPreco(this)"> ';
        <%
            ArrayList<Produto> prod = new ProdutoDAO().consultarTodos();
            for (int i = 0; i < prod.size(); i++) {
        %>
                                                                html = html + '<option value="<%= prod.get(i).getCodigo()%>" >'
                                                                        + '<%= prod.get(i).getReferencia() + " - " + prod.get(i).getDescricao()%>'
                                                                        + '</option>';
                                                                preco = <%= prod.get(i).getPreco()%>
        <%  }%>
                                                                html = html + '</select>';
                                                                break;

                                                            case 'tamanho':
                                                                html = '<select class="form-control select2" id="tamanho" required style="width: 100%;">  ';
        <%
            ArrayList<Tamanho> tam = new TamanhoDAO().consultarTodos();
            for (int i = 0; i < tam.size(); i++) {
        %>
                                                                html = html + '<option value="<%= tam.get(i).getCodigo()%>" >'
                                                                        + '<%= tam.get(i).getTamanho()%>'
                                                                        + '</option>';
        <%  }%>
                                                                html = html + '</select>';
                                                                break;

                                                            case 'quantidade':
                                                                html = '<input class="form-control" type="number" min="1" id="quantidade">';
                                                                break;

                                                            case 'preco':
                                                                html = '<input class="form-control" type="number" min="1" id="preco" value="' + preco + '" disabled>';
                                                                alert("o preco e" + preco);
                                                                break;

                                                            case 'subtotal':
                                                                html = '<input class="form-control" type="number" min="1" id="subtotal" disabled>';
                                                                break;

                                                            case 'remover':
                                                                html = '<a class="fa fa-trash-o" onClick="deleteRow(this)"></a>';
                                                                break;
                                                        }
                                                        ;

                                                        return html;

                                                    }
                                                    ;

                                                    function getTable() {

                                                        var array = [];
                                                        var headers = [];
                                                        $('#produtos th').each(function (index, item) {
                                                            headers[index] = $(item).html();
                                                        });
                                                        $('#produtos tr').has('td').each(function () {
                                                            var arrayItem = {};
                                                            $('td', $(this)).each(function (index, item) {
                                                                arrayItem[headers[index]] = $(item).html();
                                                            });
                                                            array.push(arrayItem);
                                                        });

                                                    }
                                                    ;
    </script>
</html>
