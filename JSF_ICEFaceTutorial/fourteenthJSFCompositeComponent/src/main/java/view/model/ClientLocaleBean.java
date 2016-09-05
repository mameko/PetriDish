package view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class ClientLocaleBean implements Serializable {
	private String clientLocale;//ajax seems not working fine with non primitive value. 
	private Locale clientLocaleLocale;//so seperate the locale and the localeString into 2 places
	private List<String> supportedLocales = new ArrayList<String>();

	@PostConstruct
	public void initSupportedLocales() {

		Iterator<Locale> supportedLocalesIterator = FacesContext.getCurrentInstance().getApplication()
				.getSupportedLocales();
		while(supportedLocalesIterator.hasNext()) {
			supportedLocales.add(supportedLocalesIterator.next().toString());			
		}
		
		setClientLocaleLocale(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
		setClientLocale(getClientLocaleLocale().toString());
	}

	public String getClientLocale() {
		return clientLocale;
	}

	public void setClientLocale(String clientLocale) {
		this.clientLocale = clientLocale;
	}

	public void switchLocale(AjaxBehaviorEvent ave) {
//		System.out.println("in switchLocale()" + ave);
		clientLocaleLocale = new Locale(clientLocale);				
		FacesContext.getCurrentInstance().getViewRoot().setLocale(clientLocaleLocale);
	}

	public List<String> getSupportedLocales() {
		return supportedLocales;
	}

	public void setSupportedLocales(List<String> supportedLocales) {
		this.supportedLocales = supportedLocales;
	}

	public Locale getClientLocaleLocale() {
		return clientLocaleLocale;
	}

	public void setClientLocaleLocale(Locale clientLocaleLocale) {
		this.clientLocaleLocale = clientLocaleLocale;
	}


}
