package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/namdb";
		String username = "root";
		String password = "allenwu1999";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM customer";
			Statement statement = connection.createStatement();
			ResultSet result =  statement.executeQuery(sql);
			
			int count = 0;
			
			while(result.next()) {
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				count ++;
				System.out.println("Customer" + count + ": " + firstname + " " + lastname);
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
