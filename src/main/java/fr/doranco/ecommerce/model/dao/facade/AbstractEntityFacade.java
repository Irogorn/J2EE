package fr.doranco.ecommerce.model.dao.facade;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.model.HibernateDataSource;

public abstract class AbstractEntityFacade<T> implements IEntityFacade<T> {

	private final Session session = HibernateDataSource.getInstance().getSession();
	
	@Override
	public void add(T entity) throws Exception {
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
	}

	@Override
	public T get(Class<T> entity, Integer id) throws Exception {
		T t = session.get(entity,id);
		return t;
	}

	@Override
	public void update(T entity) throws Exception {
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		
	}

	@Override
	public void remove(T entity) throws Exception {
		Transaction tx = session.beginTransaction();
		session.remove(entity);
		tx.commit();		
	}

}
