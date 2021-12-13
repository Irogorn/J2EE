package fr.doranco.ecommerce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class Dates {

	private final static String formatDate = "dd/MM/yyyy";
	
	private Dates() {}
	
	public final static java.util.Date dateSqlToUtil(java.sql.Date dateSql) {
		return new java.util.Date(dateSql.getTime());
	}

	public final static java.sql.Date dateUtilToSql(java.util.Date dateUtil) {
		if(dateUtil != null) {
			return new java.sql.Date(dateUtil.getTime());
		}
		return null;
	}
	
	public final static java.util.Date stringToDateUtil(String datestr) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.parse(datestr);
	}
	
	public final static String DateUtilToString(java.util.Date dateUtil){
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.format(dateUtil);
	}
}
