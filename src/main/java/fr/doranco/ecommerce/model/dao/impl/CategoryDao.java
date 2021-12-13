package fr.doranco.ecommerce.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entities.pojo.Category;
import fr.doranco.ecommerce.model.HibernateDataSource;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.ICategoryDao;

public class CategoryDao extends AbstractEntityFacade<Category>  implements ICategoryDao {

	@Override
	public List<Category> getCategories() throws Exception {
		Session session = HibernateDataSource.getInstance().getSession();
		Query<Category> query = session.createQuery("from Category",Category.class);
		return query.list();
	}

}
