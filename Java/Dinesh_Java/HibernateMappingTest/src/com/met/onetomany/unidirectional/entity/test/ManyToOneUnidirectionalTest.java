package com.met.onetomany.unidirectional.entity.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.manytoone.unidirectional.entity.copy.Address;
import com.met.manytoone.unidirectional.entity.copy.Employee;

public class ManyToOneUnidirectionalTest {

	public static void main(String[] args) {

		Employee employee = new Employee("Amit", "amit@met.edu");
		
		
		Address address = new Address("NY", "USA");
		Address address1 = new Address("NEWARK", "USA");
		Address address2 = new Address("DALLAS", "USA");
		
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
			
			
			session.save(address);
			session.save(address1); 
			session.save(address2);
			
			
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
