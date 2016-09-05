package services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import view.model.Applicant;

@ManagedBean
@ApplicationScoped
public class JobAppicantServiceImpl implements JobAppliantService {

	private List<Applicant> applicantsDB = new ArrayList<>();
		
	@Override
	public void addApplicantToDB(Applicant applicant) {
		applicantsDB.add(applicant);
		System.out.println("persisted to DB");
	}

	@Override
	public List<Applicant> getApplicantsFromDB() {
		System.out.println("retrieve from DB");
		return applicantsDB;
	}

}
