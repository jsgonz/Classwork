import java.util.*;
import java.io.*;

public class DataManager {

	public static void exportData(String filename, ArrayList<Passenger> passengers, ArrayList<Flight> flights){
		
		PrintStream outFile;
		
		try{
			
			outFile = new PrintStream(filename);
		}catch(FileNotFoundException e){
			
			System.err.println("Cannot create the file.");
			return;
		}
		
		outFile.println("#flightCount " + flights.size());
		
		for(int i = 0; i < flights.size(); i++){
			
			outFile.println("#newFlight");
			outFile.println(flights.get(i).getSourceAirport() + " , " + flights.get(i).getDestinationAirport() + " , " + flights.get(i).getTakeoffTime() + " , " + flights.get(i).getLandingTime());
			outFile.println(flights.get(i).getCapacity());
		}
		
		for(int i = 0; i < passengers.size(); i++){
			
			outFile.println("#newPass");
			outFile.println(passengers.get(i).getFirstName() + " , " + passengers.get(i).getLastName());
			outFile.println(passengers.get(i).getAlerts().size());
			
			for(int k = 0; k < passengers.get(i).getAlerts().size(); k++){
				
				outFile.println(passengers.get(k).getAlerts().get(k));
			}
			
			outFile.println(passengers.get(i).getBookedFlights().size());
			
			for(int k = 0; k < passengers.get(i).getBookedFlights().size(); k++){
				
				outFile.println(passengers.get(k).getBookedFlights().get(k).getSourceAirport() + " , "
						+ passengers.get(k).getBookedFlights().get(k).getDestinationAirport() + " , "
						+ passengers.get(k).getBookedFlights().get(k).getTakeoffTime() + " , "
						+ passengers.get(k).getBookedFlights().get(k).getLandingTime());
			}
			
			outFile.println(passengers.get(i).getStandbyFlights().size());
			
			for(int k = 0; k < passengers.get(i).getStandbyFlights().size(); k++){
				
				outFile.print(passengers.get(k).getStandbyFlights().get(k).getSourceAirport() + " , "
						+ passengers.get(k).getStandbyFlights().get(k).getDestinationAirport() + " , "
						+ passengers.get(k).getStandbyFlights().get(k).getTakeoffTime() + " , "
						+ passengers.get(k).getStandbyFlights().get(k).getLandingTime());
			}
		}
		
		outFile.close();
	}
	
	public static ImportData importData(String filename){
		
		
	}
}
