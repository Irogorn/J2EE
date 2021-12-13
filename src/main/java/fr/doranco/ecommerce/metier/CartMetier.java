package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entities.pojo.ArticlesCart;

public class CartMetier implements ICartMetier{

	@Override
	public Float getRemiseTotal(ArticlesCart articlesCart) throws Exception {
		if(articlesCart == null) {
			throw new IllegalArgumentException("The input is not in correct format");
		}		
		return (articlesCart.getArticle().getDiscount() * articlesCart.getArticle().getPrixArticle());	
	}

	@Override
	public Float getPrixTotal(ArticlesCart articlesCart) throws Exception {
		if(articlesCart == null) {
			throw new IllegalArgumentException("The input is not in correct format");
		}
		if(articlesCart.getArticle().getDiscount() == 0)
		{
			return articlesCart.getQuantity()*articlesCart.getArticle().getPrixArticle();
		}
		else
		{
			return articlesCart.getQuantity()*getRemiseTotal(articlesCart);
		}
	}

}
