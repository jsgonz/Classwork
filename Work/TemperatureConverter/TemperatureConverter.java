import java.util.Scanner;

public class TemperatureConverter 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		double f,c;
		
		System.out.print("Input temperature in fahrenheit : ");
		f = scan.nextDouble();
		
		c = (5d/9)*(f-32);
		
		System.out.print("The temperature in celcius is :" + c);
	}
}
