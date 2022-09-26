package MailApplication;

import java.util.Map;

public class SendAndRecivedMail extends MailPage{
	static int messageId=1;
	void dashBoard(String id) {
		System.out.println("_____________________________________________________________________________________________");
		System.out.println(" 1 > Compose Mail\n 2 > Send Mails\n 3 > Inbox\n 4 > Delete Send Mail\n 5 > Delete Inbox Mail\n 6 > Log Out");
		int option=scanner.nextInt();
		switch(option) {
		case 1:composemail(id);
		break;
		case 3:inbox(id);
		break;
		case 2:sended(id);
		break;
		case 4:deleteSended(id);
		break;
		case 5:deleteInbox(id);
		}
		 
		if(option!=6) {
			dashBoard(id);
		}
		
	}
	
	
	String composemail(String userId) {
		
		System.out.println("From : "+userId);
		System.out.print("To : ");
		scanner.nextLine();
		 String to=scanner.nextLine();
		System.out.print("Subject : ");
		 String subject=scanner.nextLine();
		System.out.print("Compose email : ");
		 String mail=scanner.nextLine();
		 
		 Compose compose=new Compose(userId,to,subject,mail);
		 
		 String[] recivers=to.split(",");
		 
		 
		 sendMail.get(userId).put(messageId,compose);
		 
		    for(int i=0; i<recivers.length; i++) {
		    	if(recivedMail.containsKey(recivers[i])) {
		    	recivedMail.get(recivers[i]).put(messageId,compose);
		    	}
		    	else {
		    		System.out.println(recivers[i]+"   User Not Found  !");
		    	}
		    }
		    messageId++;
		 return "Mail is Sended";
	}
	
	void inbox(String user) {
		
		System.out.println("  INBOX  \n");
	  if(!recivedMail.get(user).isEmpty()) {
		for(Map.Entry<Integer,Compose> m:recivedMail.get(user).entrySet()) {
			System.out.println("> Message Id : "+m.getKey()+ "   From : "+m.getValue().from+"   To : "+m.getValue().to+"   Subject : "+m.getValue().subject+"   Subject : "+m.getValue().subject+"   Mail : "+m.getValue().mail);
			
		}
	  }
	  else {
		  System.out.println("No Mail  Found   !");
	  }
	  
	  
	}
	  
	
	void sended(String user) {
		System.out.println("    Send Mails  \n");
		 if(!sendMail.get(user).isEmpty()) {
				for(Map.Entry<Integer,Compose> m:sendMail.get(user).entrySet()) {
					System.out.println("> Message Id : "+m.getKey()+ "   From : "+m.getValue().from+"   To : "+m.getValue().to+"   Subject : "+m.getValue().subject+"   Subject : "+m.getValue().subject+"   Mail : "+m.getValue().mail);
					
				}
			  }
			  else {
				  System.out.println("No Mail  Found   !");
			  }
	}
	
	void deleteInbox(String user) {
		
		System.out.println("    Inbox Mail    \n");
		 if(!recivedMail.get(user).isEmpty()) {
				for(Map.Entry<Integer,Compose> m:recivedMail.get(user).entrySet()) {
					System.out.println("> Message Id : "+m.getKey()+ "   From : "+m.getValue().from+"   To : "+m.getValue().to+"   Subject : "+m.getValue().subject+"   Subject : "+m.getValue().subject+"   Mail : "+m.getValue().mail);
		
					
				}
				System.out.print("Enter Message Id :  ");
				int deleteId=scanner.nextInt();
				if(recivedMail.get(user).containsKey(deleteId)) {
					recivedMail.get(user).remove(deleteId);
					System.out.println("Mail Deleted    !");
				}
				else {
					System.out.println("Wrong Message Id   please Enter correct Id");
					 deleteInbox(user);
				}
			  }
			  else {
				  System.out.println("No Mail  Found   !");
				 
			  }
		 
		 
		 
	}
	
	void deleteSended(String user) {
		
		System.out.println("    Send Mails     ");
		 if(!sendMail.get(user).isEmpty()) {
				for(Map.Entry<Integer,Compose> m:sendMail.get(user).entrySet()) {
					System.out.println("> Message Id : "+m.getKey()+ "   From : "+m.getValue().from+"   To : "+m.getValue().to+"   Subject : "+m.getValue().subject+"   Subject : "+m.getValue().subject+"   Mail : "+m.getValue().mail);
					
				}
				
				System.out.print("Enter Message Id :  ");
				int deleteId=scanner.nextInt();
				if(sendMail.get(user).containsKey(deleteId)) {
					sendMail.get(user).remove(deleteId);
					
					System.out.println("Message Deleted  !");
				}
				else {
					System.out.println("Message Id Incorrect Please Enter Correct Message Id");
				}
			  }
			  else {
				  System.out.println("No Mail  Found   !");
			  }
	}
	
}


 