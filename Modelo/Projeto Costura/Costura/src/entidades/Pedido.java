package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int ped_codigo;
    private Cliente cliente;
    private Date ped_data;
    private char ped_situacao;
    private ArrayList<ItemPedido> itens_pedido;

    /**
     * @return the ped_codigo
     */
    public int getPed_codigo() {
        return ped_codigo;
    }

    /**
     * @param ped_codigo the ped_codigo to set
     */
    public void setPed_codigo(int ped_codigo) {
        this.ped_codigo = ped_codigo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the ped_data
     */
    public Date getPed_data() {
        return ped_data;
    }

    /**
     * @param ped_data the ped_data to set
     */
    public void setPed_data(Date ped_data) {
        this.ped_data = ped_data;
    }

    /**
     * @return the ped_situacao
     */
    public char getPed_situacao() {
        return ped_situacao;
    }

    /**
     * @param ped_situacao the ped_situacao to set
     */
    public void setPed_situacao(char ped_situacao) {
        this.ped_situacao = ped_situacao;
    }

    /**
     * @return the itens_pedido
     */
    public ArrayList<ItemPedido> getItens_pedido() {
        return itens_pedido;
    }

    /**
     * @param itens_pedido the itens_pedido to set
     */
    public void setItens_pedido(ArrayList<ItemPedido> itens_pedido) {
        this.itens_pedido = itens_pedido;
    }
    
    
}
