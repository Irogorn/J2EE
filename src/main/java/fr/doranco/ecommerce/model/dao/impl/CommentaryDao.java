package fr.doranco.ecommerce.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.entities.pojo.Commentary;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.HibernateDataSource;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.ICommentaryDao;

public class CommentaryDao extends AbstractEntityFacade<Commentary> implements ICommentaryDao {
	
	@Override
	public void addCommentary(User user, Article article, Commentary commentary) throws Exception {
		commentary.setArticle(article);
		commentary.setUser(user);
		add(commentary);
	}

	@Override
	public void updateCommentaty(Commentary commentary) throws Exception {
		update(commentary);
	}

	@Override
	public List<Commentary> getCommentariesByArticle(Article article) throws Exception {
		Session session = HibernateDataSource.getInstance().getSession();
		Query<Commentary> query = session.createQuery("From Commentary c Where c.article.id = :id",Commentary.class);
		query.setParameter("id", article.getId());
		return query.list();
	}

}
