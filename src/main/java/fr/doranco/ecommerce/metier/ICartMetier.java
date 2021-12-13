package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entities.pojo.ArticlesCart;

public interface ICartMetier {
	Float getRemiseTotal(ArticlesCart articlesCart) throws Exception;
	Float getPrixTotal(ArticlesCart articlesCart) throws Exception;
}
