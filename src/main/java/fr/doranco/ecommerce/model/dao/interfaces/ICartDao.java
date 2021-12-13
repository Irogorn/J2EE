package fr.doranco.ecommerce.model.dao.interfaces;

import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.model.dao.facade.IEntityFacade;

public interface ICartDao extends IEntityFacade<ArticlesCart> {
	void addArtcileCart(ArticlesCart articleCart) throws Exception;
	void updateArticleCart(ArticlesCart articleCart) throws Exception;
	void removeArticleCart(ArticlesCart articleCart) throws Exception;
	
}
