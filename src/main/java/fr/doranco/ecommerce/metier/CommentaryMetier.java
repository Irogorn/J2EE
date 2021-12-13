package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.entities.pojo.Commentary;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.dao.impl.CommentaryDao;
import fr.doranco.ecommerce.model.dao.interfaces.ICommentaryDao;

public class CommentaryMetier implements ICommentaryMetier{

	private ICommentaryDao commentaryDao;
	
	public CommentaryMetier() {
		commentaryDao = new CommentaryDao();
	}
	
	@Override
	public Commentary addCommentary(User user, Article article, Commentary commentary) throws Exception {
		if(user == null) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		if(article == null) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		if(commentary == null) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		commentary.setArticle(article);
		commentary.setUser(user);
		commentaryDao.add(commentary);
		return commentary;

	}

	@Override
	public void updateCommentaty(Commentary commentary) throws Exception {
		commentaryDao.update(commentary);

	}

	@Override
	public List<Commentary> getCommentariesByArticle(Article article) throws Exception {
		if(article == null) {
			throw new IllegalArgumentException("The input is not in correct format !");
		}
		return commentaryDao.getCommentariesByArticle(article);
	}

}
