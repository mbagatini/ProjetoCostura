/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apoio.ConexaoBD;
import dao.ClienteDAO;
import entidade.Cliente;
import entidade.ItensPedido;
import entidade.Pedido;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControlePedido {
    
    Connection conn = null;
    Statement st = null;
    
    public boolean cadastrar(HttpServletRequest request) {
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        // Cabeçalho do pedido
        Pedido ped = new Pedido();
        ped.setCodigo(id);
        ped.setDataEmissao(Calendar.getInstance().getTime());
        ped.setSituacao((request.getParameter("situacao")).charAt(0));
        ped.setCliente((Cliente) new ClienteDAO().consultarId(Integer.parseInt(String.valueOf(request.getParameter("cliente")))));
        ped.setDesconto(Double.parseDouble(String.valueOf(request.getParameter("desconto"))));
        ped.setPreco(Double.parseDouble(String.valueOf(request.getParameter("valorLiquido"))));
        
        // Itens do pedido
        ArrayList<ItensPedido> itens = new ArrayList<ItensPedido>();
        String[] posicoes = request.getParameterValues("produtos");
        
        
        try {
            // BLOQUEAR O AUTO COMMIT
            conn = ConexaoBD.getInstance().getConnection();
            conn.setAutoCommit(false);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlePedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        String retorno = null;
        
        return (retorno == null);
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        return request;
    }
    
    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = null;

        return (retorno == null);
    }
}
