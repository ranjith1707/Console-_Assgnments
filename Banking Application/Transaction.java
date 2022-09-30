package banking;

public class Transaction extends DashBoard{
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
	   System.out.println("  Hi   "+ accounts.get(accountNumber).name+"\n");
	   System.out.println("Name           : "+accounts.get(accountNumber).name);
	   System.out.println("Account Number : "+accounts.get(accountNumber).getAccountNumber());
	   System.out.println("Age            : "+accounts.get(accountNumber).dob);
	   System.out.println("Mobile Number  : "+accounts.get(accountNumber).mobileNumber);
	   System.out.println("Branch Name    : "+accounts.get(accountNumber).branch);
	   System.out.println("Branch Id      : "+accounts.get(accountNumber).branchId);
	  
	   
   }
   
   void balanceEnquiry(int accountNumber) {
	   System.out.println("Name           : "+accounts.get(accountNumber).name);
	   System.out.println("Account Number : "+accounts.get(accountNumber).getAccountNumber());
	   
	  System.out.println("Balance         : "+accounts.get(accountNumber).getBalance());
   }
   
   void  deposit(int accountNumber) {
	 
	 System.out.print("Enter Pin Number : ");
	 String pin=scanner.next();
	 while(!accounts.get(accountNumber).getPin().equals(pin)) {
		 System.out.println("Pin Number Incorrect : ");
		pin=scanner.next(); 	 
	 }
	 if(accounts.get(accountNumber).getPin().equals(pin)) {
	 System.out.print("Enter Amount     : ");
	 double amount=scanner.nextDouble();
	 double balance=accounts.get(accountNumber).getBalance();
	 
	 accounts.get(accountNumber).setBalance(balance+amount);
	 String from=(accounts.get(accountNumber).name);
	 String to ="No";
	 String status="Deposit";
	 
	 
	 AccountTransfer transaction=new AccountTransfer(from,to,amount,status);
	 transactionHistory.get(accountNumber).add(transaction);
	 
	 System.out.println("Current Balance is  : "+accounts.get(accountNumber).getBalance());
	 }
	 
	 
   }
   
   
   void amountWithdrawal(int accountNumber) {
	   System.out.print("Enter Pin Number  :");
	   String pin=scanner.next();
	   while(!accounts.get(accountNumber).getPin().equals(pin)) {
		   System.out.println("Pin Number Incorrect : ");
		   pin=scanner.next();
		   
	   }
	   if(accounts.get(accountNumber).getPin().equals(pin)) {
		   System.out.print("Enter Amount  : ");
		   double amount=scanner.nextDouble();
		   double balance=accounts.get(accountNumber).getBalance();
		   double remainder=balance-amount;
		   if(remainder>=0.0) {
			   
			   accounts.get(accountNumber).setBalance(remainder);
			   String from=accounts.get(accountNumber).name;
			   String to="NO";
			   String status="WithDrawal";
			   AccountTransfer transaction=new AccountTransfer(from,to,amount,status);
				 transactionHistory.get(accountNumber).add(transaction);
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
	   while(!pinNo.equals(accounts.get(accountNumber).getPin())) {
		   System.out.print("Invalid PIN Number Enter Correct Pin Number\n");
		   System.out.print(" Enter Correct Pin Number : ");
		   pinNo=scanner.next();
	   }
	   System.out.println("To Ac Number  : ");
	   int toAcNumber=scanner.nextInt();
	   System.out.println("Enter Amount  : ");
	   double amount=scanner.nextDouble();
	   double balance=accounts.get(accountNumber).getBalance();
	   double remainder=balance-amount;
	   if(accounts.containsKey(toAcNumber)) {
	   if(remainder>=0.0) {
		   
		   accounts.get(accountNumber).setBalance(remainder);
		   String from=accounts.get(accountNumber).name;
		   String to=accounts.get(toAcNumber).name;
		   String status="Account Transaction";
		   AccountTransfer transaction=new AccountTransfer(from,to,amount,status);
			 transactionHistory.get(accountNumber).add(transaction);
			 transactionHistory.get(toAcNumber).add(transaction);
			 double oponentBalance=accounts.get(toAcNumber).getBalance();
			 accounts.get(toAcNumber).setBalance(oponentBalance+amount);
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
	   if(!transactionHistory.get(accountNumber).isEmpty()) {
		   System.out.printf("%15s %15s %20s %34s %20s","From","To","Date Time","Transaction Amount","Status");
		   System.out.println();
		   
		   System.out.println();
	   for(AccountTransfer statement:transactionHistory.get(accountNumber)) {
		   System.out.printf("%20s|%18s|%20s|%20s|%20s",statement.from,statement.to,statement.dateTime,statement.amount,statement.status);
		   System.out.println();
		  
	   }
	   }
	   else {
		   System.out.println("No Transaction   fount   !");
	   }
	   
	   
   }
   
}
