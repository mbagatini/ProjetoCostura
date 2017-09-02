<%-- 
    Document   : usuarioListagem
    Created on : 31/08/2017, 22:03:52
    Author     : Morgana
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Costura</title>
    </head>
    <body>
        <h1>Usuários Cadastrados</h1>

        <table>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>E-mail</th>
            </tr>
            <%
                ArrayList<Usuario> usuarios = new UsuarioDAO().consultarTodos();

                for (int i = 0; i < usuarios.size(); i++) {
            %>
            <tr>
                <td><%= usuarios.get(i).getId()%></td>
                <td><%= usuarios.get(i).getNome()%></td>
                <td><%= usuarios.get(i).getEmail()%></td>
                <td><a href="/Costura/Controle?parametro=usuario&manut=upd&id=<%= usuarios.get(i).getId()%>">Editar</a></td>
                <td><a href="/Costura/Controle?parametro=usuario&manut=del&id=<%= usuarios.get(i).getId()%>">Excluir</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>