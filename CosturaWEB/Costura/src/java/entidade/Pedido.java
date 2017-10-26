/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Morgana
 */
public class Pedido {
    
    private int codigo;
    private Date data_emissao;
    private char situacao;
    private Cliente cliente;
    private double desconto;
    private double preco;
    private ArrayList<ItensPedido> itens;
    
    public Pedido(){
        codigo = 0;
        data_emissao = Calendar.getInstance().getTime();
        situacao = ' ';
        cliente = new Cliente();
        desconto = 0;
        preco = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataEmissao() {
        return data_emissao;
    }

    public void setDataEmissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ArrayList<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItensPedido> itens) {
        this.itens = itens;
    }
    
}
