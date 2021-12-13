package fr.doranco.ecommerce.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.model.HibernateDataSource;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.IArticleDao;

public class ArticleDao extends AbstractEntityFacade<Article> implements IArticleDao
{

	@Override
	public List<Article> getArticlesByCategoryId(Integer id) throws Exception {
		try(Session session = HibernateDataSource.getInstance().getSession();){
			Query<Article> query = session.createNamedQuery("Article:findByCategoryId",Article.class);
			query.setParameter("id", id);
			return query.list();
		}
	}
	
	@Override
	public List<Article> getArticlesByCategoryName(String name) throws Exception {
		try(Session session = HibernateDataSource.getInstance().getSession();)
		{
			Query<Article> query = session.createNamedQuery("Article:findByCategoryName",Article.class);
			query.setParameter("name", name);
			return query.list();
		}
		
	}

	@Override
	public List<Article> getArticlesByCategoryName(String name, Boolean isSellable) throws Exception {
		try(Session session = HibernateDataSource.getInstance().getSession();)
		{
			Query<Article> query = session.createNamedQuery("Article:findByCategoryNameAndSellable",Article.class);
			query.setParameter("name", name);
			query.setParameter("isSellable", isSellable);
			return query.list();
		}
		
	}

}
