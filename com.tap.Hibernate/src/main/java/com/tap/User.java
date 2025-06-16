package com.tap;

import jakarta.persistence.*;

public class User {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
		EntityManager em = emf.createEntityManager();
		System.out.println();

		Employee student = new Employee(4, "Kumar", "kumar@gmail.com");

		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();

		em.close();
		emf.close();
		System.out.println();

		System.out.println("Student Data saved successfully / Row Inserted successfully");

	}
}

// to Delete a row //

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
//		EntityManager em = emf.createEntityManager();
//
//		em.getTransaction().begin();
//
//// Find the student entity by ID
//		Employee student = em.find(Employee.class, 4);
//		System.out.println();
//
//		if (student != null) {
//			em.remove(student); // Delete the student
//			System.out.println("Student deleted successfully.");
//		} else {
//			System.out.println("Student not found.");
//		}
//
//		em.getTransaction().commit();
//		em.close();
//		emf.close();	
