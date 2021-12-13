package fr.doranco.ecommerce.metier;

import javax.crypto.SecretKey;

public interface IParamsMetier {
	SecretKey getKey() throws Exception;
}
