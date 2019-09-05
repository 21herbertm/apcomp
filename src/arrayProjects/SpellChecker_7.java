package arrayProjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SpellChecker_7 {
	private String [] myDictionary; 
	private static final int MAX_TRYS=2;
	private String[] myGuessArray= new String[MAX_TRYS];


	public SpellChecker_7() {
		this.readInDictionary("./dictionaryWords");
		
	
		this.myGuessArray[0]= new String("");
		this.myGuessArray[1]= new String("");

	}

	public static void main(String[] args) {
		SpellChecker_7 sc= new SpellChecker_7();
		
		//PRINT OUT THE DICTIONARY
		System.out.println("Words are: \n\t" + sc.toString());
		
		System.out.println("Enter a word to check:");
		Scanner input = new Scanner(System.in);
		

		String inputStr = input.nextLine();
		while(!inputStr.equals("Q")) {
			
			sc.resetMyGuessArray();
			
			
			if (sc.isInDictionary(inputStr)){
				System.out.println("You correctly spelled this word correctly");
			} else {
				//String []guessArray= new String[2];
				//THIS WORKS BECAUSE PASSING IN THE VALUE TO A REFERENCE TO AN ARRAY OF REFERENCESsc.findGuess(inputStr,guessArray);

	
				
				sc.findGuessesWithMember(inputStr);
				System.out.println(sc.myGuessArray[0]);
				if (!sc.myGuessArray[0].equals("")) {
					System.out.println("Do you Mean:" + sc.myGuessArray[0]);
					System.out.println("Do you want to see if there is another possible match? Type Y for Yes");
					String tryAgainStr=input.nextLine();
					if (tryAgainStr.equals("Y") ) {

						if (!sc.myGuessArray[1].equals("")) {
							System.out.println("Second Guess.. Do you Mean:" + sc.myGuessArray[1]);
						} else {
							System.out.println("No words Match");
						}

					}
				}

				
			}
			System.out.println("Enter another word or Q for quit");
			inputStr = input.nextLine();
		}

	}
	
	public void readInDictionary(String fileName){
		try{
			int rowCount=0;
			File file = new File(fileName); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 

		
	
			while ((br.readLine()) != null) {			
				rowCount++;
			} 
			
		
		
			//ALLOCATE SPACE 
			myDictionary= new String[rowCount];
	
		
			
			br = new BufferedReader(new FileReader(file)); 
			String inputStr="";
			int row=0;
			while ((inputStr = br.readLine()) != null) {
				
	
				myDictionary[row]= new String(inputStr);
				row++;

			} 
			
			
			br.close();
			
		} catch (NumberFormatException | IOException e) {
			System.err.println("file Not found");
		}
		
	}
	public boolean isInDictionary(String inString) {
		for (int i=0; i< myDictionary.length;i++) {
			//CONVERT BOTH THE DICTIONARY AND INPUT STRING TO UPPER CASE WHEN COMPARING 
			if (inString.toUpperCase().equals(myDictionary[i].toUpperCase())){
				return true;
			}
		}
		return false;
		
	}
	
	//MEMBERS DO NOT HAVE TO WORRY ABOUT PASSING IN VARIABLES
	private void findGuessesWithMember(String inString) {
		int numOfSuggestions=0;
		String inFirstCharStr = inString.toUpperCase().substring(0, 1);
		
		//LOOP OVER WHOLE DICTIONARY
		for (int i=0; i< myDictionary.length;i++) {
			String dictFirstCharStr = myDictionary[i].toUpperCase().substring(0, 1);
			
			if (inFirstCharStr.equals(dictFirstCharStr) && numOfSuggestions< this.myGuessArray.length){
				this.myGuessArray[numOfSuggestions]= new String();
				this.myGuessArray[numOfSuggestions]=myDictionary[i];
				
				numOfSuggestions++;
			}

		}
		return;
		
	}

	
	
	/*************************************************************REMOVE THIS
	//YOU ARE PASSING IN THE VALUE OF THE REFERENCE TO AN ARRAY OF REFERENCES
	public void findGuess(String inString,String [] guessArray) {
		//I HAVE NO IDEA HOW TO GUESS WHAT IS ALMOST THE RIGHT SPELLING... WILL ASSUME THE USER KNOWS THE FIRST LETTER
		//ALLOW UP TO 2 GUESSES

		int trys=0;
		String inFirstCharStr = inString.toUpperCase().substring(0, 1);
		for (int i=0; i< myDictionary.length;i++) {
			String dictFirstCharStr = myDictionary[i].toUpperCase().substring(0, 1);
			if (inFirstCharStr.equals(dictFirstCharStr) && trys< guessArray.length){
				guessArray[trys]=myDictionary[i];
			
				trys++;
			}

		}
		return;
	}
	
	*****************************************************************************/

	public void resetMyGuessArray() {
		for (int i=0;i<this.myGuessArray.length;i++) {
			this.myGuessArray[i]="";
		}
	
	}
	public String toString() {
		
		String output="";
		for (int i =0; i< myDictionary.length; i++) {
			output+= myDictionary[i] +"\n\t";
		}
		
		return output;
	}

	

}
