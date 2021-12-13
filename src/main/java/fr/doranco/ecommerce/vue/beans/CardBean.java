package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.FacesValidator;

import fr.doranco.ecommerce.entities.dto.PayementDto;

@ManagedBean
@SessionScoped
@FacesValidator("cardBean")
public class CardBean {

	@ManagedProperty(name = "holderName", value = "")
	private String holderName;

	@ManagedProperty(name = "number", value = "")
	private String number;

	@ManagedProperty(name = "cvcCode", value = "")
	private String cvcCode;

	@ManagedProperty(name = "expirationDate", value = "")
	private Date expirationDate;

	@ManagedProperty(name = "modified", value = "false")
	private Boolean modified;

	@ManagedProperty(name = "updated", value = "true")
	private Boolean updated;

	private List<PayementDto> payements;

	private PayementDto payementTmp;

	public CardBean() {
		payements = new ArrayList<PayementDto>();
	}

	public String addPayement() {
		PayementDto payement = new PayementDto();
		payement.setHolderName(holderName);
		payement.setNumber(number);
		payement.setCvcCode(cvcCode);
		payement.setExpirationDate(expirationDate);
		payements.add(payement);
		payementTmp = payement;
		return "";
	}

	public String modifyPayement(PayementDto p) {
		setHolderName(p.getHolderName());
		setNumber(p.getNumber());
		setCvcCode(p.getCvcCode());
		setExpirationDate(p.getExpirationDate());
		modified = true;
		updated = false;
		return "";
	}

	public String updatePayement() {
		int i = payements.indexOf(payementTmp);
		payements.remove(i);
		PayementDto payement = new PayementDto();
		payement.setHolderName(holderName);
		payement.setNumber(number);
		payement.setCvcCode(cvcCode);
		payement.setExpirationDate(expirationDate);
		payements.add(i, payement);
		modified = false;
		updated = true;
		return "";
	}

	public String deletePayement(PayementDto p) {
		payements.remove(p);
		return "";
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(String cvcCode) {
		this.cvcCode = cvcCode;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<PayementDto> getPayements() {
		return payements;
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

}
