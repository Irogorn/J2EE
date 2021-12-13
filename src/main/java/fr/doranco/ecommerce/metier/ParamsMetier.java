package fr.doranco.ecommerce.metier;

import javax.crypto.SecretKey;

import fr.doranco.ecommerce.model.dao.impl.ParamsDao;
import fr.doranco.ecommerce.model.dao.interfaces.IParamsDao;

public class ParamsMetier implements IParamsMetier {

	private final IParamsDao paramDao;
	
	public ParamsMetier() {
		paramDao = new ParamsDao();
	}
	
	@Override
	public SecretKey getKey() throws Exception {
		return paramDao.getKey();
	}

}
