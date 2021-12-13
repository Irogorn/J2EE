package fr.doranco.ecommerce.enums;

public enum Profils {
	ADMIN ("ADMIN"),
	MAGASINIER ("MAGASINIER"),
	CLIENT ("CLIENT"),
	CLIENT_WEBSERVICE ("CLIENT WEBSERVICE");
	
	private String profils;
	
	Profils(String profil) {
		profils = profil;
	}

	public String getProfils() {
		return profils;
	}
}
