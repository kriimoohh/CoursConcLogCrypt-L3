package cryptoSymetrique;

import Interfaces.ICryptoConfig;
import Interfaces.IKeyGeneration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class KeyGeneration implements IKeyGeneration {

    @Override
    public boolean  keygeneration(String filePath) {
        SecretKey k = genkey();
        return savekey(filePath , k);
       
    }
    @Override
    public SecretKey genkey() {
        
     try {
           KeyGenerator kg = KeyGenerator.getInstance(ICryptoConfig.Algo);
           kg.init(ICryptoConfig.KeySize);
           return kg.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
    

    @Override
    public boolean savekey(String FilePath, SecretKey key) {
        try {
            FileOutputStream fos = new FileOutputStream(FilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(key);
            oos.close();
            fos.close();
            return true;
            
        } catch (IOException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        
        
    }
        return false;

    
    
}

    @Override
    public SecretKey recupkey(String FilePath) {
        try {
            FileInputStream fis = new FileInputStream(FilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SecretKey key = (SecretKey) ois.readObject();
            return key;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean keygeneration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
