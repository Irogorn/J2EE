package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.model.dao.impl.ArticleDao;
import fr.doranco.ecommerce.model.dao.interfaces.IArticleDao;

public class MagasinierMetier implements IMagasinierMetier {

	private final IArticleDao articleDao;
	
	public MagasinierMetier() {
		articleDao = new ArticleDao();
	}
	
	@Override
	public Article addArticle(Article article) throws Exception {
		articleDao.add(article);
		return article;
	}

	@Override
	public void deleteArticle(Article article) throws Exception {
		articleDao.remove(article);	
	}

	@Override
	public Article updateArticle(Article article) throws Exception {
		articleDao.update(article);
		return article;
	}

}
