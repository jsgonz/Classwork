import java.util.*;

public class TrianglePrinter 
{

	/**
	 * This program should "draw" a right (isoceles) triangle
	 * with a pre-specified edge length.
	 */
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("How large should your triangle's edge be? ");
		
		int len = input.nextInt();
		
		//System.out.println();
		
		for(int i=0; i < len; i++)
		{
			// Prints one line of the triangle.
			for(int j=-1; j < i; j++)
			{
				System.out.print("X");
				
			}
			
			System.out.println("");
		}
	}

}


