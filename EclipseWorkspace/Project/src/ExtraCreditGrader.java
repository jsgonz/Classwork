import static org.junit.Assert.*;

import org.junit.Test;


public class ExtraCreditGrader {

	@Test(timeout = 100, expected = RuntimeException.class)
	public void doubleBookingTest() 
	{
		Passenger p = new Passenger("Joshua", "Horton");
		Flight f = new Flight("MCO", "MIA", 800, 930, 8);
		
		p.bookFlight(f);
		p.bookFlight(f);
	}
	
	@Test(timeout = 100, expected = RuntimeException.class)
	public void crossBookingTest() 
	{
		Passenger p = new Passenger("Joshua", "Horton");
		Flight f = new Flight("MCO", "MIA", 800, 930, 8);
		
		p.bookFlight(f);
		p.addStandbyFlight(f);
	}
	
	@Test(timeout = 100, expected = RuntimeException.class)
	public void overlappingTimesTest() 
	{
		Passenger p = new Passenger("Joshua", "Horton");
		Flight f1 = new Flight("MCO", "MIA", 800, 930, 8);
		Flight f2 = new Flight("MIA", "BTR", 900, 1030, 8);
		
		p.bookFlight(f1);
		p.bookFlight(f2);
	}
	
	@Test(timeout = 100, expected = RuntimeException.class)
	public void sameAirportTest() 
	{
		@SuppressWarnings("unused")
		Flight f = new Flight("GNV", "GNV", 800, 930, 8);
	}
	
	@Test(timeout = 500)
	public void legalBaseFlightTimes1()
	{
		@SuppressWarnings("unused")
		Flight f;
		
		try
		{
			f = new Flight("MCO", "MIA", -200, 930, 8);
			
			fail("Flight's constructor doesn't ensure that the input times are possible times!");
		}
		catch(RuntimeException e) {}
		
		try
		{
			f = new Flight("MCO", "MIA", 200, 2930, 8);
			
			fail("Flight's constructor doesn't ensure that the input times are possible times!");
		}
		catch(RuntimeException e) {}
	}
	
	@Test(timeout = 500)
	public void legalBaseFlightTimes2()
	{
		@SuppressWarnings("unused")
		Flight f;
		
		try
		{
			f = new Flight("MCO", "MIA", 270, 980, 8);
			
			fail("Flight's constructor doesn't ensure that the input times are possible times!");
		}
		catch(RuntimeException e) {}
	}
	
	

	// TODO:  Needs an overlapping time period test.
}