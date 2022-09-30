package banking;
import java.util.Date;
public class AccountTransfer {
private String from;
private String to;
Date date=new Date();
private String dateTime=date.toString();
private double amount;
private String status;

public AccountTransfer(String from,String to,double amount,String status){
	this.setFrom(from);
	this.setTo(to);
	this.setAmount(amount);
	this.setStatus(status);
}

public String getFrom() {
	return from;
}

public void setFrom(String from) {
	this.from = from;
}

public String getTo() {
	return to;
}

public void setTo(String to) {
	this.to = to;
}

public String getDateTime() {
	return dateTime;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
}


class Account{
	private String name;
	private String dob;
	private String mobileNumber;
	private String branch;
	private String branchId;
	private int accountNumber;
	static String state="TamilNadu";
	private String pin;
	private double balance;
	Account(String name,String dob, String mobileNo, String  branch, String branchId,int accountNo,String pin,double balance ){
		 this.name=name;
		 this.dob=dob;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
}