/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Usuario;
import java.util.ArrayList;

/**
 *
 * @author fabricio.pretto
 */
public class UsuarioDAO implements IDAO<Usuario> {

    @Override
    public String salvar(Usuario objeto) {

        try {
            String sql = "INSERT INTO usuario VALUES (DEFAULT,"
                    + "'" + objeto.getNome() + "', "
                    + "'" + objeto.getEmail() + "',"
                    + "'" + objeto.getSenha() + "',"
                    + ")";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

//        try {
//            String sql = "SELECT * FROM usuario";
//
//            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
//
//            while (resultado.next()) {                
//                Usuario u = new Usuario();
//                
//                u.setId(resultado.getInt("id"));
//                u.setNome(resultado.getString("nome"));
//                u.setEmail(resultado.getString("e_mail"));
//                u.setSituacao(resultado.getString("situacao").charAt(0));
//                
//                usuarios.add(u);
//            }
//            
//        } catch (Exception e) {
//            System.out.println("erro ao consultar usuários: " + e);
//        }

        return usuarios;
    }

    @Override
    public boolean registroUnico(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
