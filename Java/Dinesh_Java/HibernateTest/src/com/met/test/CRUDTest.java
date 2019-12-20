package com.met.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.met.entity.Account;

public class CRUDTest {

	private static SessionFactory sessionFactory = new Configuration()
													.configure().buildSessionFactory();	
	public void getAccount(int id) {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			
			System.out.println("POST GET");
			System.out.println(account.getName());
			
			Account account1 = session.get(Account.class, id);
			System.out.println("POST GET");
			System.out.println(account1.getBalance());
			
			/*
			 * Account account1 = session.load(Account.class, 2);
			 * System.out.println("POST LOAD"); 
			 * System.out.println(account1.getName());
			 */
			
		}
		
		
	}
	
	public void updateAccount(int id) {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			
			account.setBalance(90000);
			
			session.beginTransaction();
			
			//session.update(account);
			
			System.out.println("After Session update is called");
			
			session.flush();
			
			
		}
		
		
	}
	
	public void updateDettachedAccount(int id) {
		
		Account account = null;
		
		try(Session session = sessionFactory.openSession()){
			
			account = session.get(Account.class, id);
			
			
			session.close();
			
			//ref of account is dettached
			
			account.setBalance(110000);
			
			Session session2 = sessionFactory.openSession();
			
			session2.get(Account.class, id);
			
			session2.beginTransaction();
			
			session2.update(account);
			
			session2.flush();
			
			
			session2.close();
			
		}
		
		
	}
	
	
	public void removeAccount(int id) {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			
			session.beginTransaction();
			
			session.remove(account);
			
			
			session.flush();
			
			
		}
		
	}
	
	public void evictAccount() {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, 1);
			Account account1 = session.get(Account.class, 3);
			
			System.out.println("Account 1 exits in session: " + session.contains(account));
			System.out.println("Account 3 exits in session: " + session.contains(account1));
			
			session.evict(account);
			
			System.out.println("Account 1 exits in session: " + session.contains(account));
			System.out.println("Account 3 exits in session: " + session.contains(account1));
			
			
		}
		
	}
	
	public void mergeDettachedAccount(int id) {
		
		Account account = null;
		
		try(Session session = sessionFactory.openSession()){
			
			account = session.get(Account.class, id);
			
			
			session.close();
			
			//ref of account is dettached
			
			account.setBalance(110000);
			
			
			Session session2 = sessionFactory.openSession();
			
			session2.get(Account.class, id);
			
			session2.beginTransaction();
			
			session2.merge(account);
			
			session2.flush();
			
			
			session2.close();
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
		CRUDTest test = new CRUDTest();
		//test.getAccount(1);
		
		//test.updateAccount(1);
		
		//test.updateDettachedAccount(1);
		
		//test.mergeDettachedAccount(1);
		
		//test.removeAccount(2);
		
		test.evictAccount();
		
		
		sessionFactory.close();
		
	}
	
	
}
