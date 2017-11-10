/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function getPrecoProduto(codigo, index) {
    $(document).ready(function () {
        $.ajax({
            url: "/Costura/Controle?parametro=precoProduto&codigoProduto=" + codigo,
            type: "POST",
            dataType: "text",
            data: {codigoProduto: codigo},
            success: function (preco) {
                var campo = "#preco_" + index;
                $(campo).val(preco);
            }
        });
    });
}