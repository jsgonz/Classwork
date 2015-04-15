import java.util.*;

public class QuadraticFormula {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		double a, b, c, discriminant, rootOne, rootTwo;
		
		System.out.print("Enter a, b, c: ");
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		
		discriminant = Math.pow(b, 2)-(4*a*c);
		
		rootOne = (-b+Math.pow(discriminant, .5))/(2*a);
		
		rootTwo = (-b-Math.pow(discriminant, .5))/(2*a);
		
		if(discriminant>0){
			System.out.print("The equation has two roots " + rootOne + " and " + rootTwo);
		}else if(discriminant==0){
			System.out.println("The equation has one root " + rootOne);
		}else if(discriminant<0){
			System.out.println("The equation has no real roots");
		}
	}
}
