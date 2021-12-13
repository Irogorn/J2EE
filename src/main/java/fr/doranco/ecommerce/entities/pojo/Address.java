package fr.doranco.ecommerce.entities.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="address")
@NamedQueries({	
	@NamedQuery(name="Address:getUsersByCity", query = "FROM Address a WHERE a.city = :city")
	})
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String number;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String city;
	
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name="user_id",  nullable = false)
	private User user;
	
	// ship address bool billing addresse bool
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}
	
	public String wellFormatedAddress() {
		String address = number + ", rue " + street.substring(0, 1).toUpperCase() + street.substring(1).toLowerCase() + " " + zipCode+ " " + city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
		return address;
		
	}
	
}
