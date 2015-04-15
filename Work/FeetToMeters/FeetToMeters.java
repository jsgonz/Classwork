import java.util.*;

public class FeetToMeters {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		double feet, meters;
		
		System.out.print("Enter a value for feet: ");
		feet = scan.nextDouble();
		
		meters = feet*0.305;
		
		System.out.println(feet + " feet is " + meters + " meters");
	}
}
