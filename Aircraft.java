/*
 * 
 * This class models an aircraft type with a model name, a maximum number of economy seats, and a max number of forst class seats 
 * 
 * Add code such that class Aircraft implements the Comparable interface
 * Compare two Aircraft objects by first comparing the number of economy seats. If the number is equal, then compare the
 * number of first class seats 
 */
public class Aircraft implements Comparable <Aircraft>
{
  int numEconomySeats;
  int numFirstClassSeats;
  
  String model;
  
  public Aircraft(int seats, String model)
  {
  	this.numEconomySeats = seats;
  	this.numFirstClassSeats = 0;
  	this.model = model;
  }

  public Aircraft(int economy, int firstClass, String model)
  {
  	this.numEconomySeats = economy;
  	this.numFirstClassSeats = firstClass;
  	this.model = model;
  }
  
	public int getNumSeats()
	{
		return numEconomySeats;
	}
	
	public int getTotalSeats()
	{
		return numEconomySeats + numFirstClassSeats;
	}
	
	public int getNumFirstClassSeats()
	{
		return numFirstClassSeats;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}
	
	public void print()
	{
		System.out.println("Model: " + model + "\t Economy Seats: " + numEconomySeats + "\t First Class Seats: " + numFirstClassSeats);
	}

	/***
	 *
	 * @param other --> other aircraft
	 * @return
	 * compares two aircrafts to sort. If num of econ seats are the same, compare by first class seats
	 * else compare by econ seats.
	 */
	public int compareTo(Aircraft other)
	{
		int a = this.numEconomySeats; //number of econ seats
		int b = other.numEconomySeats; // number of econ seats of other
		boolean result = (a == b); // if num a == num b --> true, else false

		if (result == true){
			if(this.numFirstClassSeats > other.numFirstClassSeats) return 1; // if num first class > other first class return 1
			if(this.numFirstClassSeats < other.numFirstClassSeats) return -1; // if num first class < other first class return -1
		}else{
			if (this.numEconomySeats > other.numEconomySeats) return 1; //if num econ seats > other econ seats return 1
			if (this.numEconomySeats < other.numEconomySeats)return -1; //if num econ seats < other econ seats return -1
		}


		return 0;
	}

}
  
