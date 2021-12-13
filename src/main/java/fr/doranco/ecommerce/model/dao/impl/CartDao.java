package fr.doranco.ecommerce.model.dao.impl;

import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.model.dao.facade.AbstractEntityFacade;
import fr.doranco.ecommerce.model.dao.interfaces.ICartDao;

public class CartDao extends AbstractEntityFacade<ArticlesCart> implements ICartDao {

	@Override
	public void addArtcileCart(ArticlesCart articleCart) throws Exception {
		add(articleCart);
	}

	@Override
	public void updateArticleCart(ArticlesCart articleCart) throws Exception {
		update(articleCart);	
	}
	
	@Override
	public void removeArticleCart(ArticlesCart articleCart) throws Exception {
		remove(articleCart);
		
	}

}
