package fr.doranco.ecommerce.model.dao.interfaces;

import fr.doranco.ecommerce.entities.pojo.Address;

public interface IAdresseDao {
	Address getAdresseByUser(Integer user_id) throws Exception;
	void addAdresse(Address adresse) throws Exception;
	void updateAdresse(Address adresse) throws Exception;
}
