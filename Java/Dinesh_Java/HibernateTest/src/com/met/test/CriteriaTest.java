package com.met.test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

import com.met.entity.Account;

public class CriteriaTest {

	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
		try(Session session = sessionFactory.openSession()){
			
			Criteria criteria = session.createCriteria(Account.class);
			System.out.println(criteria.list());
			
			
			Criteria criteria1 = session.createCriteria(Account.class);
			criteria1.add(Restrictions.eq("name", "RAHUL"));
			
			System.out.println(criteria1.list());
			
			NativeQuery nativeQuery = session.createNativeQuery("select * from AccountTbl");
			
			
			
		}
		
		
	}	
	
}
