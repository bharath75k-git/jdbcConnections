
package com.example.CRUDops;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.employee;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Myjpa-unit");
    	EntityManager em = emf.createEntityManager();
    	
    	employee e2 = new employee();
    	e2.setEmail("email4@gmail.com");
    	e2.setPassword("password4");
 
    	EntityTransaction et = em.getTransaction();
    	try {
    		et.begin();
    		em.persist(e2);
        	et.commit();
        	System.out.println("successfully inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
	    	emf.close();
		}

    }
}
