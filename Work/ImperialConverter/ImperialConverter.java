import java.util.Scanner;

public class ImperialConverter {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This program converts inches into miles, yards, feet");
		System.out.print("Number of inches : ");
		
		int inches = scan.nextInt();
		
		int feet, yards, miles;
		
		feet = inches / 12;
		inches %= 12;
		
		yards = feet / 3;
		feet %=3;
		
		miles = yards / 1760;
		yards %= 1760;
		
		System.out.println(miles + " m " + yards + " yd " + feet + " ft " + inches + " in ");
	}
}
