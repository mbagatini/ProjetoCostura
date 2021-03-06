<%-- 
    Document   : pedidoListagem
    Created on : 26/10/2017, 21:06:46
    Author     : Morgana
--%>

<%@page import="apoio.Constantes"%>
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
        <!-- daterange picker -->
        <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
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

                <div class="box box-solid">
                    <div class="box-body">
                        <div class="col-xs-4">
                            <!-- Date range -->
                            <div class="form-group">
                                <label>Status:</label>

                                <!-- select -->
                                <select class="form-control" id="filtroSituacao">
                                    <option value="">Todos</option>
                                    <option value="<%= Constantes.PEDIDO_SITUACAO_RECEBIDO%>"><%= new Pedido().retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_RECEBIDO)%></option>
                                    <option value="<%= Constantes.PEDIDO_SITUACAO_EM_PRODUCAO%>"><%= new Pedido().retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_EM_PRODUCAO)%></option>
                                    <option value="<%= Constantes.PEDIDO_SITUACAO_FINALIZADO%>"><%= new Pedido().retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_FINALIZADO)%></option>
                                    <option value="<%= Constantes.PEDIDO_SITUACAO_CANCELADO%>"><%= new Pedido().retornaDescricaoSituacao(Constantes.PEDIDO_SITUACAO_CANCELADO)%></option>
                                </select>
                                <!-- /.select -->
                            </div>
                        </div>

                        <div class="col-xs-4">
                            <div class="form-group">
                                <label>Período:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right" id="periodo">
                                </div>
                                <!-- /.input group -->
                            </div>
                        </div>

                        <div class="col-xs-4">
                            <label>Duplo clique</label><br>
                            <div class="btn-group">
                                <a class="btn btn-default" id="filter">Filtrar</a>
                                <a class="btn btn-default" id="clearFilter">Limpar filtros</a>
                            </div>
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
        <!-- date-range-picker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="plugins/daterangepicker/daterangepicker.js"></script>
        <!-- bootstrap datepicker -->
        <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- Importacao do arquivo comas funções javascript -->
        <script language="JavaScript" src="js/relatoriosDataTables.js"></script>
        <script language="JavaScript" src="js/funcoesPedido.js"></script>
        <!-- page script -->
        <script>
            $(function () {
                //Datemask dd/mm/yyyy
                $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
                //Datemask2 mm/dd/yyyy
                $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
                //Money Euro
                $("[data-mask]").inputmask();

                //Date range picker
                $('#periodo').daterangepicker({
                    "ranges": {
                        'Hoje': [moment(), moment()],
                        'Ontem': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Últimos 7 dias': [moment().subtract(6, 'days'), moment()],
                        'Últimos 30 dias': [moment().subtract(29, 'days'), moment()],
                        'Mês atual': [moment().startOf('month'), moment().endOf('month')],
                        'Últimos 30 dias': [moment().subtract(29, 'days'), moment()],
                        'Último mês': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')],
                        'Últimos 3 meses': [moment().subtract(3, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    "locale": {
                        "format": "DD/MM/YYYY",
                        "separator": " - ",
                        "applyLabel": "Confirmar",
                        "cancelLabel": "Cancelar",
                        "fromLabel": "De",
                        "toLabel": "Até",
                        "customRangeLabel": "Personalizado",
                        "daysOfWeek": ["Dom","Seg","Ter","Qua","Qui","Sex","Sab"],
                        "monthNames": ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                        "firstDay": 1
                    },
                    "alwaysShowCalendars": true,
                    "startDate": moment().subtract(6, 'month').format('DD/MM/YYYY'),
                    "endDate": moment().format('DD/MM/YYYY'),
                    "opens": "left"
                });
                
                // Relatórios
                var titulo = 'Listagem de pedidos';
                var subtitulo = 'SistemaCostura';
                var colunas = '0,1,2,3,4,5';

                configuraRelatorios(titulo, subtitulo, colunas);

                var $tableSel = $('#exampe1');

                // Limpa todos os filtros da tabela
                $('#clearFilter').on('click', function (e) {
                    $('#example1').DataTable().columns().search("").draw();

                    // Clear the filter. Unlike normal filters in Datatables,
                    // custom filters need to be removed from the afnFiltering array.
                    e.preventDefault();
                    $.fn.dataTableExt.afnFiltering.length = 0;
                    $tableSel.dataTable().fnDraw();
                    
                    $('#filtroSituacao').val("");
                });

                // Faz a filtragem dos dados na tabela
                $('#filter').on('click', function (e) {
                    // Por situação
                    var status = $('#filtroSituacao').find(":selected").text();
                    if (status === "Todos") {
                        $('#example1').DataTable().columns(5).search("").draw();
                    } else {
                        $('#example1').DataTable().columns(5).search(status).draw();
                    }
                    
                    // Filtra um período
                    var dataIni = $('#periodo').data('daterangepicker').startDate.format('DD/MM/YYYY');
                    var dataFim = $('#periodo').data('daterangepicker').endDate.format('DD/MM/YYYY');
                    
//                    e.preventDefault();
                    filterByDate(3, dataIni, dataFim); // We call our filter function
                    $tableSel.dataTable().fnDraw(); // Manually redraw the table after filtering


                });

            });


            /* Our main filter function
             * We pass the column location, the start date, and the end date
             */
            var filterByDate = function (column, startDate, endDate) {
                // Custom filter syntax requires pushing the new filter to the global filter array
                $.fn.dataTableExt.afnFiltering.push(
                        function (oSettings, aData, iDataIndex) {
                            
                            var dateStart = parseDateValue(($('#periodo').data('daterangepicker').startDate.format('DD/MM/YYYY')));
                            var dateEnd = parseDateValue($('#periodo').data('daterangepicker').endDate.format('DD/MM/YYYY'));

                            
                            // aData represents the table structure as an array of columns, so the script access the date value 
                            // in the first column of the table via aData[0]
                            var evalDate= parseDateValue(aData[3]);

                            if (evalDate >= dateStart && evalDate <= dateEnd) {
                                    return true;
                            }
                            else {
                                    return false;
                            }

                        }
                );
            };
           
           
            // Function for converting a mm/dd/yyyy date value into a numeric string for comparison (example 08/12/2010 becomes 20100812
            function parseDateValue(rawDate) {
                    var dateArray= rawDate.split("/");
                    var parsedDate= dateArray[2] + dateArray[1] + dateArray[0];
                    return parsedDate;
            }

        </script>
</html>
