import java.util.*;

public class LabQuiz {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		
		/*
		 * 
		 * */
		
		
		int[] a = new int[10];
		
		for(int i = 0; i < a.length; i++){
			
			a[i] = i;
		}
		
		System.out.println(sum(a));
		
		getInputAirportCode
	}
	
	public static int sum(int[] l){
		
		int sum = 0;
		
		for(int i = 0; i < l.length; i++){
			
			sum += l[i];
		}
		
		return sum;
	}
	
	public static String getInputAirportCode(){
		
		System.out.println("Input a three letter string");
		String s = scan.next();
		
		if(s.length() > 3 || s.length() < 3){
			
			throw new RuntimeException("Input has to be three letters in length");
		}
		
		return s;
	}
}
