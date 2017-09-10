   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Usuario;
import java.sql.ResultSet;
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
                    + "'" + objeto.getEmail()+ "',"
                    + "'" + objeto.getSenha() + "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Usuario o) {
        try {
            String sql = "UPDATE usuario SET "
                    + "nome = '" + o.getNome() + "', "
                    + "email = '" + o.getEmail() + "',"
                    + "senha = '" + o.getSenha() + "' "
                    + "WHERE codigo = " + o.getCodigo();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String excluir(int id) {
        try {
            String sql = "DELETE FROM usuario "
                    + "WHERE codigo = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM usuario"
                    + " ORDER BY nome ";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {                
                Usuario u = new Usuario();
                
                u.setCodigo(resultado.getInt("codigo"));
                u.setNome(resultado.getString("nome"));
                u.setEmail(resultado.getString("email"));
                
                usuarios.add(u);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuários: " + e);
        }

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
        Usuario u = new Usuario();

        try {
            String sql = "SELECT * "
                    + "FROM usuario "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {

                u.setCodigo(resultado.getInt("codigo"));
                u.setNome(resultado.getString("nome"));
                u.setEmail(resultado.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário: " + e);
        }

        return u;
    }

    @Override
    public boolean consultar(Usuario o) {
        Usuario u = (Usuario) o;
        try {

            String sql = "SELECT * "
                    + " FROM usuario "
                    + "WHERE email = '" + u.getEmail() + "' "
                    + "  AND senha = '" + u.getSenha() + "'";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao validar usuário: " + e);
        }

        return false;
    }

}
