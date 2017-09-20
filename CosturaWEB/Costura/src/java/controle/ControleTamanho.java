/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.TamanhoDAO;
import entidade.Tamanho;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControleTamanho {

    public boolean cadastrar(HttpServletRequest request) {

        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));

        Tamanho t = new Tamanho();

        t.setCodigo(id);
        t.setTamanho(String.valueOf(request.getParameter("tamanho")));

        String retorno = null;

        if (t.getCodigo() == 0) { // é uma inserção
            retorno = new TamanhoDAO().salvar(t);
        } else {
            retorno = new TamanhoDAO().atualizar(t);
        }

        return (retorno == null);
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        
        Tamanho t = (Tamanho) new TamanhoDAO().consultarId(id);
        
        if (t != null) {
            request.setAttribute("atributo", t);
        } 
        
        return request;
    }

    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new TamanhoDAO().excluir(id);

        return (retorno == null);
    }

}
