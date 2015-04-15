import java.util.*;
import java.io.*;

public class ImportData {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String filename = "myData.txt";
		Scanner input;
		
		try 
		{
			input = new Scanner(new File(filename));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("File does not exist!");
			return;
		}

		int i=1;
		
		while(input.hasNext())
		{
			System.out.print("Person " + (i++) + ": ");
			
			String first = input.next();
			String last = input.next();
			int moneys = input.nextInt();
			
			System.out.println(first + " " + last + " has $" + moneys);
		}
		
	}
	/*public ArrayList<Passenger> passengers;
	public ArrayList<Flight> flights;
	
	public ImportData(ArrayList<Passenger> ps, ArrayList<Flight> fs){
		
		passengers = ps;
		flights = fs;
	}*/
}
