package com.example.CRUDops;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.employee;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Myjpa-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			int id = 1;
			et.begin();
			employee e = em.find(employee.class, id);
			if(e != null) {
				em.remove(e);
				et.commit();
				System.out.println("successfully deleted");
			}else {
				System.out.println("employee not found with id:" + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}

}
