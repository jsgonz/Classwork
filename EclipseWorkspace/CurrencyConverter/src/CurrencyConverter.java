import java.util.Scanner;

public class CurrencyConverter {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This program converts US $ into other currencies");
		System.out.println("How much money would you like to convert? $");
		
		double usd = scan.nextDouble();
		
		double euro,pound, rupee;
		
		euro = usd * .85339;
		pound = usd * .65719;
		rupee = usd * 61.7930;
		
		System.out.println("Euros : " + euro);
		System.out.println("Pound : " + pound);
		System.out.println("Rupees : " + rupee);
	}
}
