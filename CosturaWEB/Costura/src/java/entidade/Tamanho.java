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
public class Tamanho {
    
    private int codigo;
    private String tamanho;
    
    // Construtor da classe - deve ter para que ao carregar os dados na tela, 
    // os campos fiquem preenchidos corretamente
    public Tamanho () {
        codigo = 0;
        tamanho = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    
    
}
