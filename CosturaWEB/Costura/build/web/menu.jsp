<%-- 
    Document   : index
    Created on : 27/08/2017, 18:51:05
    Author     : Morgana
--%>

<%@page import="entidade.Usuario"%>
<%@page import="apoio.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- adiciona a navegação do aplicativo --%>
    <jsp:include page="navegacao.jsp" />

    <!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
    <!-- the fixed layout is not compatible with sidebar-mini -->
    <body class="hold-transition skin-red sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <!---------- AQUI VAI O CONTEUDO PRINCIPAL DA PAGINA ------------->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Página inicial
                        <small>Que bom ver você aqui!</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home active"></i> Início</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="callout callout-info">
                        <h4>Dica!</h4>
                        <p>Escolha uma opção no menu, ao lado esquerdo, para explorar uma funcionalidade do sistema.</p>
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            
            <!-- footer -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Versão</b> 1.0
                </div>
                <strong>Copyright &copy; 2017 </strong>
            </footer>     
            <!-- /.footer -->
        </div>
        <!-- ./wrapper -->
    </body>
</html>