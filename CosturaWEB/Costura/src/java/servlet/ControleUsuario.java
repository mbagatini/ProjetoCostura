/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsuarioDAO;
import entidade.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControleUsuario {

    public static String cadastro(String manutencao, HttpServletRequest request) {

        String retorno = null;
        Usuario u = new Usuario();
        int id;

        switch (manutencao) {
            case "ins":
                id = Integer.parseInt(String.valueOf(request.getParameter("id")));
                u.setId(id);
                u.setNome(request.getParameter("nome"));
                u.setEmail(request.getParameter("email"));
                u.setSenha(request.getParameter("senha"));

                if (id == 0) {
                    retorno = new UsuarioDAO().salvar(u);
                } else {
                    retorno = new UsuarioDAO().atualizar(u);
                }
                break;

            case "del":
                id = Integer.parseInt(String.valueOf(request.getParameter("id")));
                u.setId(id);
                u.setNome(request.getParameter("nome"));
                u.setEmail(request.getParameter("email"));
                u.setSenha(request.getParameter("senha"));

                retorno = new UsuarioDAO().excluir(u.getId());
                break;
        }

        return retorno;
    }
}
