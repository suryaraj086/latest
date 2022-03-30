package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import myexception.CustomException;

public enum ConnectionUtility {
	CONNECTION;

	static String url = "jdbc:mysql://localhost:3306/bank";
	static String name = "root";
	static String password = "1234";
	static Connection connect = null;

	public static Connection getConnection() throws CustomException {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new CustomException("connection error");
		}
		try {
			if (connect == null) {
				connect = DriverManager.getConnection(url, name, password);
				return connect;
			}
			
			return connect;
		} catch (Exception e) {
			throw new CustomException("connection error");
		}
	}

	public static void closeConnection() throws CustomException {
		if (connect != null) {
			try {
				connect.close();
				connect = null;
			} catch (SQLException e) {
				throw new CustomException("Cannot close connection");
			}
		}
	}
}
