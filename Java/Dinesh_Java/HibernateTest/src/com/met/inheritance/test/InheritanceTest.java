package com.met.inheritance.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.inheritance.entity.CardPayment;
import com.met.inheritance.entity.ChequePayment;
import com.met.inheritance.entity.Payment;

public class InheritanceTest {

	public static void main(String[] args) {
		
		Payment payment = new Payment();
		payment.setAmount(500);
		
		
		/*
		 * ChequePayment chequePayment = new ChequePayment();
		 * chequePayment.setAmount(600); chequePayment.setBankName("ICICI");
		 * chequePayment.setChequeNo("0123");
		 */
		
		
		ChequePayment chequePayment = new ChequePayment("ICICI", "0123", 800);
		
		CardPayment cardPayment = new CardPayment();
		cardPayment.setAmount(700);
		cardPayment.setAgencyType("VISA");
		cardPayment.setCardNo("XXXXXXXXXXXXX-4562");
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			tx = session.beginTransaction();
			
			session.save(payment);
			session.save(chequePayment);
			session.save(cardPayment);
			
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
