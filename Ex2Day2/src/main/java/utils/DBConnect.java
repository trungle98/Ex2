package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnecttion() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cons = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Ex2", "trung", "poozal1998");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e+"looix o DBConnect");
		}
		return cons;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnecttion());
	}

}
