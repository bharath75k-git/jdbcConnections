package com.example.CRUDops;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.employee;

public class logIn {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.println("enter your email");
		String useremail = scr.nextLine();
		System.out.println("enter your password");
		String userpassword = scr.nextLine();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Myjpa-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			
			employee foundEmployee = em.find(employee.class, useremail);
			if(foundEmployee != null) {
				if(foundEmployee.getPassword().equals(userpassword)) {
					System.out.println("you have logged in successfully");
				}else {
					System.out.println("Invalid credentials - incorrect password");
				}
			}else {
				System.out.println("Invalid credentials - Email not found");
			}
			
//			TypedQuery<employee> query = em.createQuery("SELECT e FROM employee e WHERE e.email = :email", employee.class);
//			query.setParameter("email", user_email);
//			List<employee> results = query.getResultList();
//			if(!results.isEmpty()) {
//				employee foundEmployee = results.get(0);
//				if(foundEmployee.getPassword().equals(user_password)) {
//					System.out.println("You have logged in successfully");
//				}else {
//					System.out.println("Invalid credentials - incorrect password");
//				}
//			}else {
//				System.out.println("Invalid credentials - Email not found");
//			}
			
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
			scr.close();
		}
	}

}
