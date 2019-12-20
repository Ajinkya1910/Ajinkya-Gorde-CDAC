import java.sql.*;

class ParamSQLTest{

	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Date today = new Date(System.currentTimeMillis());
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		con.setAutoCommit(false);
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update counters set cur_val=cur_val+1 where ctr_name='orders'");
			ResultSet rs = stmt.executeQuery("select cur_val+1000 from counters where ctr_name='orders'");
			rs.next();
			int orderNo = rs.getInt(1);
			rs.close();
			stmt.close();
			PreparedStatement pstmt = con.prepareStatement("insert into orders values(?, ?, ?, ?, ?)");
			pstmt.setInt(1, orderNo);
			pstmt.setDate(2, today);
			pstmt.setString(3, customerId);
			pstmt.setInt(4, productNo);
			pstmt.setInt(5, quantity);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			System.out.printf("New order number is %d%n", orderNo);
		}catch(SQLException e){
			con.rollback();
			System.out.println("Order cannot be placed with given inputs");
		}
		con.close();
	}
}


