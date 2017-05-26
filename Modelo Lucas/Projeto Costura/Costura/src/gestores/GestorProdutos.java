package gestores;

import apoio.ConexaoBancoDados;
import apoio.Formatacao;
import entidades.Categoria;
import entidades.Produto;
import interfaces.IGestores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GestorProdutos implements IGestores{

    private GestorCategoria gestorcategoria = new GestorCategoria();

    @Override
    public String salvar(Object o) {
        Produto produtos = (Produto) o;
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO tb_produtos VALUES"
                        + "(DEFAULT, "
                        + " "  + produtos.getReferencia() + " ,"
                        + " "  + produtos.getCategoria().getCodigo() + " ,"
                        + " '" + produtos.getDescricao().toUpperCase()  + "',"
                        + " "  + produtos.getPreco()      + " ," 
                        + " '" + produtos.getTamanho()    + "',"
                        + " '" + produtos.getGenero()     + "')";

            System.out.println("sql: " + sql);
            int resultado = st.executeUpdate(sql);
            return null;

        } catch (SQLException ex) {
            System.out.println("Erro salvar produto = " + ex);
            return ex.toString();
        }
    }

    @Override
    public String atualizar(Object o) {
        Produto produto  = (Produto) o;
        
        try{
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "UPDATE tb_categoria "
                       + "SET cat_codigo = " + produto.getCategoria().getCodigo() + " "
                       + "pro_referencia = " + produto.getReferencia() + " "
                       + "pro_descricao = '" + produto.getDescricao().toUpperCase() + " "
                       + "pro_preco = " + produto.getPreco() + " "
                       + "pro_tamanho = '" + produto.getTamanho() + "' "
                       + "pro_genero = '" + produto.getGenero() + " "
                       + "WHERE pro_codigo = " + produto.getCodigo();
            
            System.out.println("sql: " + sql);            
            int resultado = st.executeUpdate(sql);
            return null;

        } catch(Exception ex) {
            System.out.println("Erro atualizar produto: " + ex);
            return ex.toString();
        }
    }

    @Override
    public String excluir(int cod) {
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = " DELETE FROM tb_produtos "
                       + " WHERE pro_referencia = " + cod;

            System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);

            return null;
        } catch (Exception ex) {
            System.out.println("Erro excluir produto = " + ex);
            return ex.toString();
        }
    }

    @Override
    public ArrayList<Object> consultarTodos() {
        ResultSet resultadoQ;
        ArrayList<Object> listaprodutos;
        listaprodutos = new ArrayList<>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_produtos");
            while (resultadoQ.next()) {
                listaprodutos.add(consultarCod(resultadoQ.getInt(1)));
            }       
        } catch (Exception ex) {
            System.out.println("Erro ao consultar produtos: " + ex);
        }
        return listaprodutos;
    }

    @Override
    public ArrayList<Object> consultar(String criterio) {
        ResultSet resultadoQ;
        ArrayList<Object> listaprodutos;
        listaprodutos = new ArrayList<>();
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM tb_produtos WHERE pro_referencia = '" + criterio + "' ");
            while (resultadoQ.next()) {
                listaprodutos.add(consultarCod(resultadoQ.getInt(1)));
            }       
        } catch (Exception ex) {
            System.out.println("Erro ao consultar produtos: " + ex);
        }
        return listaprodutos;
    }

    @Override
    public Object consultarCod(int cod) {
        
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM tb_produtos WHERE "
                    + "pro_codigo = " + cod + "";

            System.out.println("sql: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            if (resultado.next()) {
                Produto produto = new Produto();
                produto.setCodigo(resultado.getInt("pro_codigo"));
                produto.setCategoria((Categoria)gestorcategoria.consultarCod(resultado.getInt("cat_codigo")));
                produto.setReferencia(resultado.getInt("pro_referencia"));
                produto.setDescricao(resultado.getString("pro_descricao"));
                produto.setPreco(resultado.getDouble("pro_preco"));
                produto.setTamanho(resultado.getString("pro_tamanho"));
                produto.setGenero(resultado.getString("pro_genero"));
                return produto;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar produto = " + ex);
            return ex.toString();
        }
    }
    
   public Object consultarCod(int referencia, String tamanho){
       return consultarCod(consultarCodigoPorReferencia(referencia, tamanho));
   }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Referência";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Preço";
        cabecalho[3] = "Gênero";
        ResultSet resultadoQ;

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(distinct pro_referencia) FROM tb_produtos WHERE pro_descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception ex) {
            System.out.println("Erro ao consultar categoria: " + ex);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT DISTINCT pro_referencia, pro_descricao, pro_preco, pro_genero" + 
                      "  FROM tb_produtos WHERE pro_descricao ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("pro_referencia");
                dadosTabela[lin][1] = resultadoQ.getString("pro_descricao");
                dadosTabela[lin][2] = Formatacao.formatarDecimal2(resultadoQ.getDouble("pro_preco"));
                if(resultadoQ.getString("pro_genero").equals("F")){
                    dadosTabela[lin][3] = "FEMININO";
                } else {
                    dadosTabela[lin][3] = "MASCULINO";
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
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
                case 2:
                    column.setPreferredWidth(30);
                    break;
                case 3:
                    column.setPreferredWidth(30);
            }
        }
    }

    @Override
    public int proximoCod() {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT MAX(pro_codigo) FROM tb_produtos";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar produtos = " + ex);
        }
        return codigo;
    }
    
    public int consultarCodigoPorReferencia(int referencia, String tamanho) {
        int codigo = 0;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "SELECT pro_codigo FROM tb_produtos WHERE pro_referencia = " + referencia + " AND pro_tamanho = '" + tamanho + "'";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                codigo = resultado.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar produtos = " + ex);
        }
        return codigo;
    }
    
    public String retornaNome(int referencia) {
        String descricao = "";
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "Select distinct pro_descricao from tb_produtos where pro_referencia = " + referencia + " ";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                descricao = resultado.getString(1);
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar produtos = " + ex);
        }
        return descricao;
    }
    
    public boolean existeReferencia(int referencia) {
        boolean existe = false;
        try {
            Statement st = ConexaoBancoDados.getInstance().getConnection().createStatement();
            String sql = "Select count(*) from tb_produtos where pro_referencia = " + referencia + " ";
            System.out.println("sql: " + sql);
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                if (resultado.getInt(1) > 0) {
                    existe = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro consultar produtos = " + ex);
        }
        return existe;
    }

}
