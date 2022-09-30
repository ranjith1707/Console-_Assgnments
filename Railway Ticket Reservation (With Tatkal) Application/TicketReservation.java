package railway;
import java.util.*;
public class TicketReservation {
		Scanner scanner=new Scanner(System.in);
		String[] timeing= {"10.30","12.00","01.00","03.00","04.30","06.00","00.30","08.00"};
		static HashMap<String,BookingDetails> bookingList=new HashMap<String,BookingDetails>();
		static ArrayList<BookingDetails> waitingList=new ArrayList<BookingDetails>();
		static boolean tatkalenable=false;
		String adminLogin="adminlogin";
		String adminpassword="admin@123";

	public static void main(String[] args) {
			TicketReservation reservation=new TicketReservation();
			reservation.mainPage();
     }


	void mainPage() {
				System.out.println("<   Welcome to  Indian  Railway   >\n");
				System.out.println(" 1 > admin Login\n 2 > Ticket Booking\n 3 > Ticket Cancellation\n 4 > View Status\n 5 >  Tatkal Booking\n 6 > Exid");
				int option=scanner.nextInt();
				Booking booking=new Booking();
				Admin admin=new Admin();
				TicketCancellation cancel=new TicketCancellation();
				switch(option) {
				case 1:admin.adminCheckIn(adminLogin,adminpassword);
					break;
				case 2:booking.ticketBooking();
					break;
				case 3:System.out.println(cancel.ticketCancel());
				break;
				case 4:booking.viewStatus();
				break;
				case 5:System.out.println(tatkal());
				}
				if(option<=5) {
					mainPage();
				}
	}
	String tatkal() {
		Booking booking=new Booking();
		if(tatkalenable) {
			return (booking.tatkalbooking());
		}
		
			return "Tatkal Is  Closed :    !";
	}

	}
	
	
class BookingDetails{
		String ticketNo;
		String name;
		String age;
		String From;
		String to;
		int amount;
		String classes;
		Date date=new Date();
		String bookingTime= date.toString();
		String dateofTravel;
		int coachNo;
		String mobileNo;
		int seatNo;
		
	 BookingDetails(String ticketNo,String name,String age,String from,String to, int amount2, String classes,String date,int coachNo2,String mobilenumber,int seatno){
				this.ticketNo=ticketNo; 
				this.name=name;
				this. age=age;
				 this.From=from;
				 this.to=to;
				 this.amount=amount2;
				 this.classes=classes;
				 this.dateofTravel=date;
				this. coachNo=coachNo2;
				 this.mobileNo=mobilenumber;
				 this.seatNo=seatno;
	}
	
	
	void setSeat(int seatNo) {
		this.seatNo=seatNo;
	}
	void setCoach(int coach) {
		this.coachNo=coach;
	}
	
	
}
