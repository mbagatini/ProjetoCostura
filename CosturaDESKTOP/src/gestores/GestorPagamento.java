package gestores;

import apoio.*;
import entidades.*;
import interfaces.IGestores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorPagamento implements IGestores{
    
    private final GestorNota gestornota = new GestorNota();

    @Override
    public String salvar(Object o) {
        Pagamento pagamento = (Pagamento) o;
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "";
            try {
                sql = "INSERT INTO tb_pagamentos VALUES"
                        + "(DEFAULT, "
                        + " " + pagamento.getNota().getNot_codigo() + ", "
                        + "'" + pagamento.getValor() + "', "
                        + "'" + Formatacao.retornaDataFormatada(pagamento.getData()) + "') ";
            } catch (ParseException ex) {
                Logger.getLogger(GestorPagamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar pagamento = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        Pagamento pagamento = (Pagamento) o;
        
        try{
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "UPDATE tb_pagamentos "
                       + "SET not_codigo = " + pagamento.getNota().getNot_codigo() + ", "
                       + " pag_valor = '" + pagamento.getValor() + "', "
                       + " pag_data = '" + pagamento.getData().toString() + "' "
                       + "WHERE pag_codigo = " + pagamento.getCodigo();
            
            System.out.println("sql: " + sql);            
            int resultado = st.executeUpdate(sql);
            return null;

        } catch(Exception ex) {
            System.out.println("Erro atualizar pagamento: " + ex);
            return ex.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM tb_pagamentos "
                    + "WHERE pag_codigo = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir pagamento = " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listaPagamento;
        listaPagamento = new ArrayList<Object>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_pagamentos");
            while (resultadoQ.next()) {
                listaPagamento.add(consultarCod(resultadoQ.getInt(1)));
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao consultar pagamento: " + ex);
        }
        return listaPagamento;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_pagamentos WHERE "
                    + " pag_codigo = " + id + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Pagamento pag = new Pagamento();
                pag.setCodigo(resultado.getInt("pag_codigo"));
                pag.setNota((Nota)gestornota.consultarCod(resultado.getInt("not_codigo")));
                pag.setData(resultado.getDate("pag_data"));
                pag.setValor(resultado.getDouble("pag_valor"));
                return pag;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar pagamento = " + ex);
            return ex.toString();
        }
    }

    @Override
    public int proximoCod() {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT MAX(pag_codigo) FROM tb_pagamentos";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar pagamento = " + ex);
        }
        return codigo;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nota";
        cabecalho[2] = "Nome cliente";
        cabecalho[3] = "Data pagamento";
        cabecalho[4] = "Valor";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(            
                         "Select count(*) "
                       + "  from tb_pagamentos, tb_notas, tb_pedidos, tb_clientes "
                       + " where tb_pagamentos.not_codigo = tb_notas.not_codigo " 
                       + "   and tb_notas.ped_codigo = tb_pedidos.ped_codigo " 
                       + "   and tb_pedidos.cli_codigo = tb_clientes.cli_codigo " 
                       + "   and tb_clientes.cli_nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar categoria: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(
                         "Select tb_pagamentos.pag_codigo, tb_pagamentos.not_codigo, tb_clientes.cli_nome, tb_pagamentos.pag_data, tb_pagamentos.pag_valor "
                       + "  from tb_pagamentos, tb_notas, tb_pedidos, tb_clientes "
                       + " where tb_pagamentos.not_codigo = tb_notas.not_codigo " 
                       + "   and tb_notas.ped_codigo = tb_pedidos.ped_codigo " 
                       + "   and tb_pedidos.cli_codigo = tb_clientes.cli_codigo " 
                       + "   and tb_clientes.cli_nome ILIKE '%" + criterio + "%'"
                       + " order by 3, 2, 4");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("pag_codigo");
                dadosTabela[lin][1] = resultadoQ.getInt("not_codigo");
                dadosTabela[lin][2] = resultadoQ.getString("cli_nome");
                dadosTabela[lin][3] = Formatacao.retornaDataFormatada(resultadoQ.getDate("pag_data"));
                dadosTabela[lin][4] = Formatacao.formatarDecimal2(resultadoQ.getDouble("pag_valor"));
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
                    column.setPreferredWidth(35);
                    break;
                case 1:
                    column.setPreferredWidth(35);
                    break;
                case 2:
                    column.setPreferredWidth(160);
                    break;
                case 3:
                    column.setPreferredWidth(90);
                    break;
            }
        }
    }
}
