package Interfaces;

import javax.crypto.Cipher;

public interface IChiffrement {
    public Cipher getCipher(String keyFile);
    public boolean Process(String fileToEncrypt,String fileDest,Cipher cipher);
    public boolean runCipher(String keyFile,String fileToEncrypt,String fileDest);
    
}