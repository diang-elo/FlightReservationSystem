import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class FlightManager
{
  // Contains list of Flights departing from Toronto in a single day
	ArrayList<Flight> flights = new ArrayList<Flight>();
  
  String[] cities = 	{"Dallas", "New York", "London", "Paris", "Tokyo"};
  final int DALLAS = 0;  final int NEWYORK = 1;  final int LONDON = 2;  final int PARIS = 3; final int TOKYO = 4;
  
  // flight times in hours
  int[] flightTimes = { 3, // Dallas
  											1, // New York
  											7, // London
  											8, // Paris
  											16// Tokyo
  										};
  
  // Contains list of available airplane types and their seat capacity
  ArrayList<Aircraft> airplanes = new ArrayList<Aircraft>();  
  
  String errorMsg = null; // if a method finds an error (e.g. flight number not found) set this string. See video!
  
//  Random random = new Random(); // random number generator - google "Java class Random". Use this in generateFlightNumber
  
  
  public FlightManager()
  {
  	// DO NOT ALTER THIS CODE - THE TA'S WILL USE IT TO TEST YOUR PROGRAM
  	// IN ASSIGNMENT 2 YOU WILL BE LOADING THIS INFORMATION FROM A FILE
  
  	// Create some aircraft types with max seat capacities
  	airplanes.add(new Aircraft(4, "Boeing 737"));
  	airplanes.add(new Aircraft(4,"Airbus 320"));
  	airplanes.add(new Aircraft(4, "Dash-8 100"));
  	airplanes.add(new Aircraft(4, "Bombardier 5000"));
  	airplanes.add(new Aircraft(4, 2, "Boeing 747"));
  	
  	// Populate the list of flights with some random test flights
  	String flightNum = generateFlightNumber("United Airlines");
  	Flight flight = new Flight(flightNum, "United Airlines", "Dallas", "1400", flightTimes[DALLAS], airplanes.get(0));
  	flights.add(flight);
  	flight.setStatus(Flight.Status.DELAYED);
  	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "London", "2300", flightTimes[LONDON], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "Paris", "2200", flightTimes[PARIS], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Porter Airlines");
   	flight = new Flight(flightNum, "Porter Airlines", "New York", "1200", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "New York", "0900", flightTimes[NEWYORK], airplanes.get(3));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "New York", "0600", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "Paris", "2330", flightTimes[PARIS], airplanes.get(0));
   	flights.add(flight);
   	
    /*
     * Add this code back in when you are ready to tackle class LongHaulFlight and have implemented its methods
     */
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new LongHaulFlight(flightNum, "Air Canada", "Tokyo", "2200", flightTimes[TOKYO], airplanes.get(4));
   	flights.add(flight);
  }
  
  /*
   * This private helper method generates and returns a flight number string from the airline name parameter
   * For example, if parameter string airline is "Air Canada" the flight number should be "ACxxx" where xxx is 
   * a random 3 digit number between 101 and 300 (Hint: use class Random - see variable random at top of class)
   * you can assume every airline name is always 2 words. 
   * 
   */

    /***
     * Get the first two letters of airline name and add random number from 101-300 to the end
     * @param airline --> inputed airline name
     * @return return first two letters + random number
     */
  private String generateFlightNumber(String airline)
  {
      Scanner scan = new Scanner(airline); //scanner for airline

      String complete = "";

      while(scan.hasNext()){

          String x = scan.next();
          char letter = x.charAt(0);
          complete += letter;
      }
      int randNum = getRandomNumberUsingNextInt(101,301); // calls get random number to generate a num btw 101 and 300
      complete += randNum; // add random number to end of complete

  	return complete; // delete this when you finish the code
  }

    /***
     * Prints all flights in flights array list
     */
  public void printAllFlights()
  {
  	for (int i = 0; i < flights.size(); i++)
  	{
  		System.out.println(flights.get(i).toString());
  	}
  }
  
  // Given a flight number (e.g. "UA220"), check to see if there are economy seats available
  // if so return true, if not return false

    /***
     *
     * @param flightNum --> flight num
     * @return true if seat available, else false
     */
  public boolean seatsAvailable(String flightNum)
  {
    // First check for a valid flight number
    // if it is not found, set errorMsg String and return false
    // To determine if the given flightNum is valid, search the flights array list and find 
    // the  Flight object with matching flightNum string
    // Once a Flight object is found, check if seats are available (see class Flight) 
    // if flight is full, set errorMsg to an appropriate message (see video) and return false
    // otherwise return true
      for (int i = 0; i < flights.size(); i++){



          if(flights.get(i).getFlightNum().equals(flightNum)){

              if(flights.get(i).seatsAvailable()){
                  return true;
              }else{
                  errorMsg =("Flight " + flightNum + " Full");
                  return false;
              }
          }
      }

    return false;
  }
  
  
  // Given a flight number string flightNum and a seat type, reserve a seat on a flight
  // If successful, return a Reservation object
  // NOTE: seat types are not used for basic Flight objects (seats are all "Economy Seats")
  // class LongHaulFlight defines two seat types
  // I  suggest you first write this method *without* considering class LongHaulFlight 
  // once that works (test it!!), add the long haul flight code , String seatType

    /***
     *
     * @param flightNum --> flight num
     * @param seatType --> seat type (econ or private)
     * @return return reservation if flight available and flight equals flight num
     */
  public Reservation reserveSeatOnFlight(String flightNum, String seatType)
  {
  	// Check for valid flight number by searching through flights array list
  	// If matching flight is not found, set instance variable errorMsg (see at top) and return null
      boolean found = false;

      //loop through flights
      for (int i = 0; i < flights.size(); i++){

            // check to see if current flight num is equal to flightnum param
          if(flights.get(i).getFlightNum().equals(flightNum)){

              // if statement for longhaul flight --> checks if param seatType is first class and flight is instance of longHaulFlight
          if(seatType.equals(LongHaulFlight.firstClass) && flights.get(i) instanceof LongHaulFlight){
//              boolean space = flights.get(i).seatsAvailable();

              //if seat available make first class res
              if(((LongHaulFlight) flights.get(i)).reserveSeat(seatType)){
                  Reservation fRes = new Reservation(flightNum, ((LongHaulFlight) flights.get(i)).toStringFC());
                  fRes.setFirstClass(); //set res to first class
                  return fRes;
              }else{

                  errorMsg = "Fist class full";
                  return null;
              }
          }
          // reserve seat for econ
          else {
//              Flight x = flights.get(i);
              found = true;

              // if seat availible create new res
              if(flights.get(i).seatsAvailable()){
                  Reservation res = new Reservation(flightNum, flights.get(i).toString());
                  flights.get(i).reserveSeat();
                  return res;
              }else{
                  errorMsg =("Flight full");
                  return null;
              }
          }}
          }
      if (found == false){
          errorMsg =("Flight not found");

          return null;
      }

  	// If flight found
  	//    
  	//		****beginning of long haul flight code - you may want to skip initially
  	//		check if seat type is first class and check if this is a long haul flight (Hint: use instanceof operator)
  	//    if above is true
  	//			call reserveSeat method in class LongHaulFlight
  	//			if long haul flight first class is not full
  	//				create Reservation object, set firstClass boolean variable to true in Reservation object
  	//				return reference to Reservation object
  	//			else long haul first class is full
  	//				set errorMsg and return null
  	//		***end of long haul flight code
  	//
  	//		else must be economy seat 
  	//			reserve seat on flight (see class Flight reserveSeat() and overridden reserveSeat() in class LongHaulFlight)
  	//      if flight not full
  	//				create Reservation object and return reference to Reservation object 
  	//			else set ErrorMesg (flight full) and return null
  	
  	return null; // remove when finished code above
  }

    /***
     *
     * @return errorMsg (contains an error message)
     */
  public String getErrorMessage()
  {

  	return errorMsg;
  }
  
  /*
   * Given a Reservation object, cancel the seat on the flight
   */

    /***
     * loops through flights  and checks if flight num(i) equals reservation number. Cancels first class
     * seats or econ seats if there. Else error message == flight not found
     * @param res --> given reservation
     * @return true if flight found else flase
     */
  public boolean cancelReservation(Reservation res)
  {
  	// Get the flight number string from res
  	// Search flights to find the Flight object - if not found, set errorMsg variable and return false
  	// if found, cancel the seat on the flight (see class Flight)

      String resNumber = res.getFlightNum();
      boolean found = false;
      for (int i = 0; i < flights.size(); i++){

          if(flights.get(i).getFlightNum().equals(resNumber)){

              if(res.isFirstClass() == true &&  flights.get(i) instanceof LongHaulFlight){
//                  System.out.println("I made it instade");
//                  System.out.println(((LongHaulFlight) flights.get(i)).numFirstClassPassengers);
                  ((LongHaulFlight)flights.get(i)).cancelSeat(LongHaulFlight.firstClass);
//                  System.out.println(((LongHaulFlight) flights.get(i)).numFirstClassPassengers);
                  return true;
              }else {

                  flights.get(i).cancelSeat();

                  found = true;
                  return true;
              }
          }

      }
      if(found = false){
          errorMsg = "Flight not found";
          return false;
      }
  	// Once you have the above basic functionality working, try to get it working for canceling a first class reservation
  	// If this is a first class reservation (see class Reservation) and the flight is a LongHaulFlight (Hint use instanceof)
  	// then cancel the first class seat on the LongHaulFlight (Hint: you will need to cast)   
  	
    return false; // remove this when you have written the code above
  }
  
  // Sort the array list of flights by increasing departure time
  public void sortByDeparture()
  {
      Collections.sort(flights,new DepartureTimeComparator());
  }


  // compare two Flight objects by departure time
  private class DepartureTimeComparator implements Comparator <Flight>
  {
      @Override
      public int compare(Flight a, Flight b) {
          int flight1 = Integer.parseInt(a.getDepartureTime());
          int flight2 = Integer.parseInt(b.getDepartureTime());
          if(flight1 > flight2) return 1;
          if(flight1 < flight2) return -1;

          return 0;
      }
  }

  //Sort the array list of flights by increasing flight duration
  public void sortByDuration()
  {
      Collections.sort(flights,new DurationComparator());
  }

 // T compare two Flight objects by duration
  private class DurationComparator implements Comparator <Flight>
  {

      @Override
      public int compare(Flight a, Flight b) {

          int dur1 = a.getFlightDuration();
          int dur2 = b.getFlightDuration();
          if(dur1 > dur2) return 1;
          if(dur1 < dur2) return -1;
          return 0;
      }
  }
  // Prints all aircraft in airplanes array list.
  public void printAllAircraft()
  {
  	for (int i = 0; i < airplanes.size(); i++){
  	    Aircraft x = airplanes.get(i);
  	    x.print();
    }
  }
  
  // Sort the array list of Aircraft objects
  public void sortAircraft()
  {
  	Collections.sort(airplanes);
  }
    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
