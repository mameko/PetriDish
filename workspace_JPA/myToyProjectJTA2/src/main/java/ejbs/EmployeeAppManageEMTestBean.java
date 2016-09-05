package ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Employee;

/**
 * 
 * @author mameko
 *
 *         This method is for trying item 3 in the readme list
 * 
 *         Application managed EM example
 *
 */

@Stateless
public class EmployeeAppManageEMTestBean {

	@PersistenceUnit
	private EntityManagerFactory emf;
	private EntityManager em;
	Employee john;

	public void init() {
		em = emf.createEntityManager();
	}

	public Employee findEmployee() {
		john = em.find(Employee.class, 0);
		System.out.println("in findEmployee() em contain john ? : " + em.contains(john));
		return john;

	}

	public void setEmployeeSalary(int salaryAmount) {
		em.joinTransaction();//need to tell the persistent context to synchronize to the tx. without this call the salary won't update
		john.setSalary(salaryAmount);
		System.out.println("in setEmployeeSalary() em contain john ? ==: " + em.contains(john));

	}
	
	public void distroy(){
		em.close();		
	}

}
