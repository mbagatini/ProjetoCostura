/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CategoriaDAO;
import entidade.Categoria;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControleCategoria {
    
    public static String cadastro(String manutencao, HttpServletRequest request) {

        String retorno = null;
        Categoria cat = new Categoria();
        int id;

        switch (manutencao) {
            case "ins":
                id = Integer.parseInt(String.valueOf(request.getParameter("id")));
                cat.setCodigo(id);
                cat.setDescricao(request.getParameter("descricao"));

                if (id == 0) {
                    retorno = new CategoriaDAO().salvar(cat);
                } else {
                    retorno = new CategoriaDAO().atualizar(cat);
                }
                break;

            case "del":
                id = Integer.parseInt(String.valueOf(request.getParameter("id")));
                cat.setCodigo(id);
                cat.setDescricao(request.getParameter("descricao"));

                retorno = new CategoriaDAO().excluir(cat.getCodigo());
                break;
        }

        return retorno;
    }
    
}
