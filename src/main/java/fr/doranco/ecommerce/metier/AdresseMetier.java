package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entities.pojo.Address;
import fr.doranco.ecommerce.model.dao.impl.AdresseDao;
import fr.doranco.ecommerce.model.dao.interfaces.IAdresseDao;

public class AdresseMetier implements IAdresseMetier {
	
	private final IAdresseDao adressedao = new AdresseDao();

	@Override
	public Address getAdresseByUser(Integer user_id) throws Exception {
		// TODO Auto-generated method stub
		return adressedao.getAdresseByUser(user_id);
	}

	@Override
	public void addAdresse(Address adresse, Integer user_id) throws Exception {
		adressedao.addAdresse(adresse);

	}

	@Override
	public void updateAdresse(Address adresse, Integer user_id) throws Exception {
		adressedao.updateAdresse(adresse);

	}

}
