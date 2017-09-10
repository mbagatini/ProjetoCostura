<%-- 
    Document   : usuario
    Created on : 27/08/2017, 19:08:12
    Author     : Morgana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        <%-- Carrega o objeto passado pelo metodo doGet do Controle --%>
        <%
            Usuario usuario = (Usuario) request.getAttribute("atributo");

            if (usuario == null) {
                usuario = new Usuario();
            }
        %>
        
        <h1>Cadastro de usuários</h1>

        <form name="cadastroUsuario" action="/Costura/Controle?parametro=usuario&manut=ins" method="post">
            <input type="hidden" name="id" value="<%= usuario.getCodigo()%>">
            
            <label>Nome</label>
            <br>
            <input type="text" required="required" name="nome" value="<%= usuario.getNome()%>">
            <br>

            <label>E-mail</label>
            <br>
            <input type="email" required="required" name="email" value="<%= usuario.getEmail()%>">
            <br>

            <label>Senha</label>
            <br>
            <input type="password" required="required" name="senha">
            <br>
            <br>

            <input type="submit" name="enviar" value="Salvar">
        </form>
        
        <!-- Adiciona a listagem de usuários -->
        <%@include file = "usuarioListagem.jsp" %>
    </body>
</html>