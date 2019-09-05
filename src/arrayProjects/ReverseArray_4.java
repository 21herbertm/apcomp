package arrayProjects;
import java.util.Scanner;
public class ReverseArray_4 {


	

	    static void reverse(int originalArray[]) 
	    { 
	        int[] reversedArray = new int[originalArray.length]; 
	        int counterStartingAtEnd = originalArray.length-1; 
	        
	        
	        
	        
	
	        //REVERSE BY EXCHANGING THE BEGINING AND END ELEMENTS AND WORK TOWARD EACH OTHER UNTIL THE MIDDLE OF THE ARRAY
	        for (int i = 0; i < originalArray.length; i++) { 
	            reversedArray[counterStartingAtEnd] = originalArray[i]; 
	            counterStartingAtEnd--; 
	        } 
	  
	       
	        System.out.println("Reversed array is: \n"); 
	        for (int k = 0; k < reversedArray.length; k++) { 
	            System.out.println(reversedArray[k]); 
	        } 
	    } 
	  
	    public static void main(String[] args) 
	    { 
	        //int [] arr = {10, 20, 30, 40, 50}; 
	        
	        
	        Scanner input = new Scanner(System.in);
	        int[] numbers = new int[5];

	        for (int i = 0; i < numbers.length; i++)
	        {
	            System.out.println("Please enter number");
	            numbers[i] = input.nextInt();
	        }
	        reverse(numbers); 
	    } 
	
}
