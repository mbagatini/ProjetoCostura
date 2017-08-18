/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Nota {
    
    private int not_codigo;
    private Pedido pedido;
    private Date not_data;
    private double not_valor;

    /**
     * @return the not_codigo
     */
    public int getNot_codigo() {
        return not_codigo;
    }

    /**
     * @param not_codigo the not_codigo to set
     */
    public void setNot_codigo(int not_codigo) {
        this.not_codigo = not_codigo;
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
     * @return the not_data
     */
    public Date getNot_data() {
        return not_data;
    }

    /**
     * @param not_data the not_data to set
     */
    public void setNot_data(Date not_data) {
        this.not_data = not_data;
    }

    /**
     * @return the not_valor
     */
    public double getNot_valor() {
        return not_valor;
    }

    /**
     * @param not_valor the not_valor to set
     */
    public void setNot_valor(double not_valor) {
        this.not_valor = not_valor;
    }
    
}
