/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apoio.Criptografia;
import dao.UsuarioDAO;
import entidade.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Morgana
 */
public class ControleUsuario {
    
    public Usuario validarLogin(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String senha = Criptografia.codificarSenha(request.getParameter("senha"));

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        
        if (new UsuarioDAO().consultar(usuario)){
            return usuario;
        } else {
            return null;
        }
                
    }

    public boolean cadastrar(HttpServletRequest request) {

        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        Usuario u = new Usuario();
        u.setCodigo(id);
        u.setNome(request.getParameter("nome"));
        u.setEmail(request.getParameter("email"));
        u.setSenha(Criptografia.codificarSenha(request.getParameter("senha")));
        
        String retorno = null;
        
        if (u.getCodigo() == 0) { // é uma inserção
            retorno = new UsuarioDAO().salvar(u);
        } else {
            retorno = new UsuarioDAO().atualizar(u);
        }
        
        return (retorno == null);
    }

    public HttpServletRequest editar(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = (Usuario) new UsuarioDAO().consultarId(id);

        if (usuario != null) {
            request.setAttribute("atributo", usuario);
        }
        
        return request;
    }

    public boolean excluir(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new UsuarioDAO().excluir(id);

        return (retorno == null);
    }
}
