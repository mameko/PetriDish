package view.convertor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="nameCapConvertor")
public class NameCapConvertor implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return convertToCap(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return convertToCap(arg2.toString());
	}
	
	private String convertToCap(String input) {
		return input.toUpperCase();
	}
}
