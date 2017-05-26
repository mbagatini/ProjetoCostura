package gestores;

import apoio.ConexaoBancoDados;
import apoio.Formatacao;
import entidades.Nota;
import entidades.Pedido;
import interfaces.IGestores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorNota implements IGestores{

    private final GestorPedido gestorpedido = new GestorPedido();
    
    @Override
    public String salvar(Object o) {
        Nota nota = (Nota) o;
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO tb_notas VALUES"
                        + "(DEFAULT, "
                        + " " + nota.getPedido().getPed_codigo() + ", "
                        + "'" + nota.getNot_data() + "', "
                        + "'" + nota.getNot_valor() + "') ";
            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar nota = " + ex);
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

            String sql = "DELETE FROM tb_notas "
                    + "WHERE not_codigo = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir nota = " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listaNota;
        listaNota = new ArrayList<Object>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_notas");
            while (resultadoQ.next()) {
                listaNota.add(consultarCod(resultadoQ.getInt(1)));
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao consultar nota: " + ex);
        }
        return listaNota;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_notas WHERE "
                    + " not_codigo = " + id + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Nota nota = new Nota();
                nota.setNot_codigo(resultado.getInt("not_codigo"));
                nota.setPedido((Pedido)gestorpedido.consultarCod(resultado.getInt("ped_codigo")));
                nota.setNot_data(resultado.getDate("not_data"));
                nota.setNot_valor(resultado.getDouble("not_valor_total"));
                return nota;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar nota = " + ex);
            return ex.toString();
        }
    }

    @Override
    public int proximoCod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome cliente";
        cabecalho[2] = "Data";
        cabecalho[3] = "Valor total";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = "Select count(*) "
                       + "  from tb_notas, tb_pedidos, tb_clientes "
                       + " where tb_notas.ped_codigo = tb_pedidos.ped_codigo "
                       + "   and tb_clientes.cli_codigo = tb_pedidos.cli_codigo ";
            if (criterio != null){
                sql = sql + " and tb_notas.not_codigo = " + criterio + " ";
            }
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);

            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar nota: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            String sql = "Select tb_notas.not_codigo, tb_clientes.cli_nome, tb_notas.not_data, tb_notas.not_valor_total "
                       + "  from tb_notas, tb_pedidos, tb_clientes "
                       + " where tb_notas.ped_codigo = tb_pedidos.ped_codigo "
                       + "   and tb_clientes.cli_codigo = tb_pedidos.cli_codigo ";
            if (criterio != null){
                sql = sql + " and tb_notas.not_codigo = " + criterio + " ";
            }
            sql = sql + " order by 3 desc, 2, 1";
            
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("not_codigo");
                dadosTabela[lin][1] = resultadoQ.getString("cli_nome");
                dadosTabela[lin][2] = Formatacao.retornaDataFormatada(resultadoQ.getDate("not_data"));
                dadosTabela[lin][3] = Formatacao.formatarDecimal2(resultadoQ.getDouble("not_valor_total"));
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
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
    }
}
