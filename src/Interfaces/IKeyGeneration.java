package Interfaces;

import javax.crypto.SecretKey;

public interface IKeyGeneration {

	public boolean keygeneration();
	public SecretKey genkey();
	/**
	 * Cet méthode perrmet d'enregistrer une clé dans un fichier
         *@param FilePath filepath est le chemin du fichier qui doit stocker la clé
	 * @param key
	 * @return
	 */
    public boolean keygeneration(String FilePath);
    public boolean savekey(String FilePath , SecretKey key);
    public SecretKey recupkey(String FilePath);	
}
