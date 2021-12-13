package fr.doranco.ecommerce.model.dao.interfaces;

import javax.crypto.SecretKey;

public interface IParamsDao {
	void addKey(SecretKey sk) throws Exception;
	
	SecretKey getKey() throws Exception;
}
