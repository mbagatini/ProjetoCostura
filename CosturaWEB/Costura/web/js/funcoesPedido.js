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

    row.insertCell(0).innerHTML = getHTML('produto', rowCount);
    row.insertCell(1).innerHTML = getHTML('tamanho', rowCount);
    row.insertCell(2).innerHTML = getHTML('quantidade', rowCount);
    row.insertCell(3).innerHTML = getHTML('preco', rowCount);
    row.insertCell(4).innerHTML = getHTML('subtotal', rowCount);
    row.insertCell(5).innerHTML = getHTML('remover', rowCount);
}

function atualizaPreco(obj) {
    // Atualiza o preço do produto
    var index = obj.parentNode.parentNode.rowIndex;
    var produto = document.getElementById("produto_" + index).value;

    getPrecoProduto(produto, index);
    atualizaSubtotal(obj);
}

function atualizaSubtotal(obj) {
    // Atualiza o subtotal do produto
    var index = obj.parentNode.parentNode.rowIndex;
    var preco = document.getElementById("preco_" + index).value;
    var qtde = document.getElementById("quantidade_" + index).value;

    var subtotal = preco * qtde;

    $('#subtotal_' + index).val(subtotal);

    atualizaTotal();
}

function atualizaTotal() {
    var table = document.getElementById("produtos");
    var total = 0;

    for (i = 1; i < table.rows.length; i++) {
        total += Number(document.getElementById("subtotal_" + i).value);
    }

    $('#valorTotal').val(total);
    
    atualizaTotalLiquido();
}

function atualizaTotalLiquido() {
    var total = Number(document.getElementById("valorTotal").value);
    var desconto = Number(document.getElementById("desconto").value);
    $('#valorLiquido').val(total-desconto);
}

function deleteRow(obj) {
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("produtos");
    table.deleteRow(index);
}

function getTable() {

    var array = [];
    var headers = [];
    $('#produtos th').each(function (index, item) {
        headers[index] = $(item).html();
    });
    $('#produtos tr').has('td').each(function () {
        var arrayItem = {};
        $('td', $(this)).each(function (index, item) {
            arrayItem[headers[index]] = $(item).html();
        });
        array.push(arrayItem);
    });

}