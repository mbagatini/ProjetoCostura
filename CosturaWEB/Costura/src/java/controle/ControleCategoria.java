/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apoio.Constantes;
import dao.CategoriaDAO;
import entidade.Categoria;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.Controle;
import static servlet.Controle.encaminharPagina;

/**
 *
 * @author Morgana
 */
public class ControleCategoria {

    public static void cadastrar(HttpServletRequest request, HttpServletResponse response) {
        
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

        request.setAttribute("paginaRetorno", Constantes.CADASTRO_CATEGORIA);
        
        if (retorno == null) {
            Controle.encaminharPagina(Constantes.PAGINA_SUCESSO, request, response);
        } else {
            Controle.encaminharPagina(Constantes.PAGINA_ERRO, request, response);
        }
    }
    
    public static void editar(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        Categoria cat = (Categoria) new CategoriaDAO().consultarId(id);

        if (cat != null) {
            request.setAttribute("atributo", cat);
            Controle.encaminharPagina(Constantes.CADASTRO_CATEGORIA, request, response);
        } else {
            request.setAttribute("paginaRetorno", Constantes.LISTAGEM_CATEGORIA);
            Controle.encaminharPagina(Constantes.PAGINA_ERRO, request, response);
        }

    }
    
    public static void excluir(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new CategoriaDAO().excluir(id);

        request.setAttribute("paginaRetorno", Constantes.LISTAGEM_CATEGORIA);

        if (retorno == null) {
            encaminharPagina(Constantes.CADASTRO_CATEGORIA, request, response);
        } else {
            Controle.encaminharPagina(Constantes.PAGINA_ERRO, request, response);
        }

    }

}
