package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.metier.CartMetier;
import fr.doranco.ecommerce.metier.ICartMetier;

@ManagedBean(name = "cartBean")
@SessionScoped
public class CartBean {

	private ICartMetier cartMetier = new CartMetier();

	@ManagedProperty(name = "numberOfArticles", value = "0")
	private String numberOfArticles;

	@ManagedProperty(name = "quantity", value = "1")
	private String quantity;

	List<ArticlesCart> articles;
	
	ArticlesCart articlesCartTmp;

	public CartBean() {
		articles = new ArrayList<ArticlesCart>();
	}
	
	public String addCart(ArticlesCart articlesCart) {	
		articlesCartTmp = articlesCart;
		return "article-user.xhtml";
	}

	public String addListCart() {	
		if(articles.contains(articlesCartTmp))
		{
			int index = articles.indexOf(articlesCartTmp);
			articles.get(index).setQuantity(articles.get(index).getQuantity() + Integer.parseInt(quantity));
		}
		else
		{
			articlesCartTmp.setQuantity(Integer.parseInt(quantity));
			articles.add(articlesCartTmp);
			numberOfArticles = Integer.toString(articles.size());
		}
		quantity = "1";
		return "gestion-achats.xhtml";
	}
	
	public String modifyQuantity(ArticlesCart articlesCart){
		if(articlesCart.getQuantity() == 0)
		{
			articles.remove(articlesCart);
			numberOfArticles = Integer.toString(articles.size());
		}	
		return "";
	}

	public String getNumberOfArticles() {
		return numberOfArticles;
	}

	public void setNumberOfArticles(String numberOfArticles) {
		this.numberOfArticles = numberOfArticles;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<ArticlesCart> getArticles() {
		return articles;
	}

	public ICartMetier getCartMetier() {
		return cartMetier;
	}

	public void setCartMetier(ICartMetier cartMetier) {
		this.cartMetier = cartMetier;
	}

	public ArticlesCart getArticlesCartTmp() {
		return articlesCartTmp;
	}

	public void setArticlesCartTmp(ArticlesCart articlesCartTmp) {
		this.articlesCartTmp = articlesCartTmp;
	}

}
