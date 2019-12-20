package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.entity.Employee;

//@Component
@Repository
public class EmployeeDAO {

	private static Map<Integer, Employee> mapEmployees = 
					new HashMap<Integer, Employee>();
	
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource oracleDataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier("dataSource1") private DataSource mysqlDataSource;
	 */
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void saveEmployee(Employee employee) throws SQLException {
		
		System.out.println("Save data into database");
		
		//mapEmployees.put(employee.getId(), employee);
		
		//saveUsingJDBC(employee);
		
		/*
		 * jdbcTemplate.update("insert into EmployeeTbl values (?, ?, ?, ?, ?) ", new
		 * Object[] {
		 * 
		 * employee.getId(), employee.getName(), employee.getAge(),
		 * employee.getDesignation(), employee.getEmailId()
		 * 
		 * });
		 */
		
		
		/*
		 * Session session = null; Transaction tx = null;
		 * 
		 * try { session = sessionFactory.openSession(); tx =
		 * session.beginTransaction();
		 * 
		 * session.save(employee);
		 * 
		 * tx.commit(); }catch (HibernateException e) { e.printStackTrace(); if(tx !=
		 * null) tx.rollback(); }finally { if(session != null) session.close(); }
		 */
		
		 Session session = sessionFactory.getCurrentSession();
		 session.save(employee);
		 
		 updateEmployeeCount();
		
	}
	
	public void updateEmployeeCount() throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("update employeecount set count=count+1").executeUpdate();
		
		//throw new SQLException("table doesnot exist");
	}
	
	
	public void saveUsingJDBC(Employee employee) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try{
			con = oracleDataSource.getConnection();
			preparedStatement = con.prepareStatement("insert into EmployeeTbl values (?, ?, ?, ?, ?)");
			
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setInt(3, employee.getAge());
			preparedStatement.setString(4, employee.getDesignation());
			preparedStatement.setString(5, employee.getEmailId());			

			preparedStatement.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(con != null){
				try{
					con.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
		
	}
	
	public Collection<Employee> getAllEmployees() {
		List<Employee> employees = null;
		
		try {
			employees  = jdbcTemplate.query("select * from EmployeeTbl", new BeanPropertyRowMapper(Employee.class));
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
		return employees;
		
	}
	
	public Employee getEmployee(int id) {
		
		return jdbcTemplate.queryForObject("select * from EmployeeTbl where id=?",
									new Object[] {id} , new BeanPropertyRowMapper<Employee>(Employee.class));
		
	}
	
}




