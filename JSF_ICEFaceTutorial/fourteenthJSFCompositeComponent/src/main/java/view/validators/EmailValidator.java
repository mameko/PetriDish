package view.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		if (!arg2.toString().contains("@")) {
			String msg = "invalid email";
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
//			FacesContext fc = FacesContext.getCurrentInstance();
//			fc.addMessage(null, fm);
			throw new ValidatorException(fm);
		}
	}

}
