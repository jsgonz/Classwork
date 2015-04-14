import java.util.*;

public class AgeCategorizer {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int age;
		String group;
		
		System.out.println("This porgram categorizes people by age.");
		System.out.print("Enter a person's age: ");
		
		age = scan.nextInt();
		
		if(age>=65){
			group = "elder";
		}else if(age>=20){
			group = "adult";
		}else if(age>=13){
			group = "teen";
		}else if(age>5){
			group = "kid";
		}else if(age>2){
			group = "toddler";
		}else{
			group = "baby!";
		}
		
		System.out.println("This person is a/an "+group);
	}
}
