<%-- 
    Document   : usuarioListagem
    Created on : 31/08/2017, 22:03:52
    Author     : Morgana
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- DataTables -->
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="plugins/datatables/buttons.dataTables.min.css">
    </head>
    
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
                        <th>E-mail</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Usuario> usuarios = new UsuarioDAO().consultarTodos();

                        for (int i = 0; i < usuarios.size(); i++) {
                    %>
                    <tr>
                        <td><%= usuarios.get(i).getCodigo()%></td>
                        <td><%= usuarios.get(i).getNome()%></td>
                        <td><%= usuarios.get(i).getEmail()%></td>
                        <td><a href="/Costura/Controle?parametro=usuario&manut=upd&id=<%= usuarios.get(i).getCodigo()%>" class="fa fa-pencil-square-o"></a></td>
                        <td><a href="/Costura/Controle?parametro=usuario&manut=del&id=<%= usuarios.get(i).getCodigo()%>" class="fa fa-trash-o"></a></td>
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
    <!-- page script -->
    <script>
        $(function () {
            var titulo = 'Listagem de usuários';
            var subtitulo = 'SistemaCostura';
            var colunas = '0,1,2';
            
            $("#example1").DataTable({
                order: [[1, "asc"]],
                dom: 'Bfrtip',
                buttons: [
                    {
                        extend: 'copy',
                        exportOptions: {
                            columns: [colunas]
                        }
                    },
                    {
                        extend: 'csv',
                        title: titulo,
                        exportOptions: {
                            columns: [colunas]
                        }
                    },
                    {
                        extend: 'excel',
                        title: titulo,
                        messageTop: subtitulo,
                        exportOptions: {
                            columns: [colunas]
                        }
                    },
                    {
                        extend: 'pdf',
                        title: titulo,
                        messageTop: subtitulo,
                        exportOptions: {
                            columns: [colunas]
                        }
                    },
                    {
                        extend: 'print',
                        title: titulo,
                        messageTop: subtitulo,
                        exportOptions: {
                            columns: [colunas]
                        }
                    }
                ]
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