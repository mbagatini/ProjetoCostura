<%-- 
    Document   : produtoListagem
    Created on : 20/09/2017, 22:19:19
    Author     : Morgana
--%>

<%@page import="dao.ProdutoDAO"%>
<%@page import="entidade.Produto"%>
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
                                <th>Referência</th>
                                <th>Descrição</th>
                                <th>Preço</th>
                                <th>Gênero</th>
                                <th>Categoria</th>
                                <th>Editar</th>
                                <th>Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Produto> produtos = new ProdutoDAO().consultarTodos();

                                for (int i = 0; i < produtos.size(); i++) {
                            %>
                            <tr>
                                <td><%= produtos.get(i).getReferencia()%></td>
                                <td><%= produtos.get(i).getDescricao()%></td>
                                <td><%= produtos.get(i).getPreco()%></td>
                                <td><%= produtos.get(i).getGenero()%></td>
                                <td><%= produtos.get(i).getCategoria().getDescricao()%></td>
                                <td><a href="/Costura/Controle?parametro=produto&manut=upd&id=<%= produtos.get(i).getCodigo()%>" class="fa fa-pencil-square-o"></a></td>
                                <td><a href="/Costura/Controle?parametro=produto&manut=del&id=<%= produtos.get(i).getCodigo()%>" class="fa fa-trash-o"></a></td>
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
    <script src="plugins/datatables/dataTables.buttons.min.js"></script>
    <script src="plugins/datatables/buttons.flash.min.js"></script>
    <script src="plugins/datatables/jszip.min.js"></script>
    <script src="plugins/datatables/pdfmake.min.js"></script>
    <script src="plugins/datatables/pvfs_fonts.js"></script>
    <script src="plugins/datatables/buttons.print.min.js"></script>
    <script src="plugins/datatables/buttons.html5.min.js"></script>
    <!-- Importacao do arquivo comas funções javascript -->
    <script language="JavaScript" src="js/relatoriosDataTables.js"></script>
    <!-- page script -->
    
    <script>
        $(function () {
            
            var titulo = 'Listagem de produtos';
            var subtitulo = 'SistemaCostura';
            var colunas = '0,1,2,3,4';
            
            configuraRelatorios(titulo, subtitulo, colunas);
        });
    </script>
</html>
