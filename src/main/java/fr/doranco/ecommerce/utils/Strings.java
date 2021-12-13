package fr.doranco.ecommerce.utils;

//import org.json.JSONObject;

import fr.doranco.ecommerce.entities.pojo.User;

public final class Strings {
	
	private Strings() {
		// TODO Auto-generated constructor stub
	}
	
	public final static String getEmployeAuFormatXmlString(User employe) {
		return null;
		/*
		 * StringBuilder sb = new StringBuilder(); sb.append("<employe>\n");
		 * sb.append("<id>"+employe.getId()+"</id>\n");
		 * sb.append("<nom>"+employe.getNom()+"</nom>\n");
		 * sb.append("<prenom>"+employe.getPrenom()+"</prenom>\n");
		 * sb.append("</employe>\n"); return sb.toString();
		 */
		
	}
	
	public final static String getEmployeAuFormatJsonString(User employe) {
		return null;
		/*
		 * JSONObject jo = new JSONObject(); jo.put("id", employe.getId());
		 * jo.put("nom", employe.getNom()); jo.put("prenom", employe.getPrenom());
		 * return jo.toString();
		 */
	
		
	}
}
