package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entities.pojo.Address;

public interface IAdresseMetier {
	Address getAdresseByUser(Integer user_id) throws Exception;
	void addAdresse(Address adresse, Integer user_id) throws Exception;
	void updateAdresse(Address adresse, Integer user_id) throws Exception;
}
