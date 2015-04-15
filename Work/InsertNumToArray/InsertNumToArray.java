import java.util.Arrays;

/*Insert a number to a sorted array*/
public class InsertNumToArray {
	public static void main(String[] args) 
	{
		int[] arr = { 2, 3, 5, 7, 11, 15 };
		
		System.out.println("Original: " + Arrays.toString(arr));
		
		arr = insert(arr, 27);
		
		System.out.println("Final:    " + Arrays.toString(arr));
	}

	public static int[] insert(int[] arr, int num) 
	{
		arr = enlarge(arr);
		
		for(int i = arr.length - 1; i > 0; i--){
			if(num<arr[i - 1]){	
				arr[i]=arr[i-1];
			}else{
				arr[i]=num;
				break;
			}	
		}	
		
		return arr;
	}

	public static int[] enlarge(int[] arr) 
	{
		int[] newarr = new int[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++){
			newarr[i] = arr[i];
		}
		
		return newarr;
	}
}