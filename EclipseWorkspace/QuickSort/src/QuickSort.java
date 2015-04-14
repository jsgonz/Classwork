import java.util.Arrays;

public class QuickSort{
	
	public static void main(String[]args){
		int[] nums = {2,5,3,14,19,23,35,43,23};
		System.out.println("Original Pivot: " + nums[(nums.length-1)/2]);
		System.out.println("Before quick sort: " + Arrays.toString(nums));
		quickSort(nums,0,nums.length-1);
		System.out.println("After quick sort:  " + Arrays.toString(nums));
	}
	static int partition(int nums[], int leftIndex, int rightIndex)
	{
	      int tmp;
	      int pivot = nums[(leftIndex + rightIndex) / 2];
	     
	      while (leftIndex <= rightIndex) {
	            while (nums[leftIndex] < pivot)
	            	leftIndex++;
	            while (nums[rightIndex] > pivot)
	            	rightIndex--;
	            if (leftIndex <= rightIndex) {
	                  tmp = nums[leftIndex];
	                  nums[leftIndex] = nums[rightIndex];
	                  nums[rightIndex] = tmp;
	                  leftIndex++;
	                  rightIndex--;
	            }
	      };
	     
	      return leftIndex;
	}
	 
	static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
}