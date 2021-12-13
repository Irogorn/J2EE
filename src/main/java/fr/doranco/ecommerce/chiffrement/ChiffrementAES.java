package fr.doranco.ecommerce.chiffrement;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class ChiffrementAES {
	private final static String ALGO_CHIFF = "AES";
	
	public final static SecretKey generateKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGO_CHIFF);
	    keyGenerator.init(256);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	
	public final static byte[] enCrypt(String input, SecretKey sk) throws Exception{
		Cipher cipher = Cipher.getInstance(ALGO_CHIFF);
	    cipher.init(Cipher.ENCRYPT_MODE, sk, new SecureRandom());
	    return cipher.doFinal(input.getBytes());	
	}
	
	public final static String deCrypt(byte[] encryptedInput, SecretKey sk) throws Exception{
		Cipher cipher = Cipher.getInstance(ALGO_CHIFF);
	    cipher.init(Cipher.DECRYPT_MODE, sk, new SecureRandom());
	    byte[] plainText = cipher.doFinal(encryptedInput);
	    return new String(plainText);
	}
	
	public final static SecretKey getByteToKey(byte[] input) {
		return new SecretKeySpec(input,ALGO_CHIFF);
	}
	
}
