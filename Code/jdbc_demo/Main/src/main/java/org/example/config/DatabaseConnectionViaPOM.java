package org.example.config;

import static org.example.config.DatabaseConnectionManager.getConnection;

import java.sql.*;

public class DatabaseConnectionViaPOM {

	public static Connection getConnection() {
		 // Explicitly load the MySQL JDBC driver
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/alu_lme_price?useSSL=false"; 
			String user = "root";
			String password = "mocha123";

			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the database successfully!");
			return conn;

		// } catch (ClassNotFoundException e) {
		// 	System.out.println("Class Error: " + e.getMessage());
		}
		catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
		return null;
	}

	public static void main(String[] args) {
		getConnection();
	}

}
