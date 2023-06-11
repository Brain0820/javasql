package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/namdb";
		String username = "root";
		String password = "allenwu1999";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO customer (firstname,lastname) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,"C");
			statement.setString(2,"Cat");
			int rows = statement.executeUpdate();
			if (rows > 0) {
				System.out.println("A rows has been inserted.");
			}
			statement.close();
			connection.close();
			
			System.out.println("OK!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
		
		//System.out.println("Hello Word");
	}
}
