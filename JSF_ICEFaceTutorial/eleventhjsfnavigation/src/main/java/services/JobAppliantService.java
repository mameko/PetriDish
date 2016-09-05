package services;

import java.util.List;

import view.model.Applicant;

public interface JobAppliantService {
	public void addApplicantToDB(Applicant applicant);
	
	public List<Applicant> getApplicantsFromDB();
}
