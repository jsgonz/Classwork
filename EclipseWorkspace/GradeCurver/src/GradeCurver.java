import java.util.*;

public class GradeCurver {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int numStudents;
        int[] listStudents;
        int i=0;
        int highScore = 0;
        char grade=' ';
        
        System.out.print("Enter the number of students: ");
        numStudents = scan.nextInt();
        
        listStudents = new int[numStudents];
        
        System.out.print("Enter " + numStudents + " scores: ");
        
        while(i<numStudents){
            listStudents[i] = scan.nextInt();
            if(listStudents[i] > highScore){
                highScore = listStudents[i];
            }
            i++;
        }
        
        for(int j = 0; j<listStudents.length; j++){
            
            if(listStudents[j] >= highScore-10){
                grade = 'A';
            }else if(listStudents[j] >= highScore-20){
                grade = 'B';
            }else if(listStudents[j] >= highScore-30){
                grade = 'C';
            }else if(listStudents[j] >= highScore-40){
                grade = 'D';
            }else{
                grade = 'F';
            }
            
            System.out.println("Sudent " + j + " score is " + listStudents[j] + " and grade is " + grade);
        }
    }
}
