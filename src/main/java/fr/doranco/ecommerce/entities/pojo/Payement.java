package fr.doranco.ecommerce.entities.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Payement implements Serializable {

	private static final long serialVersionUID = 4864563203606507171L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Integer id;
	
	@Column(name = "holder_name",length = 45, nullable = false)
	private String holderName;
	
	@Lob
	@Column(name = "card_number", nullable = false, columnDefinition = "BLOB")
	private byte[] number;
	
	@Lob
	@Column(name = "cvc_code", nullable = false, columnDefinition = "BLOB")
	private byte[] cvcCode;
	
	@NotNull
	@Column(name="expiration_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date expirationDate;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false) 
	private User user;
	
	public Payement() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public byte[] getNumber() {
		return number;
	}

	public void setNumber(byte[] number) {
		this.number = number;
	}

	public byte[] getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(byte[] cvcCode) {
		this.cvcCode = cvcCode;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
