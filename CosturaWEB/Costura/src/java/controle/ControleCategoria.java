/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CategoriaDAO;
import entidade.Categoria;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControleCategoria {

    public boolean cadastrar(HttpServletRequest request) {
        
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        Categoria cat = new Categoria();
        cat.setCodigo(id);
        cat.setDescricao(request.getParameter("descricao"));
        
        String retorno = null;

        if (cat.getCodigo() == 0) { // é uma inserção
            retorno = new CategoriaDAO().salvar(cat);
        } else {
            retorno = new CategoriaDAO().atualizar(cat);
        }

        return (retorno == null);
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        Categoria cat = (Categoria) new CategoriaDAO().consultarId(id);

        if (cat != null) {
            request.setAttribute("atributo", cat);
        }
        
        return request;
    }
    
    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new CategoriaDAO().excluir(id);

        return (retorno == null);
    }

}
