package fr.doranco.ecommerce.vue.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.chiffrement.ChiffrementAES;
import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.enums.Profils;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;
import fr.doranco.ecommerce.model.dao.impl.ParamsDao;
import fr.doranco.ecommerce.model.dao.interfaces.IParamsDao;



@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	@ManagedProperty(name = "email", value = "mo@mo.fr")
	private String email;
	@ManagedProperty(name = "password", value = "")
	private String password;
	@ManagedProperty(name = "errorMessage", value = "")
	private String errorMessage;

	private String errorMessagePassWord;

	private User connectedUser;

	private String oddPassword;

	private String newPassword;

	private String newPassword2;
	
	private boolean display;
	
	@ManagedProperty(value = "#{cartBean}")
	private CartBean cartBean;
	
	@ManagedProperty(name = "render", value = "true")
	private Boolean render;

	private final IUserMetier userMetier = new UserMetier();
	private final IParamsDao paramDao = new ParamsDao();
	
	private List<String> profils = new ArrayList<String>(
			Arrays.asList(Profils.CLIENT_WEBSERVICE.getProfils(), Profils.MAGASINIER.getProfils(), Profils.ADMIN.getProfils()));
	
	@ManagedProperty(name = "profil", value = "")
	private String profil;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String seConnecter() {
		try {
			User user = userMetier.seConnecter(email, password);
			if (user == null) {
				this.errorMessage = "Email et/ou Mot de passe incorrectes ! Veuillez réessayer !";
				return "";
			}
			if (user.getProfil().equals(Profils.CLIENT.getProfils())) {
				connectedUser = user;
				display = false;
				return "gestion-achats.xhtml";
			} else if (user.getProfil().equals(Profils.MAGASINIER.getProfils())) {
				connectedUser = user;
				display = true;
				return "gestion-achats.xhtml";
			} else if (user.getProfil().equals(Profils.ADMIN.getProfils())) {
				connectedUser = user;
				display = false;
				render = false;
				return "gestion-admin.xhtml";
			}

		} catch (Exception e) {
			this.errorMessage = "Erreur technique, veuillez réessayer plus tard\n" + "Erreur" + e;
			e.printStackTrace();
		}
		return "";
	}

	public String modifyPassword() {
		return errorMessage;

	}

	public String changePassword() throws Exception {
		if (ChiffrementAES.deCrypt(connectedUser.getPassword(), paramDao.getKey()).equals(oddPassword)) {
			if (newPassword.equals(newPassword2)) {
				connectedUser.setPassword(ChiffrementAES.enCrypt(newPassword2, paramDao.getKey()));
				userMetier.upDateUser(connectedUser);

			} else {
				errorMessagePassWord = "Les 2 champs nouveau mot de passe sont différent !";
				return "";
			}
			return "gestion-achats.xhtml";
		} else {
			errorMessagePassWord = "L'ancien mot de passe est incorrect !";
			return "";
		}
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public String logout() {
		cartBean.getArticles().removeAll(cartBean.getArticles());
		cartBean.setNumberOfArticles("0");
		connectedUser = null;
		return "accueil.xhtml";
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String getOddPassword() {
		return oddPassword;
	}

	public void setOddPassword(String oddPassword) {
		this.oddPassword = oddPassword;
	}

	public String getErrorMessagePassWord() {
		return errorMessagePassWord;
	}

	public void setErrorMessagePassWord(String errorMessagePassWord) {
		this.errorMessagePassWord = errorMessagePassWord;
	}

	public CartBean getCartBean() {
		return cartBean;
	}

	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public Boolean getRender() {
		return render;
	}

	public void setRender(Boolean render) {
		this.render = render;
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

}
