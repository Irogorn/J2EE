package fr.doranco.ecommerce.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entities.pojo.Address;

import fr.doranco.ecommerce.model.HibernateDataSource;
import fr.doranco.ecommerce.model.dao.interfaces.IAdresseDao;

public class AdresseDao implements IAdresseDao {

	@Override
	public Address getAdresseByUser(Integer user_id) throws Exception {
		Address adresse = null;
		Transaction tx = null;
		try(Session session = HibernateDataSource.getInstance().getSession())
		{
			try {
				tx = session.beginTransaction();
				adresse = session.get(Address.class, user_id);
				tx.commit();
			}
			catch(Exception e) {
				if(tx != null) {
					tx.rollback();		
				}
				throw e;
			}	
		}			
		return adresse;
	}

	@Override
	public void addAdresse(Address address) throws Exception {
		Transaction tx = null;
		try(Session session = HibernateDataSource.getInstance().getSession())
		{
			try {
				tx = session.beginTransaction();
				session.save(address);
				tx.commit();
			}
			catch(Exception e) {
				if(tx != null) {
					tx.rollback();		
				}
				throw e;
			}	
		}

	}

	@Override
	public void updateAdresse(Address adresse) throws Exception {
		Transaction tx = null;
		try(Session session = HibernateDataSource.getInstance().getSession())
		{
			try {
				tx = session.beginTransaction();
				session.update(adresse);
				tx.commit();
			}
			catch(Exception e) {
				if(tx != null) {
					tx.rollback();		
				}
				throw e;
			}	
		}

	}

}
