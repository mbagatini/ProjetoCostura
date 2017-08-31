package gestores;

import apoio.ConexaoBancoDados;
import entidades.Categoria;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import interfaces.IGestores;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorCategoria implements IGestores{

    @Override
    public String salvar(Object o) {
        Categoria categoria = (Categoria) o;
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO tb_categoria VALUES"
                        + "(DEFAULT, "
                        + "'" + categoria.getDescricao().toUpperCase() + "')";
            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar categoria = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        Categoria categoria = (Categoria) o;
        
        try{
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "UPDATE tb_categoria "
                       + "SET cat_pro_descricao = '" + categoria.getDescricao().toUpperCase() + "' "
                       + "WHERE cat_pro_codigo = " + categoria.getCodigo();
            
            System.out.println("sql: " + sql);            
            int resultado = st.executeUpdate(sql);
            return null;

        } catch(Exception ex) {
            System.out.println("Erro atualizar categoria: " + ex);
            return ex.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM tb_categoria "
                    + "WHERE cat_pro_codigo = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir categoria = " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listaCategoria;
        listaCategoria = new ArrayList<Object>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_categoria");
            while (resultadoQ.next()) {
                listaCategoria.add(consultarCod(resultadoQ.getInt(1)));
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao consultar categoria: " + ex);
        }
        return listaCategoria;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int cod) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_categoria WHERE "
                    + "cat_pro_codigo = " + cod + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Categoria c = new Categoria();
                c.setCodigo(resultado.getInt("cat_pro_codigo"));
                c.setDescricao(resultado.getString("cat_pro_descricao"));
                return c;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar categoria = " + ex);
            return ex.toString();
        }
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM tb_categoria WHERE cat_pro_descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][2];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar categoria: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_categoria WHERE cat_pro_descricao ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("cat_pro_codigo");
                dadosTabela[lin][1] = resultadoQ.getString("cat_pro_descricao");
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
                    column.setPreferredWidth(10);
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
            String sql = "SELECT MAX(cat_pro_codigo) FROM tb_categoria";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
          
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar categoria = " + ex);
        }
        return codigo;
    }
}
