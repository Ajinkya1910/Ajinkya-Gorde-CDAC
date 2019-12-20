package com.met.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.met.entity.Account;

public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account();
		account.setId(2);
		account.setName("Rohit");
		account.setBalance(20000);
		
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("jpaTest");
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		
		try {
			
			entityManager = entityManagerFactory.createEntityManager();
			
			entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			
			entityManager.persist(account);
		
			entityTransaction.commit();
			
		}catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			if(entityManager != null) {
				entityManager.close();
			}
			
			
			 if(entityManagerFactory != null) { entityManagerFactory.close(); }
			 
		}
		
		
	}
	
}



