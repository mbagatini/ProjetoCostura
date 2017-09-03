/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author fabricio.pretto
 */
public class Usuario {

    private int codigo;
    private String nome;
    private String email;
    private String senha;
    
    // Construtor da classe - deve ter para que ao carregar os dados na tela, 
    // os campos fiquem preenchidos corretamente
    public Usuario () {
        codigo = 0;
        nome = "";
        email ="";
        senha = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
