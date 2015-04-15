import java.util.*;

public class Driver{
 	
	public static int[] getRandomArray(int size){

		Random ng = new Random();
		int [] newArray = new int[size];

		for(int i = 0; i< size; i++){
			newArray[i] = ng.nextInt(100);
		}
		return newArray;
	}

	public static void timeTrial(int arraySize){
		
		int[] arrayA = getRandomArray(arraySize);
		int[] arrayB = Arrays.copyOf(arrayA, arrayA.length);
		
		StopWatch s = new StopWatch();
		
		int temp;
		
		for(int i = 0; i < arrayA.length; i++){
			
			for(int j = i+1; j<arrayA.length; j++){
				
				if(arrayA[i] > arrayA[j]){
					
					temp = arrayA[i];
					arrayA[i] = arrayA[j];
					arrayA[j] = temp;
				}
			}
		}
		
		s.stop();
		s.getElapsedTime();
		
		System.out.println(s.getElapsedTime());
		
		s.start();
		
		Arrays.sort(arrayB);
		
		s.stop();
		s.getElapsedTime();
		
		System.out.println(s.getElapsedTime());
	}

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int input;
		
		System.out.println("Input array size: ");
		input = scan.nextInt();
		
		timeTrial(input);
		
	}
}