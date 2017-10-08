/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Cliente;
import entidade.Endereco;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class ClienteDAO implements IDAO<Cliente> {

    @Override
    public String salvar(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        try {
            String sql = "DELETE FROM cliente "
                    + "WHERE codigo = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao excluir cliente: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registroUnico(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Cliente cli = new Cliente();
        
        try {
            String sql = "SELECT * "
                    + "FROM cliente "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {

                cli.setCodigo(resultado.getInt("codigo"));
                cli.setNome(resultado.getString("nome"));
                cli.setCnpj(resultado.getString("cnpj"));
                cli.setCpf(resultado.getString("cpf"));
                cli.setEndereco((Endereco) new EnderecoDAO().consultarId(resultado.getInt("codigo_endereco")));
                cli.setTelefone(resultado.getString("telefone"));
                cli.setCelular(resultado.getString("celular"));
                cli.setEmail(resultado.getString("email"));
                cli.setDataCadastro(resultado.getDate("data_cadastro"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        return cli;
    }

    @Override
    public boolean consultar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
