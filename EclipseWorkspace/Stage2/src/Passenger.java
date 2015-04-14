import java.util.*;

public class Passenger
{
	private String first;
	private String last;
	private ArrayList<String> alerts;
	private ArrayList<Flight> bookedFlights;
	private ArrayList<Flight> standbyFlights;
	
	public Passenger(String first, String last)
	{
		this.first = first;
		this.last = last;
		alerts = new ArrayList<String>();
		bookedFlights = new ArrayList<Flight>();
		standbyFlights = new ArrayList<Flight>();
	}
	
	public String getFirstName()
	{
		return first;
	}
	
	public String getLastName()
	{
		return last;
	}
	
	public ArrayList<String> getAlerts()
	{
		return alerts;
	}
	
	public ArrayList<Flight> getBookedFlights()
	{
		return bookedFlights;
	}
	
	public ArrayList<Flight> getStandbyFlights()
	{
		return standbyFlights;
	}
	
	public boolean bookFlight(Flight f)
	{
		bookedFlights.add(f);
		
		if(f.addPassenger(this))
		{
			return true;
		}else
		{
			bookedFlights.remove(f);
			return false;
		}
	}
	
	public boolean addStandbyFlight(Flight f)
	{
		standbyFlights.add(f);
		f.addStandbyPassenger(this);
		return true;
	}
	
	void addAlert(String s)
	{
		alerts.add(s);
	}
	
	public void clearAlerts()
	{
		alerts.clear();
	}
	
	public void cancelFlight(Flight f)
	{
		if(bookedFlights.contains(f))
		{
			bookedFlights.remove(f);
			f.removePassenger(this);
		}else if(standbyFlights.contains(f))
		{
			standbyFlights.remove(f);
			f.removeStandbyPassenger(this);
		}
	}
	
	public void cancelAll()
	{
		for(int i = 0; i < bookedFlights.size(); i++)
		{
			bookedFlights.get(i).removePassenger(this);
			bookedFlights.get(i).removeStandbyPassenger(this);
		}
		
		for(int i = 0; i < standbyFlights.size(); i++)
		{
			standbyFlights.get(i).removePassenger(this);
			standbyFlights.get(i).removeStandbyPassenger(this);
		}
	}
}