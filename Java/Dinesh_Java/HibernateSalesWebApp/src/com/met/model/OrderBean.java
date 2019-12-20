package com.met.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.met.entity.Counter;
import com.met.entity.Order;
import com.met.util.HibernateUtil;

public class OrderBean {

	private String userName;
	private int pno;
	private int quantity;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getNewOrderNo(){
		
		int orderNo = -1;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			Counter counter = session.get(Counter.class, "orders");
			int counterValue = counter.getValue(); //131
			
			orderNo = ++counterValue + 1000;
			
			Order order = new Order();		//transient
			order.setOrderNo(orderNo);
			order.setCustomerId(userName);
			order.setOrderDate(new Date(System.currentTimeMillis()));
			order.setQty(quantity);
			order.setPno(pno);
			
			counter.setValue(counterValue);
			
			tx = session.beginTransaction();
			
			
			//session.update(counter);
			session.save(order);
			
			
			//order  persistent 
			
			
			tx.commit();
			
			
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
		
		
		
		/*
		 * Connection con = null; Statement stmt = null; PreparedStatement pstmt = null;
		 * ResultSet rs = null;
		 * 
		 * try {
		 * 
		 * Class.forName("oracle.jdbc.OracleDriver"); con =
		 * DriverManager.getConnection("jdbc:oracle:thin:@//192.168.4.31:1521/orcl11g",
		 * "dinesh", "dinesh");
		 * 
		 * con.setAutoCommit(false);
		 * 
		 * stmt = con.createStatement();
		 * 
		 * stmt.
		 * executeUpdate("update counters set cur_val=cur_val+1 where ctr_name='orders'"
		 * );
		 * 
		 * rs = stmt.
		 * executeQuery("select 1000 + cur_val from counters where ctr_name='orders'");
		 * 
		 * rs.next();
		 * 
		 * orderNo = rs.getInt(1);
		 * 
		 * String insertQuery = "insert into orders values (?, ?, ?, ?, ?)";
		 * 
		 * pstmt = con.prepareStatement(insertQuery);
		 * 
		 * pstmt.setInt(1, orderNo); pstmt.setDate(2, new
		 * Date(System.currentTimeMillis())); pstmt.setString(3, userName);
		 * pstmt.setInt(4, pno); pstmt.setInt(5, quantity);
		 * 
		 * pstmt.executeUpdate();
		 * 
		 * con.commit();
		 * 
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace();
		 * 
		 * if(con != null) try { con.rollback(); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } }finally{ if(rs != null){
		 * try { rs.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } }
		 * 
		 * if(pstmt != null){ try { pstmt.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 * 
		 * if(stmt != null){ try { stmt.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 * 
		 * if(con != null){ try { con.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }
		 */
		
		return orderNo;
		
	}
	
	
	
}
