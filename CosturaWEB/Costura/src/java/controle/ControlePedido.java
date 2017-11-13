/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apoio.ConexaoBD;
import dao.ClienteDAO;
import dao.TamanhoDAO;
import entidade.Cliente;
import entidade.ItensPedido;
import entidade.Pedido;
import entidade.Produto;
import entidade.Tamanho;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControlePedido {
    
    Connection conn = null;
    Statement st = null;
    
    public boolean cadastrar(HttpServletRequest request) {
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        // Cabeçalho do pedido
        Pedido ped = new Pedido();
        ped.setCodigo(id);
        ped.setDataEmissao(Calendar.getInstance().getTime());
        ped.setSituacao((request.getParameter("situacao")).charAt(0));
        ped.setCliente((Cliente) new ClienteDAO().consultarId(Integer.parseInt(String.valueOf(request.getParameter("cliente")))));
        ped.setDesconto(Double.parseDouble(String.valueOf(request.getParameter("desconto"))));
        ped.setPreco(Double.parseDouble(String.valueOf(request.getParameter("valorLiquido"))));
        
        // Itens do pedido
        ArrayList<ItensPedido> itens = new ArrayList<ItensPedido>();
        String[] produtos = request.getParameterValues("produto");
        String[] tamanhos = request.getParameterValues("tamanho");
        String[] quantidades = request.getParameterValues("quantidade");
        String[] precos = request.getParameterValues("preco");
        
        for (int i = 0; i < produtos.length; i++) {
            Produto p = new Produto();
            p.setCodigo(Integer.parseInt(produtos[i])); //(Produto) new ProdutoDAO().consultarId(Integer.parseInt(produtos[i]));
            p.setPreco(Double.parseDouble(precos[i]));
            Tamanho t = (Tamanho) new TamanhoDAO().consultarId(Integer.parseInt(tamanhos[i]));
            int qtde  = Integer.parseInt(quantidades[i]);
            
            ItensPedido item = new ItensPedido();
            item.setProduto(p);
            item.setTamanho(t);
            item.setQuantidade(qtde);
            
            itens.add(item);
        }
        
        try {
            // BLOQUEAR O AUTO COMMIT
            conn = ConexaoBD.getInstance().getConnection();
            conn.setAutoCommit(false);
            
            // Grava o pedido
            int codigoPedido;
            
            String sql = "INSERT INTO produto VALUES ("
                        + "DEFAULT, "
                        + "'" + ped.getDataEmissao().getTime() + "', "
                        + "'" + ped.getSituacao()+ "', "
                              + ped.getCliente().getCodigo() + ", "
                        + "'" + ped.getDesconto()+ "', "
                        + "'" + ped.getPreco()+ "'"
                        + ") returning codigo";
            
            ResultSet resul = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            resul.next();

            codigoPedido = resul.getInt(1);
            
            // Grava os itens do pedido
            st = ConexaoBD.getInstance().getConnection().createStatement();
            for (int i = 0; i < itens.size(); i++) {
                sql = "INSERT INTO item_pedido VALUES ("
                        + codigoPedido + ", "
                        + itens.get(i).getProduto().getCodigo() + ", "
                        + itens.get(i).getTamanho().getCodigo() + ", "
                        + itens.get(i).getQuantidade() + ", "
                        + "'" + itens.get(i).getProduto().getPreco() + "'"
                        + ") ";
                
                int resultado = st.executeUpdate(sql);
            }
            
            // Comita os dados
            conn.commit();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro salvar pedido: " + ex);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                System.out.println("Erro ao atualizar pedido: " + ex1);
            }
            return false;
        }
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        return request;
    }
    
    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = null;

        return (retorno == null);
    }
}
