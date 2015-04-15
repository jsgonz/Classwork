import java.util.*;

public class PosAndNeg {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int numPositive = 0;
		int numNegative = 0;
		int numNumbers = 0;
		double sumNumbers = 0, avg;
		int numbers;
	
		System.out.println("Enter an integer, the input ends if it is 0: ");
		numbers = scan.nextInt();
		
		if(numbers==0){
			System.out.println("No numbers are entered except 0");
		}
		
		while(numbers!=0){
			numNumbers++;
			sumNumbers += numbers;
			if(numbers<0){
				numNegative++;
			}else{
				numPositive++;
			}
			numbers = scan.nextInt();
			if(numbers==0){
				avg = sumNumbers / numNumbers;
				System.out.println("The number of positives is " + numPositive);
				System.out.println("The number of negatives is " + numNegative);
				System.out.println("The total is " + sumNumbers);
				System.out.println("The average is " + avg);
			}
		}
		
	}
}
