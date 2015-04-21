import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ImportBasicTest 
{	
	@Test
	public void testCompleteDataLoading() 
	{
		testInitialFlightLoading(); // If it fails that test, this one is an auto-fail.
		testInitialPassengerLoading(); // If it fails that test, this one is an auto-fail.
		testPassengerFlightCount(); // Ensures that we've loaded the right number of flights, not whether they're loaded correctly.

		// If we're here, we know that the basic information for Passengers and Flights is properly loaded.
		// But, are the flights loaded - and /properly/?  They should be linked.
		ImportData data = DataManager.importData("ProjStage3BasicFile.txt");

		for(Passenger p:data.passengers)
		{
			for(Flight f1:p.getBookedFlights())
			{
				boolean matched = false;
				
				for(Flight f2:data.flights)
				{
					if(isFlightEqual(f1, f2))
					{
						if(f1 != f2)
						{
							fail("Reference mismatch - a duplicate Flight definition has been detected.  The imported Flight reference doesn't match the reference booked by this Passenger, although the data matches.\n  Data: " + flightToString(f2) + " <=/=> " + passToString(p));
						}
						
						matched = true;
						break;
					}
				}
				
				if(!matched) fail("Passenger is booked on a Flight not found in ANY way within the imported list of Flights!");
			}
		}
	}
	
	@Test
	public void testPassengerFlightCount() 
	{
		/*
		 * WARNING - this test only checks whether the number of flights loaded is correct, NOT whether they CORRECTLY match.
		 * You can pass this method and still bomb the actual flight loading!
		 */
		
		ImportData data = DataManager.importData("ProjStage3BasicFile.txt");
		
		ArrayList<Passenger> truePassList = new ArrayList<Passenger>(2);
		
		Flight f1 = new Flight("MCO", "MIA", 800, 930, 8);
		Flight f2 = new Flight("MIA", "ATL", 1100, 1400, 23);
		Flight f3 = new Flight("ATL", "GNV", 1430, 1615, 15);
		
		truePassList.add(new Passenger("Joshua", "Horton"));
		truePassList.add(new Passenger("Adam", "Smith"));
		
		truePassList.get(0).bookFlight(f1);
		truePassList.get(0).bookFlight(f2);
		
		truePassList.get(1).bookFlight(f3);
		truePassList.get(1).addStandbyFlight(f1);
		truePassList.get(1).addStandbyFlight(f2);
		
		for(Passenger p1:truePassList)
		{
			boolean matchFound = false;
			
			for(Passenger p2:data.passengers)
			{
				if(isPassengerEqual(p1, p2))
				{
					if(p1.getBookedFlights().size() == p2.getBookedFlights().size())
					{
						matchFound = true;
					}
					else fail("Passenger loaded incorrect number of booked flights: " + passToString(p2));
					
					if(p1.getStandbyFlights().size() != p2.getStandbyFlights().size())
					{
						fail("Passenger loaded incorrect number of standby flights: " + passToString(p2));
					}
					
					break;
				}
			}
			
			if(!matchFound)
				fail("Import did not load an expected Passenger:  " + passToString(p1));
		}
	}
	
	@Test
	public void testPassengerAlertLoading() 
	{
		ImportData data = DataManager.importData("ProjStage3BasicFile.txt");
		
		ArrayList<Passenger> truePassList = new ArrayList<Passenger>(2);
		
		truePassList.add(new Passenger("Joshua", "Horton"));
		truePassList.get(0).addAlert("The 7:30 flight from BTR to GNV has been cancelled!");
		truePassList.add(new Passenger("Adam", "Smith"));
		
		for(Passenger p1:truePassList)
		{
			boolean matchFound = false;
			
			for(Passenger p2:data.passengers)
			{
				if(isPassengerEqual(p1, p2))
				{
					if(p1.getAlerts().equals(p2.getAlerts()))
					{
						matchFound = true;
					}
					else fail("Mismatch between expected and actual alert lists for a passenger: " + passToString(p2));
					break;
				}
			}
			
			if(!matchFound)
				fail("Import did not load an expected Passenger:  " + passToString(p1));
		}
	}
	
	@Test
	public void testInitialPassengerLoading() 
	{
		ImportData data = DataManager.importData("ProjStage3BasicFile.txt");
		
		ArrayList<Passenger> truePassList = new ArrayList<Passenger>(2);
		
		truePassList.add(new Passenger("Joshua", "Horton"));
		truePassList.add(new Passenger("Adam", "Smith"));
		
		for(Passenger p1:truePassList)
		{
			boolean matchFound = false;
			
			for(Passenger p2:data.passengers)
			{
				if(isPassengerEqual(p1, p2))
				{
					matchFound = true;
					break;
				}
			}
			
			if(!matchFound)
				fail("Import did not load an expected Passenger:  " + passToString(p1));
		}
	}
	
	@Test
	public void testInitialFlightLoading() 
	{
		ImportData data = DataManager.importData("ProjStage3BasicFile.txt");
		
		if(data.flights.size() != 3) fail("Error - improper count of flights loaded.");
		
		ArrayList<Flight> trueFlightList = new ArrayList<Flight>(3);
		
		trueFlightList.add(new Flight("MCO", "MIA", 800, 930, 8));
		trueFlightList.add(new Flight("MIA", "ATL", 1100, 1400, 23));
		trueFlightList.add(new Flight("ATL", "GNV", 1430, 1615, 15));
		
		for(Flight f1:trueFlightList)
		{
			boolean matchFound = false;
			
			for(Flight f2:data.flights)
			{
				if(isFlightEqual(f1, f2))
				{
					matchFound = true;
					break;
				}
			}
			
			if(!matchFound)
				fail("Import did not load an expected Flight:  " + flightToString(f1));
		}
	}
	
	public String passToString(Passenger p)
	{
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("Passenger(\"");
		strBuilder.append(p.getFirstName());
		strBuilder.append("\", \"");
		strBuilder.append(p.getLastName());
		strBuilder.append("\")");
		
		return strBuilder.toString();
	}
	
	public String flightToString(Flight f)
	{
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("Flight(\"");
		strBuilder.append(f.getSourceAirport());
		strBuilder.append("\", \"");
		strBuilder.append(f.getDestinationAirport());
		strBuilder.append("\", ");
		strBuilder.append(f.getTakeoffTime());
		strBuilder.append(", ");
		strBuilder.append(f.getLandingTime());
		strBuilder.append(", ");
		strBuilder.append(f.getCapacity());
		strBuilder.append(")");
		
		return strBuilder.toString();
	}
	
	public boolean isPassengerEqual(Passenger expected, Passenger actual)
	{
		if(!expected.getFirstName().equals(actual.getFirstName()))
		{
			return false;
		}
		
		if(!expected.getLastName().equals(actual.getLastName()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean isFlightEqual(Flight expected, Flight actual)
	{
		if(!expected.getSourceAirport().equals(actual.getSourceAirport()))
		{
			return false;
		}
		
		if(!expected.getDestinationAirport().equals(actual.getDestinationAirport()))
		{
			return false;
		}
		
		if(expected.getTakeoffTime() != actual.getTakeoffTime())
		{
			return false;
		}
		
		if(expected.getLandingTime() != actual.getLandingTime())
		{
			return false;
		}
		
		if(expected.getCapacity() != actual.getCapacity())
		{
			return false;
		}
		
		return true;
	}

}