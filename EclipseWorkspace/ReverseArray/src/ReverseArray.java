import java.util.*;
   
public class ReverseArray{
	public static void main(String[] args){
           
		Scanner scan = new Scanner(System.in);
           
        int[] fArray = new int[5];
        int number, secondTry=0;
           
        for(int i=0; i<fArray.length; i++){
        	System.out.println("Enter an integer within the range [0,9]");
        	number = scan.nextInt();
        	fArray[i] = number;
        	
        	while(number<0 || number>9){
        		System.out.println("Error, integer is not in range. Input an integer within the range [0,9]");
        		secondTry = scan.nextInt();
        		
        		if(secondTry>=0 && secondTry<=9){
        			fArray[i] = secondTry;
        			break;
        		}
        	}
        }
        
        System.out.println("The array in reverse is: ");
        
        for(int i=fArray.length-1; i>=0; i--){
        	System.out.print(fArray[i]+" ");
        }
    }
}