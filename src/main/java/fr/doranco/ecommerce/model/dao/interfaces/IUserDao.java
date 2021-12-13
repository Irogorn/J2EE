package fr.doranco.ecommerce.model.dao.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.User;

public interface IUserDao {
	User getUserByEmail(String email) throws Exception;
	User addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	void removeUser(User user) throws Exception;
	List<User> getAllUserExceptClient() throws Exception;
}
