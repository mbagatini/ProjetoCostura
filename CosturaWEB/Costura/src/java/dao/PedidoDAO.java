/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAO;
import entidade.Cliente;
import entidade.ItensPedido;
import entidade.Pedido;
import entidade.Produto;
import entidade.Tamanho;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Morgana
 */
public class PedidoDAO implements IDAO<Pedido> {

    Connection conn = null;
    Statement st = null;

    @Override
    public String salvar(Pedido objeto) {

        int codigoPedido;
        String dataEmissao = null;
        try {
            dataEmissao = Formatacao.retornaDataFormatadaAMD(objeto.getDataEmissao());
        } catch (ParseException ex) {
            System.out.println("Erro ao formatar a data do pedido: " + ex);
            return ex.toString();
        }

        try {
            // BLOQUEAR O AUTO COMMIT
            conn = ConexaoBD.getInstance().getConnection();
            conn.setAutoCommit(false);

            // Grava o pedido
            String sql = "INSERT INTO pedido VALUES ("
                    + "DEFAULT, "
                    + "'" + dataEmissao + "', "
                    + "'" + objeto.getSituacao() + "', "
                    + objeto.getCliente().getCodigo() + ", "
                    + "'" + objeto.getDesconto() + "', "
                    + "'" + objeto.getPreco() + "'"
                    + ") returning codigo";

            ResultSet resul = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            resul.next();

            codigoPedido = resul.getInt(1);

            // Grava os itens do pedido
            st = ConexaoBD.getInstance().getConnection().createStatement();
            for (ItensPedido item : objeto.getItens()) {
                sql = "INSERT INTO item_pedido VALUES ("
                        + codigoPedido + ", "
                        + item.getProduto().getCodigo() + ", "
                        + item.getTamanho().getCodigo() + ", "
                        + item.getQuantidade() + ", "
                        + "'" + item.getProduto().getPreco() + "'"
                        + ") ";

                int resultado = st.executeUpdate(sql);
            }

            // Comita os dados
            conn.commit();
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar pedido: " + ex);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                System.out.println("Erro ao atualizar pedido: " + ex1);
            }
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Pedido o) {
        Pedido pedido = o;

        String dataEmissao = null;
        try {
            dataEmissao = Formatacao.retornaDataFormatadaAMD(pedido.getDataEmissao());
        } catch (ParseException ex) {
            System.out.println("Erro ao formatar a data do pedido: " + ex);
            return ex.toString();
        }

        try {
            // BLOQUEAR O AUTO COMMIT
            conn = ConexaoBD.getInstance().getConnection();
            conn.setAutoCommit(false);

            int retorno;

            // Atualiza o pedido
            String sql = "UPDATE pedido SET "
                    + "data_emissao = '" + dataEmissao + "', "
                    + "situacao = '" + pedido.getSituacao() + "', "
                    + "codigo_cliente = " + pedido.getCliente().getCodigo() + ", "
                    + "desconto = '" + pedido.getDesconto() + "', "
                    + "preco = '" + pedido.getPreco() + "'"
                    + " WHERE codigo = " + pedido.getCodigo();

            retorno = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

            // Regrava os itens do pedido
            sql = "DELETE FROM item_pedido WHERE codigo_pedido = " + pedido.getCodigo();
            retorno = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

            st = ConexaoBD.getInstance().getConnection().createStatement();
            for (ItensPedido item : pedido.getItens()) {
                sql = "INSERT INTO item_pedido VALUES ("
                        + pedido.getCodigo() + ", "
                        + item.getProduto().getCodigo() + ", "
                        + item.getTamanho().getCodigo() + ", "
                        + item.getQuantidade() + ", "
                        + "'" + item.getProduto().getPreco() + "'"
                        + ") ";

                retorno = st.executeUpdate(sql);
            }

            // Comita os dados
            conn.commit();
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro atualizar pedido: " + ex);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                System.out.println("Erro ao atualizar pedido: " + ex1);
            }
            return ex.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            // BLOQUEAR O AUTO COMMIT
            conn = ConexaoBD.getInstance().getConnection();
            conn.setAutoCommit(false);

            String sql;
            int resultado;

            // Apaga os itens
            sql = "DELETE FROM item_pedido "
                    + "WHERE codigo_pedido = " + id;

            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

            // Apaga o pedido
            sql = "DELETE FROM pedido "
                    + "WHERE codigo = " + id;

            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

            conn.commit();
            return null;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir pedido: " + e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e2) {
                System.out.println("Erro ao excluir pedido: " + e2);
            }
            return e.toString();
        }
    }

    @Override
    public ArrayList<Pedido> consultarTodos() {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

        try {
            String sql = "SELECT * "
                    + "FROM pedido "
                    + "ORDER BY data_emissao";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pedido ped = new Pedido();

                ped.setCodigo(resultado.getInt("codigo"));
                ped.setDataEmissao(resultado.getDate("data_emissao"));
                ped.setCliente((Cliente) new ClienteDAO().consultarId(resultado.getInt("codigo_cliente")));
                ped.setSituacao(resultado.getString("situacao").charAt(0));
                ped.setDesconto(resultado.getDouble("desconto"));
                ped.setPreco(resultado.getDouble("preco"));

                // Carrega os itens
                ArrayList<ItensPedido> itens = new ArrayList<ItensPedido>();

                sql = "SELECT * "
                        + "FROM item_pedido "
                        + "WHERE codigo_pedido = " + ped.getCodigo()
                        + "ORDER BY codigo_produto";

                ResultSet resultadoItem = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

                while (resultadoItem.next()) {
                    ItensPedido item = new ItensPedido();
                    Produto p = (Produto) new ProdutoDAO().consultarId(resultadoItem.getInt("codigo_produto"));
                    p.setPreco(resultadoItem.getDouble("preco_unitario"));
                    item.setProduto(p);
                    item.setTamanho((Tamanho) new TamanhoDAO().consultarId(resultadoItem.getInt("codigo_tamanho")));
                    item.setQuantidade(resultadoItem.getInt("quantidade"));
                    
                    itens.add(item);
                }

                ped.setItens(itens);
                
                pedidos.add(ped);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar pedidos: " + e);
        }
        return pedidos;
    }

    @Override
    public boolean registroUnico(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarId(int id) {
        Pedido pedido = new Pedido();

        try {
            String sql = "SELECT * "
                    + "FROM pedido "
                    + "WHERE codigo = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultado.next()) {
                pedido.setCodigo(resultado.getInt("codigo"));
                pedido.setDataEmissao(resultado.getDate("data_emissao"));
                pedido.setSituacao(resultado.getString("situacao").charAt(0));
                pedido.setCliente((Cliente) new ClienteDAO().consultarId(resultado.getInt("codigo_cliente")));
                pedido.setDesconto(resultado.getDouble("desconto"));
                pedido.setPreco(resultado.getDouble("preco"));
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar pedido: " + e);
            return null;
        }

        return pedido;
    }

    @Override
    public boolean consultar(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int proximoNumero() {
        int numero = 0;
        try {
            String sql = "SELECT last_value + 1 FROM pedido_codigo_seq";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                numero = (resultado.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Erro ao pegar o próximo numero de pedido:" + e);
            return 0;
        }
        return numero;
    }

}
