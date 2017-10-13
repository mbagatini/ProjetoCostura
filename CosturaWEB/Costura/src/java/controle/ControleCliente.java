/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.EnderecoDAO;
import entidade.Cidade;
import entidade.Cliente;
import entidade.Endereco;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Morgana
 */
public class ControleCliente {

    public boolean cadastrar(HttpServletRequest request) {
        int id = Integer.parseInt(String.valueOf(request.getParameter("id")));

        Cliente cli = new Cliente();
        cli.setCodigo(id);
        cli.setNome(request.getParameter("nome"));
        cli.setCnpj(request.getParameter("cnpj"));
        cli.setCpf(request.getParameter("cpf"));
        cli.setTelefone(request.getParameter("telefone"));
        cli.setCelular(request.getParameter("celular"));
        cli.setEmail(request.getParameter("email"));
        cli.setDataCadastro(Calendar.getInstance().getTime());

        String retorno = null;

        // Endereço
        Endereco ender = new Endereco();
        ender.setLogradouro(request.getParameter("endereco"));
        ender.setBairro(request.getParameter("bairro"));
        ender.setCidade((Cidade) new CidadeDAO().consultarId(Integer.parseInt(String.valueOf(request.getParameter("cidade")))));

        // Cadastra o endereço se não existir
        if (new EnderecoDAO().consultarEndereco(ender) == null) {
            retorno = new EnderecoDAO().salvar(ender);
            
            if (retorno != null) {
                return false;
            }
        }
        
        ender = new EnderecoDAO().consultarEndereco(ender);

        cli.setEndereco(ender);

        if (cli.getCodigo() == 0) { // é uma inserção
            retorno = new ClienteDAO().salvar(cli);
        } else {
            retorno = new ClienteDAO().atualizar(cli);
        }

        return (retorno == null);

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
