package ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Employee;

/**
 * 
 * @author mameko
 *
 *         This method is for trying item 3 in the readme list
 * 
 *         Tx scope entity manager example
 *
 */

@Stateless
public class EmployeeTxScopeEMTestBean {

	@PersistenceContext//(type = PersistenceContextType.EXTENDED) <- this will generate an exception. need to use stateful bean for extended persistence context
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

}
