import static org.junit.Assert.*;
import java.lang.reflect.*;

import junit.framework.Assert;

import org.junit.Test;

public class Flight_Verifier
{
	@Test
	public void testConstructor_noDefault_test()
	{
		// Expecting NO constructor: public Flight()
		try
		{
			Constructor<?> c = Flight.class.getDeclaredConstructor();
			if(c.getModifiers() != 2) // Must be private if it exists. 
				Assert.fail("Default constructor should not be declared!");
		}
		catch (NoSuchMethodException e)
		{
			return;
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for non-existence of a constructor!");
		}
	}

	@Test
	public void testConstructor_String_String_int_int_int_test()
	{
		// Expecting constructor: public Flight(String arg0, String arg1, int arg2, int arg3, int arg4)
		try
		{
			Constructor<?> c = Flight.class.getDeclaredConstructor(java.lang.String.class, java.lang.String.class, int.class, int.class, int.class);
			if(c.getModifiers() != 1) // Must be "public"
				Assert.fail("Constructor is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required constructor is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required constructor!");
		}
	}


	@Test
	public void cancel_test()
	{
		// Expecting method: public void cancel()
		try
		{
			Method m = Flight.class.getDeclaredMethod("cancel");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getSourceAirport_test()
	{
		// Expecting method: public String getSourceAirport()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getSourceAirport");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getDestinationAirport_test()
	{
		// Expecting method: public String getDestinationAirport()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getDestinationAirport");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getTakeoffTime_test()
	{
		// Expecting method: public int getTakeoffTime()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getTakeoffTime");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getLandingTime_test()
	{
		// Expecting method: public int getLandingTime()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getLandingTime");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getBookedPassengers_test()
	{
		// Expecting method: public ArrayList getBookedPassengers()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getBookedPassengers");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getStandbyPassengers_test()
	{
		// Expecting method: public ArrayList getStandbyPassengers()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getStandbyPassengers");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void addStandbyPassenger_Passenger_test()
	{
		// Expecting method: public void addStandbyPassenger(Passenger arg0)
		try
		{
			Method m = Flight.class.getDeclaredMethod("addStandbyPassenger", Passenger.class);
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void removePassenger_Passenger_test()
	{
		// Expecting method: public void removePassenger(Passenger arg0)
		try
		{
			Method m = Flight.class.getDeclaredMethod("removePassenger", Passenger.class);
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void removeStandbyPassenger_Passenger_test()
	{
		// Expecting method: public void removeStandbyPassenger(Passenger arg0)
		try
		{
			Method m = Flight.class.getDeclaredMethod("removeStandbyPassenger", Passenger.class);
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void promotePassengers_test()
	{
		// Expecting method: public int promotePassengers()
		try
		{
			Method m = Flight.class.getDeclaredMethod("promotePassengers");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void getCapacity_test()
	{
		// Expecting method: public int getCapacity()
		try
		{
			Method m = Flight.class.getDeclaredMethod("getCapacity");
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}

	@Test
	public void addPassenger_Passenger_test()
	{
		// Expecting method: public boolean addPassenger(Passenger arg0)
		try
		{
			Method m = Flight.class.getDeclaredMethod("addPassenger", Passenger.class);
			if(m.getModifiers() != 1) // Must be "public"
				Assert.fail("Method is improperly declared!  Check your public/protected/private settings!");
		}
		catch (NoSuchMethodException e)
		{
			Assert.fail("Required method is missing!");
		}
		catch (SecurityException e)
		{
			Assert.fail("Somehow unable to test for a required method!");
		}
	}


	@Test
	public void all_fields_private_test()
	{
		for(Field f:Flight.class.getDeclaredFields())
		{
			// Must be "private" or a final variable.  Checks the corresponding bits, acts if both are empty.
			if((f.getModifiers() & Modifier.PRIVATE) == 0 && (f.getModifiers() & Modifier.FINAL) == 0) 
				Assert.fail("Field " + f + " is improperly declared!  Check your public/protected/private settings!");
		}
	}
}