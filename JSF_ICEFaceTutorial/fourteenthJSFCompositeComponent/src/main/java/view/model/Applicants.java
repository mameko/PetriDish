package view.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Applicants implements Serializable {
	private static int MAX_APPLICANT_NUMBER = 10;
	private List<Applicant> applicants = new ArrayList<>();
	private boolean full;

	public List<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}

	public void refresh(List<Applicant> refreshApplicants) {
		setApplicants(refreshApplicants);
	}

	public boolean isFull() {
		return applicants.size() > MAX_APPLICANT_NUMBER;
	}

	public void setFull(boolean full) {
		this.full = full;
	}	
}
