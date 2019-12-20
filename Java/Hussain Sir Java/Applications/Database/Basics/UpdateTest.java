import java.sql.*;

class UpdateTest{

	public static void main(String[] args) throws Exception{
		String sql = "update products set stock=stock+5 where pno=" + Integer.parseInt(args[0]);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost/xe", "scott", "tiger");
		Statement stmt = con.createStatement();
		int n = stmt.executeUpdate(sql);
		if(n != 0)
			System.out.println("Product stock incremented.");
		stmt.close();
		con.close();
	}
}


