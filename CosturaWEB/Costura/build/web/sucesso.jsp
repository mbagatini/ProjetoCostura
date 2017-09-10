<%-- 
    Document   : sucesso
    Created on : 27/08/2017, 19:54:19
    Author     : Morgana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso!</title>
    </head>
    <body>
        <h1>Cadastro realizado com sucesso!</h1>
        
        <a href="<%= request.getAttribute("paginaRetorno")%>">Voltar</a>
    </body>
</html>
