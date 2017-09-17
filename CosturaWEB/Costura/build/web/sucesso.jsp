<%-- 
    Document   : sucesso
    Created on : 27/08/2017, 19:54:19
    Author     : Morgana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%-- adiciona a navegação do aplicativo --%>
    <jsp:include page="navegacao.jsp" />

    <head>
        <style>
            .example-modal .modal {
                position: relative;
                top: auto;
                bottom: auto;
                right: auto;
                left: auto;
                display: block;
                z-index: 1;
            }

            .example-modal .modal {
                background: transparent !important;
            }
        </style>
    </head>

    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Main content -->
                <section class="content">
                    <div class="example-modal">
                        <div class="modal modal-success">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">Sucesso!</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>Operação concluída com sucesso&hellip;</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="<%= request.getAttribute("paginaRetorno")%>" type="button" class="btn btn-outline" >Voltar</a>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                    </div>
                    <!-- /.example-modal -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
    </body>
</html>