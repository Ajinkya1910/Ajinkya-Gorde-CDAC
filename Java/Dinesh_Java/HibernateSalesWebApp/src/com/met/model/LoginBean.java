package com.met.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.met.entity.Customer;
import com.met.util.HibernateUtil;

public class LoginBean {

	private String userName = null;

	public String getUserName() {
		return userName;
	}

	@SuppressWarnings("deprecation")
	public boolean authenticate(String userName, String password) {

		boolean success = false;

		/*
		 * if(count > 0){ success = true; this.userName = userName; }
		 */
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		
		
		try(Session session = sessionFactory.openSession()){
			
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("id", userName));
			criteria.add(Restrictions.eq("pwd", password));
			
			List list = criteria.list();
			
			if(list != null && list.size() == 1) {
				success = true; 
				this.userName = userName;
			}
			
		}
		
		
		

		/*
		 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
		 * 
		 * Context context = null; DataSource dataSource = null;
		 * 
		 * try { Class.forName("oracle.jdbc.OracleDriver"); con =
		 * DriverManager.getConnection("jdbc:oracle:thin:@//192.168.4.31:1521/orcl11g",
		 * "dinesh", "dinesh");
		 * 
		 * 
		 * context = new InitialContext(); Context initCtx = (Context)
		 * context.lookup("java:/comp/env"); dataSource = (DataSource)
		 * initCtx.lookup("jdbc/MySalesDB");
		 * 
		 * con = dataSource.getConnection();
		 * 
		 * 
		 * pstmt = con.
		 * prepareStatement("select count(1) from customers where cust_id=? and pwd=?");
		 * 
		 * pstmt.setString(1, userName); pstmt.setString(2, password);
		 * 
		 * rs = pstmt.executeQuery();
		 * 
		 * if(rs.next()){ int count = rs.getInt(1);
		 * 
		 * if(count > 0){ success = true; this.userName = userName; }
		 * 
		 * }
		 * 
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (NamingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }finally{ if(rs != null){ try
		 * { rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * if(pstmt != null){ try { pstmt.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 * 
		 * if(con != null){ try { con.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }
		 */

		return success;

	}

}
