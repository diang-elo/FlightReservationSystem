/*
 *  Class to model an airline flight. In this simple system, all flights originate from Toronto
 *  
 *  This class models a simple flight that has only economy seats
 */
public class Flight
{
	public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};

	String flightNum;
	String airline;
	String origin, dest;
	String departureTime;
	Status status; // see enum Status above. google this to see how to use it
	int flightDuration;
	Aircraft aircraft;
	protected int passengers; // count of (economy) passengers on this flight - initially 0
  
	public Flight()
	{
		this.flightNum = "";
		this.airline = "";
		this.origin = "Toronto";
		this.dest = "";
		this.departureTime = "";
		this.flightDuration = 0;
		this.passengers = 0;

		// write code to initialize instance variables to default values
	}
	
	public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		this.flightNum = flightNum;
		this.airline = airline;
		this.dest = dest;
		this.origin = "Toronto";
		this.departureTime = departure;
		this.flightDuration = flightDuration;
		this.aircraft = aircraft;
		passengers = 0;
		status = Status.ONTIME;
		
	}
	public String getFlightNum()
	{
		return flightNum;
	}
	public void setFlightNum(String flightNum)
	{
		this.flightNum = flightNum;
	}
	public String getAirline()
	{
		return airline;
	}
	public void setAirline(String airline)
	{
		this.airline = airline;
	}
	public String getOrigin()
	{
		return origin;
	}
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
	public String getDest()
	{
		return dest;
	}
	public void setDest(String dest)
	{
		this.dest = dest;
	}
	public String getDepartureTime()
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}
	
	public Status getStatus()
	{
		return status;
	}
	public void setStatus(Status status)
	{
		this.status = status;
	}
	public int getFlightDuration()
	{
		return flightDuration;
	}
	public void setFlightDuration(int dur)
	{
		this.flightDuration = dur;
	}
	
	public int getPassengers()
	{
		return passengers;
	}
	public void setPassengers(int passengers)
	{
		this.passengers = passengers;
	}

	public int getMaxSeatss(){return aircraft.getNumSeats();}
	// Check to see if there is room on this flight - compare current passenger count
	// with aircraft max capacity of economy seats

	/***
	 * Checks if the current amount of econ passengers are less than the max amount of seats
	 * @return	True if passangers < max seats. Else false
	 */
	public boolean seatsAvailable()
	{

		int currentSeatsTaken = passengers;
		int maxSeats = aircraft.getNumSeats();

		return (currentSeatsTaken < maxSeats);

		// your code here

	}
	
	/*
	 * Cancel a seat - essentially reduce the passenger count by 1. Make sure the count does not
	 * fall below 0 (see instance variable passenger)
	 */

	/***
	 * reduces the number of passengers by one if passengers > 0
	 */
	public void cancelSeat()
	{
		// your code here
		if(passengers > 0){
			passengers --;
		}
	}
	
	/*
	 * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
	 * economy passengers on the aircraft used for this flight (see instance variables above)
	 */

	/***
	 * If seats are available, increase passengers by one and return true
	 * else return false
	 * @return
	 */
	public boolean reserveSeat()
	{

		if(seatsAvailable()){

			passengers ++;
			return true;
		}else{
			return false;
		}
		// your code here

	}

	/***
	 *
	 * @return airline, flightnum, dest, departureTime, flightDuration, status
	 * to string
	 */
	public String toString()
	{
		 return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status;
		
	}

  
}
