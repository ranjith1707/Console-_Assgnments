package banking;
import java.util.*;
public class Transaction{
	Scanner scanner=new Scanner(System.in);
   void userInterface(int accountNumber){
	   System.out.println("_________________________________________________________________________");
	   System.out.println(" 1 > View Profile\n 2 > Balance Enquiry\n 3 > Deposit\n 4 > Amount Withdrawal\n 5 > View Statements\n 6 > Amount Transfer\n 7 > LogOut");
	   int option=scanner.nextInt();
	   switch(option) {
	   case 1:viewProfile(accountNumber);
		   break;
	   case 2:balanceEnquiry(accountNumber);
		   break;
	   case 3: deposit(accountNumber);
		   break;
	   case 4:amountWithdrawal(accountNumber);
		   break;
	   case 5:viewStatements(accountNumber);
		   break;
	   case 6:amountTransfer(accountNumber);
		   
	   }
	   
	   if(option!=7&&option<7) {
		   userInterface(accountNumber);
	   }
   }
   
   void viewProfile(int accountNumber){
	   System.out.println("  Hi   "+ DashBoard.accounts.get(accountNumber).getName()+"\n");
	   System.out.println("Name           : "+DashBoard.accounts.get(accountNumber).getName());
	   System.out.println("Account Number : "+DashBoard.accounts.get(accountNumber).getAccountNumber());
	   System.out.println("Age            : "+DashBoard.accounts.get(accountNumber).getDob());
	   System.out.println("Mobile Number  : "+DashBoard.accounts.get(accountNumber).getMobileNumber());
	   System.out.println("Branch Name    : "+DashBoard.accounts.get(accountNumber).getBranch());
	   System.out.println("Branch Id      : "+DashBoard.accounts.get(accountNumber).getBranchId());
	  
	   
   }
   
   void balanceEnquiry(int accountNumber) {
	   System.out.println("Name           : "+DashBoard.accounts.get(accountNumber).getName());
	   System.out.println("Account Number : "+DashBoard.accounts.get(accountNumber).getAccountNumber());
	   
	  System.out.println("Balance         : "+DashBoard.accounts.get(accountNumber).getBalance());
   }
   
   void  deposit(int accountNumber) {
	 
	 System.out.print("Enter Pin Number : ");
	 String pin=scanner.next();
	 while(!DashBoard.accounts.get(accountNumber).getPin().equals(pin)) {
		 System.out.println("Pin Number Incorrect : ");
		pin=scanner.next(); 	 
	 }
	 if(DashBoard.accounts.get(accountNumber).getPin().equals(pin)) {
	 System.out.print("Enter Amount     : ");
	 double amount=scanner.nextDouble();
	 double balance=DashBoard.accounts.get(accountNumber).getBalance();
	 
	 DashBoard.accounts.get(accountNumber).setBalance(balance+amount);
	 String from=(DashBoard.accounts.get(accountNumber).getName());
	 String to ="No";
	 String status="Deposit";
	 
	 
	 AccountTransfer transaction=new AccountTransfer(from,to,amount,status);
	 DashBoard.transactionHistory.get(accountNumber).add(transaction);
	 
	 System.out.println("Current Balance is  : "+DashBoard.accounts.get(accountNumber).getBalance());
	 }
	 
	 
   }
   
   
   void amountWithdrawal(int accountNumber) {
	   System.out.print("Enter Pin Number  :");
	   String pin=scanner.next();
	   while(!DashBoard.accounts.get(accountNumber).getPin().equals(pin)) {
		   System.out.println("Pin Number Incorrect : ");
		   pin=scanner.next();
		   
	   }
	   if(DashBoard.accounts.get(accountNumber).getPin().equals(pin)) {
		   System.out.print("Enter Amount  : ");
		   double amount=scanner.nextDouble();
		   double balance=DashBoard.accounts.get(accountNumber).getBalance();
		   double remainder=balance-amount;
		   if(remainder>=0.0) {
			   
			   DashBoard.accounts.get(accountNumber).setBalance(remainder);
			   String from=DashBoard.accounts.get(accountNumber).getName();
			   String to="NO";
			   String status="WithDrawal";
			   AccountTransfer transaction=new AccountTransfer(from,to,amount,status);
			   DashBoard.transactionHistory.get(accountNumber).add(transaction);
		   }
		   else {
			   System.out.println("Amount not Sufficient     !");
		   }
	   }
   }
   
   void amountTransfer(int accountNumber) {
	   System.out.print("Enter Your Account Number  : ");
	   int acNumber=scanner.nextInt();
	   while(acNumber!=accountNumber) {
		   System.out.print("Incorrrect Account Number  Enter valid Account Number : ");
		   acNumber=scanner.nextInt();
	   }
	   System.out.print("Enter Your Pin Number  :  ");
	   String pinNo=scanner.next();
	   while(!pinNo.equals(DashBoard.accounts.get(accountNumber).getPin())) {
		   System.out.print("Invalid PIN Number Enter Correct Pin Number\n");
		   System.out.print(" Enter Correct Pin Number : ");
		   pinNo=scanner.next();
	   }
	   System.out.println("To Ac Number  : ");
	   int toAcNumber=scanner.nextInt();
	   System.out.println("Enter Amount  : ");
	   double amount=scanner.nextDouble();
	   double balance=DashBoard.accounts.get(accountNumber).getBalance();
	   double remainder=balance-amount;
	   if(DashBoard.accounts.containsKey(toAcNumber)) {
	   if(remainder>=0.0) {
		   
		   DashBoard.accounts.get(accountNumber).setBalance(remainder);
		   String from=DashBoard.accounts.get(accountNumber).getName();
		   String to=DashBoard.accounts.get(toAcNumber).getName();
		   String status="Account Transaction";
		   AccountTransfer transaction=new AccountTransfer(from,to,amount,status);
		   DashBoard.transactionHistory.get(accountNumber).add(transaction);
		   DashBoard.transactionHistory.get(toAcNumber).add(transaction);
			 double oponentBalance=DashBoard.accounts.get(toAcNumber).getBalance();
			 DashBoard.accounts.get(toAcNumber).setBalance(oponentBalance+amount);
	   }
	   else {
		   System.out.println("Balance Not Suficient");
	   }
	   
		   
	   }
	   else {
		   System.out.println("User Not Fount   !");
	   }
   }
   
   void viewStatements(int accountNumber) {
	   System.out.println("<    All Statements   >\n");
	   if(!DashBoard.transactionHistory.get(accountNumber).isEmpty()) {
		   System.out.printf("%15s %15s %20s %34s %20s","From","To","Date Time","Transaction Amount","Status");
		   System.out.println();
		   
		   System.out.println();
	   for(AccountTransfer statement:DashBoard.transactionHistory.get(accountNumber)) {
		   System.out.printf("%20s|%18s|%20s|%20s|%20s",statement.getFrom(),statement.getTo(),statement.getDateTime(),statement.getAmount(),statement.getStatus());
		   System.out.println();
		  
	   }
	   }
	   else {
		   System.out.println("No Transaction   fount   !");
	   }
	   
	   
   }
   
}
