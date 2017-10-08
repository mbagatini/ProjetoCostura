<%-- 
    Document   : clientes
    Created on : 07/10/2017, 14:45:58
    Author     : Morgana
--%>

<%@page import="apoio.Constantes"%>
<%@page import="entidade.Cliente"%>
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
        Cliente cliente = (Cliente) request.getAttribute("atributo");

        if (cliente == null) {
            cliente = new Cliente();
        }
    %>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Clientes</h1>
                    <ol class="breadcrumb">
                        <li><a href="<%= Constantes.PAGINA_MENU%>"><i class="fa fa-home"></i> Início</a></li>
                        <li class="active">Clientes</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Cadastro</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Minimizar/Maximizar">
                                    <i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" name="cadastroCliente" action="/Costura/Controle?parametro=cliente&manut=ins" method="post">
                            <div class="box-body">
                                <input type="hidden" name="id" value="<%= cliente.getCodigo()%>">

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Nome*</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="nome" value="<%= cliente.getNome()%>" required placeholder="Nome">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Tipo*</label>
                                    <div class="col-sm-3">
                                        <!-- select -->
                                        <select class="form-control" id="tipo_pessoa" name="tipo_pessoa" required onchange="exibir_ocultar()">
                                            <option value="0">Selecione</option>
                                            <option value="juridica" <%= !cliente.getCnpj().trim().equals("") ? "selected" : ""%>>Pessoa jurídica</option>
                                            <option value="fisica" <%= !cliente.getCpf().trim().equals("") ? "selected" : ""%>>Pessoa física</option>
                                        </select>
                                        <!-- /.select -->
                                    </div>

                                    <div id="cnpj">
                                        <label class="col-sm-1 control-label">CNPJ*</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="cnpj" value="<%= cliente.getCnpj()%>" required placeholder="CNPJ">
                                        </div>
                                    </div>

                                    <div id="cpf">
                                        <label class="col-sm-1 control-label">CPF*</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="cpf" value="<%= cliente.getCpf()%>" required placeholder="CPF">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Endereço*</label>

                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="endereco" value="<%= cliente.getEndereco().getLogradouro()%>" required placeholder="Rua, avenida...">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Bairro*</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" name="bairro" value="<%= cliente.getEndereco().getBairro()%>" required placeholder="Bairro">
                                    </div>

                                    <label class="col-sm-1 control-label">Cidade*</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="cidade" value="<%= cliente.getEndereco().getBairro()%>" required>
                                    </div>

                                    <label class="col-sm-1 control-label">Estado*</label>
                                    <div class="col-sm-1">
                                        <input type="text" class="form-control" name="estado" value="<%= cliente.getEndereco().getCidade().getEstado().getSigla()%>" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Telefone*</label>
                                    <div class="col-sm-3">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone"></i>
                                            </div>
                                            <input type="text" class="form-control" name="telefone" value="<%= cliente.getTelefone()%>" data-inputmask='"mask": "(99) 9999-9999"' data-mask>
                                        </div>
                                        <!-- /.input group -->
                                    </div>

                                    <label class="col-sm-1 control-label">Celular*</label>
                                    <div class="col-sm-4">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone"></i>
                                            </div>
                                            <input type="text" class="form-control" name="celular" value="<%= cliente.getCelular()%>" data-inputmask='"mask": "(99) 99999-9999"' data-mask>
                                        </div>
                                        <!-- /.input group -->
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

                    <!-- Adiciona a listagem  -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Adiciona o footer -->
            <%@include file = "footer.jsp" %>
        </div>
        <!-- ./wrapper -->

        <!-- page script -->
        <!-- Select2 -->
        <script src="plugins/select2/select2.full.min.js"></script>
        <!-- InputMask -->
        <script src="plugins/input-mask/jquery.inputmask.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
        <!-- Page script -->
        <script>
            $(function () {
                //Initialize Select2 Elements
                $(".select2").select2();

                //Money Euro
                $("[data-mask]").inputmask();
                
                //Ajusta o CNPJ/CPF conforme o tipo de pessoa
                exibir_ocultar();
             });
        </script>
        <script>
            function exibir_ocultar() {
                var valor = $("#tipo_pessoa").val();

                if (valor == 'fisica') {
                    $("#cnpj").hide();
                    $("#cpf").show();
                } else {
                    $("#cnpj").show();
                    $("#cpf").hide();
                }
            }
            ;
        </script>
    </body>
</html>
