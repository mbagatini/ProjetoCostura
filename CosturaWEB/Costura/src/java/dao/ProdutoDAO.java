/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Categoria;
import entidade.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class ProdutoDAO implements IDAO<Produto> {

    @Override
    public String salvar(Produto objeto) {
        try {
            String sql = "INSERT INTO produto VALUES ("
                    + "DEFAULT, "
                    + objeto.getReferencia() + ", "
                    + "'" + objeto.getDescricao() + "', "
                    + "'" + objeto.getPreco() + "', "
                    + "'" + objeto.getGenero() + "', "
                    + objeto.getCategoria().getCodigo()
                    + ")";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar produto: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Produto o) {
        try {
            String sql = "UPDATE produto SET "
                    + "referencia = " + o.getReferencia() + ", "
                    + "descricao = '" + o.getDescricao()+ "', "
                    + "preco = " + o.getPreco() + ", "
                    + "genero = '" + o.getGenero()+ "', "
                    + "codigo_categoria = " + o.getCategoria().getCodigo()
                    + "WHERE codigo = " + o.getCodigo();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto:" + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String excluir(int id) {
        try {
            String sql = "DELETE FROM produto "
                    + "WHERE codigo = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar produto: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            String sql = "SELECT * "
                    + "FROM produto "
                    + "ORDER BY descricao";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Produto pro = new Produto();

                pro.setCodigo(resultado.getInt("codigo"));
                pro.setReferencia(resultado.getInt("referencia"));
                pro.setDescricao(resultado.getString("descricao"));
                pro.setPreco(resultado.getDouble("preco"));
                pro.setGenero(resultado.getString("genero"));
                pro.setCategoria((Categoria) new CategoriaDAO().consultarId(resultado.getInt("codigo_categoria")));

                produtos.add(pro);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produtos: " + e);
        }

        return produtos;
    }

    @Override
    public boolean registroUnico(Produto o) {
        try {
            String sql = "SELECT * "
                    + "FROM produto "
                    + "WHERE UPPER(descricao) = UPPER('" + o.getDescricao() + "')";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Produto pro = new Produto();
        
        try {
            String sql = "SELECT * "
                    + "FROM produto "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                pro.setCodigo(resultado.getInt("codigo"));
                pro.setReferencia(resultado.getInt("referencia"));
                pro.setDescricao(resultado.getString("descricao"));
                pro.setPreco(resultado.getDouble("preco"));
                pro.setGenero(resultado.getString("genero"));
                pro.setCategoria((Categoria) new CategoriaDAO().consultarId(resultado.getInt("codigo_categoria")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return pro;
    }

    @Override
    public boolean consultar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
