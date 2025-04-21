package com.example.CRUDops;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.employee;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Myjpa-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			int id = 2;
			et.begin();
			employee e = em.find(employee.class, id);
			if(e != null) {
				e.setEmail("email1@gmail.com");
				e.setPassword("password1");
				em.merge(e);
				et.commit();
				System.out.println("data successfully updated");
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
