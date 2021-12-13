package fr.doranco.ecommerce.entities.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Params implements Serializable {

	private static final long serialVersionUID = -4103701850345108196L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Lob
	@Column(name = "crypted_pwd_key", nullable = false, columnDefinition = "BLOB")
	private byte[] pwd_key;
	
	@Lob
	@Column(name = "crypted_cc_key", nullable = true, columnDefinition = "BLOB")
	private byte[] cc_key;
	
	public Params() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getPwd_key() {
		return pwd_key;
	}

	public void setPwd_key(byte[] pwd_key) {
		this.pwd_key = pwd_key;
	}

	public byte[] getCc_key() {
		return cc_key;
	}

	public void setCc_key(byte[] cc_key) {
		this.cc_key = cc_key;
	}
	
}
