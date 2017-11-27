/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function consultarCliente(codigo) {
    $(document).ready(function () {
        $.ajax({
            url: "/Costura/Controle?parametro=consultaCliente&codigoCliente=" + codigo,
            type: "POST",
            dataType: "json",
            data: {codigoCliente: codigo},
            success: function (cliente) {
                $('#consulta_cliente').text(cliente.nome);
                $('#consulta_cnpj_cpf').text(cliente.cnpj_cpf);
                $('#consulta_endereco').text(cliente.endereco);
                $('#consulta_bairro').text(cliente.bairro);
                $('#consulta_cidade').text(cliente.cidade);
                $('#consulta_telefone').text(cliente.telefone);
                $('#consulta_celular').text(cliente.celular);
                $('#consulta_email').text(cliente.email);
                $('#consulta_data_cadastro').text(cliente.data_cadastro);
            }
        });
    });
}