package com.example.CRUDops;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.employee;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Myjpa-unit");
		EntityManager em = emf.createEntityManager();
		
		try {
			List<employee> li = em.createQuery("from employee",employee.class).getResultList();
			
			for(employee e : li) {
				System.out.println("id :" + e.getId());
				System.out.println("email :" + e.getEmail());
				System.out.println("password :"+ e.getPassword());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
