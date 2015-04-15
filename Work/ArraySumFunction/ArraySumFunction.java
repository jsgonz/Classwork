
public class ArraySumFunction {

	public static void main(String[] args){
		int[] numbers = {34, -7, 42, 101};
		System.out.println("Sum of array = " + sum(numbers));
	}
	
	public static int sum(int[] array){
		int sum = 0;
		
		for(int i=0; i < array.length; i++){
			sum += array[i];
		}
		
		 return sum;
	}
}
