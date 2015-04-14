import java.util.*;

public class FutureWeekday {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int today, daysAfter, finalDay;
		String t="";
		String f="";
		
		System.out.print("Enter today's day: ");
		today = scan.nextInt();
		
		System.out.print("Enter the number of days elapsed since today: ");
		daysAfter = scan.nextInt();
		
		finalDay = today+daysAfter;
		
		finalDay %= 7;
		
		if(today==0){
			t="Sunday";
		}else if(today==1){
			t="Monday";
		}else if(today==2){
			t="Tuesday";
		}else if(today==3){
			t="Wednesday";
		}else if(today==4){
			t="Thursday";
		}else if(today==5){
			t="Friday";
		}else if(today==6){
			t="Saturday";
		}
		
		if(finalDay==0){
			f="Sunday";
		}else if(finalDay==1){
			f="Monday";
		}else if(finalDay==2){
			f="Tuesday";
		}else if(finalDay==3){
			f="Wednesday";
		}else if(finalDay==4){
			f="Thursday";
		}else if(finalDay==5){
			f="Friday";
		}else if(finalDay==6){
			f="Saturday";
		}
		
		System.out.println("Today is " + t + " and the future day is " + f);
		
	}
}
