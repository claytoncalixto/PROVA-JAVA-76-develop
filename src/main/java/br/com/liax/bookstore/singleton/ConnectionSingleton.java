package br.com.liax.bookstore.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	private static Connection CONNECTION = null;

	private ConnectionSingleton() {
		// singleton
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (isExistsConnection()) {
			return CONNECTION;
		}

		return createConnection();

	}

	private static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		CONNECTION = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BOOKSTORE", "root", "1234567");
		return CONNECTION;
	}

	private static boolean isExistsConnection() {
		return CONNECTION != null;
	}

}
