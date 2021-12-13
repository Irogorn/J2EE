package fr.doranco.ecommerce.entities.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 616335857278376280L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "category_name", nullable = false)
	private String name;
	
	@Column(name = "category_picture", nullable = true)
	private String picture;
	
	@NotEmpty
	@Column(length = 500, nullable = false) 
	private String description;
	
	private Float discount;
	
	@Column(name="is_discount_cumulative")
	private Boolean isDiscountCumulative;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Article> articles;
	
	public Category() {
		this.articles = new ArrayList<Article>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Boolean getIsCombinableDiscount() {
		return isDiscountCumulative;
	}

	public void setIsCombinableDiscount(Boolean isDiscountCumulative) {
		this.isDiscountCumulative = isDiscountCumulative;
	}
}
