package MailApplication;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class MailPage{
	Map<String,Account> mailAccounts=new HashMap<String,Account>();
	
	static HashMap<String,HashMap<Integer,Compose>> sendMail=new HashMap<String,HashMap<Integer,Compose>>();
	static HashMap<String,HashMap<Integer,Compose>> recivedMail=new HashMap<String,HashMap<Integer,Compose>>();
	Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		MailPage mail=new MailPage();
		mail.display();
	}
	
	void display()
	{
		System.out.println(" 1 > Create New Account\n 2 > LogIn\n 3 > Exit");
		int selection=scanner.nextInt();
		switch(selection) {
		case 1: System.out.println(createAccount());
		  break;
		case 2: logIn();
		break;
		case 3: System.out.println("Thank you");
		}
		if(selection!=3)
		 display();
	}
	
	
	String createAccount(){
		System.out.print("Enter Your Name  :  ");
		 String name=scanner.next();
		System.out.print("Create your ID  Without Space   :  ");
		 String mailId=scanner.next();
		 Pattern paten=Pattern.compile("[A-Z]");
		 Matcher matching=paten.matcher(mailId);
		 Pattern specialCheck=Pattern.compile("[@]{1}");
		 Matcher specialMatcher=specialCheck.matcher(mailId);
		 while(matching.find()||!specialMatcher.find()) {
			 if(!specialMatcher.find()) {
				 System.out.println("Use Special Character '@'  !");
				 
			 }
			 else {
			 	 System.out.println("user Id Must be LowerCase    !\n");
			 }			 
			 
			 System.out.print("Create your ID  Without Space   :  ");
			  mailId=scanner.next();
			  specialMatcher=specialCheck.matcher(mailId);
			  matching=paten.matcher(mailId);
		 }  
		  System.out.print("Create New Password  :   ");
		 String password=scanner.next();
		if(!mailAccounts.containsKey(mailId)) {
			Account account=new Account(name,mailId,password);
			 mailAccounts.put(mailId, account);
			HashMap<Integer, Compose> composeMail=new HashMap<Integer,Compose>();
			 sendMail.put(mailId,composeMail);
			HashMap<Integer,Compose> inboxMail=new HashMap<Integer,Compose>();
			 recivedMail.put(mailId, inboxMail);
		}
		else {
			return "User Id Alredy Excists use Different Use I  d";
		}
		return "Account Created";
	}
	
	void logIn() {
		SendAndRecivedMail process=new SendAndRecivedMail();
		System.out.print("Enter Your Mail Id");
		String id=scanner.next();
		System.out.print("Enter PassWord");
		String password=scanner.next();
		if(mailAccounts.containsKey(id)) {
			if(password.equals(mailAccounts.get(id).passcode)) {
				process.dashBoard(id);
			}
			else {
				System.out.println("PassWord Incorrect");
			}
		}
		else {
			System.out.println(" Incorrect User Id   !");
		}
	}
}


class Account{
	String name;
	String mailId;
	String passcode;
	public Account(String name, String id, String password) {
		this.name=name;
		this.mailId=id;
		this.passcode=password;
	}
}
class Compose{
	String from;
	String to;
	String subject;
	String mail;
	
	public Compose(String from,String to, String subject, String mail) {
		this.from=from;
		this.to=to; 
		this.subject=subject;
		this.mail=mail;
	}
}