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
		
		outFile.println("#passCount " + passengers.size());
		
		for(int i = 0; i < passengers.size(); i++){
			
			outFile.println("#newPass");
			outFile.println(passengers.get(i).getFirstName() + " , " + passengers.get(i).getLastName());
			outFile.println(passengers.get(i).getAlerts().size());
			
			for(int j = 0; j < passengers.get(i).getAlerts().size(); j++){
			
				outFile.println(passengers.get(i).getAlerts().get(j));
			}
			
			outFile.println(passengers.get(i).getBookedFlights().size());
			
			for(int j = 0; j < passengers.get(i).getBookedFlights().size(); j++){
				
				outFile.println(passengers.get(i).getBookedFlights().get(j).getSourceAirport() + " , " + 
								passengers.get(i).getBookedFlights().get(j).getDestinationAirport() + " , " + 
								passengers.get(i).getBookedFlights().get(j).getTakeoffTime() + " , " + 
								passengers.get(i).getBookedFlights().get(j).getLandingTime());
			}
			
			outFile.println(passengers.get(i).getStandbyFlights().size());
			
			for(int j = 0; j < passengers.get(i).getStandbyFlights().size(); j++){
			
				outFile.println(passengers.get(i).getStandbyFlights().get(j).getSourceAirport() + " , " + 
								passengers.get(i).getStandbyFlights().get(j).getDestinationAirport() + " , " + 
								passengers.get(i).getStandbyFlights().get(j).getTakeoffTime() + " , " + 
								passengers.get(i).getStandbyFlights().get(j).getLandingTime());
			}
		}
		
		outFile.close();
	}
	
	public static ImportData importData(String filename){
		
		Scanner scan = null;
		
		ArrayList<Flight> fli = new ArrayList<Flight>();
		ArrayList<Passenger> pass = new ArrayList<Passenger>();
		
		ImportData thing = new ImportData(pass, fli);
		
		try{
		
			scan = new Scanner(new File(filename));
		}catch(FileNotFoundException e){
		
			System.err.println("File does not exist!");
		}
		
		String src;
		String dest;
		int takeofftime;
		int landingtime;
		int capacity;
		
		String first;
		String last;
		
		String alert;
		
		String temp = scan.next();
		
		int count = scan.nextInt();
		
		for(int i = 0; i < count; i++){
			
			temp = scan.next();
			src = scan.next();
			
			temp = scan.next();
			dest = scan.next();
			
			temp = scan.next();
			takeofftime = scan.nextInt();
			
			temp = scan.next();
			landingtime = scan.nextInt();
			
			capacity = scan.nextInt();
			
			fli.add(new Flight(src, dest, takeofftime, landingtime, capacity));
		}
		
		temp = scan.next();
		
		count = scan.nextInt();
		int tempc = count;
		
		for(int i = 0; i < tempc; i++){
			temp = scan.next();
			
			first = scan.next();
			temp = scan.next();
			last = scan.next();
			
			pass.add(new Passenger(first, last));
			
			count = scan.nextInt();
			
			for(int j = 0; j < count; j++){
				
				scan.nextLine();
				alert = scan.nextLine();
				pass.get(i).addAlert(alert);
			}
			
			count = scan.nextInt();
			
			for(int j = 0; j < count; j++){
			
				src = scan.next();
				temp = scan.next();
				
				dest = scan.next();
				temp = scan.next();
				
				takeofftime = scan.nextInt();
				temp = scan.next();
				
				landingtime = scan.nextInt();
				
				for(int k = 0; k < fli.size(); k++){
					
					if(src.equals(fli.get(k).getSourceAirport()) && dest.equals(fli.get(k).getDestinationAirport()) && takeofftime == fli.get(k).getTakeoffTime() && landingtime == fli.get(k).getLandingTime()){
					
						pass.get(i).bookFlight(fli.get(k));
					}
				}	
			}
			
			count = scan.nextInt();
			
			for(int j = 0; j < count; j++){
				
				src = scan.next();
				temp = scan.next();
				
				dest = scan.next();
				temp = scan.next();
				
				takeofftime = scan.nextInt();
				temp = scan.next();
				
				landingtime = scan.nextInt();
				
				for(int k = 0; k < fli.size(); k++){
				
					if(src.equals(fli.get(k).getSourceAirport()) && dest.equals(fli.get(k).getDestinationAirport()) && takeofftime == fli.get(k).getTakeoffTime() && landingtime == fli.get(k).getLandingTime()){
					
						pass.get(i).addStandbyFlight(fli.get(k));
					}
				}	
			}
		}
		
		scan.close();
		
		return thing;
	}
}
