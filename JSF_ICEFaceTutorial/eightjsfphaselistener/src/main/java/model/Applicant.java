package model;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class Applicant implements Serializable{

	private String firstName;
	private String lastName;
	private String country;
	private Integer title;
	private Double salary;
	private String email;
	
	
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void submitCheck(ActionEvent ae) {
		if (firstName.equalsIgnoreCase("john")) {
			String msg = "We decide not to hire people called john";
			FacesMessage fm = new FacesMessage(msg);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, fm);
		}
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
