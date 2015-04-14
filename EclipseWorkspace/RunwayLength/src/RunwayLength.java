import java.util.*;

public class RunwayLength {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int speed;
		double acceleration, length;
		
		System.out.print("Enter speed and acceleration: ");
		speed = scan.nextInt();
		acceleration = scan.nextDouble();
		
		length= (Math.pow(speed, 2))/(2*acceleration);
		
		System.out.print("The minimum runway length for this airplane is " + length);
	}
}
