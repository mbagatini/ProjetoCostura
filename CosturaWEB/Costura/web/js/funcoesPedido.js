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

function addRow() {
    var table = document.getElementById("produtos");
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    while (document.getElementById("produto_" + rowCount) !== null) {
        rowCount++;
    }

    row.insertCell(0).innerHTML = getHTML('produto', rowCount, '');
    row.insertCell(1).innerHTML = getHTML('tamanho', rowCount, '');
    row.insertCell(2).innerHTML = getHTML('quantidade', rowCount, '');
    row.insertCell(3).innerHTML = getHTML('preco', rowCount, '');
    row.insertCell(4).innerHTML = getHTML('subtotal', rowCount, '');
    row.insertCell(5).innerHTML = getHTML('remover', rowCount, '');

}

function atualizaPreco(obj) {
    var index = obj.id;
    // Pega o numero do id
    var index = index.match(/\d+/)[0];
    var produto = document.getElementById("produto_" + index).value;

    getPrecoProduto(produto, index);
    atualizaSubtotal(obj);
}

function atualizaSubtotal(obj) {
    var index = obj.id;
    // Pega o numero do id
    var index = index.match(/\d+/)[0];
    var preco = document.getElementById("preco_" + index).value;
    var qtde = document.getElementById("quantidade_" + index).value;

    var subtotal = preco * qtde;

    $('#subtotal_' + index).val(subtotal);

    atualizaTotal();
}

function atualizaTotal() {
    var total = 0;

    for (i = 1; i < 50; i++) {
        if (document.getElementById("subtotal_" + i) !== null) {
            total += Number(document.getElementById("subtotal_" + i).value);
        }
    }

    $('#valorTotal').val(total);

    atualizaTotalLiquido();
}

function atualizaTotalLiquido() {
    var total = Number(document.getElementById("valorTotal").value);
    var desconto = Number(document.getElementById("desconto").value);
    $('#valorLiquido').val(total - desconto);
}

function deleteRow(obj) {
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("produtos");
    table.deleteRow(index);

    atualizaTotal();
}

function consultarPedido(codigo) {
    $(document).ready(function () {
        $.ajax({
            url: "/Costura/Controle?parametro=consultaPedido&codigoPedido=" + codigo,
            type: "POST",
            dataType: "json",
            data: {codigoPedido: codigo},
            success: function (pedido) {
                $('#consulta_pedido').text(codigo);
                $('#consulta_cnpj_cpf').text(pedido.cnpj_cpf);
                $('#consulta_cliente').text(pedido.cliente);
                $('#consulta_data_emissao').text(pedido.data_emissao);
                $('#consulta_situacao').text(pedido.situacao);
                $('#consulta_valor_total').text(pedido.valor_total);
                $('#consulta_desconto').text(pedido.desconto);
                $('#consulta_total_liquido').text(pedido.total_liquido);
                
                // Itens
                var table = document.getElementById("consulta_produtos");
                
                // Deleta todas linhas antes
                for (var i = 0; i < table.rows.length; i++) {
                    table.deleteRow(i);
                }
                
                // Insere as linhas
                pedido.itens.forEach(function (item) {
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);
                    
                    row.insertCell(0).innerHTML = item.produto;
                    row.insertCell(1).innerHTML = item.tamanho;
                    row.insertCell(2).innerHTML = item.quantidade;
                    row.insertCell(3).innerHTML = item.valor;
                    row.insertCell(4).innerHTML = item.subtotal;
                });
            }
        });
    });
}