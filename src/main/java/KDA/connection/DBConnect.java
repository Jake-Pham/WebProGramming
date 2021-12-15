package KDA.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kda?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root",
					"080120");
			return conn;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
