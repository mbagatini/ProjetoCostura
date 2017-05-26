
package gestores;

import apoio.ConexaoBancoDados;
import entidades.Cidade;
import entidades.Cliente;
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
public class GestorCliente implements IGestores{

    @Override
    public String salvar(Object o) {
        Cliente cliente = (Cliente) o;
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO tb_clientes VALUES"
                        + "(DEFAULT, "
                        + " " + cliente.getCidade().getCodigo() + ", "
                        + "'" + cliente.getNome().toUpperCase() + "', "
                        + "'" + cliente.getEndereco().toUpperCase() + "', "
                        + "'" + cliente.getBairro().toUpperCase() + "', "
                        + "'" + cliente.getTelefone() + "')";

            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar cliente = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        Cliente cliente = (Cliente) o;
        
        try{
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "UPDATE tb_clientes "
                       + "SET cid_codigo = " + cliente.getCidade().getCodigo() + ", "
                       + " cli_nome = '" + cliente.getNome().toUpperCase() + "', "
                       + " cli_endereco = '" + cliente.getEndereco().toUpperCase() + "', "
                       + " cli_telefone = '" + cliente.getTelefone() + "', "
                       + " cli_bairro = '" + cliente.getBairro().toUpperCase() + "' "
                       + "WHERE cli_codigo = " + cliente.getCodigo();
            
            System.out.println("sql: " + sql);            
            int resultado = st.executeUpdate(sql);
            return null;

        } catch(Exception ex) {
            System.out.println("Erro atualizar cliente: " + ex);
            return ex.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM tb_clientes "
                    + "WHERE cli_codigo = " + id;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir cliente = " + ex);
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
                    + "SELECT * FROM tb_clientes");
            while (resultadoQ.next()) {
                listaCategoria.add(consultarCod(resultadoQ.getInt(1)));
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao consultar cliente: " + ex);
        }
        return listaCategoria;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCod(int id) {
        try {
            GestorCidade gestorcidade = new GestorCidade();
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_clientes WHERE "
                    + "cli_codigo = " + id + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Cliente clientes = new Cliente();
                clientes.setCodigo(resultado.getInt("cli_codigo"));
                clientes.setCidade((Cidade)gestorcidade.consultarCod(resultado.getInt("cid_codigo")));
                clientes.setNome(resultado.getString("cli_nome"));
                clientes.setEndereco(resultado.getString("cli_endereco"));
                clientes.setTelefone(resultado.getString("cli_telefone"));
                clientes.setBairro(resultado.getString("cli_bairro"));
                return clientes;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar categoria = " + ex);
            return ex.toString();
        }
    }

    @Override
    public int proximoCod() {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT MAX(cli_codigo) FROM tb_clientes";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
          
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar clientes = " + ex);
        }
        return codigo;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Cidade";
        cabecalho[3] = "Telefone";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + " select count(*) from tb_cidades, tb_clientes " +
                      " where tb_cidades.cid_codigo = tb_clientes.cid_codigo and tb_clientes.cli_nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar categoria: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + " select tb_clientes.cli_codigo, tb_clientes.cli_nome, tb_cidades.cid_descricao, tb_clientes.cli_telefone " + 
                      " from tb_cidades, tb_clientes where tb_cidades.cid_codigo = tb_clientes.cid_codigo and tb_clientes.cli_nome ILIKE '%" + criterio + "%' ORDER BY 2");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt(1);
                dadosTabela[lin][1] = resultadoQ.getString(2);
                dadosTabela[lin][2] = resultadoQ.getString(3);
                dadosTabela[lin][3] = resultadoQ.getString(4);
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
