package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entities.pojo.Article;

public interface IMagasinierMetier {
	Article addArticle(Article article) throws Exception;
	void deleteArticle(Article article) throws Exception;
	Article updateArticle(Article article) throws Exception;
}
