package fr.doranco.ecommerce.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.HibernateDataSource;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.IUserDao;

public class UserDao extends AbstractEntityFacade<User> implements IUserDao {

	@Override
	public User getUserByEmail(String email) throws Exception {
		try(Session session = HibernateDataSource.getInstance().getSession();)
		{
			Query<User> query = session.createQuery("from User u where u.email = :email",User.class);
			query.setParameter("email", email);
			
			return query.uniqueResult();
		}
	}
	
	@Override
	public User addUser(User user) throws Exception {
		//add(user);
		try(Session session = HibernateDataSource.getInstance().getSession();){
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}
		return user;	
	}

	@Override
	public void updateUser(User user) throws Exception {
		//update(user);
		try(Session session = HibernateDataSource.getInstance().getSession();){
			Transaction tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		}
	}

	@Override
	public void removeUser(User user) throws Exception {
		//remove(user);	
		try(Session session = HibernateDataSource.getInstance().getSession();){
			Transaction tx = session.beginTransaction();
			session.remove(user);
			tx.commit();
		}
	}

	@Override
	public List<User> getAllUserExceptClient() throws Exception {
		try(Session session = HibernateDataSource.getInstance().getSession();)
		{
			Query<User> query = session.createQuery("from User u where u.profil != 'CLIENT'",User.class);
			return query.list();
		}
		
	}

}
