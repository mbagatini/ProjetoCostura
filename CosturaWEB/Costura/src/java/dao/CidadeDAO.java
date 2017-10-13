/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Cidade;
import entidade.Estado;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class CidadeDAO implements IDAO<Cidade> {

    @Override
    public String salvar(Cidade objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar(Cidade o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cidade> consultarTodos() {
        ArrayList<Cidade> cidades = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM cidade ORDER BY nome";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {                
                Cidade cid=  new Cidade();
                
                cid.setCodigo(resultado.getInt("codigo"));
                cid.setNome(resultado.getString("nome"));
                cid.setEstado((Estado) new EstadoDAO().consultarId(resultado.getInt("codigo_estado")));
                
                cidades.add(cid);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar cidades: " + e);
        }

        return cidades;
    }

    @Override
    public boolean registroUnico(Cidade o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cidade> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Cidade cid = new Cidade();
        
        try {
            String sql = "SELECT * "
                    + "FROM cidade "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                cid.setCodigo(resultado.getInt("codigo"));
                cid.setNome(resultado.getString("nome"));
                cid.setEstado((Estado) new EstadoDAO().consultarId(resultado.getInt("codigo_estado")));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cidade: " + e);
        }

        return cid;
    }

    @Override
    public boolean consultar(Cidade o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
