package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.chiffrement.ChiffrementAES;
import fr.doranco.ecommerce.entities.dto.PayementDto;
import fr.doranco.ecommerce.entities.pojo.Payement;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.dao.impl.ParamsDao;
import fr.doranco.ecommerce.model.dao.impl.UserDao;
import fr.doranco.ecommerce.model.dao.interfaces.IParamsDao;
import fr.doranco.ecommerce.model.dao.interfaces.IUserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	private final IParamsDao paramsDao = new ParamsDao();
	
	public UserMetier() {
		
	}

	@Override
	public User seConnecter(String email, String password) throws Exception {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("");
		}
		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException("");
		}
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			if (ChiffrementAES.deCrypt(user.getPassword(), paramsDao.getKey()).equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User addUser(User user, String password,List<PayementDto> payementDto) throws Exception {
		if(user == null) {
			throw new IllegalArgumentException("Il y a une problème au niveau des données rentrées !");
		}
		if(payementDto == null || payementDto.size() == 0) {
			throw new IllegalArgumentException("Il y a une problème au niveau des données rentrées ! (PAY)");
		}
		if(password == null || password.isEmpty()) {
			throw new IllegalArgumentException("Il y a une problème au niveau des données rentrées !");
		}
		
		for(PayementDto p : payementDto) {
			Payement payement = new Payement();
			payement.setUser(user);
			payement.setHolderName(p.getHolderName());
			payement.setNumber(ChiffrementAES.enCrypt(p.getNumber(), paramsDao.getKey()));
			payement.setCvcCode(ChiffrementAES.enCrypt(p.getCvcCode(),paramsDao.getKey()));
			payement.setExpirationDate(p.getExpirationDate());
			user.getPayements().add(payement);	
		}

		user.setNom(user.getNom().trim().toUpperCase());
		user.setPrenom(user.getPrenom().trim().toLowerCase());
		user.setPassword(ChiffrementAES.enCrypt(password,paramsDao.getKey()));
		
		return userDao.addUser(user);
	}

	@Override
	public User upDateUser(User user) throws Exception {
		if(user == null) {
			throw new IllegalArgumentException("The input is not in a good format !");
		}
		userDao.updateUser(user);
		return user;
	}

	@Override
	public List<User> getAllUserExceptClient() throws Exception {
		return userDao.getAllUserExceptClient();
	}

	@Override
	public void removeUser(User user) throws Exception {
		if(user == null) {
			throw new IllegalArgumentException("The input is not in a good format !");
		}
		userDao.removeUser(user);
		
	}

	@Override
	public User addUserByAdmin(User user, String password) throws Exception {
		if(user == null) {
			throw new IllegalArgumentException("Il y a une problème au niveau des données rentrées !");
		}
		if(password == null || password.isEmpty()) {
			throw new IllegalArgumentException("Il y a une problème au niveau des données rentrées !");
		}
		user.setPassword(ChiffrementAES.enCrypt(password,paramsDao.getKey()));
		userDao.addUser(user);
		return user;
	}

}
