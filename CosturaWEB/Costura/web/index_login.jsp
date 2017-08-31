<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Projeto Costura</title>
        <!-- Bootstrap core CSS -->
        <link href="boots/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom styles for this template -->
        <link href="boots/css/signin.css" rel="stylesheet">
    </head>
    <body>
        <h1 style="text-align:center;">Bem-vindo ao Projeto Costura</h1>
        <div class="container">
            <form name="login" method="post" action="/Costura/acao?parametro=login" class="form-signin" onsubmit="return validar()">
                <br>
                <label >Usuário</label>
                <input type="email" name="emailUsuario" class="form-control" id="inputEmail" required >
                <br>
                <label>Senha</label>
                <input type="password" name="senha" class="form-control" id="inputPassword" required >
                <br>
                <input type="submit" value="Acessar" class="btn btn-lg btn-primary btn-block">
            </form>
        </div>
    </body>
    <!-- Importacao do arquivo de validacao -->
    <script language="JavaScript" src="JS/validacaoLogin.js"></script>

</html>
