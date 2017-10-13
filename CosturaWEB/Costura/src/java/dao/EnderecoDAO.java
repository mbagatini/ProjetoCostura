/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Cidade;
import entidade.Endereco;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class EnderecoDAO implements IDAO<Endereco> {

    @Override
    public String salvar(Endereco objeto) {
        try {
            String sql = "INSERT INTO endereco VALUES("
                    + " DEFAULT, "
                    + "'" + objeto.getLogradouro() + "', "
                    + "'" + objeto.getBairro() + "', "
                    + objeto.getCidade().getCodigo()
                    + ")";
            
            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println("Erro ao salvar endereço: " + e);
            return e.toString();
        }
        
        return null;
    }

    @Override
    public String atualizar(Endereco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Endereco> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registroUnico(Endereco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Endereco> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Endereco end = new Endereco();
        
        try {
            String sql = "SELECT * "
                    + "FROM endereco "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                end.setCodigo(resultado.getInt("codigo"));
                end.setLogradouro(resultado.getString("logradouro"));
                end.setBairro(resultado.getString("bairro"));
                end.setCidade((Cidade) new CidadeDAO().consultarId(resultado.getInt("codigo_cidade")));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar endereço: " + e);
        }

        return end;
    }

    @Override
    public boolean consultar(Endereco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Endereco consultarEndereco(Endereco o){
        Endereco e = (Endereco) o;
        
        try {
            String sql = "SELECT * "
                    + " FROM endereco "
                    + "WHERE lower(logradouro) = lower('" + e.getLogradouro() + "') "
                    + "  AND lower(bairro) = lower('" + e.getBairro() + "')"
                    + "  AND codigo_cidade = " + e.getCidade().getCodigo();

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                e.setCodigo(resultado.getInt("codigo"));
                e.setLogradouro(resultado.getString("logradouro"));
                e.setBairro(resultado.getString("bairro"));
                e.setCidade((Cidade) new CidadeDAO().consultarId(resultado.getInt("codigo_cidade")));
                return e;
            }

        } catch (Exception ex) {
            System.out.println("Erro ao consultar endereço: " + ex);
        }

        return null;
    }
    
}
