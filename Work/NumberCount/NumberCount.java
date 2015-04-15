import java.util.*;

public class NumberCount {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int[] list = new int[100];
		int input=0;
		
		System.out.println("Enter the integers between 1 and 100: ");
		
		for(int i = 0; i < list.length; i++){
			
			input = scan.nextInt();
			
			if(input >= 1 && input <= 100){
			
				list[input - 1]++;
			
			}else if(input == 0){
			
				break;
			
			}
		}	
			
		for(int i = 0; i < list.length; i++){
			
			if(list[i] > 1){
			
				System.out.println((i+1) + " occurs " + list[i] + " times");
			
			}else if(list[i] == 1){
			
				System.out.println((i+1) + " occurs " + list[i] + " time");
			
			}
		}	
		
		
	}
}
