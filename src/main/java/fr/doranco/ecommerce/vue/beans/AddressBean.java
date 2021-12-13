package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entities.dto.AddressDto;

@ManagedBean(name = "addressBean")
@SessionScoped
public class AddressBean {

	@ManagedProperty(name = "number", value = "")
	private String number;

	@ManagedProperty(name = "street", value = "")
	private String street;

	@ManagedProperty(name = "city", value = "")
	private String city;

	@ManagedProperty(name = "zipCode", value = "")
	private String zipCode;

	@ManagedProperty(name = "address", value = "")
	private String address;

	@ManagedProperty(name = "modified", value = "false")
	private Boolean modified;

	@ManagedProperty(name = "updated", value = "true")
	private Boolean updated;

	private List<AddressDto> addresses;

	private AddressDto addressTmp;
	
	private String errorMessage;

	public String addAddress() {
		AddressDto address = new AddressDto();
		address.setNumero(number);
		address.setStreet(street);
		address.setZipCode(zipCode);
		address.setCity(city);
		addresses.add(address);
		addressTmp = address;
		return "";
	}

	public String modifyAddress(AddressDto address) {
		setNumber(address.getNumber());
		setStreet(address.getStreet());
		setZipCode(address.getZipCode());
		setCity(address.getCity());
		modified = true;
		updated = false;
		return "";
	}

	public String updateAddress() {
		int i = addresses.indexOf(addressTmp);
		addresses.remove(i);
		AddressDto address = new AddressDto();
		address.setNumero(number);
		address.setStreet(street);
		address.setZipCode(zipCode);
		address.setCity(city);
		addresses.add(i, address);
		modified = false;
		updated = true;
		return "";
	}

	public String deleteAddress(AddressDto address) {
		addresses.remove(address);
		return "";
	}
	
	public String verifyAddress() {
		if(addresses.size() == 0)
		{
			errorMessage = "Il doit avoir au moins une adresse de rentrer !";
			return "";
		}
		return "payement-user.xhtml";
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressBean() {
		addresses = new ArrayList<AddressDto>();
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

	public List<AddressDto> getAddresses() {
		return addresses;
	}

	public Boolean getModified() {
		return modified;
	}

	public void setModified(Boolean modified) {
		this.modified = modified;
	}

	public Boolean getUpdated() {
		return updated;
	}

	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
