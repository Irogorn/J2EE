package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entities.pojo.Category;
import fr.doranco.ecommerce.metier.CategoryMetier;
import fr.doranco.ecommerce.metier.ICategoryMetier;

@ManagedBean(name = "categoryBean")
@SessionScoped
public class CategoryBean {

	private List<Category> categories;

	@ManagedProperty(value = "#{articlesBean}")
	private ArticlesBean articlesBean;
	
	@ManagedProperty(name="inactive", value = "true")
	private boolean inactive;

	public String chooseCategory(Category category) throws Exception{
		articlesBean.setCategory(category.getName());
		if(!category.getName().isEmpty())
		{
			inactive = false;
		}
		else
		{
			inactive = true;
		}
		return "";
	}

	public CategoryBean() throws Exception {
		categories = new ArrayList<Category>();
		ICategoryMetier categoryMetier = new CategoryMetier();
		categories = categoryMetier.getCategories();
		
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public ArticlesBean getArticlesBean() {
		return articlesBean;
	}

	public void setArticlesBean(ArticlesBean articlesBean) {
		this.articlesBean = articlesBean;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

}
