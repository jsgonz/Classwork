import java.util.*;

public class MinutesInYear {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int minutes, years, days, leftoverMinutes;
		
		System.out.print("Enter the number of minutes: ");
		minutes = scan.nextInt();
		
		years = minutes/525600;
		leftoverMinutes = minutes%525600;
		
		days = leftoverMinutes/1440;
		
		System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
	}
}
