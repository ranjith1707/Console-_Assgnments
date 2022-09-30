package railway;

public class TicketCancellation extends TicketReservation{
   
	String ticketCancel(){
		System.out.print("Eneter Your Ticket Number  : ");
		  String ticketNumberForCancel=scanner.next();
		System.out.print("Enter Your Mobile Number  : ");
		  String mobile=scanner.next();
		
		if(bookingList.containsKey(ticketNumberForCancel)) {
					if(bookingList.get(ticketNumberForCancel).mobileNo.equals(mobile)) {
						int cancelOtp=(int)Math.ceil(Math.random()*5000);
						System.out.println("Your Cancellation  OTP   : "+cancelOtp);
						System.out.println("\nEnter OTP : ");
						int otp=scanner.nextInt();
						int seat=0;
						int coach=0;
							if(otp==cancelOtp) {
									seat=bookingList.get(ticketNumberForCancel).seatNo;
									coach=bookingList.get(ticketNumberForCancel).coachNo;
									
										if(!waitingList.isEmpty()) {
											waitingList.get(0).setSeat(seat);
											waitingList.get(0).setCoach(coach);
											String ticketNo=waitingList.get(0).ticketNo;
											bookingList.put(ticketNo,waitingList.get(0));
											waitingList.remove(0);
										}
										
										bookingList.remove(ticketNumberForCancel);
								    	
									return ">  Your  Ticket SuccessFully  Canceled   !  ";
							}
			   }
				return "Mobile Number Incorrect  !  ";
		}
		return "  >   Wrong  Ticket Number  !";
	}
}
