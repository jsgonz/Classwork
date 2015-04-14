import static org.junit.Assert.*;
import java.lang.reflect.*;

import junit.framework.Assert;

import org.junit.Test;

public class Passenger_Verifier
{
	@Test
	public void testConstructor_noDefault_test()
	{
		// Expecting NO constructor: public Passenger()
		try
		{
			Constructor<?> c = Passenger.class.getDeclaredConstructor();
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
	public void testConstructor_String_String_test()
	{
		// Expecting constructor: public Passenger(String arg0, String arg1)
		try
		{
			Constructor<?> c = Passenger.class.getDeclaredConstructor(java.lang.String.class, java.lang.String.class);
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
	public void getFirstName_test()
	{
		// Expecting method: public String getFirstName()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("getFirstName");
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
	public void getLastName_test()
	{
		// Expecting method: public String getLastName()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("getLastName");
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
	public void getBookedFlights_test()
	{
		// Expecting method: public ArrayList getBookedFlights()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("getBookedFlights");
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
	public void getStandbyFlights_test()
	{
		// Expecting method: public ArrayList getStandbyFlights()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("getStandbyFlights");
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
	public void addStandbyFlight_Flight_test()
	{
		// Expecting method: public void addStandbyFlight(Flight arg0)
		try
		{
			Method m = Passenger.class.getDeclaredMethod("addStandbyFlight", Flight.class);
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
	public void getAlerts_test()
	{
		// Expecting method: public ArrayList getAlerts()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("getAlerts");
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
	public void bookFlight_Flight_test()
	{
		// Expecting method: public boolean bookFlight(Flight arg0)
		try
		{
			Method m = Passenger.class.getDeclaredMethod("bookFlight", Flight.class);
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
	public void addAlert_String_test()
	{
		// Expecting method:  void addAlert(String arg0)
		try
		{
			Method m = Passenger.class.getDeclaredMethod("addAlert", java.lang.String.class);
			if(m.getModifiers() != 0) // Must be ""
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
	public void clearAlerts_test()
	{
		// Expecting method: public void clearAlerts()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("clearAlerts");
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
	public void cancelFlight_Flight_test()
	{
		// Expecting method: public void cancelFlight(Flight arg0)
		try
		{
			Method m = Passenger.class.getDeclaredMethod("cancelFlight", Flight.class);
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
	public void cancelAll_test()
	{
		// Expecting method: public void cancelAll()
		try
		{
			Method m = Passenger.class.getDeclaredMethod("cancelAll");
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