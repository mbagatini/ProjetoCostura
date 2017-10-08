/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ClienteDAO;
import entidade.Cliente;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControleCliente {
    
    public boolean cadastrar(HttpServletRequest request) {
        
        return true;
    
    }
    
    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        
        Cliente cli = (Cliente) new ClienteDAO().consultarId(id);

        if (cli != null) {
            request.setAttribute("atributo", cli);
        }
        
        return request;
    }
    
    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new ClienteDAO().excluir(id);

        return (retorno == null);
    }
    
}
