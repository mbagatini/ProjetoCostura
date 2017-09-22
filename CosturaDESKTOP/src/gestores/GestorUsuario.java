package gestores;

import apoio.ConexaoBancoDados;
import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;

public class GestorUsuario {

    public Object fazerLogin(String login, String senha) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_usuarios WHERE "
                    + " usu_login = '" + login + "' "
                    + " AND usu_senha = '" + senha + "' ";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(resultado.getInt("usu_codigo"));
                usuario.setUsu_login(resultado.getString("usu_login"));
                usuario.setUsu_senha(resultado.getString("usu_senha"));
                return usuario;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar usuario = " + ex);
            return ex.toString();
        }
    }
}
