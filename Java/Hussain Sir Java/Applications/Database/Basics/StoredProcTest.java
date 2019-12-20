import java.sql.*;

class StoredProcTest{

	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		try{
			CallableStatement cstmt = con.prepareCall("{call place_order(?, ?, ?, ?)}");
			cstmt.setString(1, customerId);
			cstmt.setInt(2, productNo);
			cstmt.setInt(3, quantity);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.executeUpdate();
			System.out.printf("New order number is %d%n", cstmt.getInt(4));
			cstmt.close();
		}catch(SQLException e){
			System.out.println("Order cannot be placed with given inputs");
		}
		con.close();
	}
}


