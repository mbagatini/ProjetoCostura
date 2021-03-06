<%-- 
    Document   : clienteListagem
    Created on : 13/10/2017, 14:13:05
    Author     : Morgana
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.ClienteDAO"%>
<%@page import="dao.ClienteDAO"%>
<%@page import="entidade.Cliente"%>
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
                <!-- /.box-header -->
                <div class="box-body">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nome</th>
                                <th>CPF/CNPJ</th>
                                <th>Cidade</th>
                                <th>Telefone</th>
                                <th>Perfil</th>
                                <th>Editar</th>
                                <th>Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Cliente> clientes = new ClienteDAO().consultarTodos();

                                for (int i = 0; i < clientes.size(); i++) {
                            %>
                            <tr>
                                <td><%= clientes.get(i).getCodigo()%></td>
                                <td><%= clientes.get(i).getNome()%></td>
                                <td><%= clientes.get(i).getCpf() + "" + clientes.get(i).getCnpj()%></td>
                                <td><%= clientes.get(i).getEndereco().getCidade().getNome() %></td>
                                <td><%= clientes.get(i).getTelefone()%></td>
                                <td>
                                    <a data-toggle="modal" data-target="#modal-default" class="fa fa-file-text-o" onclick="consultarCliente(<%= clientes.get(i).getCodigo()%>)"></a>
                                </td>
                                <td><a href="/Costura/Controle?parametro=cliente&manut=upd&id=<%= clientes.get(i).getCodigo()%>" class="fa fa-pencil-square-o"></a></td>
                                <td><a href="/Costura/Controle?parametro=cliente&manut=del&id=<%= clientes.get(i).getCodigo()%>" class="fa fa-trash-o"></a></td>
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
                        <h4 class="modal-title">Perfil do cliente</h4>
                    </div>

                    <div class="modal-body">
                        <div class="box-body">
                            <div class="form-group">
                                <div class="col-sm-6">
                                    <label class="control-label">Nome</label>
                                    <h4 id="consulta_cliente"></h4>
                                    <br>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">CNPJ/CPF</label>
                                    <h4 id="consulta_cnpj_cpf"></h4>
                                    <br>
                                </div>

                                <div class="col-sm-12">
                                    <label class="control-label">Endereço</label>
                                    <p id="consulta_endereco"></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Bairro</label>
                                    <p id="consulta_bairro"></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Cidade</label>
                                    <p id="consulta_cidade"></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Telefone</label>
                                    <p id="consulta_telefone"></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Celular</label>
                                    <p id="consulta_celular"></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">E-mail</label>
                                    <p id="consulta_email"></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Data de cadastro</label>
                                    <p id="consulta_data_cadastro"></p>
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
    <script language="JavaScript" src="js/funcoesCliente.js"></script>
    <!-- page script -->
    <script>
        $(function () {
            var titulo = 'Listagem de clientes';
            var subtitulo = 'SistemaCostura';
            var colunas = '0,1,2,3,4';

            configuraRelatorios(titulo, subtitulo, colunas);
        });
    </script>
</html>