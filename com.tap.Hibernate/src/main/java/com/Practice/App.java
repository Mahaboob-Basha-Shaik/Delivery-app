package com.Practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("Setting.xml");
		config.addAnnotatedClass(Student.class);

		SessionFactory factory = config.buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

//		// 1.INSERT //.............................

//		Student student = new Student(5, "John Doe", "john@example.com");
//		session.persist(student);
//		tx.commit();
//
//		session.close();
//		factory.close();
//
//		System.out.println("✅ Student Data saved successfully.");

		// 2. Get One Student...............................

//		Student student = session.get(Student.class, 2);
//		System.out.println();
//		System.out.println(student.getId() + " " + student.getName() + " " + student.getEmail());

		// Get All Details //................................

		Query q = session.createQuery("FROM Student s");
		List<Student> students = q.getResultList();
		System.out.println(".........................................................");

		for (Student student : students) {
			System.out.println(student);
		}

		tx.commit();
		session.close();

		// Update //.........................................

//		Student student = session.get(Student.class, 4); // Assuming ID = 1
//		if (student != null) {
//			student.setName("Raj");
//			student.setEmail("Raj@gmail.com");
//
//			session.update(student);
//
//			tx.commit();
//			session.close();
//		}

		// Delete //...........................................
//
//		Student student = session.get(Student.class, 4);
//		if (student != null) {
//			session.delete(student);
//		}
//
//		tx.commit();
//		session.close();

	}
}
