package library;

import java.util.Scanner;

public class Management {
	Scanner scanner=new Scanner(System.in);
public static void main(String[] args) {
	Management manage=new Management();
	manage.login();
}


void login() {
	BookManagement manage=new BookManagement();
	System.out.print("Enter User Id : ");
	String userid=scanner.nextLine();
	System.out.println("Enter the Password : ");
	String password=scanner.nextLine();
	if(adminCheck(userid,password)) {
		manage.storeBook();
		manage.bookmanager();
	}
	else {
		login();
	}

}

boolean adminCheck(String userId,String password) {

	if(userId.equals("Adminlogin")&&password.equals("admin@123")) {
		return true;
	}
	return false;
}
}
