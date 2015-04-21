import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import junit.framework.Assert;

import org.junit.Test;


public class ExportBasicTest {

	@Test(timeout = 1000)
	public void exportExampleFile() 
	{
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		
		Flight f1 = new Flight("MCO", "MIA", 800, 930, 8);
		Flight f2 = new Flight("MIA", "ATL", 1100, 1400, 23);
		Flight f3 = new Flight("ATL", "GNV", 1430, 1615, 15);
		
		flightList.add(f1);
		flightList.add(f2);
		flightList.add(f3);
		
		ArrayList<Passenger> passList = new ArrayList<Passenger>();
		
		Passenger p1 = new Passenger("Joshua", "Horton");
		Passenger p2 = new Passenger("Adam", "Smith");
		
		passList.add(p1);
		passList.add(p2);
		
		p1.addAlert("The 7:30 flight from BTR to GNV has been cancelled!");
		
		p1.bookFlight(f1);
		p1.bookFlight(f2);
		
		p2.bookFlight(f3);
		p2.addStandbyFlight(f1);
		p2.addStandbyFlight(f2);
		
		DataManager.exportData("ExportedFile.txt", passList, flightList);
		
		// This file, given the initial setup, should almost perfectly match the provided example file.
		Assert.assertEquals("File contents are not as expected!", true, matchFiles("ProjStage3BasicFile.txt", "ExportedFile.txt"));
	}
	
	// Checks if the files match by directly comparing their exact contents.
	private boolean matchFiles(String expected, String actual)
	{
		Scanner inFile1;
		Scanner inFile2;
		
		try
		{
			inFile1 = new Scanner(new File(expected));
			inFile2 = new Scanner(new File(actual));
		}
		catch(IOException e)
		{
			throw new RuntimeException("Cannot open files!", e);
		}
		
		ArrayList<String> expectedLines = new ArrayList<String>();
		ArrayList<String> actualLines = new ArrayList<String>();
		
		while(inFile1.hasNextLine())
		{
			expectedLines.add(inFile1.nextLine());
		}
		
		while(inFile2.hasNextLine())
		{
			actualLines.add(inFile2.nextLine());
		}
		
		// Erase a trailing blank line at the file's end; I don't mind that.
		if(actualLines.get(actualLines.size() - 1).trim().equals(""))
		{
			actualLines.remove(actualLines.size() - 1);
		}
		
		return expectedLines.equals(actualLines);
	}

}