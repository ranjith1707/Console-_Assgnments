package railway;
import java.util.Map.Entry;
import java.util.Scanner;
public class Admin {
Scanner scanner=new Scanner(System.in);
	void adminCheckIn(String id,String password) {
		System.out.print("Enter Admin Id  : ");
		String adminId=scanner.nextLine();
		if(id.equals(adminId)) {
			System.out.print("Enter Password : ");
			String adminPass=scanner.nextLine();
			  if(password.equals(adminPass)) {
				adminAccess();
				
			  }
		}
		
	}
	
	void adminAccess() {
		System.out.println(" 1 > List the Booking Details\n 2 > Counter Access\n 3 >Exit ");
		
		int option=scanner.nextInt();
		switch(option) {
		case 1: bookingDetails();
			break;
		case 2: counterAccess();
			break;
			
		}
		if(option<=2)
			adminAccess();
		
	}
	void bookingDetails(){
System.out.println("Total Booking : "+TicketReservation.bookingList.size());
System.out.println("Waiting List  : "+TicketReservation.waitingList.size());
	for(Entry<String, BookingDetails> m:TicketReservation.bookingList.entrySet()) {
		System.out.println("Ticket No : "+m.getKey()+"  name : "+ m.getValue().name);
	}
	}
	
	void counterAccess() {
		System.out.println(" 1 > Tatkal Ticket Counter Open \n 2 > Tatkal Ticket Counter Close");
		
		int option=scanner.nextInt();
		if(option==1) {
			TicketReservation.tatkalenable=true;
	}
		else {
			TicketReservation.tatkalenable=false;
		}
	}
	
}
