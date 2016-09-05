package view.model;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class CountryList implements Serializable {
	private String[] countryList = {"Canada", "USA"};

	public String[] getCountryList() {
		return countryList;
	}

	public void setCountryList(String[] countryList) {
		this.countryList = countryList;
	}
	
}
