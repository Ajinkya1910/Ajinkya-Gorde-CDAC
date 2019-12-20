package com.met.onetomany.bidirectional.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.onetomany.bidirectional.Address;
import com.met.onetomany.bidirectional.Employee;


public class OneToManyBidirectionalTest {

	public static void main(String[] args) {

		Employee employee = new Employee("Karan", "karan@met.edu");
		
		
		Address address = new Address("DELHI", "INDIA");
		Address address1 = new Address("Pune", "INDIA");
		Address address2 = new Address("HYD", "INDIA");
		
		List<Address> listAddress = new ArrayList<Address>();
		
		listAddress.add(address);
		listAddress.add(address1);
		listAddress.add(address2);
		
		employee.setListAddress(listAddress);
		
		address.setEmployee(employee);
		address1.setEmployee(employee);
		address2.setEmployee(employee);
		
		
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			tx = session.beginTransaction();
			
			/*
			 * session.save(address); session.save(address1); session.save(address2);
			 */
			
			session.save(employee);
			
			tx.commit();
			
			
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}finally {
			
			if(session != null) session.close();
			if(sessionFactory != null) sessionFactory.close();
		}
				
		
	
		
	}
	
}
