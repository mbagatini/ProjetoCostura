/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Tamanho;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class TamanhoDAO implements IDAO<Tamanho> {

    @Override
    public String salvar(Tamanho objeto) {
        try {
            String sql = "INSERT INTO tamanho VALUES (DEFAULT,"
                    + "'" + objeto.getTamanho() + "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar tamanho: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Tamanho o) {
        try {
            String sql = "UPDATE tamanho SET "
                    + "tamanho = '" + o.getTamanho() + "' "
                    + "WHERE codigo = " + o.getCodigo();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar tamanho:" + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String excluir(int id) {
        try {
            String sql = "DELETE FROM tamanho "
                    + "WHERE codigo = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao excluir tamanho: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Tamanho> consultarTodos() {
        ArrayList<Tamanho> tamanhos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tamanho ORDER BY tamanho";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Tamanho tam = new Tamanho();

                tam.setCodigo(resultado.getInt("codigo"));
                tam.setTamanho(resultado.getString("tamanho"));

                tamanhos.add(tam);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar tamanhos: " + e);
        }

        return tamanhos;
    }

    @Override
    public boolean registroUnico(Tamanho o) {
        try {
            String sql = "SELECT * "
                    + "FROM tamanho "
                    + "WHERE UPPER(tamanho) = UPPER('" + o.getTamanho()+ "')";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar tamanho: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Tamanho> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Tamanho tam = new Tamanho();
        
        try {
            String sql = "SELECT * "
                    + "FROM tamanho "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {

                tam.setCodigo(resultado.getInt("codigo"));
                tam.setTamanho(resultado.getString("tamanho"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar tamanho: " + e);
        }

        return tam;
    }

    @Override
    public boolean consultar(Tamanho o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
