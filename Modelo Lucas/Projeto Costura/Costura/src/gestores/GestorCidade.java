
package gestores;

import apoio.ConexaoBancoDados;
import entidades.Cidade;

import interfaces.IGestores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author Lucas
 */
public class GestorCidade implements IGestores{

    @Override
    public String salvar(Object o) {
        Cidade cidade = (Cidade) o;
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO tb_cidades VALUES"
                        + "(DEFAULT, "
                        + "'" + cidade.getDescricao() + "', "
                        + "'" + cidade.getCep() + "', "
                        + "'" + cidade.getUf() + "' )";

            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar cidade = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        Cidade cidade = (Cidade) o;
        
        try{
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "UPDATE tb_cidades "
                       + "SET cid_descricao = '" + cidade.getDescricao() + "', "
                       + "cid_cep = '" + cidade.getCep() + "', "
                       + "cid_uf = '" + cidade.getUf() + "' "
                       + "WHERE cid_codigo = " + cidade.getCodigo();
            
            System.out.println("sql: " + sql);            
            int resultado = st.executeUpdate(sql);
            return null;

        } catch(Exception ex) {
            System.out.println("Erro atualizar cidade: " + ex);
            return ex.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM tb_cidades "
                    + "WHERE cid_codigo = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir cidade = " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listaCidade;
        listaCidade = new ArrayList<Object>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_cidades");
            while (resultadoQ.next()) {
                listaCidade.add(consultarCod(resultadoQ.getInt(1)));
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao consultar Cidade: " + ex);
        }
        return listaCidade;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_cidades WHERE "
                    + "cid_codigo = " + id + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Cidade cidade = new Cidade();
                cidade.setCodigo(resultado.getInt("cid_codigo"));
                cidade.setDescricao(resultado.getString("cid_descricao"));
                cidade.setCep(resultado.getString("cid_cep"));
                cidade.setUf(resultado.getString("cid_uf"));
                return cidade;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar cidade = " + ex);
            return ex.toString();
        }
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "CEP";
        cabecalho[3] = "UF";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM tb_cidades WHERE cid_descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar cidade: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_cidades WHERE cid_descricao ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("cid_codigo");
                dadosTabela[lin][1] = resultadoQ.getString("cid_descricao");
                dadosTabela[lin][2] = resultadoQ.getString("cid_cep");
                dadosTabela[lin][3] = resultadoQ.getString("cid_uf");
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

    @Override
    public int proximoCod() {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT MAX(cid_codigo) FROM tb_cidades";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
          
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar cidade = " + ex);
        }
        return codigo;
    }
}