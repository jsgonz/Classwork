import java.util.*;

public class Triangle {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int x, y, z;
		
		System.out.println("Type in three lengths of a triangle: ");
		x = scan.nextInt();
		y = scan.nextInt();
		z = scan.nextInt();
		
		if((x + y) > z && (x + z) > y && (y + z) > x){
			System.out.println("It is a valid triangle");
		}else{
			System.out.println("Not a valid triangle.");
		}
	}
}
