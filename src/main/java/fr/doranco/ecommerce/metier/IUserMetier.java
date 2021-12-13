package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.dto.PayementDto;
import fr.doranco.ecommerce.entities.pojo.User;

public interface IUserMetier {
	User seConnecter(String email, String password) throws Exception;
	User addUser(User user, String password, List<PayementDto> payementDto) throws Exception;
	User addUserByAdmin(User user, String password) throws Exception;
	User upDateUser(User user) throws Exception;
	List<User> getAllUserExceptClient() throws Exception;
	void removeUser(User user) throws Exception;
}
