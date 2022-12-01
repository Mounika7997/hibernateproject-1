package com.flm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

	public static void main(String[] args) {

		// S-1 : configuration to build session factory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);

		System.out.println("Config loaded !!");

		// S-2 : session factory to obtain session
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// S-3 : session object - to persist in db
		Session session = sessionFactory.openSession();

		System.out.println("session created !!");
		User u1 = new User(14, "Fayaz", 99.99);
		session.beginTransaction();

		session.save(u1);

		session.getTransaction().commit();

		System.out.println("Saved!!");

	}

}
