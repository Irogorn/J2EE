package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.chiffrement.ChiffrementAES;
import fr.doranco.ecommerce.entities.dto.AddressDto;
import fr.doranco.ecommerce.entities.pojo.Address;
import fr.doranco.ecommerce.entities.pojo.Payement;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.enums.Profils;
import fr.doranco.ecommerce.metier.IParamsMetier;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.ParamsMetier;
import fr.doranco.ecommerce.metier.UserMetier;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	@ManagedProperty(name = "genre", value = "M")
	private String genre;

	@ManagedProperty(name = "nom", value = "")
	private String nom;

	@ManagedProperty(name = "prenom", value = "")
	private String prenom;

	@ManagedProperty(name = "dateNaissance", value = "")
	private Date dateNaissance;

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private String password;

	private List<String> profils = new ArrayList<String>(
			Arrays.asList(Profils.CLIENT.getProfils(), Profils.MAGASINIER.getProfils(), Profils.ADMIN.getProfils()));

	@ManagedProperty(name = "profil", value = "")
	private String profil;

	@ManagedProperty(name = "render", value = "false")
	private Boolean render;
	
	@ManagedProperty(name = "modify", value = "false")
	private boolean modify;
	
	@ManagedProperty(name = "validate", value = "true")
	private boolean validate;

	private final IUserMetier userMetier = new UserMetier();
	
	private final IParamsMetier paramMetier = new ParamsMetier();

	private User connectedUser;

	private String errorMessage;
	
	private User userByAdmin;

	@ManagedProperty(value = "#{addressBean}")
	private AddressBean addressBean;

	@ManagedProperty(value = "#{cardBean}")
	private CardBean cardBean;

	@ManagedProperty(name = "payement", value = "")
	private Payement payement;

	@ManagedProperty(name = "payementByDefault", value = "")
	private Payement payementByDefault;

	private List<User> userTypes;
	
	@ManagedProperty(name = "passwordReturned", value = "")
	private String passwordReturned;

	public UserBean() throws Exception {
		userTypes = userMetier.getAllUserExceptClient();
		userByAdmin = new User();
	}


	public String next() {
		connectedUser = new User();
		connectedUser.setGenre(genre);
		connectedUser.setNom(nom);
		connectedUser.setPrenom(prenom);
		connectedUser.setDateNaissance(dateNaissance);
		connectedUser.setEmail(email);
		connectedUser.setProfil(Profils.CLIENT.getProfils());
		connectedUser.setIsActif(true);
		return ("address-user.xhtml");
	}

	public String validateUser() {
		try {
			if (cardBean.getPayements().size() == 0) {
				errorMessage = "Il doit avoir au moins un moyen de paiemment de rentrer !";
				return "";
			}

			for (AddressDto a : addressBean.getAddresses()) {
				Address address = new Address();
				address.setUser(connectedUser);
				address.setNumber(a.getNumber());
				address.setStreet(a.getStreet());
				address.setZipCode(a.getZipCode());
				address.setCity(a.getCity());
				connectedUser.getAddresses().add(address);
			}

			connectedUser = userMetier.addUser(connectedUser, password, cardBean.getPayements());
			return "login-user.xhtml";

		} catch (Exception e) {
			this.errorMessage = "Erreur technique, veuillez réessayer plus tard\n" + "Erreur : " + e;
			return "";
		}
	}
	
	public String transfertUser(User user) throws Exception {
		userByAdmin = user;
		modify=true;
		validate = false;
		if(user.getPassword() != null) {
			passwordReturned = ChiffrementAES.deCrypt(user.getPassword(), paramMetier.getKey());	
		}
		
		return "add-admin.xhtml";
	}
	
	public String validateAdmin() throws Exception {
		userMetier.addUserByAdmin(userByAdmin, passwordReturned);
		userByAdmin.setNom("");
		userByAdmin.setPrenom("");
		userByAdmin.setGenre("M");
		userByAdmin.setEmail("");
		userByAdmin.setIsActif(true);
		userByAdmin.setProfil("CLIENT WEBSERVICE");
		userByAdmin.setDateNaissance(null);
		userByAdmin.setPassword(null);
		passwordReturned = "";
		userTypes = userMetier.getAllUserExceptClient();
		return "gestion-admin.xhtml";
	}
	
	public String modifyAdmin() throws Exception {
		userByAdmin.setPassword(ChiffrementAES.enCrypt(passwordReturned, paramMetier.getKey()));
		userMetier.upDateUser(userByAdmin);
		userByAdmin.setNom("");
		userByAdmin.setPrenom("");
		userByAdmin.setGenre("M");
		userByAdmin.setEmail("");
		userByAdmin.setIsActif(true);
		userByAdmin.setProfil("CLIENT WEBSERVICE");
		userByAdmin.setDateNaissance(null);
		userByAdmin.setPassword(null);
		passwordReturned = "";
		modify=false;
		validate = true;
		userTypes = userMetier.getAllUserExceptClient();
		return "gestion-admin.xhtml";
		
	}
	
	public String reset() throws Exception {
		userByAdmin.setNom("");
		userByAdmin.setPrenom("");
		userByAdmin.setGenre("M");
		userByAdmin.setEmail("");
		userByAdmin.setIsActif(true);
		userByAdmin.setProfil("CLIENT WEBSERVICE");
		userByAdmin.setDateNaissance(null);
		userByAdmin.setPassword(null);
		passwordReturned = "";
		modify=false;
		validate = true;
		userTypes = userMetier.getAllUserExceptClient();
		return "add-admin.xhtml";
	}
	
	public String deleteUserByAdmin(User user) throws Exception{
		userMetier.removeUser(user);
		userTypes = userMetier.getAllUserExceptClient();
		return "";
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getProfils() {
		return profils;
	}

	public void setProfils(List<String> profils) {
		this.profils = profils;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Boolean getRender() {
		return render;
	}

	public void setRender(Boolean render) {
		this.render = render;
	}

	public Payement getPayement() {
		return payement;
	}

	public void setPayement(Payement payement) {
		this.payement = payement;
	}

	public Payement getPayementByDefault() {
		return payementByDefault;
	}

	public void setPayementByDefault(Payement payementByDefault) {
		this.payementByDefault = payementByDefault;
	}

	public AddressBean getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}

	public CardBean getCardBean() {
		return cardBean;
	}

	public void setCardBean(CardBean cardBean) {
		this.cardBean = cardBean;
	}

	public List<User> getUserTypes() {
		return userTypes;
	}

	public User getUserByAdmin() {
		return userByAdmin;
	}

	public void setUserByAdmin(User userByAdmin) {
		this.userByAdmin = userByAdmin;
	}


	public String getPasswordReturned() {
		return passwordReturned;
	}


	public void setPasswordReturned(String passwordReturned) {
		this.passwordReturned = passwordReturned;
	}


	public boolean isModify() {
		return modify;
	}


	public void setModify(boolean modify) {
		this.modify = modify;
	}


	public boolean isValidate() {
		return validate;
	}


	public void setValidate(boolean validate) {
		this.validate = validate;
	}

}
