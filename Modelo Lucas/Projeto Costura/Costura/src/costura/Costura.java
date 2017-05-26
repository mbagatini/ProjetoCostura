
package costura;

import apoio.ConexaoBancoDados;
import telas.FrmLogin;

public class Costura {

    public static void main(String[] args) {
        if (ConexaoBancoDados.getInstance().getConnection() != null) {
            FrmLogin frmlogin = new FrmLogin();
            frmlogin.setVisible(true);
        } else {
            System.out.println("errooouuuu");
        }
    }    
}
