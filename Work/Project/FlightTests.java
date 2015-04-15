import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class FlightTests 
{	
	/*
	 * Note the timeout mentioned on each of these tests.  This timeout will be enforced in the Autograded version
	 * as well, and is clearly too small to allow console input within the objects.  This is very intentional.
	 * (For clarification, "100" = 100 ms.)
	 */
	
	@Test(timeout = 100)
	public void constructorAndGetterTest() 
	{
		Flight f = new Flight("MCO", "MIA", 800, 930, 8);
		
		assertEquals("MCO", f.getSourceAirport());
		assertEquals("MIA", f.getDestinationAirport());
		assertEquals(800, f.getTakeoffTime());
		assertEquals(930, f.getLandingTime());
		assertEquals(8, f.getCapacity());
	}

	@Test(timeout = 100)
	public void singlePassengerAddTest()
	{
		Passenger p = new Passenger("Joshua", "Horton");
		Flight f = new Flight("MCO", "MIA", 800, 930, 8);
		
		assertEquals("Passenger should have been successfully booked; was not.", true, f.addPassenger(p));
		
		ArrayList<Passenger> pList = f.getBookedPassengers();
		
		if(pList.size() != 1)
		{
			fail("No one is booked on the flight, despite a passenger booking it!");
		}
		
		if(p != pList.get(0))
		{
			fail("The passenger is not booked on the flight!  (Did you make a duplicate instead of adding the passenger itself?");
		}
	}
	
	//TODO:  PromotePassenger test?
	@Test//(timeout = 100)
	public void promotePassengerSuccessTest()
	{
		Passenger p = new Passenger("Joshua", "Horton");
		Flight f = new Flight("MCO", "MIA", 800, 930, 8);
		
		p.addStandbyFlight(f);
		assertEquals("An empty flight with capacity should allow a passenger to be promoted!", 1, f.promotePassengers());
		assertEquals("The 'promoted' passenger should have recieved an alert for confirmation on their now-guaranteed booking!", 1, p.getAlerts().size());
		
		ArrayList<Flight> fList = p.getBookedFlights();
		
		if(fList.size() != 1)
		{
			fail("The passenger supposedly booked a flight, but it doesn't show on the flight list!");
		}
		
		/* NOTE:  there will be additional tests here in the final (grading) version, analogous to those of
		 * PassengerTests.singlePassengerAddTest().  In fact, they'll be more extensive.
		 * 
		 * Keep in mind, there's making sure on the standby list details before promotion, as well as
		 * making sure on the booked list details after promotion.  The only tests I've included here are
		 * in regard to whether the promotion itself was possible or not.
		 */
		
	}
	
	//TODO:  PromotePassenger test?
	@Test(timeout = 100)
	public void promotePassengerFailureTest()
	{
		Passenger p1 = new Passenger("Joshua", "Horton");
		Passenger p2 = new Passenger("Clark", "Kent");
		Flight f = new Flight("MCO", "MIA", 800, 930, 1);
		
		p1.bookFlight(f);
		p2.addStandbyFlight(f);
		
		assertEquals("A full flight should not allow a passenger to be promoted!", 0, f.promotePassengers());
		
		/* NOTE:  there will be additional tests here in the final (grading) version, analogous to those of
		 * PassengerTests.singlePassengerAddTest().  In fact, they'll be more extensive.
		 * 
		 * Keep in mind, there's making sure on the standby list details before promotion, and ensuring the list
		 * is unchanged after the failed promotion attempt.  The only tests I've included here are
		 * in regard to whether the promotion itself was possible or not.
		 */
		
	}
	@Test(timeout = 100, expected = RuntimeException.class)
	public void nullPassengerTest()
	{
		Flight f = new Flight("MCO", "MIA", 800, 930, 1);
		
		f.addPassenger(null);
	}
}