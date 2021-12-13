package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Category;

public interface ICategoryMetier {
	List<Category> getCategories() throws Exception;
}
