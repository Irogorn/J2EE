package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.entities.pojo.Commentary;
import fr.doranco.ecommerce.entities.pojo.User;

public interface ICommentaryMetier {
	Commentary addCommentary(User user, Article article, Commentary commentary) throws Exception;
	void updateCommentaty(Commentary commentary) throws Exception;
	List<Commentary> getCommentariesByArticle(Article article) throws Exception;
}
