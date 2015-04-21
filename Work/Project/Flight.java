import java.util.*;

public class Flight {

	private String src, dest;
	private int takeofftime, landingtime, capacity;
	private ArrayList<Passenger> bPassengers;
	private ArrayList<Passenger> sPassengers;
	
	/*Flight clearly requires a lot more up-front data for instantiation.
	 * Note: takeoffTime must come before landingTime. throw a RuntimeException otherwise.
	 * */
	public Flight(String src, String dest, int takeofftime, int landingtime, int capacity){
		
		if(src == null || dest == null){
			
			throw new RuntimeException();
		}
		
		if(takeofftime > landingtime){
		
			throw new RuntimeException();
		}
		
		if(takeofftime < 0){
			
			throw new RuntimeException();
		}
		
		if(landingtime > 2400){
		
			throw new RuntimeException();
		}
		
		if(takeofftime % 100 >= 60){
			
			throw new RuntimeException();
		}
		
		if(landingtime % 100 >= 60){
			
			throw new RuntimeException();
		}
		
		if(capacity < 0){
		
			throw new RuntimeException();
		}
		
		if(src.equals(dest)){
			
			throw new RuntimeException();
		}
		
		this.src = src;
		this.dest = dest;
		this.takeofftime = takeofftime;
		this.landingtime = landingtime;
		this.capacity = capacity;
		
		bPassengers = new ArrayList<Passenger>(capacity);
		sPassengers = new ArrayList<Passenger>();
	}
	
	//returns the source airport code
	public String getSourceAirport(){
		
		return src;
	}
	
	//returns the destination airport code
	public String getDestinationAirport(){
		
		return dest;
	}
	
	//returns the capacity
	public int getCapacity(){
	
		return capacity;
	}
	
	//returns the time of takeoff
	public int getTakeoffTime(){
		
		return takeofftime;
	}
	
	//returns the time of landing
	public int getLandingTime(){
		
		return landingtime;
	}
	
	//returns the passengers that are booked
	public ArrayList<Passenger> getBookedPassengers(){
		
		return new ArrayList<Passenger>(bPassengers);
	}
	
	//return the passengers that are on standby
	public ArrayList<Passenger> getStandbyPassengers(){
		
		return new ArrayList<Passenger>(sPassengers);
	}
	
	/*Adds the Passenger to the Flight's passenger list.
	 * Returns true if the Passenger was successfully added.
	 * Returns false if the flight was full and could not be booked.
	 * */
	public boolean addPassenger(Passenger p){
		
		if(p == null){
			
			throw new RuntimeException();
		}
		
		if(bPassengers.contains(p)){
			
			throw new RuntimeException();
		}
		
		if(sPassengers.contains(p)){
			
			throw new RuntimeException();
		}
		
		if(bPassengers.size() < capacity){
			
			bPassengers.add(p);
			return true;
		}else{
		
			return false;
		}
	}
	
	/*Adds the Passenger to the Flight's standby list.
	 * Always succeeds.
	 * */
	public void addStandbyPassenger(Passenger p){
		
		if(p == null){
			
			throw new RuntimeException();
		}
		
		if(sPassengers.contains(p)){
			
			throw new RuntimeException();
		}
		
		if(bPassengers.contains(p)){
			
			throw new RuntimeException();
		}
		
		sPassengers.add(p);
	}
	
	/*Removes the Passenger from the Flight's passenger list.
	 * Does not generate an alert.
	 * */
	public void removePassenger(Passenger p){
		
		bPassengers.remove(p);
	}
	
	/*Removes the Passenger from the Flight's standby list.
	 * Does not generate an alert.
	 * */
	public void removeStandbyPassenger(Passenger p){
		
		sPassengers.remove(p);
	}
	
	/*Cancels the specified flight.
	 * All Passengers are removed from both internal lists.
	 * All Passengers receive an alert about the cancellation.
	 * */
	public void cancel(){
	
		while(bPassengers.size() > 0){
			
			Passenger p = bPassengers.get(0);
			p.addAlert("The " + takeofftime + " flight from " + src + " to " + dest + " has been cancelled.");
			p.cancelFlight(this);
		}
		
		while(sPassengers.size() > 0){
		
			Passenger p = sPassengers.get(0);
			p.addAlert("Your tentative (standby) " + takeofftime + " flight from " + src + " to " + dest + " has been cancelled.");
			p.cancelFlight(this);
		}
	}
	
	/*If the "booked" Passenger list is not full, Passengers should be removed
	 * from the "standby" list until the plane is full and added to the "booked" list.
	 * If there aren't enough Passengers on the "standby" list, all Passengers are
	 * "promoted."
	 * All Passenger data should be updated accordingly.
	 * --That is, their "standby" list and "itinerary" are also updated.
	 * Each Passenger "promoted" by this method call should receive an alert about
	 * their change in booking status.*/
	public int promotePassengers(){
		
		int emptySpace = capacity - bPassengers.size();
		
		if(emptySpace < 0){
			
			throw new IllegalStateException();
		}
		
		int count = 0;
		
		while(emptySpace > 0 && sPassengers.size() > 0){
			
			Passenger p = sPassengers.get(0);
			p.cancelFlight(this);
			p.bookFlight(this);
			
			p.addAlert("You now have guaranteed seating on the " + takeofftime + " flight from " + src + " to " + dest + ".");
			emptySpace--;
			count++;
		}
		
		return count;
	}	
}