package cryptoSymetrique;

import Interfaces.IChiffrement;
import Interfaces.ICryptoConfig;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


public class Chiffrement implements IChiffrement {

    @Override
    public Cipher getCipher(String keyFile) {
        KeyGeneration gen = new KeyGeneration();
        SecretKey key = gen.recupkey(keyFile);
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.Trans);
            c.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
                    
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public boolean Process(String fileToEncrypt, String fileDest, Cipher cipher) {
        try {
            FileInputStream fis = new FileInputStream(fileToEncrypt);
            byte[] tampon = new byte[1024];
            FileOutputStream fos = new FileOutputStream(fileDest);
            int tailleLue=0;
            tailleLue=fis.read(tampon);
            
            while(tailleLue!=-1){
                    
                fos.write(tampon, 0, tailleLue);
             tailleLue=fis.read(tampon);    
            }
        } catch (IOException ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean runCipher(String keyFile, String fileToEncrypt, String fileDest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
