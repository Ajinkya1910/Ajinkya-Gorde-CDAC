package com.met.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.entity.Account;

public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account();
		//account.setId(0);
		account.setName("SANIL");
		account.setBalance(1260000);
		
		/*
		 * EntityManagerFactory entityManagerFactory =
		 * Persistence.createEntityManagerFactory("jpaTest");
		 */
		
		//SessionFactory sessionFactory2 = new Configuration().configure("hibernate1.cfg.xml").buildSessionFactory();
		
		SessionFactory sessionFactory = new Configuration().configure().
											buildSessionFactory();
		/*
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		*/
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			/*
			 * entityManager = entityManagerFactory.createEntityManager();
			 * 
			 * entityTransaction = entityManager.getTransaction();
			 * 
			 * entityTransaction.begin();
			 * 
			 * entityManager.persist(account);
			 * 
			 * entityTransaction.commit();
			 */
			
			session = sessionFactory.openSession();
			
			transaction = session.beginTransaction();
			
			session.save(account);
			
			//transaction.commit();
			
			session.flush();
			
			
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			/*
			 * if(entityManager != null) { entityManager.close(); }
			 * 
			 * 
			 * if(entityManagerFactory != null) { entityManagerFactory.close(); }
			 */
			
			if(session != null) {
				session.close();
			}
			
			if(sessionFactory != null)
				sessionFactory.close();
		}
		
		
	}
	
}



