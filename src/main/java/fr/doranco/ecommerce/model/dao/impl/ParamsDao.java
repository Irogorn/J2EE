package fr.doranco.ecommerce.model.dao.impl;

import javax.crypto.SecretKey;

import fr.doranco.ecommerce.chiffrement.ChiffrementAES;
import fr.doranco.ecommerce.entities.pojo.Params;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.IParamsDao;

public class ParamsDao extends AbstractEntityFacade<Params>  implements IParamsDao {

	@Override
	public void addKey(SecretKey sk) throws Exception {
		
		if(sk == null) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		
		Params p = new Params();
		p.setPwd_key(sk.getEncoded());
		
		add(p);
	}

	@Override
	public SecretKey getKey() throws Exception {
		Params p = get(Params.class,1);
		if(p != null)
		{
			return ChiffrementAES.getByteToKey(p.getPwd_key());
		}
		SecretKey sk =  ChiffrementAES.generateKey();
		addKey(sk);
		return sk;
	}

}
