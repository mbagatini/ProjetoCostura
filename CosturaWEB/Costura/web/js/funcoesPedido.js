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
}

function deleteRow(obj) {
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("produtos");
    table.deleteRow(index);
}

function getHTML(campo, index) {

    var html;

    switch (campo) {
        case 'produto':
            html = '<select class="form-control select2" id="produto_' + index + '" required style="width: 100%;" onChange="atualizaPreco(this)"> ' +
                    '<option value="-1" disabled selected>Selecione</option>';
            <%
                ArrayList<Produto> prod = new ProdutoDAO().consultarTodos();
                for (int i = 0; i < prod.size(); i++) {
            %>
            html = html + '<option value="<%= prod.get(i).getCodigo()%>" >'
                    + '<%= prod.get(i).getReferencia() + " - " + prod.get(i).getDescricao()%>'
                    + '</option>';

            <%  }%>
            html = html + '</select>';
            break;

        case 'tamanho':
            html = '<select class="form-control select2" id="tamanho_' + index + '" required style="width: 100%;"> ' +
                    '<option value="-1" disabled selected>Selecione</option>';
<%
                ArrayList<Tamanho> tam = new TamanhoDAO().consultarTodos();
                for (int i = 0; i < tam.size(); i++) {
%>
            html = html + '<option value="<%= tam.get(i).getCodigo()%>" >'
                    + '<%= tam.get(i).getTamanho()%>'
                    + '</option>';
<%  }%>
            html = html + '</select>';
            break;

        case 'quantidade':
            html = '<input class="form-control" type="number" min="1" pattern="^\d+(?:\d{1,2})?$" id="quantidade_' + index + '" required onChange="atualizaSubtotal(this)">';
            break;

        case 'preco':
            html = '<input class="form-control" type="number" min="1" id="preco_' + index + '" value="0" disabled>';
            break;

        case 'subtotal':
            html = '<input class="form-control" type="number" min="1" id="subtotal_' + index + '" value="0" disabled>';
            break;

        case 'remover':
            html = '<a class="fa fa-trash-o" onClick="deleteRow(this)"></a>';
            break;
    }

    return html;

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