package schoolatendance;
import java.util.Scanner;
import java.sql.*;
public class Institution {
	Scanner scanner=new Scanner(System.in);
	
void instituteLogin(){
	System.out.println("Enter Login Id");
	String userId=scanner.nextLine();
	System.out.print("Eneter Password");
   String userpassword=scanner.nextLine();
   
   if(login(userId, userpassword)) {
	   instituteDashBoard();
   }
   else
   {
	   System.out.println("Incorrect User ID or Password");
   }
   
}

boolean login(String userId,String userpassword) {
	boolean flag=false;
	String id="--";
	String pass="--";
	
	DataBase data=new DataBase();
		try {
			Statement st=data.getData();
			ResultSet result=st.executeQuery("select * from login");
			result.next();
			id=result.getString(1);
		    pass=result.getString(2);
			
		} catch (Exception e) {
			System.out.println("Exception");
			
			flag=false;
		}
		if(id.equals(userId)&&pass.equals(userpassword)) {
			flag=true;
		}
		return flag;
	
}

void instituteDashBoard() {
	System.out.println("__________________________________________________________________________");
	System.out.println(" 1 > Show StudentList\n 2 > Show TeacherList\n 3 > Show Student Details\n 4 > Show Teacher Details\n 5 > Add New Admission\n 6 > update Attendance\n 7 > View Attendance ");
	int option =scanner.nextInt();
	switch(option) {
	case 1:studentList();
	break;
	case 2:teacherList();
	break;
	case 3:studentDetails();
	break;
	case 4:teacherDetails();
	break;
	case 5:newAdmission();
	break;
	case 6:updateAttendance();
	break;
	case 7:viewAttendance();
	}
	instituteDashBoard();
}

void studentList() {
	
	DataBase data=new DataBase();
	try {
		Statement st=data.getData();
		ResultSet result=st.executeQuery("select * from student_details");
		
		System.out.println("Reg No\t|Name\n---------------------");
		while(result.next()) {
			System.out.println(result.getString(1)+"\t|"+result.getString(2));
			
		}
		
	} catch (Exception e) {
		System.out.println("Exception");
		
	}
}

void teacherList() {
	DataBase data=new DataBase();
	try {
		Statement st=data.getData();
		ResultSet result=st.executeQuery("select * from teachers_information");
		
		System.out.println("Staf id\t|Name\n---------------------");
		while(result.next()) {
			System.out.println(result.getString(1)+"\t|"+result.getString(2));
			
		}
		
	} catch (Exception e) {
		System.out.println("Exception");
		
	}
}
void studentDetails() {
	System.out.println("Enter Student Id");
	int id=scanner.nextInt();
	DataBase data=new DataBase();
	try {
		Statement st=data.getData();
		Statement leavst=data.getData();
		ResultSet result=st.executeQuery("select * from student_details where regNo="+id+"");
		ResultSet leave=leavst.executeQuery("select * from student_attendance where regNo="+id+"");
		
		System.out.println("Reg No\t|Name\t       |Dob\t    |Mobile No\n-------------------------------------");
		result.next();
			System.out.println("Reg No    : "+result.getString(1)+"\nName     : "+result.getString(2)+"\nDate Of Birth: "+result.getString(3)+"\nMobile Number: "+result.getString(4));
			
		
		System.out.println("Date\t   |status\n-----------------");
		while(leave.next()) {
			System.out.println(leave.getString(3)+" |"+leave.getString(4));
		}
		
	} catch (Exception e) {
		System.out.println("Exception");
		
	}
}
void teacherDetails() {
	System.out.println("Enter Staff Id");
	int id=scanner.nextInt();
	DataBase data=new DataBase();
	try {
		Statement st=data.getData();
		ResultSet result=st.executeQuery("select * from teachers_information where idNo="+id+"");
		
		System.out.println("Staff Id\t|Name\t|Degree\t|Mobile No\n-------------------------------------");
		while(result.next()) {
			System.out.println(result.getString(1)+"\t|"+result.getString(2)+"\t|"+result.getString(3)+"\t|"+result.getString(4));
			
		}
		
	} catch (Exception e) {
		System.out.println("Exception");
		
	}
	
}
void newAdmission() {
	System.out.println("Enter Student Rigister Number");
	int regNo=scanner.nextInt();
	scanner.nextLine();
	System.out.print("Enter Student Name : ");
	String nName=scanner.nextLine();
	System.out.print("Entre Student Date Of Birth ");
	String dob=scanner.nextLine();
	System.out.println("Mobile Number");
	String mobile=scanner.nextLine();
	
	DataBase data=new DataBase();
	try {
		Statement statment=data.getData();
		int n=statment.executeUpdate("Insert into student_details(regNo,name,dob,mobile_number)values("+regNo+",'"+nName+"','"+dob+"','"+mobile+"')");
	}catch(Exception e) {
		System.out.println("Exception");
	}
}
void updateAttendance() {
	System.out.print("Enter Student Id : ");
	int id=scanner.nextInt();
	String[] status= {"Present","Absent"};
	System.out.println(" 1 > Present\n 2 > Absent");
	int option=scanner.nextInt();
	String attendance=status[option-1];
	DataBase data=new DataBase();
	try {
		Statement statment=data.getData();
		int n=statment.executeUpdate("Insert into student_attendance(regNo,date,status)values("+id+",date(now()),'"+attendance+"')");
	}catch(Exception e) {
		System.out.println("Exception");
	}
	
}
void viewAttendance() {
	System.out.println(" Enter Date : ");
	scanner.nextLine();
	String date=scanner.nextLine();
	DataBase data=new DataBase();
	try {
		Statement st=data.getData();
		Statement leavst=data.getData();
		ResultSet result=st.executeQuery("select * from student_details where regNo in(select regNo from student_attendance where date='"+date+"')");
		ResultSet leave=leavst.executeQuery("select status from student_attendance where date='"+date+"'");
		System.out.print("");
		
		while(result.next()) {
		     leave.next();
			System.out.print("Reg No : "+result.getString(1)+"\tName : "+result.getString(2));
            System.out.print("\t Status : "+leave.getString(1));
            System.out.println();
		}
	} catch (Exception e) {
		System.out.println("Exception");
		
	}
}
}
