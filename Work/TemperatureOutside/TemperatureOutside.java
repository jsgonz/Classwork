import java.util.*;

public class TemperatureOutside {
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		double outsideTemp, windSpeed, windChill;
		
		System.out.println("Enter the temperature in Fahrenheit between -58 F and 41 F: ");
		outsideTemp = scan.nextDouble();
		
		System.out.println("Enter the wind speed (>=2) in miles per hour: ");
		windSpeed = scan.nextDouble();
		
		windChill = 35.74+(0.6215*outsideTemp)-(35.75*Math.pow(windSpeed, 0.16))+(0.4275*outsideTemp*Math.pow(windSpeed, 0.16));
		
		System.out.println("The wind chill index is: " + windChill);
		
	}
}
