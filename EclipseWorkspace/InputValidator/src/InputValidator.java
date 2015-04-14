import java.util.*;

public class InputValidator {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int x = 0;
		
		System.out.print("Enter an int, 1 - 10: ");
		
		boolean err;
		
		
		do{
			err = false;
			if(scan.hasNextInt()){
				x = scan.nextInt();
				
				if(x < 1 || x > 10){
					System.out.println("Error - input is not in range!");
					err = true;
				}
			}else{
				System.out.println("Error - input is not an integer!");
				err = true;
				scan.next();
			}
		}while(err);
		
		if(!err){
			System.out.println("Input is good. x= " + x);
		}

	}

}
