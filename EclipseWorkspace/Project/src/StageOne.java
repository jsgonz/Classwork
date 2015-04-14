import java.util.*;

public class StageOne{

	static Scanner scan = new Scanner(System.in);
	
	private static String[] codes = {"GNV", "BTR", "MCO", "MIA", "ATL", "IAH", "LAX", "JFK", "LGA", "ORD", "BOS", "ANC", "DEN", "SLC", "SFO", "IAD", "SEA", "OKC"};
	static int option = 0;
	static String first, last, name, src, dest;
	static RandomItinerary random = new RandomItinerary();
	static boolean av = false, err;
	static String[] itinerary = random.get();
	
    
	public static void main(String[] args){
		
		menuOne();
	}
	
	//MENU ONE
	public static void menuOne(){
		
		do{
			
			err = false;
			System.out.print("============ Menu 1 ============\nEnter option (1, 2, 3): ");
			
			if(scan.hasNextInt()){	//checks input is an integer
			
				option = scan.nextInt();	//scans for option
				
				if(option < 1 || option > 3){	//handles out of range integers
				
					System.out.println("Error - input is not in range!");
					err = true;
				}
			}else{	//handles input that is not an integer
				
				System.out.println("Error - input is not an integer!");
				err = true;
				scan.next();
			}
		}while(err);
		
		if(option == 1){
			
			menuOneOptionOne();
		}else if(option == 2){
			
			menuOneOptionTwo();
		}else if(option == 3){
			
			System.exit(0);
		}
	}
	
	//OPTION ONE MENU ONE
	public static void menuOneOptionOne(){

			System.out.print("Enter your first name: ");
			first = scan.next();	//scans for first name
		
			System.out.print("Enter your last name: ");
			last = scan.next();	//scans for last name

		
		System.out.println("newPassenger: " + first + " " + last);
		
		menuTwo();
	}
		
	//OPTION ONE MENU TWO
	public static void menuOneOptionTwo(){

			System.out.print("Enter your first name: ");
			first = scan.next();	//scans for first name

			System.out.print("Enter your last name: ");
			last = scan.next();	//scans for last name

		
		System.out.println("findPassenger: " + first + " " + last);
		
		menuTwo();
	}
	
	//MENU TWO
	public static void menuTwo(){
		
		do{
			
			err = false;
			System.out.print("============ Menu 2 ============\nEnter option (1, 2, 3, 4): ");
			
			if(scan.hasNextInt()){	//checks input is an integer
				
				option = scan.nextInt();	//scans for option
				
				if(option < 1 || option > 4){	//handles out of range integers
					
					System.out.println("Error - input is not in range!");
					err = true;
				}
			}else{	//handles input that is not an integer
				
				System.out.println("Error - input is not an integer!");
				err = true;
				scan.next();
			}
		}while(err);
			
		if(option == 1){
			
			menuTwoOptionOne();
		}else if(option == 2){
			
			menuTwoOptionTwo();
		}else if(option == 3){
			
			menuTwoOptionThree();
		}else if(option == 4){
			
			menuOne();
		}
	}
	
	//OPTION ONE MENU TWO
	public static void menuTwoOptionOne(){
		
		do{
			
			err = false;
			System.out.print("Enter originating airport (three letter code): ");
			src = scan.next();	//scans for origin code
			
			for(int i = 0; i < codes.length; i++){
				
				if(src.equals(codes[i])){	//checks input code exists
					av = false;
					break;
				}else{
					
					av = true;
				}
			}
			
			if(av){	//only happens if code doesn't exist
				
				System.out.println("Origin does not exist.");
				av = false;
				err = true;
			}
		}while(err);
		
		do{
			
			err = false;
			System.out.print("Enter destination airport (three letter code): ");
			dest = scan.next();	//scans for destination code
			
			for(int i = 0; i < codes.length; i++){
				
				if(dest.equals(codes[i])){	//checks input code exists
					av = false;
					break;
				}else{
					
					av = true;
				}
			}
			
			if(av){	//only happens if code doesn't exist
				
				System.out.println("Destination does not exist.");
				av = false;
				err =true;
			}
		}while(err);
		
		System.out.print("findAvailableFlightPlans: " + src + " " + dest);
	}
	
	//OPTION TWO MENU TWO
	public static void menuTwoOptionTwo(){
		
		for(int i = 0; i < itinerary.length; i++){	//prints out itinerary
			
			System.out.println((i+1) + ". " + itinerary[i]);
			
			if(i==(itinerary.length-1)){
				
				System.out.println((itinerary.length+1) + ". cancel");
			}
		}
		
		do{
			
			err = false;
			System.out.println("Enter a flight number: ");
			
			if(scan.hasNextInt()){	//checks input is an integer
			
				option = scan.nextInt();	//scans for option
				
				if(option < 1 || option > itinerary.length+1){	//handles out of range integers
					
					System.out.println("Error - input is not in range!");
					err = true;
				}
			}else{	//handles input that is not an integer
				
				System.out.println("Error - input is not an integer!");
				err = true;
				scan.next();
			}
		}while(err);
		
		if(option >= 1 && option <= itinerary.length){
			
			System.out.println("cancelFlight: " + itinerary[option-1] + " " + first + " " + last);
		}else if(option == itinerary.length+1){	//happens if cancel option is selected
			
			menuTwo();
		}
	}
	
	//OPTION THREE MENU TWO
	public static void menuTwoOptionThree(){
		
		for(int i = 0; i < itinerary.length; i++){	//prints out canceled flights
			
			System.out.println("cancelFlight: " + itinerary[i] + " " + first + " " + last);
		}
	}
	
}