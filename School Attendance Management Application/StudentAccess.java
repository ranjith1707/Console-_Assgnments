package schoolatendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentAccess {
	Scanner scanner=new Scanner(System.in);
void studentLogin() {
	System.out.print("Enter Your Regiseter Number : ");
	int regN=scanner.nextInt();
	scanner.nextLine();
	System.out.print("Enter your Date Of Birth : ");
	String dob=scanner.nextLine();
	if(loginCheck(regN,dob)) {
		studentDetails(regN);
		
		System.out.println("Press 1 Login again  else Exit Page");
		String option=scanner.next();
		if(option.equals("1")) {
			studentLogin();
		}
	}
	else {
		System.out.println("Incorrect id ");
	}
}


boolean loginCheck(int regNo, String dob) {
	
	DataBase data=new DataBase();
	
	int idNo;
	String pass;
	try {
		Statement st=data.getData();
		ResultSet result=st.executeQuery("select * from student_details");
		while(result.next()) {
		idNo=result.getInt(1);
	    pass=result.getString(3);
		if(idNo==regNo&&pass.equals(dob)) {
	    return (idNo==regNo&&pass.equals(dob)); 
		}
		}
		
	} catch (Exception e) {
		System.out.println("Exception");
		
		
	}
	
	return false;

}


void studentDetails(int rollNo) {
System.out.println("   >  Hai <  ");	

DataBase data=new DataBase();

Statement stmt=data.getData();
Statement leavst=data.getData();
try {
	ResultSet details=stmt.executeQuery("select * from student_details where regNo="+rollNo+"");
	ResultSet leave=leavst.executeQuery("select * from student_attendance where regNo="+rollNo+"");
	details.next();
		System.out.println("Roll Number : "+details.getInt(1)+" ; Name : "+details.getString(2)+"  ;  Date Of Birth : "+details.getString(3)+"  ;  Mobile Number : "+details.getString(4));
	
	System.out.println("Date\t   |status\n-----------------");
	while(leave.next()) {
		System.out.println(leave.getString(3)+" |"+leave.getString(4));
	}

} catch (SQLException e) {
	
	System.out.println("Exception");
}

}
}
