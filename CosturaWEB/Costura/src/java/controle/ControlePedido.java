/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControlePedido {
    
    public boolean cadastrar(HttpServletRequest request) {
        String retorno = null;
        
        return (retorno == null);
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
