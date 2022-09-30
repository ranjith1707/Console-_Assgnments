package railway;


public class Booking extends TicketReservation{
	static int ticketNumber=1000;
	static int totalSeat=2;
	static int tatkalseat=10;
	String[] stations= {"Chennai","Selam","Madhurai","Thiruchendhur","Tirunelvali","Tenkasi","Sengottai","Thiruvanandhapuram"};
	String[] classesArr= {"Air-Conditioned Executive Chair Class (EC)", "Air-Conditioned First Class (1AC) "," Air-Conditioned Two-Tier Class (2AC)","Air-Conditioned Three-Tier Class (3AC)","First Class"+"AC Chair Class (CC)","Sleeper Class (SL)","Second Class (2S)", "Unreserved/General Class (2S)"};
	void ticketBooking(){
			
			int initialAmount= 230;
			
			
			System.out.print("Enter Your Name : ");
			String name=scanner.nextLine();
			System.out.print("Enter your Age : ");
			 String age=scanner.next(); 
			 System.out.print("Entre Your Mobile Number  :  ");
			 String mobileNumber=scanner.next();
			 System.out.println();
			 
			System.out.println("  >  Select Your Class  <\n");
				int i=1;
				for(String c:classesArr) {
					System.out.println(i+ " > "+c);
					i++;
				}
				
			System.out.print("select One: ");
			 int selection=scanner.nextInt();
			 String classes=classesArr[selection-1];
			System.out.println("Starting Point  :  ");
				i=1;
				for(String start:stations) {
					System.out.println(i+" > "+start);
				i++;
				}
				
			System.out.println("Select Starting point  : ");
				int selectStarting=scanner.nextInt();
				String startingpoint=stations[selectStarting-1]+" -  "+timeing[selectStarting-1];
			System.out.println("\n Ending Point\n");
				i=1;
				for(String end:stations) {
					System.out.println(i+" > "+end);
				i++;
				}
				
		System.out.println("Select End Point : ");
			int selectEnd=scanner.nextInt();
		String endingPoint=stations[selectEnd-1]+" -  "+timeing[selectEnd-1];
		
			while(endingPoint.equals(startingpoint)) {
				System.out.println("Choose Different Location  :  ");
			     selectEnd=scanner.nextInt();
			     endingPoint=stations[selectEnd-1];
			}
		//amount counter
			int difference=Math.abs(selectStarting-selectEnd);
			int amount=difference*initialAmount;
			int classAmount=100;
			int finalAmount=amount-(selection*10);
		
		 scanner.nextLine();
			System.out.println("Enter Travaling Date : ");
			
			String dateOfTravel=scanner.nextLine();
		System.out.println("\n  Please Pay  Amount : "+finalAmount);
			int payAmount=scanner.nextInt();
				while(!(payAmount>=finalAmount)) {
					System.out.println("Amount Not Suffucient");
					payAmount=scanner.nextInt();
					
				}
		if(payAmount>finalAmount) {
			System.out.println("Please Collect The remaining Blalance : "+(payAmount-finalAmount));
		}
		
		  String ticketNo=String.valueOf(ticketNumber);
		
		int coachNo=0;
		boolean available=true;
		int seatNo = 0;
		if(totalSeat>=1) {
			coachNo=(int) Math.ceil(Math.random()*10);
			 seatNo=totalSeat;
			totalSeat--;
			available=true;
		}
		else {
			System.out.println("Seats Are Not Available   !\n");
			System.out.println(">    Continue To Booking  Or Cancel Booking    <");
			System.out.println("1 > Continue\n 2 > Cancel");
			available=false;
			int option=scanner.nextInt();
			if(option>=2) {
				return;
			}
		}
		//booking;
		BookingDetails book=new BookingDetails(ticketNo,name,age,startingpoint,endingPoint,amount,classes,dateOfTravel,coachNo,mobileNumber,seatNo);
			if(available) {
				bookingList.put(ticketNo, book);
				System.out.println("Ticket Booked  !");
				System.out.println("Your Ticket Number is : "+ticketNo);
				ticketNumber++;
			}
			else {
				waitingList.add(book);
				System.out.println(" your Waiting List  !");
				System.out.println("Your Ticket Number is : "+ticketNo);
				ticketNumber++;
			}
	
	}
	
