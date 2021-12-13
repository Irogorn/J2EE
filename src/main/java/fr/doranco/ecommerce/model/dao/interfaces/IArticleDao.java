package fr.doranco.ecommerce.model.dao.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.model.dao.facade.IEntityFacade;

public interface IArticleDao extends IEntityFacade<Article>  {
	List<Article> getArticlesByCategoryId(Integer id) throws Exception;
	List<Article> getArticlesByCategoryName(String name) throws Exception;
	List<Article> getArticlesByCategoryName(String name, Boolean isSellable) throws Exception;
}
