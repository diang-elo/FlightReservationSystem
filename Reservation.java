/*
 * A simple class to model an electronic airline flight reservation
 * 
 * This class has been done for you
 */
public class Reservation
{
	String flightNum;
	String flightInfo;
	boolean firstClass;
	
	
	public Reservation(String flightNum, String info)
	{
		this.flightNum = flightNum;
		this.flightInfo = info;
		this.firstClass = false;
	}
	
	public boolean isFirstClass()
	{
		return firstClass;
	} // return first class

	public void setFirstClass()
	{
		this.firstClass = true;
	} // set first class

	public String getFlightNum()
	{
		return flightNum;
	} // return flight num
	
	public String getFlightInfo()
	{
		return flightInfo;
	} // return flightinfo

	public void setFlightInfo(String flightInfo)
	{
		this.flightInfo = flightInfo;
	} //set flightinfo

	public void print()
	{
		System.out.println(flightInfo);//print flightinfo
	}
}
