package com.met.onetomany.bidirectional.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.met.onetomany.bidirectional.Employee;

public class CriteriaTest {

	
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			Criteria createCriteria = session.createCriteria(Employee.class);
			createCriteria.setFetchMode("listAddress", FetchMode.EAGER);
			System.out.println(createCriteria.list());
			
			//List list = createCriteria.list();
			
			sessionFactory.close();
		}
		
		
	}
	
	
}
