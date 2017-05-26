package entidades;

import java.util.ArrayList;
import java.util.Date;

public class OrdemProducao {

    private int ord_ordcodigo;
    private Pedido pedido;
    private char ord_situacao;
    private Date data_ini;
    private Date data_fim;
    private ArrayList<ItemPedido> itens_ordem;

    /**
     * @return the ord_ordcodigo
     */
    public int getOrd_ordcodigo() {
        return ord_ordcodigo;
    }

    /**
     * @param ord_ordcodigo the ord_ordcodigo to set
     */
    public void setOrd_ordcodigo(int ord_ordcodigo) {
        this.ord_ordcodigo = ord_ordcodigo;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the ord_situacao
     */
    public char getOrd_situacao() {
        return ord_situacao;
    }

    /**
     * @param ord_situacao the ord_situacao to set
     */
    public void setOrd_situacao(char ord_situacao) {
        this.ord_situacao = ord_situacao;
    }

    /**
     * @return the data_ini
     */
    public Date getData_ini() {
        return data_ini;
    }

    /**
     * @param data_ini the data_ini to set
     */
    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    /**
     * @return the data_fim
     */
    public Date getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    /**
     * @return the itens_ordem
     */
    public ArrayList<ItemPedido> getItens_ordem() {
        return itens_ordem;
    }

    /**
     * @param itens_ordem the itens_ordem to set
     */
    public void setItens_ordem(ArrayList<ItemPedido> itens_ordem) {
        this.itens_ordem = itens_ordem;
    }
    
}
