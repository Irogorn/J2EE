package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Article;

public interface IArticleMetier {
	List<Article> getArticlesByCategoryName(String name) throws Exception;
	List<Article> getArticlesByCategoryName(String name, Boolean isSellable) throws Exception;
}
