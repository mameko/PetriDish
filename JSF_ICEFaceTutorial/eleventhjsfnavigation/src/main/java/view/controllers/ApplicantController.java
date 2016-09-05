package view.controllers;

import java.io.Serializable;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.event.ActionEvent;

import services.JobAppliantService;
import view.model.Applicant;
import view.model.Applicants;
import view.utils.FacesUtils;

@ManagedBean
@SessionScoped
public class ApplicantController implements Serializable {

	@ManagedProperty(value="#{jobAppicantServiceImpl}")
	private JobAppliantService jobAppliantService;
	
	public String addApplicant() {
		Applicant applicant = (Applicant) FacesUtils.getManagedBean("applicant");
		if (applicant.getFirstName().equalsIgnoreCase("john")) {
			String msg = "We decide not to hire people called john";
			FacesUtils.addErrorMessage(msg);
			return null;
		} else {
			jobAppliantService.addApplicantToDB(applicant);
			Applicants applicants = (Applicants) FacesUtils.getManagedBean("applicants");
			applicants.refresh(jobAppliantService.getApplicantsFromDB());
			return "result?faces-redirect=true";
		}
	}

	public void clearForm(ActionEvent ae) {
		// Clear bean value
		Applicant applicant = (Applicant) FacesUtils.getManagedBean("applicant");
		applicant.clear();

		// Clear component values
		UIComponent form = getContainingForm(ae.getComponent());
		clearEditableValueHolders(form);
	}

	private void clearEditableValueHolders(UIComponent form) {
		Iterator<UIComponent> iterator = form.getFacetsAndChildren();
		while (iterator.hasNext()) {
			UIComponent uiComponent = (UIComponent) iterator.next();
			if (uiComponent instanceof EditableValueHolder) {
				((EditableValueHolder)uiComponent).resetValue();
			}
			clearEditableValueHolders(uiComponent);
		}
	}

	private UIComponent getContainingForm(UIComponent component) {
		if (!(component.getParent() instanceof UIForm)) {
			return getContainingForm(component.getParent());
		} else {
			return component.getParent();
		}
	}

	public JobAppliantService getJobAppliantService() {
		return jobAppliantService;
	}

	public void setJobAppliantService(JobAppliantService jobAppliantService) {
		this.jobAppliantService = jobAppliantService;
	}
}
