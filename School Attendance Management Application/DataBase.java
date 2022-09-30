package schoolatendance;
import java.sql.*;
public class DataBase {

	public  Statement getData() {
		Statement statement = null;
	try {
	  Class.forName("com.mysql.cj.jdbc.Driver");  
	 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_details","root","Ranjithkumar@1705");
	 statement=connect.createStatement();
	}catch(Exception e) {
		System.out.println("SQL Exception");
	}	
	return statement;
	}
}

