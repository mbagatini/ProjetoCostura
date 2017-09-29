/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class CategoriaDAO implements IDAO<Categoria>{

    @Override
    public String salvar(Categoria objeto) {
        try {
            String sql = "INSERT INTO categoria VALUES (DEFAULT,"
                    + "'" + objeto.getDescricao()+ "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Categoria o) {
        try {
            String sql = "UPDATE categoria SET "
                    + "descricao = '" + o.getDescricao()+ "' "
                    + "WHERE codigo = " + o.getCodigo();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar categoria:" + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String excluir(int id) {
        try {
            String sql = "DELETE FROM categoria "
                    + "WHERE codigo = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Categoria> consultarTodos() {
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            String sql = "SELECT * FROM categoria ORDER BY descricao";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {                
                Categoria cat=  new Categoria();
                
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setDescricao(resultado.getString("descricao"));
                
                categorias.add(cat);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar categorias: " + e);
        }

        return categorias;
    }

    @Override
    public boolean registroUnico(Categoria o) {
        try {
            String sql = "SELECT * "
                    + "FROM categoria "
                    + "WHERE UPPER(descricao) = UPPER('" + o.getDescricao() + "')";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar categoria: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Categoria> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Categoria cat = new Categoria();
        
        try {
            String sql = "SELECT * "
                    + "FROM categoria "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {

                cat.setCodigo(resultado.getInt("codigo"));
                cat.setDescricao(resultado.getString("descricao"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar categoria: " + e);
        }

        return cat;
    }

    @Override
    public boolean consultar(Categoria o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
