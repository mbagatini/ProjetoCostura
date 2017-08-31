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
        <h1>Cadastro de usuários</h1>

        <form name="cadastroUsuario" action="/Costura/acao?parametro=cadastroUsuario" method="post">
            <label>Nome</label>
            <br>
            <input type="text" name="nome">
            <br>

            <label>E-mail</label>
            <br>
            <input type="email" name="email">
            <br>

            <label>Senha</label>
            <br>
            <input type="password" name="senha">
            <br>
            <br>

            <input type="submit" name="enviar" value="Salvar">
        </form>
    </body>
</html>