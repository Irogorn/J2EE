package fr.doranco.ecommerce.model.dao.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Category;

public interface ICategoryDao {
	List<Category> getCategories() throws Exception;
}
