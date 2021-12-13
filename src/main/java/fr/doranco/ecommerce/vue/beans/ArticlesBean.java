package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entities.pojo.Article;
import fr.doranco.ecommerce.entities.pojo.ArticlesCart;
import fr.doranco.ecommerce.entities.pojo.Commentary;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.CommentaryMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.ICommentaryMetier;
import fr.doranco.ecommerce.metier.IMagasinierMetier;
import fr.doranco.ecommerce.metier.MagasinierMetier;

@ManagedBean(name = "articlesBean")
@SessionScoped
public class ArticlesBean {
	
	private IArticleMetier articleMetier;
	private ICommentaryMetier commentaryMetier;
	private IMagasinierMetier magasinierMetier;
	
	private List<ArticlesCart> articlesForCategory;
	
	private List<Commentary> commentariesOfArticle;
	
	@ManagedProperty(name="titleArticle", value = "")
	private String titleArticle;

	private String category;
	
	@ManagedProperty(name="commentary", value = "")
	private String commentary;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	@ManagedProperty(name="modify", value = "false")
	private boolean modify;
	
	@ManagedProperty(name="add", value = "true")
	private boolean add;
	
	private Article articleTmp;
	
	private Article newArticle;
	
	private List<Article> articles;
	
	public String commentaryArticle(ArticlesCart articlesCart) throws Exception {
		articleTmp = articlesCart.getArticle();
		commentariesOfArticle = commentaryMetier.getCommentariesByArticle(articlesCart.getArticle());
		titleArticle = articlesCart.getArticle().getTitreArticle();
		return "commentary.xhtml";
		
	}
	
	public String addCommentary() throws Exception {
		Commentary comment = new Commentary();
		comment.setCommentary(commentary);
		comment.setRatings(5);
		comment = commentaryMetier.addCommentary(loginBean.getConnectedUser(), articleTmp, comment);
		commentariesOfArticle.add(comment);
		commentary = "";
		return "";
	}
	
	public ArticlesBean() throws Exception {
		articleMetier = new ArticleMetier();
		commentaryMetier = new CommentaryMetier();
		magasinierMetier = new MagasinierMetier();
		newArticle = new Article();
	}

	public List<ArticlesCart> getArticlesForCategory() {
		return articlesForCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) throws Exception {
		this.category = category;
		articles = articleMetier.getArticlesByCategoryName(category,true);
		articlesForCategory = new ArrayList<ArticlesCart>();
		for(Article a : articles) {
			ArticlesCart articlesCart = new ArticlesCart();
			articlesCart.setQuantity(1);
			articlesCart.setArticle(a);
			articlesCart.setUser(loginBean.getConnectedUser());
			articlesForCategory.add(articlesCart);
		}
		
		
	}
	
	public String addArticle() throws Exception {
		newArticle.setCategory(articles.get(0).getCategory());
		magasinierMetier.addArticle(newArticle);
		articles.add(newArticle);
		articlesForCategory.clear();
		for(Article a : articles) {
			ArticlesCart articlesCart = new ArticlesCart();
			articlesCart.setQuantity(1);
			articlesCart.setArticle(a);
			articlesCart.setUser(loginBean.getConnectedUser());
			articlesForCategory.add(articlesCart);
		}
		return "gestion-achats.xhtml";
		
	}
	
	public String deleteArticle(ArticlesCart article) throws Exception {
		magasinierMetier.deleteArticle(article.getArticle());
		articlesForCategory.remove(article);
		return "";
	}
	
	public String modifyArticle() throws Exception {
		magasinierMetier.updateArticle(newArticle);
		
		return "gestion-achats.xhtml";
	}
	
	public String transfertArticle(ArticlesCart article) {
		modify = true;
		add = false;
		newArticle = article.getArticle();
		return "gestion-articles.xhtml";
	}

	public String getTitleArticle() {
		return titleArticle;
	}

	public void setTitleArticle(String titleArticle) {
		this.titleArticle = titleArticle;
	}

	public List<Commentary> getCommentariesOfArticle() {
		return commentariesOfArticle;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Article getNewArticle() {
		return newArticle;
	}

	public void setNewArticle(Article newArticle) {
		this.newArticle = newArticle;
	}

	public boolean isModify() {
		return modify;
	}

	public void setModify(boolean modify) {
		this.modify = modify;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	

}
