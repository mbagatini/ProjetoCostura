<%-- 
    Document   : pedido
    Created on : 26/10/2017, 20:51:46
    Author     : Morgana
--%>

<%@page import="apoio.Formatacao"%>
<%@page import="dao.TamanhoDAO"%>
<%@page import="entidade.Tamanho"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="entidade.Produto"%>
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
                                <form class="form-horizontal" name="cadastroPedido" action="/Costura/Controle?parametro=pedido&manut=ins" method="post">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">Pedido</label>
                                            <div class="col-sm-1">
                                                <input class="form-control" type="number" name="id" id="id" value="<%= pedido.getCodigo()%>" readonly>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">Cliente*</label>
                                            <div class="col-sm-4">
                                                <!-- select -->
                                                <select class="form-control select2" name="cliente" id="cliente" required style="width: 100%;">
                                                    <option value="" disabled selected>Selecione</option>

                                                    <%
                                                        ArrayList<Cliente> clis = new ClienteDAO().consultarTodos();
                                                        for (int i = 0; i < clis.size(); i++) {
                                                    %>
                                                    <option 
                                                        value="<%= clis.get(i).getCodigo()%>"  
                                                        <%= pedido.getCliente().getCodigo() == clis.get(i).getCodigo() ? "selected" : ""%>>
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
                                                    <input type="text" class="form-control pull-right" id="datepicker" name="dataEmissao" 
                                                           value="<%= Formatacao.retornaDataFormatada(pedido.getDataEmissao())%>" required>
                                                </div>
                                            </div>

                                            <label class="col-sm-1 control-label">Status*</label>
                                            <div class="col-sm-2">
                                                <!-- select -->
                                                <select class="form-control" name="situacao" id="situacao" required <%= pedido.getCodigo() == 0 ? "readonly" : ""%>>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_RECEBIDO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_RECEBIDO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_RECEBIDO)%></option>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_EM_PRODUCAO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_EM_PRODUCAO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_EM_PRODUCAO)%></option>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_FINALIZADO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_FINALIZADO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_FINALIZADO)%></option>
                                                    <option value="<%= Constantes.PEDIDO_SITUACAO_CANCELADO%>" <%= pedido.getSituacao() == Constantes.PEDIDO_SITUACAO_CANCELADO ? "selected" : ""%>><%= pedido.retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_CANCELADO)%></option>
                                                </select>
                                                <!-- /.select -->
                                            </div>
                                        </div>

                                        <!-- Produtos -->
                                        <br>
                                        <div class="form-group">
                                            <div class="col-sm-12" style="overflow:auto; max-height: 300px">
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

                                            <div class="col-sm-12">
                                                <div class="col-sm-3">
                                                    <a class="btn btn-block btn-default" onclick="addRow()">
                                                        <i class="fa fa-plus"></i> Adicionar um produto
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <br>

                                        <!-- Totais -->

                                        <div class="form-group">
                                            <label class="col-sm-10 control-label">Valor total</label>
                                            <div class="col-sm-2">
                                                <div class="input-group">
                                                    <span class="input-group-addon">R$</span>
                                                    <input type="number" class="col-sm-6 form-control" id="valorTotal" value="<%= (0)%>" readonly>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-10 control-label">Desconto</label>
                                            <div class="col-sm-2">
                                                <div class="input-group">
                                                    <span class="input-group-addon">R$</span>
                                                    <input type="text" class="form-control pull-right" id="desconto" name="desconto" type="number" min="1" pattern="^\d+(?:\.\d{1,2})?$" value="<%= (pedido.getDesconto())%>" onChange="atualizaTotalLiquido()">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-10 control-label">Total líquido</label>
                                            <div class="col-sm-2">
                                                <div class="input-group">
                                                    <span class="input-group-addon">R$</span>
                                                    <input type="text" class="form-control pull-right" id="valorLiquido" name="valorLiquido" type="number" min="1" pattern="^\d+(?:\.\d{1,2})?$" value="<%= (pedido.getPreco())%>" readonly>
                                                </div>
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
    <script src="plugins/datepicker/locales/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
    <!-- Importacao do arquivo comas funções AJAX -->
    <script language="JavaScript" src="js/funcoesPedido.js"></script>

    <!-- Page script -->
    <script>
        $(function () {
            // Carrega os itens do pedido
            $(document).ready(carregarTabela());
            // Ajusta as situações
            $(document).ready(controlaSituacao());
            
            //Initialize Select2 Elements
            $(".select2").select2({
                width: '100%',
                dropdownAutoWidth : true
            });

            //Money Euro
            $("[data-mask]").inputmask();

            //Date picker
            $("#datepicker").datepicker({
                autoclose: true,
                format: 'dd/mm/yyyy',
                language: 'pt-BR'
            });
        });
        
        function carregarTabela(){
            var table = document.getElementById("produtos");
            
            <%
                for (ItensPedido ip : pedido.getItens()) {
            %>
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);

                    row.insertCell(0).innerHTML = getHTML('produto', rowCount, <%= ip.getProduto().getCodigo() %>);
                    row.insertCell(1).innerHTML = getHTML('tamanho', rowCount, <%= ip.getTamanho().getCodigo() %>);
                    row.insertCell(2).innerHTML = getHTML('quantidade', rowCount, <%= ip.getQuantidade() %>);
                    row.insertCell(3).innerHTML = getHTML('preco', rowCount, <%= ip.getProduto().getPreco() %>);
                    row.insertCell(4).innerHTML = getHTML('subtotal', rowCount, <%= ip.getQuantidade() * ip.getProduto().getPreco() %>);
                    row.insertCell(5).innerHTML = getHTML('remover', rowCount, '');
            <%  } %>
                
            // Alteração de um pedido
            if (table.rows.length > 1) {
                atualizaTotal();
            }
        }
        
        function controlaSituacao(){
            var table = document.getElementById("produtos");
            var pedidoNovo = table.rows.length === 1;
            
            $("#situacao > option").each(function() {
                if (pedidoNovo) {
                    $(this).prop('disabled', (this.value !== '<%= Constantes.PEDIDO_SITUACAO_RECEBIDO%>'));
                } else {
                    $(this).prop('disabled', false);
                }
            });
        }
        
        function getHTML(campo, index, valor) {

            var html;

            switch (campo) {
                case 'produto':
                    html = '<select class="form-control select2" name="produto" id="produto_' + index + '" required style="width: 100%;" onChange="atualizaPreco(this)"> ' +
                            '<option value="" disabled selected>Selecione</option>';
        <%
            ArrayList<Produto> prod = new ProdutoDAO().consultarTodos();
            for (int i = 0; i < prod.size(); i++) {
        %>
                    html = html + '<option value="<%= prod.get(i).getCodigo()%>" ';
                                    if (valor == <%= prod.get(i).getCodigo()%>){
                                        html = html + " selected ";
                                    };
                    html = html + '>' 
                                + '<%= prod.get(i).getReferencia() + " - " + prod.get(i).getDescricao()%>';
                    html = html + '</option>';

        <%  }%>
                    html = html + '</select>';
                    break;

                case 'tamanho':
                    html = '<select class="form-control select2" name="tamanho" id="tamanho_' + index + '" required style="width: 100%;"> ' +
                            '<option value="" disabled selected>Selecione</option>';
        <%
            ArrayList<Tamanho> tam = new TamanhoDAO().consultarTodos();
            for (int i = 0; i < tam.size(); i++) {
        %>
                    html = html + '<option value="<%= tam.get(i).getCodigo()%>" ';
                                    if (valor == <%= tam.get(i).getCodigo()%>){
                                        html = html + " selected ";
                                    };
                    html = html + '>' 
                                + '<%= tam.get(i).getTamanho()%>'
                                + '</option>';
        <%  }%>
                    html = html + '</select>';
                    break;

                case 'quantidade':
                    html = '<input class="form-control" type="number" min="1" pattern="^\d+(?:\d{1,2})?$" '
                         + 'value="' + valor + '" '
                         + 'name="quantidade" id="quantidade_' + index + '" required onChange="atualizaSubtotal(this)">';
                    break;

                case 'preco':
                    html = '<input class="form-control" type="number" min="1" '
                         + 'value="' + valor + '" '
                         + 'name="preco" id="preco_' + index + '" value="0" readonly>';
                    break;

                case 'subtotal':
                    html = '<input class="form-control" type="number" min="1" '
                         + 'value="' + valor + '" '
                         + 'name="subtotal" id="subtotal_' + index + '" value="0" readonly>';
                    break;

                case 'remover':
                    html = '<a class="fa fa-trash-o" onClick="deleteRow(this)"></a>';
                    break;
            }
            
            //Initialize Select2 Elements
            $(".select2").select2({
                width: '100%',
                dropdownAutoWidth : true
            });

            return html;

        }
    </script>
</html>
