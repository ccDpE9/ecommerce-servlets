package com.ccDpE9.ecommerce_servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/ecommerce_servlets";
    static final String USER = "comm";
    static final String PASS = "comm";

	
	public static Connection get() {
		Connection connection = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver registered");
			
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver not found.");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		
		if (connection != null) System.out.println("Connection established.");
		
		return connection;
	}
}
