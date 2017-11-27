/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import entidade.Produto;
import entidade.Categoria;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Morgana
 */
public class ControleProduto {
    
    public boolean cadastrar(HttpServletRequest request) {
        
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        Produto pro = new Produto();
        pro.setCodigo(id);
        pro.setReferencia(Integer.parseInt(String.valueOf(request.getParameter("referencia"))));
        pro.setDescricao(request.getParameter("descricao"));
        pro.setPreco(Double.parseDouble(String.valueOf(request.getParameter("preco"))));
        pro.setGenero(request.getParameter("genero"));
        
        Categoria cat = (Categoria) new CategoriaDAO().consultarId(Integer.parseInt(String.valueOf(request.getParameter("categoria"))));
        pro.setCategoria(cat);
        
        String retorno = null;

        if (pro.getCodigo() == 0) { // é uma inserção
            retorno = new ProdutoDAO().salvar(pro);
        } else {
            retorno = new ProdutoDAO().atualizar(pro);
        }

        return (retorno == null);
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        Produto pro = (Produto) new ProdutoDAO().consultarId(id);

        if (pro != null) {
            request.setAttribute("atributo", pro);
        }
        
        return request;
    }
    
    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new ProdutoDAO().excluir(id);

        return (retorno == null);
    }
    
    public void carregaPrecoProduto(HttpServletRequest request, HttpServletResponse response) {

        int produto = Integer.parseInt(request.getParameter("codigoProduto"));
        String preco = String.valueOf(((Produto) new ProdutoDAO().consultarId(produto)).getPreco());

        try {
            response.getWriter().write(preco);
        } catch (IOException ex) {
            System.out.println("Erro ao pegar o preço do produto: " + ex.getMessage());
        }
    }
}
