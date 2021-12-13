package fr.doranco.ecommerce.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateDataSource{
	
	private static HibernateDataSource instance;
	private SessionFactory sessionFactory;
	
	private HibernateDataSource() throws HibernateException {
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	public static HibernateDataSource getInstance() throws HibernateException {
		if(instance == null) {
			instance = new HibernateDataSource();
		}
		return instance;
	}
	
	public Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
