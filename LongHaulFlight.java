/*
 * A long haul flight is a flight that travels thousands of kilometers and typically has separate seating areas 
 */

public class LongHaulFlight extends Flight
{
	int numFirstClassPassengers;
	String seatType;
	
	// Possible seat types
	public static final String firstClass = "First Class Seat";
	public static final String economy 		= "Economy Seat";  
	

	public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		super(flightNum,airline,dest,departure,flightDuration,aircraft);
		numFirstClassPassengers =0;
		seatType = "";
		// use the super() call to initialize all inherited variables
		// also initialize the new instance variables 
	}

	public LongHaulFlight()
	{
     // default constructor
	}
//	@Override
//	public boolean seatsAvailable()
//	{
//		int currentSeatsTaken = numFirstClassPassengers;
//		int maxSeats = aircraft.getNumFirstClassSeats();
//
//		return (currentSeatsTaken < maxSeats);
//
//		// your code here
//
//	}



	/*
	 * Reserves a seat on a flight. Essentially just increases the number of (economy) passengers
	 */
	@Override
	public boolean reserveSeat()
	{
		// override the inherited reserveSeat method and call the reserveSeat method below with an economy seatType
		// use the constants defined at the top

		reserveSeat(economy);

		return true;
	}

	/*
	 * Reserves a seat on a flight. Essentially just increases the number of passengers, depending on seat type (economy or first class)
	 */
	public boolean reserveSeat(String seatType)
	{
		// if seat type is economy 
		//			call the superclass method reserveSeat() and return the result
		// else if the seat type is first class then 
		// 			check to see if there are more first class seats available (use the aircraft method to get the max first class seats
		// 			of this airplane
		//    	if there is a seat available, increment first class passenger count (see instance variable at the top of the class)
		//    	return true;
		// else return false
		
		// remove this once you have written your code


		if(seatType.equals(economy)){


			return super.reserveSeat();
		}else if(seatType.equals(firstClass)){
			if(numFirstClassPassengers < aircraft.getNumFirstClassSeats()){

				numFirstClassPassengers ++;
				return true;
			}else{

				return false;
			}
		}



		return false;
	}
	
	// Cancel a seat
	@Override
	public void cancelSeat()
	{
	  // override the inherited cancelSeat method and call the cancelSeat method below with an economy seatType
		// use the constants defined at the top
		cancelSeat(economy);
		
	}
	
	public void cancelSeat(String seatType)
	{
		// if seat type is first class and first class passenger count is > 0
		//  decrement first class passengers
		// else
		// decrement inherited (economy) passenger count

		if(seatType == firstClass &&  numFirstClassPassengers > 0){
			numFirstClassPassengers = numFirstClassPassengers -1;
		}else{
			super.passengers --;
		}


		
	}
	// return the total passenger count of economy passengers *and* first class passengers
	// use instance variable at top and inherited method that returns economy passenger count
	public int getPassengerCount()
	{
		return numFirstClassPassengers + getPassengers();
	}

	@Override
	public String toString()
	{
		return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status + "\t LongHaul";

	}

	public String toStringFC()
	{
		return airline +" FCL" + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status + "\t LongHaul";

	}
}
