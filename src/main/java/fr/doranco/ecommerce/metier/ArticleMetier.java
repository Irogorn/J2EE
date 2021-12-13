package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.model.dao.impl.ArticleDao;
import fr.doranco.ecommerce.model.dao.interfaces.IArticleDao;

public class ArticleMetier implements IArticleMetier {

	private IArticleDao articleDao;
	
	public ArticleMetier() {
		articleDao = new ArticleDao();
	}
	
	@Override
	public List<Article> getArticlesByCategoryName(String name) throws Exception {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		return articleDao.getArticlesByCategoryName(name);
	}

	@Override
	public List<Article> getArticlesByCategoryName(String name, Boolean isSellable) throws Exception {
		if(name == null || isSellable == null || name.isEmpty()) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		return articleDao.getArticlesByCategoryName(name,isSellable);
	}

}
