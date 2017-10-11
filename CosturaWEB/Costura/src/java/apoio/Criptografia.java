/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.motta
 */
public class Criptografia {

    public static String codificarSenha(String senha) {

        MessageDigest algorithm = null;
        byte messageDigest[] = null;

        try {
            algorithm = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO DE CRIPTOGRAFIA");
        }

        try {
            messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO DE CONVERSAO DE CARACTERES");
        }
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            //A máscara de bits é utilizada para evitar números negativos.
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        //System.out.println(senhahex);
        return senhahex;
    }

}
