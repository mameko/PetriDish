package com.pan.jpa.myToyProject.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pan.jpa.myToyProject.entities.Employee;

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

	@PersistenceContext
	private EntityManager em;

	public Employee findEmployee() {

		Employee john = em.find(Employee.class, 0);
		System.out.println("ouch");
		return john;

	}

}
