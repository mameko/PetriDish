package com.pan.jpa.myToyProject;

import javax.persistence.*;

import com.pan.jpa.myToyProject.entities.Employee;
import com.pan.jpa.myToyProject.utils.ConstantsOrEnum.Gender;
/**
 * SE exmaple
 *
 */
public class SEExmple 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompanyExample");
    	EntityManager em = emf.createEntityManager();
    	
    	Employee e = new Employee();
    	e.setGender(Gender.MALE);
    	e.setFirstName("John");
    	e.setLastName("Doe");
    	e.setSalary(1000);

    	int eid = e.getEmployee_id();
    	
    	em.getTransaction().begin();
    	//em.persist(e);
    	Employee eFromDB = em.find(Employee.class, e.getEmployee_id());
    	em.detach(eFromDB);
//    	em.refresh(eFromDB);
    	eFromDB.setSalary(900);
//    	em.merge(eFromDB);
    	
    	
    	
    	
    	Employee john = em.find(Employee.class, eid);
//    	System.out.println(em.contains(eFromDB));//contain john but not eFromDB
//    	System.out.println(john.equals(eFromDB));//false
    	System.out.println(em.getEntityManagerFactory().getCache().contains(Employee.class, john.getEmployee_id()));
    	
    	System.out.println(john.getSalary());
    	
    	//Hibernate cannot unwrap class com.pan.jpa.myToyProject.entities.Employee
//    	System.out.println(em.unwrap(Employee.class).toString());
    	
    	em.getTransaction().commit();
    	em.close();
    	emf.close();
    	
    }
}
