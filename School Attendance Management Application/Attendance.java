package schoolatendance;
import java.util.*;
public class Attendance {
	Scanner scanner=new Scanner(System.in);
     public static void main(String[] args) {
    	 Attendance attendance=new Attendance();
    	 attendance.dashBoard();
     }
     
    void dashBoard(){
    	 System.out.println(" 1 > Institution Login \n 2 > Student Login");
    	 int option=scanner.nextInt();
    	 Institution insLog=new Institution();
    	 StudentAccess stuLogin=new StudentAccess();
    	 switch(option) {
    	 case 1:insLog.instituteLogin();
    	 break;
    	 case 2:stuLogin.studentLogin();
    	 }
    	 if(option<3) {
    		 dashBoard();
    		 }
     }
}
