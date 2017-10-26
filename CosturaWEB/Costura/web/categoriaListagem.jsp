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
                                <th>Descrição</th>
                                <th>Editar</th>
                                <th>Excluir</th>
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
                                <td><a href="/Costura/Controle?parametro=categoria&manut=upd&id=<%= categorias.get(i).getCodigo()%>" class="fa fa-pencil-square-o"></a></td>
                                <td><a href="/Costura/Controle?parametro=categoria&manut=del&id=<%= categorias.get(i).getCodigo()%>" class="fa fa-trash-o"></a></td>
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

    <!-- DataTables -->
    <script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
    <!-- page script -->
    <script>
        $(function () {
            $("#example1").DataTable({
                "order": [[1, "asc"]]
            });
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
