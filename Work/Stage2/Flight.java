import java.util.*;

public class Flight
{
	private String src;
	private String dest;
	private int takeofftime;
	private int landingtime;
	private int capacity;
	private ArrayList<Passenger> bookedPassengers = new ArrayList<Passenger>();
	private ArrayList<Passenger> standbyPassengers = new ArrayList<Passenger>();
	
	public Flight(String src, String dest, int takeofftime, int landingtime, int capacity)
	{
		this.src = src;
		this.dest = dest;
		this.takeofftime = takeofftime;
		this.landingtime = landingtime;
		this.capacity = capacity;
		
		if(takeofftime >= landingtime)
		{
			throw new RuntimeException();
		}
	}
	
	public String getSourceAirport()
	{
		return src;
	}
	
	public String getDestinationAirport()
	{
		return dest;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public int getTakeoffTime()
	{
		return takeofftime;
	}
	
	public int getLandingTime()
	{
		return landingtime;
	}
	
	public ArrayList<Passenger> getBookedPassengers()
	{
		return bookedPassengers;
	}
	
	public ArrayList<Passenger> getStandbyPassengers()
	{
		return standbyPassengers;
	}
	
	public boolean addPassenger(Passenger p)
	{
		if(bookedPassengers.size() < capacity)
		{
			bookedPassengers.add(p);
			p.bookFlight(this);
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean addStandbyPassenger(Passenger p)
	{
		standbyPassengers.add(p);
		p.addStandbyFlight(this);
		return true;
	}
	
	public void removePassenger(Passenger p)
	{
		p.cancelFlight(this);
	}
	
	public void removeStandbyPassenger(Passenger p)
	{
		p.cancelFlight(this);
	}
	
	public void cancel()
	{
		for(int i = 0; i < bookedPassengers.size(); i++)
		{
			bookedPassengers.get(i).addAlert("Flight " + this + " removed.");
			bookedPassengers.get(i).cancelFlight(this);
		}
		
		for(int i = 0; i < standbyPassengers.size(); i++)
		{
			standbyPassengers.get(i).addAlert("Standby flight " + this + " removed");
			standbyPassengers.get(i).cancelFlight(this);
		}
	}
	
	public int promotePassengers()
	{
		int start = standbyPassengers.size();
		
		if(bookedPassengers.size() != capacity)
		{
			for(int i = 0; i < standbyPassengers.size(); i++)
			{
				bookedPassengers.add(standbyPassengers.get(i));
				
				standbyPassengers.get(i).addAlert("Flight " + this + " is now booked.");
				standbyPassengers.remove(i);
				
				if(bookedPassengers.size() == capacity)
				{
					break;
				}
			}
		}else if((capacity - bookedPassengers.size()) > standbyPassengers.size())
		{
			for(int i = 0; i < standbyPassengers.size(); i++)
			{
				standbyPassengers.get(i).addAlert("Flight " + this + " is now booked.");
				standbyPassengers.get(i).getStandbyFlights().remove(this);
				standbyPassengers.get(i).bookFlight(this);
				
				bookedPassengers.add(standbyPassengers.get(i));
				
				standbyPassengers.remove(i);
			}
		}
		
		int end = standbyPassengers.size();
		int upgraded = start - end;
		
		return upgraded;
	}
}