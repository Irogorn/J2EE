package fr.doranco.ecommerce.model.dao.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.entities.pojo.Commentary;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.dao.facade.IEntityFacade;

public interface ICommentaryDao extends IEntityFacade<Commentary> {
	void addCommentary(User user, Article article, Commentary commentary) throws Exception;
	void updateCommentaty(Commentary commentary) throws Exception;
	List<Commentary> getCommentariesByArticle(Article article) throws Exception;
}
