package com.met.customtag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.met.model.ProductBean;

public class ProductInfoTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		JspContext jspContext = super.getJspContext();
		JspWriter out = jspContext.getOut();

		JspFragment body = super.getJspBody();
		

		try {
			Class.forName("oracle.jdbc.OracleDriver");	
			con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.4.31:1521/orcl11g", "dinesh", "dinesh");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select pno, price, stock from products");
			
			while(rs.next()){
				
				int pNo = rs.getInt("pno");
				double price = rs.getDouble("price");
				int stock = rs.getInt("stock");
					
				ProductBean productBean = new ProductBean(pNo, price, stock);
				//out.write(productBean.toString());
				
				jspContext.setAttribute("product", productBean);
				
				body.invoke(null);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
