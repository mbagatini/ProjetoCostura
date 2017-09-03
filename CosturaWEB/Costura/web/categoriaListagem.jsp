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
        <title>Costura</title>
    </head>
    <body>
        <h1>Categorias cadastradas</h1>

        <table>
            <tr>
                <th>Código</th>
                <th>Descrição</th>
            </tr>
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
        </table>
    </body>
</html>
