package banking;
import java.util.Date;
public class AccountTransfer {
String from;
String to;
Date date=new Date();
String dateTime=date.toString();
double amount;
String status;

public AccountTransfer(String from,String to,double amount,String status){
	this.from=from;
	this.to=to;
	this.amount=amount;
	this.status=status;
}
}


class Account{
	String name;
	String dob;
	String mobileNumber;
	String branch;
	String branchId;
	private int accountNumber;
	static String state="TamilNadu";
	private String pin;
	private double balance;
	Account(String name,String dob, String mobileNo, String  branch, String branchId,int accountNo,String pin,double balance ){
		 this.name=name;
		 this. dob=dob;
	     this.mobileNumber=mobileNo;
		 this.branch=branch;
		 this.branchId=branchId;
		 this.accountNumber=accountNo;
		 this.pin=pin;
		 this.balance=balance;
	}
	int getAccountNumber() {
		return accountNumber;
	}
	String getPin() {
		return pin;
	}
	void setPin(String pin) {
		this.pin=pin;
	}
	void setMobileNo(String mobile) {
		this.mobileNumber=mobile;
	}
	double getBalance() {
		return balance;
	}
	void setBalance(double balance){
		this.balance=balance;
	}
}