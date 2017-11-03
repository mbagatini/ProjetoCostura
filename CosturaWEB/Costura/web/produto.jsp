<%-- 
    Document   : produto
    Created on : 20/09/2017, 15:47:34
    Author     : Morgana
--%>

<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Produto"%>
<%@page import="entidade.Tamanho"%>
<%@page import="apoio.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- adiciona a navegação do aplicativo --%>
    <jsp:include page="navegacao.jsp" />

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
    <%
        Produto produto = (Produto) request.getAttribute("atributo");

        if (produto == null) {
            produto = new Produto();
        }
    %>

    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Produtos</h1>
                    <ol class="breadcrumb">
                        <li><a href="<%= Constantes.PAGINA_MENU%>"><i class="fa fa-home"></i> Início</a></li>
                        <li><a href="#">Produtos</a></li>
                        <li class="active">Produtos</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
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
                        <form class="form-horizontal" name="cadastroProduto" action="/Costura/Controle?parametro=produto&manut=ins" method="post">
                            <div class="box-body">
                                <input type="hidden" name="id" value="<%= produto.getCodigo()%>">
                                
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Referência*</label>
                                    <div class="col-sm-2">
                                        <input type="number" min="1" class="form-control" name="referencia" value="<%= (produto.getReferencia() == 0) ? "" : produto.getReferencia()%>" required placeholder="Referência">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Descrição*</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="descricao" value="<%= produto.getDescricao()%>" required placeholder="Descrição">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Preço*</label>
                                    <div class="col-sm-2">
                                        <input type="number" min="1" pattern="^\d+(?:\.\d{1,2})?$" class="form-control" name="preco" value="<%= (produto.getPreco() == 0) ? "" : produto.getPreco()%>" required placeholder="Preço">
                                    </div>
                                    
                                    <label class="col-sm-1 control-label">Gênero*</label>
                                    <div class="col-sm-3">
                                        <!-- select -->
                                        <select class="form-control" name="genero" required placeholder="Gênero">
                                            <option value="-1" disabled selected>Selecione</option>
                                            <option value="Feminino" <%= produto.getGenero().equals("Feminino") ? "selected" : ""%>>Feminino</option>
                                            <option value="Masculino" <%= produto.getGenero().equals("Masculino") ? "selected" : ""%>>Masculino</option>
                                            <option value="Unisex" <%= produto.getGenero().equals("Unisex") ? "selected" : ""%>>Unisex</option>
                                        </select>
                                        <!-- /.select -->
                                    </div>
                                        
                                    <label class="col-sm-1 control-label">Categoria*</label>
                                    <div class="col-sm-3">
                                        <!-- select -->
                                        <select class="form-control" name="categoria" required placeholder="Categoria">
                                            <option value="-1" disabled selected>Selecione</option>

                                            <%
                                                ArrayList<Categoria> cat = new CategoriaDAO().consultarTodos();
                                                for (int i = 0; i < cat.size(); i++) {
                                            %>
                                            <option 
                                                value="<%= cat.get(i).getCodigo()%>"  
                                                <%= produto.getCategoria().getCodigo() == cat.get(i).getCodigo() ? "selected" : ""%> >
                                                <%= cat.get(i).getDescricao()%> 
                                            </option>
                                            <%  }%>
                                        </select>
                                        <!-- /.select -->
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

                    <!-- Adiciona a listagem de tamanhos -->
                    <%@include file = "produtoListagem.jsp" %>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Adiciona o footer -->
            <%@include file = "footer.jsp" %>
        </div>
        <!-- ./wrapper -->
    </body>
</html>