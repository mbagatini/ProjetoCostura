/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Pedido;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class PedidoDAO implements IDAO<Pedido> {

    @Override
    public String salvar(Pedido objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registroUnico(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int proximoNumero(){
        int numero = 0;
        try {
            String sql = "SELECT coalesce(MAX(codigo),0)+1 numero FROM pedido";
            
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                numero = (resultado.getInt("numero"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao pegar o próximo numero de pedido:" + e);
            return 0;
        }
        return numero;
    }
    
}
