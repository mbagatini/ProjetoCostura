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
                                <th>Perfil</th>
                                <th>Editar</th>
                                <th>Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Cliente cli = new Cliente();
                                ArrayList<Cliente> clientes = new ClienteDAO().consultarTodos();

                                for (int i = 0; i < clientes.size(); i++) {
                            %>
                            <tr>
                                <td><%= clientes.get(i).getCodigo()%></td>
                                <td><%= clientes.get(i).getNome()%></td>
                                <td><%= clientes.get(i).getCpf() + "" + clientes.get(i).getCnpj()%></td>
                                <td><%= clientes.get(i).getEndereco().getCidade().getNome() %></td>
                                <td>
                                    <a data-toggle="modal" data-target="#modal-default" class="fa fa-file-text-o">
                                        <% cli = clientes.get(i);%>
                                    </a>
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
                                    <h4><%= cli.getNome()%></h4>
                                    <br>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">CNPJ/CPF</label>
                                    <h4><%= cli.getCnpj() + cli.getCpf()%></h4>
                                    <br>
                                </div>

                                <div class="col-sm-12">
                                    <label class="control-label">Endereço</label>
                                    <p><%= cli.getEndereco().getLogradouro()%></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Bairro</label>
                                    <p><%= cli.getEndereco().getBairro()%></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Cidade</label>
                                    <p><%= cli.getEndereco().getCidade().getNome()%></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Telefone</label>
                                    <p><%= cli.getTelefone().equals("") ? "Não cadastrado" : cli.getTelefone() %></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Celular</label>
                                    <p><%= cli.getCelular().equals("") ? "Não cadastrado" : cli.getCelular() %></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">E-mail</label>
                                    <p><%= cli.getEmail().equals("") ? "Não cadastrado" : cli.getEmail() %></p>
                                </div>

                                <div class="col-sm-6">
                                    <label class="control-label">Data de cadastro</label>
                                    <p><%= new SimpleDateFormat("dd/MM/yyyy").format(cli.getDataCadastro().getTime())%></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
    <!-- page script -->
    <script>
        $(function () {
            $("#example1").DataTable();
            $('#example2').DataTable({
                "paging": true,
                "lengthChange": false,
                "searching": false,
                "ordering": true,
                "info": true,
                "autoWidth": false
            });
        });
    </script>
</html>