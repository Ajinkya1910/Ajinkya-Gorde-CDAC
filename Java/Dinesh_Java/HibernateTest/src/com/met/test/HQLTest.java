package com.met.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLTest {

	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		
		try(Session session = sessionFactory.openSession()){
			
			Query query = session.createQuery("from Account");
			System.out.println(query.list());
			
			
			Query query1 = session.createQuery("select A.balance from Account A");
			System.out.println(query1.list());
			
			
			Query query2 = session.createQuery("select max(A.balance) from Account A");
			System.out.println(query2.list());
			
			Query query3 = session.createQuery("select max(A.balance) from Account A");
			query3.setMaxResults(2);
			System.out.println(query3.list());
			
			
		}
		
		sessionFactory.close();
	}
	
}
