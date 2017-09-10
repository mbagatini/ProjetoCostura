<%-- 
    Document   : categoria
    Created on : 02/09/2017, 20:50:07
    Author     : Morgana
--%>

<%@page import="entidade.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
        <%
            Categoria categoria = (Categoria) request.getAttribute("atributo");

            if (categoria == null) {
                categoria = new Categoria();
            }
        %>
        
        <h1>Cadastro de usuários</h1>

        <form name="cadastroCategoria" action="/Costura/Controle?parametro=categoria&manut=ins" method="post">
            <input type="hidden" name="id" value="<%= categoria.getCodigo()%>">
            
            <label>Descrição</label>
            <br>
            <input type="text" required="required" name="descricao" value="<%= categoria.getDescricao()%>">
            <br>
            <br>

            <input type="submit" name="enviar" value="Salvar">
        </form>
        
        <!-- Adiciona a listagem de usuários -->
        <%@include file = "categoriaListagem.jsp" %>
            
    </body>
</html>
