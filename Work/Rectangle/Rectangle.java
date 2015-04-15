import java.util.*;
//Have a program receive the x,y center coordinates of a rectangle along with height and width.
//Have the program take a second x,y point.
//Check to see if the point lies in the rectangle.
public class Rectangle {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		double x1, y1, height, width, x2, y2, tx, ty;
		
		System.out.println("Enter the center (x,y) coordinates of the rectangle, then the height and the width: ");
		
		x1 = scan.nextDouble();
		y1 = scan.nextDouble();
		height = scan.nextDouble();
		width = scan.nextDouble();
		
		System.out.println("Enter the second (x,y) coordinates: ");
		
		x2 = scan.nextDouble();
		y2 = scan.nextDouble();
		
		tx = Math.abs(x2 - x1);
		ty = Math.abs(y2 - y1);
		
		if(tx <= (width / 2) && ty <= (height / 2)){
			System.out.println("Second point lies on the rectangle.");
		}else{
			System.out.println("Second point does not lie in the rectangle.");
		}
	}
}
