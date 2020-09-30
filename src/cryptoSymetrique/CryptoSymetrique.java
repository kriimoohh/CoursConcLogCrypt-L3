package cryptoSymetrique;

public class CryptoSymetrique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //new KeyGeneration().keygeneration("./essai.key");
        
        Chiffrement chiffrement = new Chiffrement();
        chiffrement.Process("./akf.pdf","./ndeye.key",null);
    }
    
}