	String tatkalbooking() {
		System.out.println("   Tatkal Booking   ! \n");
		int i;
		int initialAmount= 230;
		System.out.print("Enter Your Name : ");
		String name=scanner.nextLine();
		System.out.print("Enter your Age : ");
		 String age=scanner.next(); 
		 System.out.print("Entre Your Mobile Number  :  ");
		 String mobileNumber=scanner.next();
		 System.out.println();
		 System.out.println("Starting Point  :  ");
			i=1;
			for(String start:stations) {
				System.out.println(i+" > "+start);
			i++;
			}
			
		System.out.println("Select Starting point  : ");
			int selectStarting=scanner.nextInt();
			String startingpoint=stations[selectStarting-1]+" -  "+timeing[selectStarting-1];
		System.out.println("\n Ending Point\n");
			i=1;
			for(String end:stations) {
				System.out.println(i+" > "+end);
			i++;
			}
			
	System.out.println("Select End Point : ");
		int selectEnd=scanner.nextInt();
	String endingPoint=stations[selectEnd-1]+" -  "+timeing[selectEnd-1];
	int difference=Math.abs(selectStarting-selectEnd);
	int amount=difference*initialAmount;
	int finalAmount=amount;

 scanner.nextLine();
	System.out.println("Enter Travaling Date : ");
	
	String dateOfTravel=scanner.nextLine();
System.out.println("\n  Please Pay  Amount : "+finalAmount);
	int payAmount=scanner.nextInt();
		while(!(payAmount>=finalAmount)) {
			System.out.println("Amount Not Suffucient");
			payAmount=scanner.nextInt();
			
		}
		String classes="Unreserved/General Class (2S)";
		int coachNo=(int) Math.ceil(Math.random()*10);
		String ticketNo=String.valueOf(ticketNumber);
		BookingDetails book=new BookingDetails(ticketNo,name,age,startingpoint,endingPoint,amount,classes,dateOfTravel,coachNo,mobileNumber,tatkalseat);
		if(tatkalseat>=1) {
			bookingList.put(ticketNo, book);
			System.out.println("Ticket Booked  !");
			System.out.println("Your Ticket Number is : "+ticketNo);
			ticketNumber++;
			tatkalseat--;
			return "Ticket Booked";
		}
		else {
			TicketReservation.tatkalenable=false;
			
		}
		return "Seat Full";
	
	}

	public void viewStatus() {
		System.out.println("Enter Your Ticket Number");
		String tickeNumber=scanner.next();
		if(bookingList.containsKey(tickeNumber)) {
			System.out.println("> Ticket Number : "+bookingList.get(tickeNumber).ticketNo);
			System.out.println("> Name          : "+bookingList.get(tickeNumber).name);
			System.out.println("> Age           : "+bookingList.get(tickeNumber).age);
			System.out.println("> From          : "+bookingList.get(tickeNumber).From);
			System.out.println("> To            : "+bookingList.get(tickeNumber).to);
			System.out.println("> Amount        : "+bookingList.get(tickeNumber).amount);
			System.out.println("> class         : "+bookingList.get(tickeNumber).classes);
			System.out.println("> Date          : "+bookingList.get(tickeNumber).dateofTravel);
			System.out.println("> Seat Number   : "+bookingList.get(tickeNumber).seatNo);
			System.out.println("> Mobile Number : "+bookingList.get(tickeNumber).mobileNo);
			System.out.println("> Coach No      : "+bookingList.get(tickeNumber).coachNo);
			
		}
		else
			System.out.println("You are Now Waiting Lits");
	}
}