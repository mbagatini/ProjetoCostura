/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Morgana
 */
public class Categoria {
    
    private int codigo;
    private String descricao;
    
    // Construtor da classe - deve ter para que ao carregar os dados na tela, 
    // os campos fiquem preenchidos corretamente
    public Categoria () {
        codigo = 0;
        descricao = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
