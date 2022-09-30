package library;

import java.sql.*;

public class DataBaseConnection {

	
	Statement getData() {
		Statement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_Management","root","Ranjithkumar@1705");
			statement=connect.createStatement();
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return statement;
	}
}
