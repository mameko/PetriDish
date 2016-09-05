package ejbs;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import entities.Employee;

/**
 * 
 * @author mameko
 *
 *         This method is for trying item 3 in the readme list
 * 
 *         Extended scope entity manager example
 *
 */
@Stateful
public class EmployeeExtScoptEMTestBean {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	Employee john;

	public Employee findEmployee() {
		john = em.find(Employee.class, 0);
		System.out.println("in findEmployee() em contain john ? : " + em.contains(john));
		return john;

	}

	public void setEmployeeSalary(int salaryAmount) {
		john.setSalary(salaryAmount);
		System.out.println("in setEmployeeSalary() em contain john ? : " + em.contains(john));

	}
	
	@Remove
	public void finished(){
		System.out.println("closing em ?");		
	}
}
