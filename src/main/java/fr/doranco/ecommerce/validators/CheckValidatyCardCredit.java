package fr.doranco.ecommerce.validators;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@ManagedBean
@SessionScoped
@FacesValidator("checkValidatyCardCredit")
public class CheckValidatyCardCredit implements Validator {

	public CheckValidatyCardCredit() {
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if (value == null) {
			return;
		}

		Date dateToCompare = (Date)value;

		Calendar calendar = Calendar.getInstance();
		Date day = calendar.getTime();
		
		 
		  if (dateToCompare.before(day)) { 
			  throw new  ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Votre carte de paiement a dépassé la date de validité !", null)); 
		  }

}

}
