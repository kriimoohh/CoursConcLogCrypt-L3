/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;

import javax.swing.JFileChooser;

/**
 *
 * @author kriimoohh
 */
public class CryptoSymetrique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        new KeyGeneration().keygeneration("./kriimoohh2.key");
        
        //Chiffrement chiffrement = new Chiffrement();
        //chiffrement.runCipher("./kriimoohh.key","./test.txt","./chiffre.txt");
        
        //Dechiffrement dechiffrement = new  Dechiffrement();
        //dechiffrement.runCipher("./kriimoohh.key","./chiffre.txt","./dechiffre.txt");
        
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(jfc);
                
    }
    
}
