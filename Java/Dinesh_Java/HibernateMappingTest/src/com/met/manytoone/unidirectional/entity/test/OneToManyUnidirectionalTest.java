package com.met.manytoone.unidirectional.entity.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.onetomany.unidirectional.entity.Address;
import com.met.onetomany.unidirectional.entity.Employee;

public class OneToManyUnidirectionalTest {

	public static void main(String[] args) {

		Address address = new Address("NY", "US");
		Address address1 = new Address("NEWARK", "US");
		
		Employee employee = new Employee("Anil", "sunil@met.edu");
		
		
		List<Address> listAddress = new ArrayList<Address>();
		listAddress.add(address);
		listAddress.add(address1);
		
		
		employee.setListAddress(listAddress);
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			tx = session.beginTransaction();
			
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
