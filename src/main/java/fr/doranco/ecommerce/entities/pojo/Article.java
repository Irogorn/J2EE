package fr.doranco.ecommerce.entities.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({	
	@NamedQuery(name="Article:findAllSellable", query = "FROM Article a WHERE a.isSellable = :isSellable"),
	@NamedQuery(name="Article:findAllAvailable", query = "FROM Article a WHERE a.quantity > 0"),
	@NamedQuery(name="Article:findByCategoryId", query = "FROM Article a WHERE a.category.id = :id"),
	@NamedQuery(name = "Article:findByCategoryName",query ="FROM Article a WHERE a.category.name = :name"),
	@NamedQuery(name = "Article:findByCategoryNameAndSellable",query ="FROM Article a WHERE a.category.name = :name AND a.isSellable = :isSellable")
	})
public class Article implements Serializable {

	private static final long serialVersionUID = 1623553980373807509L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name= "titre_article", length = 30, nullable = false) 
	private String titreArticle;
	
	@NotEmpty
	@Column(nullable = false)
	private Float prixArticle;	
	
	@NotEmpty
	@Column(length = 500, nullable = false) 
	private String description;
	
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<ArticlesCart> commentaries;
	
	@Column(nullable = true)
	private String pictures;
	
	@Column(nullable = true)
	private String videos;
	
	@Column(length = 2, nullable = false)
	private Float discount;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	private Category category;
	
	@NotNull
	@Column(name = "is_sellable", nullable = false)
	private Boolean isSellable;
	
	@NotNull
	@Column(name = "quantity", nullable = false,length = 2)
	private Integer quantity;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public Float getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(Float prixArticle) {
		this.prixArticle = prixArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}
	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Boolean getIsSellable() {
		return isSellable;
	}

	public void setIsSellable(Boolean isSellable) {
		this.isSellable = isSellable;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<ArticlesCart> getCommentaries() {
		return commentaries;
	}

	
}
