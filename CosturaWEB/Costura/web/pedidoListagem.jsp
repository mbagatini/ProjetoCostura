<%-- 
    Document   : pedidoListagem
    Created on : 26/10/2017, 21:06:46
    Author     : Morgana
--%>

<%@page import="entidade.ItensPedido"%>
<%@page import="apoio.Formatacao"%>
<%@page import="dao.PedidoDAO"%>
<%@page import="entidade.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- DataTables -->
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="plugins/datatables/buttons.dataTables.min.css">
    </head>
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Listagem</h3>
                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Expandir/Contrair">
                            <i class="fa fa-minus"></i></button>
                    </div>
                </div>
                
                <div class="box-body">
                    <div class="large-6 columns">
                      <label for="start">Start Date</label>
                      <input id="start" type="date" /><br />
                    </div>
                    <div class="large-6 columns">
                      <label for="end">End Date</label>
                      <input id="end" type="date" /><br />
                    </div>
                </div>
                
                <div class="box-body">
                    <div class="large-12 columns">
                      <button class="button radius" id="filter">Filter</button>
                      <button id="clearFilter" class="button radius secondary">Clear Filter</button>
                    </div>
                </div>
                
                <!-- /.box-header -->
                <div class="box-body">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Pedido</th>
                                <th>Cliente</th>
                                <th>CPF/CNPJ</th>
                                <th>Data emissão</th>
                                <th>Valor</th>
                                <th>Situação</th>
                                <th>Consultar</th>
                                <th>Editar</th>
                                <th>Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Pedido> pedidos = new PedidoDAO().consultarTodos();

                                for (int i = 0; i < pedidos.size(); i++) {
                            %>
                            <tr>
                                <td><%= pedidos.get(i).getCodigo()%></td>
                                <td><%= pedidos.get(i).getCliente().getNome()%></td>
                                <td><%= pedidos.get(i).getCliente().getCpf() + "" + pedidos.get(i).getCliente().getCnpj()%></td>
                                <td><%= Formatacao.retornaDataFormatada(pedidos.get(i).getDataEmissao())%></td>
                                <td><%= Formatacao.retornaDecimalFormatado(pedidos.get(i).getPreco())%></td>
                                <td><%= pedidos.get(i).retornaDescricaoSituacao(pedidos.get(i).getSituacao())%></td>
                                <td>
                                    <a data-toggle="modal" data-target="#modal-default" class="fa fa-file-text-o" onclick="consultarPedido(<%= pedidos.get(i).getCodigo()%>)"></a>
                                </td>
                                <td><a href="/Costura/Controle?parametro=pedido&manut=upd&id=<%= pedidos.get(i).getCodigo()%>" class="fa fa-pencil-square-o"></a></td>
                                <td><a href="/Costura/Controle?parametro=pedido&manut=del&id=<%= pedidos.get(i).getCodigo()%>" class="fa fa-trash-o"></a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                        <tfoot>
                        </tfoot>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
                    
    <!-- Main content -->
    <section class="content">
        <!-- Modal -->
        <div class="modal fade" id="modal-default">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Dados do pedido</h4>
                    </div>

                    <div class="modal-body">
                        <div class="box-body">
                            <div class="box-group">
                                <div class="col-sm-2">
                                    <label class="control-label">Pedido</label>
                                    <h4 id="consulta_pedido"></h4>
                                    <br>
                                </div>

                                <div class="col-sm-4">
                                    <label class="control-label">Cliente</label>
                                    <p id="consulta_cnpj_cpf"></p>
                                    <h4 id="consulta_cliente"></h4>
                                    <br>
                                </div>

                                <div class="col-sm-3">
                                    <label class="control-label">Data de emissão</label>
                                    <h4 id="consulta_data_emissao"></h4>
                                    <br>
                                </div>

                                <div class="col-sm-3">
                                    <label class="control-label">Situação</label>
                                    <h4 id="consulta_situacao"></h4>
                                    <br>
                                </div>
                            </div>

                            <br>

                            <!-- Itens -->
                            <div class="box-group">
                                <div class="col-sm-12" style="overflow:auto; max-height: 300px">
                                    <table id="consulta_produtos" class="table table-striped table-hover" >
                                        <tr>
                                            <th>Produto</th>
                                            <th>Tamanho</th>
                                            <th>Quantidade</th>
                                            <th>Valor</th>
                                            <th>Subtotal</th>
                                        </tr>
                                    </table>
                                </div>
                            </div>

                            <div class="box-group">
                                <label class="col-sm-10 control-label">Valor total</label>
                                <div class="col-sm-2">
                                    <h4 id="consulta_valor_total"></h4>
                                </div>
                            </div>

                            <div class="box-group">
                                <label class="col-sm-10 control-label">Desconto</label>
                                <div class="col-sm-2">
                                    <h4 id="consulta_desconto"></h4>
                                </div>
                            </div>

                            <div class="box-group">
                                <label class="col-sm-10 control-label">Total líquido</label>
                                <div class="col-sm-2">
                                    <h4 id="consulta_total_liquido"></h4>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Voltar</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
    </section>

    <!-- DataTables -->
    <script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="plugins/datatables/dataTables.buttons.min.js"></script>
    <script src="plugins/datatables/buttons.flash.min.js"></script>
    <script src="plugins/datatables/jszip.min.js"></script>
    <script src="plugins/datatables/pdfmake.min.js"></script>
    <script src="plugins/datatables/pvfs_fonts.js"></script>
    <script src="plugins/datatables/buttons.print.min.js"></script>
    <script src="plugins/datatables/buttons.html5.min.js"></script>
    <!-- Importacao do arquivo comas funções javascript -->
    <script language="JavaScript" src="js/relatoriosDataTables.js"></script>
    <script language="JavaScript" src="js/funcoesPedido.js"></script>
    <!-- page script -->
    <script>
        $(function () {
            var titulo = 'Listagem de pedidos';
            var subtitulo = 'SistemaCostura';
            var colunas = '0,1,2,3,4,5';
            
            configuraRelatorios(titulo, subtitulo, colunas);
            });
    </script>
</html>
