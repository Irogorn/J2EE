package fr.doranco.ecommerce.entities.dto;

import fr.doranco.ecommerce.entities.pojo.User;

public class AddressDto {

	private String number;
	
	
	private String street;
	
	
	private String city;
	
	
	private String zipCode;
	
	private User user;
	
	public AddressDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNumber() {
		return number;
	}

	public void setNumero(String number) {
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

	public String wellFormatedAddress() {
		String address = number + ", rue " + street.substring(0, 1).toUpperCase() + street.substring(1).toLowerCase() + " " + zipCode+ " " + city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
		return address;
		
	}
}
