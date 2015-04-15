import java.util.*;

public class TipCalculator {
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		double subtotal, grautity, gRate, tip, total;
		double gratuity;
		
		System.out.println("~Tip Calculator~");
		
		System.out.println("Enter the subtotal and gratuity rate, separated by a space: ");
		
		subtotal = scan.nextDouble();
		gratuity = scan.nextDouble();
		
		gRate=gratuity/100;
		
		tip=subtotal*gRate;
		
		total=subtotal+tip;
		
		System.out.println("The gratuity is $" + tip + " and the total is $" + total);
	}
}
