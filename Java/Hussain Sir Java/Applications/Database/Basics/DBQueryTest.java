import java.io.*;
import java.util.*;
import java.sql.*;

class DBQueryTest{

	public static void main(String[] args) throws Exception{
		Properties settings = new Properties();
		try(InputStream input = new FileInputStream(args[0])){
			settings.load(input);
		}
		String driver = settings.getProperty("jdbc.driver");
		String url = settings.getProperty("jdbc.url");
		String user = settings.getProperty("jdbc.user");
		String password = settings.getProperty("jdbc.password");
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select pno, price, stock from products");
		while(rs.next())
			System.out.printf("%d\t%.2f\t%d%n", rs.getInt(1), rs.getDouble(2), rs.getInt("stock"));
		rs.close();
		stmt.close();
		con.close();
	}
}

