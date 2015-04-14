import java.util.*;

public class CurveBreaker {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int numStudents;
		int i = 0;
		int highScore = 0;
		String stuName="";
		
		System.out.print("Please enter the number of students who were graded: ");
		numStudents = scan.nextInt();
		
		String[] stuNameList = new String[numStudents];
		int[] stuScoreList = new int[numStudents];
		
		while(i < numStudents){
			System.out.print("Enter a grade and name: ");
			stuScoreList[i] = scan.nextInt();
			stuNameList[i] = scan.nextLine();
			
			if(stuScoreList[i]>highScore){
				highScore = stuScoreList[i];
				stuName = stuNameList[i];
			}

			i++;
		}
		
		System.out.println("Best result: " + highScore + " " + stuName);
	
	}
}
