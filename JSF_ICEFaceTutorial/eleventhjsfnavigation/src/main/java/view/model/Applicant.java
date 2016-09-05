package view.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Applicant implements Serializable {

	private String firstName;
	private String lastName;
	private String country;
	private Integer title;
	private Double salary;
	private String email;

	@Override
	public String toString() {
		return firstName + lastName + " - " + super.toString();
	}

	@PostConstruct
	public void clear() {
		setCountry("");
		setEmail("");
		setFirstName("");
		setLastName("");
		setSalary(0.0);
		setTitle(null);
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
