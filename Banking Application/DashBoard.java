package banking;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class DashBoard {
	static HashMap<Integer,Account> accounts=new HashMap<Integer,Account>();
	static HashMap<Integer,ArrayList<AccountTransfer>> transactionHistory=new HashMap<Integer,ArrayList<AccountTransfer>>();
	Scanner scanner=new Scanner(System.in);
	static int NumberGenarator=1001;
  public static void main(String[] args) {
	DashBoard dashBoard=new DashBoard();
	dashBoard.banking();
  }
  
  void banking() {
	  System.out.println("  Welcome To Banking   !\n");
	  System.out.println(" 1 > Alredy Costomer\n 2 > New Costomer\n 3 > Exit");
	  int option=scanner.nextInt();
	  
	  switch(option) {
	  case 2:newUser();
	  break;
	  case 1:costomerLogin();
	  break;
	  }
	  if(option!=3&& option<3) {
		  banking();
	  }
	  
  }
  
  
  void newUser(){
	  
System.out.println("	! Welcome to State Bank Of India  !\n");
System.out.print("Enter Your Name First Letter Must UpperCase : ");
scanner.nextLine();
String name=scanner.nextLine();
Pattern nameCase=Pattern.compile("^[A-Z]");
Matcher nameMatch=nameCase.matcher(name);
while(!nameMatch.find()) {
	System.out.println("Name Must Start With Upper Case");
	name=scanner.nextLine();
	nameMatch=nameCase.matcher(name);
}

System.out.print("Enter your Date Of Birth  : ");
String dob=scanner.nextLine();
System.out.println("select Branch  > ");
String[] branches= {" Surandai", "Tenkasi","Tirunelveli", "Madurai", "Thoothukudi", "Chennai"};
String[] branchId= {"62","76","72","50","71","10"};
int selection=1;
for(String s:branches) {
	System.out.println(selection+" > "+s);
	selection++;
}
System.out.print("Enter option  :");
int option=scanner.nextInt();
while(!(option>0&&option<=6)) {
	System.out.println("Select Correct Branch\n");
	option=scanner.nextInt();
 
}
String branchIdNo=branchId[option-1];
int accountNumber=(int)Integer.parseInt(branchIdNo+NumberGenarator);
String branch=branches[option-1];
System.out.print("Enter Your Mobile Number > 10 numbers");
String mobileNumber=scanner.next();
Pattern mobileNo=Pattern.compile("[6-9][0-9]{9}");
Matcher numberCheck=mobileNo.matcher(mobileNumber);
while(!numberCheck.find()) {
	System.out.println("Incorrect Mobile Number \n");
	
	System.out.print("Enter Your Mobile Number > 10 numbers  : ");
	mobileNumber=scanner.next();
	numberCheck=mobileNo.matcher(mobileNumber);
}
System.out.println("Create PIN number");
String  pin=scanner.next();
double balance=0.0;
Account account=new Account(name,dob,mobileNumber,branch,branchIdNo,accountNumber,pin,balance);
accounts.put(accountNumber, account);
ArrayList<AccountTransfer> history=new ArrayList<AccountTransfer>();
transactionHistory.put(accountNumber,history);
System.out.println("Your Account Number is :  "+accountNumber+"\nPin Number : "+pin+"\n Your Name  : "+name);
System.out.println();
NumberGenarator++;
}

  void costomerLogin() {
	  System.out.print("Enter Your AccountNumber : ");
	  int accountNumber=scanner.nextInt();
	  System.out.print("Enter Pin Number  : ");
	  String pin=scanner.next();
	  if(accounts.containsKey(accountNumber)) {
		  if(accounts.get(accountNumber).getPin().equals(pin)) {
                Transaction transaction=new Transaction();
                transaction.userInterface(accountNumber);
		  }
		  else {
			  System.out.println("Invalid PIN Number");
		  }
	  }
	  else {
		  System.out.println("Account Number Incorrect");
	  }
  }
}
