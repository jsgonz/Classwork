import java.util.*;
/*
 * Write a program that prompts the user to enter the center x,y coordinates,
 * width, and height of two rectangles and determines whether the second rectangle
 * is inside the first or overlaps with the first.
 */
public class TwoRectangles {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        double r1x, r1y, r1w, r1h, r2x, r2y, r2w, r2h, tx, ty;
        
        System.out.print("Enter r1's center x-, y-coordinates, width and height: ");
        
        r1x = scan.nextDouble();
        r1y = scan.nextDouble();
        r1w = scan.nextDouble();
        r1h = scan.nextDouble();
        
        System.out.print("Enter r2's center x-, y-coordinates, width and height: ");
        
        r2x = scan.nextDouble();
        r2y = scan.nextDouble();
        r2w = scan.nextDouble();
        r2h = scan.nextDouble();
        
        tx = Math.abs(r2x - r1x);
        ty = Math.abs(r2y - r1y);
        
        if(tx<((r1w / 2)+(r2w / 2)) && ty<((r1h / 2) + (r2h /2)) ){
            if((r1x + (r1w / 2) >= r2x + (r2w / 2)) && (r1y + (r1h / 2) >= r2y + (r2h / 2))){
                System.out.println("Inside.");
            }else{
            	System.out.println("Overlap");
            }
        }else{
            System.out.println("Outside");
        }
        
    }
}
