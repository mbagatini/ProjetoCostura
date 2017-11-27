/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apoio.Formatacao;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.TamanhoDAO;
import entidade.Cliente;
import entidade.ItensPedido;
import entidade.Pedido;
import entidade.Produto;
import entidade.Tamanho;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import servlet.Controle;

/**
 *
 * @author Morgana
 */
public class ControlePedido {
    
    public boolean cadastrar(HttpServletRequest request) throws ParseException {
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        // Cabeçalho do pedido
        Pedido ped = new Pedido();
        ped.setCodigo(id);
        ped.setDataEmissao(Formatacao.retornaDataString(String.valueOf(request.getParameter("dataEmissao"))));
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
            p.setCodigo(Integer.parseInt(produtos[i]));
            p.setPreco(Double.parseDouble(precos[i]));
            Tamanho t = (Tamanho) new TamanhoDAO().consultarId(Integer.parseInt(tamanhos[i]));
            int qtde  = Integer.parseInt(quantidades[i]);
            
            ItensPedido item = new ItensPedido();
            item.setProduto(p);
            item.setTamanho(t);
            item.setQuantidade(qtde);
            
            itens.add(item);
        }
        
        ped.setItens(itens);
        
        PedidoDAO pedDAO = new PedidoDAO();
        String retorno = null;
        
        if ((pedDAO.consultarId(ped.getCodigo())) == null ) { // é uma inserção
            retorno = pedDAO.salvar(ped);
        } else {
            retorno = pedDAO.atualizar(ped);
        }
        
        return (retorno == null);
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        
        Pedido ped = (Pedido) new PedidoDAO().consultarId(id);
        
        if (ped != null) {
            request.setAttribute("atributo", ped);
        }

        return request;
    }
    
    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new PedidoDAO().excluir(id);

        return (retorno == null);
    }
    
    public void carregaConsultaPedido(HttpServletRequest request, HttpServletResponse response) {

        // Alguma coisa que serve pra devolver pro browser
        PrintWriter out = null;
        try {
            int pedido = Integer.parseInt(request.getParameter("codigoPedido"));
            Pedido ped = (Pedido) new PedidoDAO().consultarId(pedido);
            
            out = response.getWriter();
            try {
                // Objeto para o pedido
                JSONObject jsonPedido = new JSONObject();
                
                String cnpj_cpf = ped.getCliente().getCnpj()+ ped.getCliente().getCpf();
                
                jsonPedido.put("cliente", ped.getCliente().getNome());
                jsonPedido.put("cnpj_cpf", cnpj_cpf);
                jsonPedido.put("data_emissao", Formatacao.retornaDataFormatada(ped.getDataEmissao()));
                jsonPedido.put("situacao", ped.retornaDescricaoSituacao(ped.getSituacao()));
                jsonPedido.put("valor_total", Formatacao.retornaDecimalFormatado(ped.getPreco() + ped.getDesconto()));
                jsonPedido.put("desconto", Formatacao.retornaDecimalFormatado(ped.getDesconto()));
                jsonPedido.put("total_liquido", Formatacao.retornaDecimalFormatado(ped.getPreco()));
                
                // Itens do pedido
                JSONArray arrayJsonItens = new JSONArray();
                
                for (ItensPedido item : ped.getItens()) {
                    JSONObject jsonItem = new JSONObject();
                    jsonItem.put("produto", item.getProduto().getReferencia() + " - " + item.getProduto().getDescricao());
                    jsonItem.put("tamanho", item.getTamanho().getTamanho());
                    jsonItem.put("quantidade", item.getQuantidade());
                    jsonItem.put("valor", Formatacao.retornaDecimalFormatado(item.getProduto().getPreco()));
                    jsonItem.put("subtotal", Formatacao.retornaDecimalFormatado(item.getProduto().getPreco() * item.getQuantidade()));
                    arrayJsonItens.put(jsonItem);
                }
                
                // Adiciona os itens no JSON do pedido
                jsonPedido.put("itens", arrayJsonItens);
                
                out.print(jsonPedido);
            } catch (Exception ex) {
                System.out.println("Erro ao pegar o pedido: " + ex.getMessage());
            }
        } catch (IOException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}
