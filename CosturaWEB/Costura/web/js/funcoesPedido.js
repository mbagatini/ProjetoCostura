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
            dataType: "json",
            data: {produto: codigo},
            success: function (precos) {
                var campo = "#preco_" + index;
                
                $(campo).html(""); // clear before appending new list
                var string = "";
                $.each(precos, function (i, preco) {
                    string = '<input class="form-control" type="number" min="1" id="preco_'+ index +'" value="' + preco.valor + '" disabled>';
                });
                $(campo).html("" + string);
            }
        });
        
    });
}