package fr.doranco.ecommerce.chiffrement.main;

import java.math.BigInteger;

import javax.crypto.SecretKey;

import fr.doranco.ecommerce.chiffrement.ChiffrementAES;

public class TestChiffrement {

	public static void main(String[] args) {
		try {
			SecretKey sk = ChiffrementAES.generateKey();
			String text = "Texte pour le test de chiffrement";
			byte[] encryptedText = ChiffrementAES.enCrypt(text, sk);
			System.out.println(new BigInteger(encryptedText));
			System.out.println(ChiffrementAES.deCrypt(encryptedText, sk));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
