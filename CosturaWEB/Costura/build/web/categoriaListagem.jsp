<%-- 
    Document   : categoriaListagem
    Created on : 02/09/2017, 21:10:34
    Author     : Morgana
--%>

<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Categorias
                        <small>Listagem</small>
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Data Table With Full Features</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Descrição</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<Categoria> categorias = new CategoriaDAO().consultarTodos();

                                                for (int i = 0; i < categorias.size(); i++) {
                                            %>
                                            <tr>
                                                <td><%= categorias.get(i).getCodigo()%></td>
                                                <td><%= categorias.get(i).getDescricao()%></td>
                                                <td><a href="/Costura/Controle?parametro=categoria&manut=upd&id=<%= categorias.get(i).getCodigo()%>">Editar</a></td>
                                                <td><a href="/Costura/Controle?parametro=categoria&manut=del&id=<%= categorias.get(i).getCodigo()%>">Excluir</a></td>
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
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->

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
    </body>
</html>
