package fr.doranco.ecommerce.entities.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotEmpty
	@Column(nullable = false)
	private String gender;
	
	@NotEmpty
	@Column(name="first_name", length = 25, nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name="last_name", length = 25, nullable = false)
	private String lastName;
	
	@Column(name="date_naissance", columnDefinition = "Date")
	private Date dateNaissance;
	
	@NotEmpty
	private String email;
	
	@Lob
	@Column(name="password", columnDefinition = "BLOB", nullable = false)
	private byte[] password;
	
	@Column(name="profil")
	private String profil;
	
	@NotNull
	@Column(name="is_actif")
	private Boolean isActif;
	

	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> addresses;
	  
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<Payement> payements;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private	List<Orders> orders;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<ArticlesCart> cart;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<ArticlesCart> commentaries;
	
	public User() {
		addresses = new ArrayList<Address>();
		payements = new ArrayList<Payement>();
		orders = new ArrayList<Orders>();
		cart = new ArrayList<ArticlesCart>();
	}

	public String getGenre() {
		return gender;
	}

	public void setGenre(String genre) {
		this.gender = genre;
	}

	public String getNom() {
		return firstName;
	}

	public void setNom(String nom) {
		this.firstName = nom;
	}

	public String getPrenom() {
		return lastName;
	}

	public void setPrenom(String prenom) {
		this.lastName = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public List<Payement> getPayements() {
		return payements;
	}

	public List<ArticlesCart> getCart() {
		return cart;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateNaissance=" + dateNaissance + ", email=" + email + ", password=" + password + ", profil="
				+ profil + ", addresses=" + addresses + ", payements=" + payements + ", orders=" + orders + ", cart="
				+ cart + "]";
	}
	
}
