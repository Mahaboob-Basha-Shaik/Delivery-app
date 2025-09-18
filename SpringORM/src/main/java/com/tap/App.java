package com.tap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.Entity.Student;

public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Student std = new Student("Mech", "shiva@gmail.com", "Kumar");

		Transaction tx = session.beginTransaction();
		session.save(std);
		tx.commit();

		session.close();
		factory.close();

	}

}
