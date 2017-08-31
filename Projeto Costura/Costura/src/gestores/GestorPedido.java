package gestores;

import apoio.ConexaoBancoDados;
import apoio.Formatacao;
import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import interfaces.IGestores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorPedido implements IGestores{

    private final GestorProdutos gestorproduto = new GestorProdutos();
    private final GestorCliente  gestocliente  = new GestorCliente();

    @Override
    public String salvar(Object o) {
        Connection conn = null;
        Statement st = null;
        Pedido pedido = (Pedido) o;
        try {
            // Bloquear o auto commit, para faze-lo apenas quando inserir todas as informações
            conn = ConexaoBancoDados.getInstance().getConnection();
            conn.setAutoCommit(false);
            
            String sql;
            int codigo_pedido;

            sql = "INSERT INTO tb_pedidos VALUES"
                + "(DEFAULT, "
                + "" + pedido.getCliente().getCodigo() + ", " 
                + "'" + Formatacao.retornaDataFormatada(pedido.getPed_data()) + "', "
                + "'" + pedido.getPed_situacao() +"') RETURNING ped_codigo";
            System.out.println("sql: " + sql);
            ResultSet resul = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);
            resul.next();

            codigo_pedido = resul.getInt(1);
            
            st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            for(ItemPedido item: pedido.getItens_pedido()){
                int resultado;
                sql = "INSERT INTO tb_itens_pedido VALUES ("
                    + "" + codigo_pedido + ", "
                    + "" + item.getProduto().getCodigo()+ ", "
                    + "" + item.getQuantidade() + ", "
                    + "'" + item.getPreco() + "') ";
                System.out.println("sql: " + sql);
                resultado = st.executeUpdate(sql);
            }
            
            
            
            conn.commit();
            return null;
        } catch (SQLException ex) {
            System.out.println("Erro salvar pedido = " + ex);
            try{
                if(conn != null){
                    conn.rollback();
                }
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            return ex.toString();
        } catch (ParseException ex) {
            System.out.println("Erro salvar pedido = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            // DELETA OS ITENS DO PEDIDO
            String sql = "DELETE FROM tb_itens_pedido "
                       + "WHERE ped_codigo = " + id;
            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql); 

            // DELETA O PEDIDO
            sql = "DELETE FROM tb_pedidos "
                + "WHERE ped_codigo = " + id;
            System.out.println("sql: " + sql);
            resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir pedido: " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listapedidos;
        listapedidos = new ArrayList<>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_pedidos");
            while (resultadoQ.next()) {
                listapedidos.add(consultarCod(resultadoQ.getInt(1)));
            }       
        } catch (Exception ex) {
            System.out.println("Erro ao consultar pedido: " + ex);
        }
        return listapedidos;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int id) {       
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_pedidos WHERE "
                    + "ped_codigo = " + id + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Pedido pedido = new Pedido();
                ArrayList<ItemPedido> itens_pedido = new ArrayList<>();
                pedido.setPed_codigo(resultado.getInt("ped_codigo"));
                pedido.setCliente((Cliente)gestocliente.consultarCod(resultado.getInt("cli_codigo")));
                pedido.setPed_data(resultado.getDate("ped_data"));
                pedido.setPed_situacao(resultado.getString("ped_situacao").charAt(0));

                String sql_itens = "SELECT pro_codigo, ped_preco_unitario, ped_quantidade FROM tb_itens_pedido WHERE "
                                 + " ped_codigo = " + pedido.getPed_codigo() + "";
                Statement st_itens = ConexaoBancoDados.getInstance().getConnection().createStatement();
                ResultSet resultado_itens = st_itens.executeQuery(sql_itens);
                while (resultado_itens.next()){
                    ItemPedido itempedido = new ItemPedido();
                    itempedido.setProduto((Produto)gestorproduto.consultarCod(resultado_itens.getInt("pro_codigo")));
                    itempedido.setPreco(resultado_itens.getDouble("ped_preco_unitario"));
                    itempedido.setQuantidade(resultado_itens.getInt("ped_quantidade"));
                    itens_pedido.add(itempedido);
                }
                pedido.setItens_pedido(itens_pedido);
                return pedido;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar pedido = " + ex);
            return ex.toString();
        }
    }

    @Override
    public int proximoCod() {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT MAX(ped_codigo) FROM tb_pedidos";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar pedidos = " + ex);
        }
        return codigo;
    }

    public void popularTabela(JTable tabela, String criterio_cliente, String criterio_data) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Cliente";
        cabecalho[2] = "Data";
        cabecalho[3] = "Valor Total";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql_count =   " select count(distinct tb_pedidos.ped_codigo) from tb_pedidos, tb_clientes, tb_itens_pedido " 
                               + "  where tb_pedidos.cli_codigo = tb_clientes.cli_codigo " 
                               + "    and tb_pedidos.ped_codigo = tb_itens_pedido.ped_codigo ";
            if(criterio_cliente != null){
                sql_count = sql_count + " and tb_clientes.cli_nome ilike '%" + criterio_cliente + "%' ";
            }
            if(!Formatacao.removerFormatacao(criterio_data).trim().isEmpty()){;
                   sql_count = sql_count + " and tb_pedidos.ped_data = '" + criterio_data + "' ";
            }
            
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql_count);
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar pedidos: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            String sql =   " select tb_pedidos.ped_codigo, tb_clientes.cli_nome, tb_pedidos.ped_data, sum(tb_itens_pedido.ped_preco_unitario * tb_itens_pedido.ped_quantidade) total "
                         + "   from tb_pedidos, tb_clientes, tb_itens_pedido " 
                         + "  where tb_pedidos.cli_codigo = tb_clientes.cli_codigo " 
                         + "    and tb_pedidos.ped_codigo = tb_itens_pedido.ped_codigo ";
            if(criterio_cliente != null){
                sql = sql + " and tb_clientes.cli_nome ilike '%" + criterio_cliente + "%' ";
            }
            if(!Formatacao.removerFormatacao(criterio_data).trim().isEmpty()){
                sql = sql + " and tb_pedidos.ped_data = '" + criterio_data + "' ";
            }
            sql = sql + " group by 1, 2, 3 "
                      + " order by 1, 3 ";
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("ped_codigo");
                dadosTabela[lin][1] = resultadoQ.getString("cli_nome");
                dadosTabela[lin][2] = Formatacao.retornaDataFormatada(resultadoQ.getDate("ped_data"));
                dadosTabela[lin][3] = Formatacao.formatarDecimal2(resultadoQ.getDouble("total"));
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //   return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }
}
