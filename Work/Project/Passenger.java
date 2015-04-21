import java.util.*;

public class Passenger {

	private String first, last;
	private ArrayList<String> alerts;
	private ArrayList<Flight> bFlight;
	private ArrayList<Flight> sFlight;
	
	/* This is the only data you need to initially represent the passenger. 
	 * The other data elements (the lists) can be represented by empty, 
	 * default-initialized ArrayLists.
	 */
	public Passenger(String first, String last){
		
		if(first == null || last == null){
			
			throw new RuntimeException();
		}
		
		this.first = first;
		this.last = last;
		
		alerts = new ArrayList<String>();
		bFlight = new ArrayList<Flight>();
		sFlight = new ArrayList<Flight>();
	}
	
	//returns first name
	public String getFirstName(){
		
		return first;
	}
	
	//returns last name
	public String getLastName(){
		
		return last;
	}
	
	//returns the alerts
	public ArrayList<String> getAlerts(){
		
		return new ArrayList<String>(alerts);
	}
	
	//returns the booked flights
	public ArrayList<Flight> getBookedFlights(){
		
		return new ArrayList<Flight>(bFlight);
	}
	
	//returns the standby flights
	public ArrayList<Flight> getStandbyFlights(){
		
		return new ArrayList<Flight>(sFlight);
	}
	
	/*Adds Flight f to the Passenger's booked flight itinerary.
	 * Adds the Passenger to the Flight's passenger list.
	 * Returns true if the flight was successfully booked.
	 * Returns false if the flight was full and could not be booked.
	 * --Any modifications should be cancelled if this occurs
	 * */
	public boolean bookFlight(Flight f){
		
		if(bFlight.contains(f) || sFlight.contains(f)){
			
			throw new RuntimeException();
		}
		
		Flight existing = overlapsExistingFlight(f);
		
		if(existing != null){
			
			throw new RuntimeException("Added flight overlaps an existing flight!");
		}
		
		if(f.addPassenger(this)){
			
			bFlight.add(f);
			return true;
		}else{
			
			return false;
		}
	}
	
	/*Adds Flight f to the Passenger's standby flight list.
	 * Adds the Passenger to the Flight's standby list.
	 * Always succeeds
	 * */
	public void addStandbyFlight(Flight f){
		
		if(bFlight.contains(f) || sFlight.contains(f)){
			
			throw new RuntimeException();
		}
		
		Flight existing = overlapsExistingFlight(f);
		
		if(existing != null){
			
			throw new RuntimeException("Added flight overlpas an existing flight!");
		}
		
		sFlight.add(f);
		f.addStandbyPassenger(this);
	}
	
	/*A method used for an extra credit test
	 * */
	private Flight overlapsExistingFlight(Flight f){
		
		for(Flight bPassengers:bFlight){
		
			if(bPassengers.getTakeoffTime() < f.getTakeoffTime() && f.getTakeoffTime() < bPassengers.getLandingTime()){
				
				return bPassengers;
			}
			
			if(bPassengers.getTakeoffTime() < f.getLandingTime() && f.getLandingTime() < bPassengers.getLandingTime()){
			
				return bPassengers;
			}
		}
		
		for(Flight sPassengers:sFlight){
			
			if(sPassengers.getTakeoffTime() < f.getTakeoffTime() && f.getTakeoffTime() < sPassengers.getLandingTime()){
				
				return sPassengers;
			}
			
			if(sPassengers.getTakeoffTime() < f.getLandingTime() && f.getLandingTime() < sPassengers.getLandingTime()){
				
				return sPassengers;
			}
		}
		
		return null;
	}
	
	/*Adds the specified string to the Passenger's alert list
	 * */
	void addAlert(String s){
		
		alerts.add(s);
	}
	
	//Removes all alerts for the passenger
	public void clearAlerts(){
		
		alerts.clear();
	}
	
	/*Cancels the specified flight, regardless of whether it is on the "booked"
	 * itinerary or the "standby" list.
	 * This also removes the Passenger from Flight's passenger/standby list,
	 * whichever is relevant.
	 * */
	public void cancelFlight(Flight f){
	
		if(sFlight.contains(f)){
		
			sFlight.remove(f);
			f.removeStandbyPassenger(this);
		}else if(bFlight.contains(f)){
			
			bFlight.remove(f);
			f.removePassenger(this);
		}
	}
	
	/*Cancels every flight for which the passenger is booked or on standby, using
	 * the same rules as for canceling a single flight.
	 * */
	public void cancelAll(){
		
		for(Flight f:bFlight){
		
			cancelFlight(f);
		}
		
		for(Flight f:sFlight){
			
			cancelFlight(f);
		}
	}
}
