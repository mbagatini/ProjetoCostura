/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import apoio.Constantes;
import dao.UsuarioDAO;
import entidade.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.Controle;
import static servlet.Controle.encaminharPagina;

/**
 *
 * @author Morgana
 */
public class ControleUsuario {

    public static void cadastrar(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
        
        Usuario u = new Usuario();
        u.setCodigo(id);
        u.setNome(request.getParameter("nome"));
        u.setEmail(request.getParameter("email"));
        u.setSenha(request.getParameter("senha"));
        
        String retorno = null;
        
        if (u.getCodigo() == 0) { // é uma inserção
            retorno = new UsuarioDAO().salvar(u);
        } else {
            retorno = new UsuarioDAO().atualizar(u);
        }

        request.setAttribute("paginaRetorno", Constantes.CADASTRO_USUARIO);
        
        if (retorno == null) {
            Controle.encaminharPagina(Constantes.PAGINA_SUCESSO, request, response);
        } else {
            Controle.encaminharPagina(Constantes.PAGINA_ERRO, request, response);
        }

    }

    public static void editar(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = (Usuario) new UsuarioDAO().consultarId(id);

        if (usuario != null) {
            request.setAttribute("atributo", usuario);
            Controle.encaminharPagina(Constantes.CADASTRO_USUARIO, request, response);
        } else {
            request.setAttribute("paginaRetorno", Constantes.LISTAGEM_USUARIO);
            Controle.encaminharPagina(Constantes.PAGINA_ERRO, request, response);
        }

    }

    public static void excluir(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        String retorno = new UsuarioDAO().excluir(id);

        request.setAttribute("paginaRetorno", Constantes.LISTAGEM_USUARIO);

        if (retorno == null) {
            encaminharPagina(Constantes.CADASTRO_USUARIO, request, response);
        } else {
            Controle.encaminharPagina(Constantes.PAGINA_ERRO, request, response);
        }

    }
}
