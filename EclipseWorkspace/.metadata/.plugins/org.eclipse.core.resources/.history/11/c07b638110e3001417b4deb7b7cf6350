import java.util.*;

public class Flight {

	private String src, dest;
	private int takeofftime, landingtime, capacity;
	private ArrayList<Passenger> bPassengers = new ArrayList<Passenger>();
	private ArrayList<Passenger> sPassengers = new ArrayList<Passenger>();
	
	/*Flight clearly requires a lot more up-front data for instantiation.
	 * Note: takeoffTime must come before landingTime. throw a RuntimeException otherwise.
	 * */
	public Flight(String src, String dest, int takeofftime, int landingtime, int capacity){
		
		if(src == null || dest == null){
			
			throw new RuntimeException();
		}else if(takeofftime >= landingtime){
			
			throw new RuntimeException();
		}
		
		this.src = src;
		this.dest = dest;
		this.takeofftime = takeofftime;
		this.landingtime = landingtime;
		this.capacity = capacity;
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
		
		return bPassengers;
	}
	
	//return the passengers that are on standby
	public ArrayList<Passenger> getStandbyPassengers(){
		
		return sPassengers;
	}
	
	/*Adds the Passenger to the Flight's passenger list.
	 * Returns true if the Passenger was successfully added.
	 * Returns false if the flight was full and could not be booked.
	 * */
	public boolean addPassenger(Passenger p){
		
		if(p == null){
			
			throw new RuntimeException();
		}
		
		bPassengers.add(p);

		if(bPassengers.contains(p)){
			
			return true;
		}else{
			
			return false;
		}
	}
	
	/*Adds the Passenger to the Flight's standby list.
	 * Always succeeds.
	 * */
	public boolean addStandbyPassenger(Passenger p){
		
		if(p == null){
			
			throw new RuntimeException();
		}
		
		sPassengers.add(p);
		return true;
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
		
		for(int i = 0; i < bPassengers.size(); i++){
			
			bPassengers.get(i).addAlert("Removed from flight: " + this);
			bPassengers.get(i).cancelFlight(this);
		}
		
		for(int i = 0; i < sPassengers.size(); i++){
			
			sPassengers.get(i).addAlert("Removed from stanby for flight: " + this);
			sPassengers.get(i).cancelFlight(this);
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

		int initial = sPassengers.size();
		
		if(bPassengers.size() != capacity){
			
			for(int i = 0; i < sPassengers.size(); i++){
				
				sPassengers.get(i).addAlert("Flight " + this + "changed from standby to booked");
				sPassengers.get(i).bookFlight(this);
				sPassengers.get(i).getStandbyFlights().remove(this);
				sPassengers.remove(i);
				
				if(bPassengers.size() == capacity){
					
					break;
				}
			}
		}else if((capacity - bPassengers.size()) >= sPassengers.size()){
			for(int j = 0; j < sPassengers.size(); j++){
				
				sPassengers.get(j).addAlert("Flight " + this + "changed from standby to booked");	
				sPassengers.get(j).bookFlight(this);
				sPassengers.get(j).getStandbyFlights().remove(this);
				sPassengers.remove(j);
			}
		}
		
		int end = sPassengers.size();
		
		return initial - end;
	}	
}