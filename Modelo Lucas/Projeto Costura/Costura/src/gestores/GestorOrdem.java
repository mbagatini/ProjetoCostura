package gestores;

import apoio.ConexaoBancoDados;
import apoio.Formatacao;
import entidades.*;
import interfaces.IGestores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorOrdem implements IGestores{

    private final GestorPedido gestorpedido = new GestorPedido();
    private final GestorProdutos gestorproduto = new GestorProdutos();
    private final GestorNota gestornota = new GestorNota();
    
    @Override
    public String salvar(Object o) {
        Connection conn = null;
        Statement st = null;
        OrdemProducao ordem = (OrdemProducao) o;
        try {
            // Bloquear o auto commit, para faze-lo apenas quando inserir todas as informações
            conn = ConexaoBancoDados.getInstance().getConnection();
            conn.setAutoCommit(false);

            String sql;
            int codigo_pedido;

            sql = "INSERT INTO tb_ordens_producao VALUES"
                + "(DEFAULT, "
                + "" + ordem.getPedido().getPed_codigo() + ", "
                + "'" + ordem.getOrd_situacao() + "', ";
            if (ordem.getData_ini() == null){
                sql = sql + " null, ";
            } else {
                sql = sql + "'" + Formatacao.retornaDataFormatada(ordem.getData_ini()) + "', ";
            }
            if (ordem.getData_ini() == null){
                sql = sql + " null) ";
            } else {
                sql = sql + "'" + Formatacao.retornaDataFormatada(ordem.getData_fim()) + "') ";
            }    
            sql = sql + " RETURNING ord_codigo";
            System.out.println("sql: " + sql);
            ResultSet resul = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);
            resul.next();

            codigo_pedido = resul.getInt(1);
            
            st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            for(ItemPedido item: ordem.getItens_ordem()){
                int resultado;
                sql = "INSERT INTO tb_itens_ordem VALUES ("
                    + "" + item.getProduto().getCodigo()+ ", "
                    + "" + codigo_pedido + ", "
                    + "" + item.getQuantidade() + ") ";
                System.out.println("sql: " + sql);
                resultado = st.executeUpdate(sql);
            }
            conn.commit();
            return null;
        } catch (SQLException ex) {
            System.out.println("Erro salvar ordem de produção = " + ex);
            try{
                if(conn != null){
                    conn.rollback();
                }
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            return ex.toString();
        } catch (ParseException ex) {
            System.out.println("Erro salvar ordem de produção = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        OrdemProducao ordem = (OrdemProducao) o;
        Connection conn = null;
        try{
            // Bloquear o auto commit, para faze-lo apenas quando inserir todas as informações
            conn = ConexaoBancoDados.getInstance().getConnection();
            conn.setAutoCommit(false);

            String data_ini = null;
            String data_fim = null;
            
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            if(ordem.getData_ini() != null){
                data_ini = "'" + Formatacao.retornaDataFormatada(ordem.getData_ini()) + "'";
            }
            if(ordem.getData_fim() != null){
                data_fim = "'" + Formatacao.retornaDataFormatada(ordem.getData_fim()) + "'";
            }
            //Altera a tabela de ordens            
            String sql = "UPDATE tb_ordens_producao "
                       + "SET ord_data_ini = " + data_ini + ", "
                       + "ord_data_fim = " + data_fim + ", "
                       + "ord_situacao = '" + ordem.getOrd_situacao() + "' "
                       + "WHERE ord_codigo = " + ordem.getOrd_ordcodigo();
            
            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            //Altera a situação do pedido
            sql = "UPDATE tb_pedidos "
                + "SET ped_situacao = '" + ordem.getOrd_situacao() + "' "
                + "WHERE ped_codigo = " + ordem.getPedido().getPed_codigo();
            System.out.println("sql: " + sql);
            resultado = st.executeUpdate(sql);
            
            if (ordem.getOrd_situacao() == 'F'){
                String retorno = null;
                Nota nota = new Nota();
                double total = 0.0;
                ArrayList<ItemPedido> itens_pedido = new ArrayList<>();
                itens_pedido = ordem.getPedido().getItens_pedido();
                
                nota.setNot_codigo(0);
                nota.setNot_data(Formatacao.retornaDataString(Formatacao.getDataAtual()));
                for (int i = 0; i < itens_pedido.size(); i++) {
                    total = total + (itens_pedido.get(i).getPreco() * itens_pedido.get(i).getQuantidade());
                }
                nota.setNot_valor(total);
                nota.setPedido(ordem.getPedido());
                
                retorno = gestornota.salvar(nota);
                if (retorno != null){
                    System.out.println("Erro inserir nota: " + retorno);
                }
            }
            conn.commit();
            return null;

        } catch(Exception ex) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                   ex1.printStackTrace();
                }
            }
            System.out.println("Erro atualizar ordem: " + ex);
            return ex.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            // DELETA OS ITENS DO PEDIDO
            String sql = "DELETE FROM tb_itens_ordem "
                       + "WHERE ord_codigo = " + id;
            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql); 

            // DELETA O PEDIDO
            sql = "DELETE FROM tb_ordens_producao "
                + "WHERE ord_codigo = " + id;
            System.out.println("sql: " + sql);
            resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir ordem de produção: " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listaordens;
        listaordens = new ArrayList<>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_ordens_producao");
            while (resultadoQ.next()) {
                listaordens.add(consultarCod(resultadoQ.getInt(1)));
            }       
        } catch (Exception ex) {
            System.out.println("Erro ao consultar ordens de producao: " + ex);
        }
        return listaordens;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_ordens_producao WHERE "
                    + " ord_codigo = " + id + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                OrdemProducao ordem = new OrdemProducao();
                ArrayList<ItemPedido> itens_ordem = new ArrayList<>();
                ordem.setOrd_ordcodigo(resultado.getInt("ord_codigo"));
                ordem.setPedido((Pedido) gestorpedido.consultarCod(resultado.getInt("ped_codigo")));
                ordem.setOrd_situacao(resultado.getString("ord_situacao").charAt(0));
                ordem.setData_ini(resultado.getDate("ord_data_ini"));
                ordem.setData_fim(resultado.getDate("ord_data_fim"));

                String sql_itens = "SELECT pro_codigo, ord_qtde FROM tb_itens_ordem WHERE "
                                 + " ord_codigo = " + ordem.getOrd_ordcodigo()+ "";
                Statement st_itens = ConexaoBancoDados.getInstance().getConnection().createStatement();
                ResultSet resultado_itens = st_itens.executeQuery(sql_itens);
                while (resultado_itens.next()){
                    ItemPedido itemordem = new ItemPedido();
                    itemordem.setPedido(ordem.getPedido());
                    itemordem.setProduto((Produto)gestorproduto.consultarCod(resultado_itens.getInt("pro_codigo")));
                    itemordem.setQuantidade(resultado_itens.getInt("ord_qtde"));
                    itemordem.setPreco(0.0);
                    itens_ordem.add(itemordem);
                }
                ordem.setItens_ordem(itens_ordem);
                return ordem;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar ordem de produção = " + ex);
            return ex.toString();
        }
    }

    @Override
    public int proximoCod() {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT MAX(ord_codigo) FROM tb_ordens_producao";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar ordens de produção = " + ex);
        }
        return codigo;
    }
    
    public int getOrdCodigo(int ped_codigo){
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT ord_codigo FROM tb_ordens_producao "
                       + "WHERE ped_codigo = " + ped_codigo;
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                codigo = resultado.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar ordens de produção = " + ex);
        }
        return codigo;
    }
    
    public void popularTabela(JTable tabela, String criterio_ordem, String status) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Ordem";
        cabecalho[1] = "Pedido";
        cabecalho[2] = "Data Início";
        cabecalho[3] = "Data Fim";
        cabecalho[4] = "Status";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql_count =   " select count(tb_ordens_producao.ord_codigo) from tb_ordens_producao where 1 = 1 ";
            
            if(criterio_ordem != null){
                sql_count = sql_count + " and tb_ordens_producao.ord_codigo = " + criterio_ordem + " ";
            }
            if(status != null){;
                   sql_count = sql_count + " and tb_ordens_producao.ord_situacao = '" + status + "' ";
            }
            
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql_count);
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar pedidos: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            String sql =   " select tb_ordens_producao.ord_codigo, tb_ordens_producao.ped_codigo, tb_ordens_producao.ord_situacao, tb_ordens_producao.ord_data_ini , tb_ordens_producao.ord_data_fim "
                         + "   from tb_ordens_producao where 1 = 1 ";
            if(criterio_ordem != null){
                sql = sql + " and tb_ordens_producao.ord_codigo = " + criterio_ordem + " ";
            }
            if(status != null){
                sql = sql + " and tb_ordens_producao.ped_data = '" + status + "' ";
            }
            sql = sql + " group by 1, 2, 3 "
                      + " order by 1, 3 ";
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("ord_codigo");
                dadosTabela[lin][1] = resultadoQ.getInt("ped_codigo");
                if (resultadoQ.getDate("ord_data_ini") == null){
                    dadosTabela[lin][2] = "";
                } else {
                    dadosTabela[lin][2] = Formatacao.retornaDataFormatada(resultadoQ.getDate("ord_data_ini"));
                }
                if (resultadoQ.getDate("ord_data_fim") == null){
                    dadosTabela[lin][3] = "";
                } else {
                    dadosTabela[lin][3] = Formatacao.retornaDataFormatada(resultadoQ.getDate("ord_data_fim"));
                }
                String sit = resultadoQ.getString("ord_situacao");
                switch (sit){
                    case "E":
                        dadosTabela[lin][4] = "Em espera";
                        break;
                    case "P":
                        dadosTabela[lin][4] = "Em produção";
                        break;
                    case "F":
                        dadosTabela[lin][4] = "Finalizado";
                        break;
                }
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
                    column.setPreferredWidth(20);
                    break;
                case 1:
                    column.setPreferredWidth(20);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
    }
}
