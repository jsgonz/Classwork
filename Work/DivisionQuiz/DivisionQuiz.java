import java.util.*;

public class DivisionQuiz {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int x, y;
		double userAnswer, trueAnswer, ERROR_RANGE;
		
		int MIN = 1;
		int MAX = 10;
		
		x = (int) (Math.random() * (MAX - MIN) + MIN);
		y = (int) (Math.random() * (MAX - MIN) + MIN);
		
		System.out.println("What is the result of " + x + "/" + y + "?");
		
		userAnswer = scan.nextDouble();
		trueAnswer = ((double) x) / y;
		
		ERROR_RANGE = 0.001;
		
		if(Math.abs(userAnswer - trueAnswer) < ERROR_RANGE){
			System.out.println("Correct!");
		}else{
			System.out.println("Wrong. The correct asnwer is " + trueAnswer);
		}
		
		
	}
}
