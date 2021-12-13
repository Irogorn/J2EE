package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Category;
import fr.doranco.ecommerce.model.dao.impl.CategoryDao;
import fr.doranco.ecommerce.model.dao.interfaces.ICategoryDao;

public class CategoryMetier implements ICategoryMetier {

	private ICategoryDao categoryDao;
	
	public CategoryMetier() {
		categoryDao = new CategoryDao();
	}
	
	@Override
	public List<Category> getCategories() throws Exception {
		return categoryDao.getCategories();
	}

}
