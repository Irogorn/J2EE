package fr.doranco.ecommerce.main;

import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.dao.impl.UserDao;
import fr.doranco.ecommerce.model.dao.interfaces.IUserDao;

public class TestHibernate {

	public static void main(String[] args) {
		IUserDao userDao = new UserDao();
		
		try {
			User user = userDao.getUserByEmail("ze");
			System.out.println(user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
