import java.util.*;

public class ArrayLoop {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int[] j = {1,2,3};
		int option;
		int indexValue=0, newValue;
		int a=0, b=0, c=0;
		
		boolean x = true, f = true;
		
		System.out.println("Welcome to the array machine, initial contents are 1,2,3");
		
		while(x){
			
			System.out.println("Enter 1 to print the array");
			System.out.println("Enter 2 to change one value");
			System.out.println("Enter 3 to change all values");
			System.out.println("Enter 4 to print the sum of the array");
			System.out.println("Enter 0 to exit");
			
			if(scan.hasNextInt()){
				option = scan.nextInt();
			
				if(option==1){
					
					System.out.print("Contents of the array are: ");
					
					for(int i=0; i<j.length; i++){
						System.out.print(j[i] + " ");
					}
					
					System.out.println("\n");
					
				}else if(option==2){
					
					System.out.println("Enter an index: ");
					
					if(scan.hasNextInt()){
						indexValue = scan.nextInt();
						
						System.out.println("Enter a value: ");
						
						if(scan.hasNextInt()){
							newValue = scan.nextInt();
							
							j[indexValue]=newValue;
							
							System.out.print("Contents of the array are: ");
	
							for(int i=0; i<j.length; i++){
								System.out.print(j[i] + " ");
							}
							
							System.out.println("\n");
						}else{
							System.out.println("Must enter an integer\n");
							scan.next();
						}
						
					}else{
						System.out.println("Please enter an integer\n");
						scan.next();
					}
					
				}else if(option==3){
					
					System.out.println("Enter three values: ");
					
					if(scan.hasNextInt()){
						a = scan.nextInt();	
					}else{
						System.out.println("Enter only integers\n");
						scan.next();
						continue;
					}
					
					if(scan.hasNextInt()){
						b = scan.nextInt();
					}else{
						System.out.println("Enter only integers\n");
						scan.next();
						continue;
					}
					if(scan.hasNextInt()){
						c = scan.nextInt();
					}else{
						System.out.println("Enter only integers\n");
						scan.next();
						continue;
					}
					
					for(int i=0; i<1; i++){
						j[i] = a;
						j[i+1] = b;
						j[i+2] = c;
					}
					
					System.out.print("Contents of the array are: ");
	
					for(int i=0; i<j.length; i++){
						System.out.print(j[i] + " ");
					}
					
					System.out.println("\n");
					
				}else if(option==4){
					
					int temp=0;
					
					for(int i=0; i<j.length; i++){
						
						temp+=j[i];
					}
					
					System.out.println("The sum of the array is " + temp + "\n");
					
					
				}else if(option==0){
					System.out.println("Bye!");
					break;
				}
			}else{
				scan.next();
			}
		}
		
	}
}
