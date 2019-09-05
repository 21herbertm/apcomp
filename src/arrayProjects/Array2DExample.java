package arrayProjects;

import java.util.Scanner;






// ************************************************************************************************
/*
 * 
 * THIS PROGRAM WILL ALLOW A USER TO ENTER IN INTS OR DOUBLE NUMBERS INTO A PREDFINED 2D ARRAY
 * USER CAN ENTER IN UP TO 4 NUMS INTO 5 SEPERATE ROWS. 
 * THIS PROGRAM WILL PERMIT USERS TO ENTER IN LESS VALUES BUT NOT MORE THEN THE ARRAY SIZE BY UTILIZING A CONSTANT 
 * THEN THE PROGRAM WILL CALC 
 * 1) THE SUM OF EACH ROW
 * 2) THE NUMBER OF ELEMENTS ASSIGNED BY THE USER IN THE WHOLE ARRAY
 * 3) THE AVERAGE FOR THE ENTIRE 2D ARRAY 
 *  
 *
 */
// ************************************************************************************************
public class Array2DExample {

	// ************************************************************************************************
	//PRIVATE MEMBER VARS
	// ************************************************************************************************
	//SCANNER TO READ INPUT FROM CONSOLE
	private Scanner input;
	//CREATE CONSTANTS THAT DONT CHANGE
	//STATIC MEANS IT DOES NOT NEED AN OBJECT NEWED TO BE USED
	//FINAL MEANS IT CAN NOT BE CHANGED
	private static final int ROWS_MAX = 5;
	private static final int COLUMNS_MAX = 4;
	
	//THIS IS THE VALUE THE ARRAY IS INITALIZED TO SO THAT WE CAN TELL IF IT HAS BEEN FILLED IN BY THE USER
	private static final int UNSET_VALUE = -999;
	
	
	//2D ARRAY FOR THE INT PART OF THE PROBLEM, THIS COULD HAVE BEEN NEWED IN THE CONSTRUCTOR
	private int my2DArray[][] = new int[ROWS_MAX][COLUMNS_MAX];
	
	
	//2D ARRAY FOR THE DOUBLE PART OF THE PROBLEM, THIS COULD HAVE BEEN NEWED IN THE CONSTRUCTOR
	private double my2DArrayDouble[][] = new double[ROWS_MAX][COLUMNS_MAX];
	
	
	// ************************************************************************************************
	//PUBLIC METHODS
	// ************************************************************************************************
	
	/**
	 * THIS IS THE MAIN PROGRAM
	 * IT IS STATIC SO THAT IT CAN BE CALLED WITHOUT NEWING THIS CLASS
	 * 
	 * THIS MAIN METHOD WILL 
	 * 1) NEW THIS CLASS 
	 * 2) CALL CLASS FUNCTION TO ENTER IN THE INTERGER VALUES FROM THE USER
	 * 3) CALL CLASS FUNCTION TO PRINT OUT THE 2DARRAY OF INTERGERS
	 * 4) CALC AND PRINT OUT THE SUM AND AVERAGE OF THE ARRAY OF INTEGERS
	 * 5) NEW THIS CLASS AGAIN
	 * 6) CLASS CLASS FUNCTION TO ENTER IN THE DOUBLE VALUES FROM THE USER
	 * 7) CLASS CLASS FUNCTION TO PRINT OUT THE 2DARRAY OF DOUBLES
	 * 8) CALC AND PRINT OUT THE SUM AND AVERAGE OF THE ARRAY OF DOUBLES
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		//**************************************
		//INTEGERS FIRST
		//**************************************
		//CREATE THIS CLASS FOR THIS INTS
		Array2DExample inValues = new Array2DExample();
		
		//GET VALUES FROM THE USER
		inValues.enterValuesInt();

		//PRINT OUT THE VALUES ENTERED BY USER INTO 2D ARRAY
		inValues.print2DArray();

		//PRINT OUT THE SUM AND AVERAGE 
		inValues.printSumAndAverage();
		
		
		//**************************************
		//DOUBLES
		//**************************************		
		//CREATE THE CLASS OF 2D ARRAYS
		Array2DExample inValuesDouble = new Array2DExample();
		
		//GET VALUES FROM THE USER
		inValuesDouble.enterValuesDouble();

		//PRINT OUT THE VALUES ENTERED BY USER INTO 2D ARRAY
		inValuesDouble.print2DArray();

		//PRINT OUT THE SUM AND AVERAGE 
		inValuesDouble.printSumAndAverageDouble();
	}
	
	
	
	
	
	/**
	 * CONSTRUCTOR: THIS INITIALIZES THE 2D ARRAY WITH CONSTANT UNSET_VALUE 
	 * IT'S PURPOSE IS TO CREATE MEMORY WHERE NEEDED AND INITIALIZE THE CLASS MEMBER VARIABLES 
	 * HAS NO ARGUMENTS
	 * 1) ASSIGNS MEMORY TO THE MEMBER VARIABLE input WHICH IS THE SCANNER TO THE KEYBOARD
	 * 2) LOOPS OVER THE CLASS MEMBER VARIABLE my2DArray, AND FILLS IT WITH UNSET_VALUE, WE DO THIS BECAUSE 
	 * 		INTS ARE NORMALLY FILLED WITH ZEROS AND ZERO CAN BE A VALID INPUT FOR GRADES ( THE NEXT ASSIGNMENT) SO 
	 * 		WE ARE FILLING IT WITH -999
	 * 3) DO THE SAME THING FOR THE DOUBLE ARRAY my2DArrayDouble 
	 * 
	 */

	public Array2DExample() {
		
		//CREATE MEMORY FOR THE CLASS MEMBER VARIABLE INPUT
		input = new Scanner(System.in);
		
		// FILL THE ARRAY WITH A CONSTANT UNSET_VALUE SO THAT WE KNOW IT IS NOT BEEN FILLED IN AND
		// TO ALLOW ZERO TO BE INPUTED BY USER
		for (int rNum = 0; rNum < this.ROWS_MAX; rNum++) {
			for (int cNum = 0; cNum < this.COLUMNS_MAX; cNum++) {
				this.my2DArray[rNum][cNum] = this.UNSET_VALUE;
			}
		}
		
		//DO THE SAME THING FOR THE DOUBLE ARRAY 
		for (int rNum = 0; rNum < this.ROWS_MAX; rNum++) {
			for (int cNum = 0; cNum < this.COLUMNS_MAX; cNum++) {
				this.my2DArrayDouble[rNum][cNum] = this.UNSET_VALUE;
			}
		}

	}


	

	/**
	 * enterValuesInt 
	 * ALLOW USER TO ENTER IN VALUES INTO THE INTEGER 2D ARRAY
	 * USERS CAN ENTER IN LESS THEN THE MAX BUT NOT MORE
	 * USERS MUST USE SPACES BETWEEN NUMBERS AND A RETURN AT THE END OF THE ROW
	 * Q IS TO QUIT ENTERING IN VALUES
	 */
	public void enterValuesInt() {

		System.out.print("Enter Array values ");
		System.out.println(
				"Enter your value for max rows " + ROWS_MAX + " and MAX COLUMNS " + COLUMNS_MAX + " one row at a time");
		System.out.println("Q for end");


		// LOOP OVER THE MAX NUMBER OF ROWS THAT THE USER COULD ENTER ( IGNORE ADDITIONAL ROWS THE USER ENTERED IF THEY DECIDED TO IGNORE)
		// FOR EACH ROW READ IN THE INPUT LINE OF SEVERAL NUMBERS AS STRING AND SPLIT IT INTO AN ARRAY OF STRINGS
		// FOR THE ARRAY OF STRING DO ANOTHER LOOP FOR THE COLLUMS IN THE ROW
	
		for (int rNum = 0; rNum < ROWS_MAX; rNum++) {

			// READ IN THE STRING INTO INPUTSTRING FROM THE KEYBOARD UP TO THE RETURN CHAR, THIS WILL BE A ROW
			// OF INTEGERS SEPERATED BY A SPACE
			String inputString = input.nextLine();
			
			
			//IF USER INTPUTTED Q THAT MEANS QUIT
			if (inputString.equals("Q")) {
				return;
			}

			// SPLIT THE INPUT STRING BY WHITE SPACE INTO AN ARRAY OF STRINGS
			String[] userStrArray = inputString.split(" ");

			// LOOP OVER THE ARRAY OF STRING, EACH VALUE IS A STRING OF A NUMBER
			// CONVERT THE STRING INTO AN INT AND STUFF IT INTO THE COLUMNS IN THE CURRENT ROW,
			// COULD HAVE USER THIS.COLUMS_MAX INSTEAD OF userStrArray.length

			for (int c = 0; c < userStrArray.length; c++) {

				// I HAVE TO CHECK IF THE USER DOES NOT READ INSTRUCTIONS
				// IF THE USER INPUTTED MORE NUMBERS THEN THE COLUMNS_MAX OF NUMERS ALLOWED,
				// PRINT OUT AN ERROR MESSAGE AND IGNORE THE VALUE

				if (c >= COLUMNS_MAX) {

					// USER IS STUPID...THEY TRIED TO STUFF TOO MANY NUMBERS INTO MY ARRAY
					System.out.println("You entered in to many values. Program will ignore for COLUMN:" + c + " VALUE:" + userStrArray[c]);
					break;

				} else {

					// System.out.println("Row: " + rNum + " Column: " + c+ " IS: "+ userStrArray[c]);

					// CONVERT THE STRING FROM THE USER INPUT ARRAY INTO AN ACTUAL INT
					int result = Integer.parseInt(userStrArray[c]);

					// NOW ASSIGN IT INTO OUR ARRAY... WE DO NOT HAVE TO ADD MEMORY, WE DID THAT 
					my2DArray[rNum][c] = result;

				}
			}

		}

	}

	
	
	// ************************************************************************************************
	// ALLOW USER TO ENTER IN VALUES INTO THE PREDIFINED 2D ARRAY
	// USERS CAN ENTER IN LESS THEN THE MAX BUT NOT MORE
	// USERS MUST USE SPACES BETWEEN NUMBERS AND A RETURN AT THE END OF THE ROW
	// Q IS TO QUIT ENTERING IN VALUES
	// ************************************************************************************************

	public void enterValuesDouble() {

		System.out.print("Enter Array values as DOUBLE ");
		System.out.println("Enter your value for max rows " + ROWS_MAX + " and MAX COLUMNS " + COLUMNS_MAX + " one row at a time");
		System.out.println("Q for end");
		for (int rNum = 0; rNum < ROWS_MAX; rNum++) {

			String inputString = input.nextLine();
			if (inputString.equals("Q")) {
				return;
			}
			String[] userStrArray = inputString.split(" ");
			for (int c = 0; c < userStrArray.length; c++) {
				if (c >= COLUMNS_MAX) {
					// USER IS STUPID...THEY TRIED TO STUFF TOO MANY NUMBERS INTO MY ARRAY
					System.out.println("You entered in to many values. Program will ignore for COLUMN:" + c + " VALUE:" + userStrArray[c]);
					break;
				} else {
					double result = Double.parseDouble(userStrArray[c]);
					my2DArrayDouble[rNum][c] = result;
				}
			}

		}

	}
	
	
	
	
	
	
	// ************************************************************************************************
	// CREATE A STATIC FUNCTION ( IT DOES NOT NEED THIS CLASS INSTATIATED
	// TO TAKE IN AN 1D ARRAY AND CALCULATE THE SUM
	// THIS IS GOOD FOR CALCULATING THE SUM OF EACH  ROW IN A 2D ARRAY
	// PASS IN ONLY ONE ROW AT A TIME ( 1 D ARRAY)
	// ************************************************************************************************
	public static int calcRowSum(int[] rowArray) {
		int total = 0;
		
		
		//LOOP OVER THE INPUTTED ARRAY 
		for (int c = 0; c < rowArray.length; c++) {

			//IF 
			if(c==0 && rowArray[c]==UNSET_VALUE) {
				//EMPTY ROW
				return UNSET_VALUE;
			}
			
			if (rowArray[c] != UNSET_VALUE) {
				total = rowArray[c] + total;
			}
		}

		return total;

	}

	// ************************************************************************************************
	// OVERLOAD FOR DOUBLE. THIS MEANS THAT IT HAS THE SAME NAME AS THE ONE ABOVE WITH DIFFERENT INPUTS and/or OUTPUTS
	// CREATE A STATIC FUNCTION ( IT DOES NOT NEED THIS CLASS INSTATIATED
	// TO TAKE IN AN 1D ARRAY AND CALCULATE THE SUM
	// THIS IS GOOD FOR JUST THE ROW IN A 2D ARRAY
	// ************************************************************************************************

	public static double calcRowSum(double[] rowArray) {
		double total = 0.0;
		for (int c = 0; c < rowArray.length; c++) {
			if(c==0 && rowArray[c]==UNSET_VALUE) {
				//EMPTY ROW
				return UNSET_VALUE;
			}
			if (rowArray[c] != UNSET_VALUE) {
				total = rowArray[c] + total;
			}
		
		}

		return total;

	}
	
	

	// ************************************************************************************************
	//  CALCULATES THE AVERAGE FOR THE INT ARRAYS
	// CREATE A STATIC FUNCTION ( IT DOES NOT NEED THIS CLASS INSTATIATED)
	// TO TAKE IN A 2D ARRAY OF INTS AND CALC THE AVERAGE
	//  THIS ALSO PRINTS OUT THE SUM OF EACH ROW AND THE SUM OF THE 2D ARRAY
	// ************************************************************************************************
	public static double calc2dArrayAverage(int[][] myArray) {
		double grandTotal = 0.0;
		int totalElements = 0;
		double arrayAverage = 0.0;
		
		//LOOP OVER THE 2D ARRAY BY GETTING THE ROW AND SENDING IT TO THE CALCROWSUM MEMBER FUNCTION
		//FOR EACH ROW, GET THE SUM ( BY CALLING MEMBER FUNCTION calcRowSum) AND ADD IT TO THE LOCAL VAR GRANDTOTAL
		for (int rowNum = 0; rowNum < myArray.length; rowNum++) {

			int rowSum = calcRowSum(myArray[rowNum]);
	
			if (rowSum != UNSET_VALUE) {
				grandTotal = rowSum + grandTotal;
			
			
			
				//PRINT OUT THE SUM OF THE ROW
				int r = rowNum +1; //ADD ONE BECAUSE THE ARRAY STARTS AT ZERO AND WE WANT TO PRINT OUT FROM 1
				System.out.println("ROW: " + r + " = " + rowSum);
			}
		}
		
		//PRINT OUT THE TOTALSUM
		System.out.println("SUM = " + grandTotal);

		//GET THE TOTAL NUMBER OF ELEMENTS IN THE 2D ARRAY
		totalElements = getTotalElementsAssignedByUser(myArray);
		
		//CHECK IF DIVIDING BY ZERO
		if (totalElements > 0) {
			//CALC AVERAGE OF THE WHOLE 2D ARRAY
			// REMEMBER THAT INT/INT WILL RETURN INT
			arrayAverage = grandTotal / totalElements;
			return arrayAverage;
		}

		return UNSET_VALUE;
	}


//SAME THING AS THE ABOVE FUNCTION BUT FOR A 2d ARRAY OF DOUBLES
	//HAVING A FUNCTION WITH THE SAME NAME BUT DIFFERENT INPUT/OUTPUT TYPES IS CALLED OVERLOADING
	public static double calc2dArrayAverage(double[][] myArray) {
		double grandTotal = 0.0;
		int totalElements = 0;
		double arrayAverage = 0.0;
		
		//FOR EACH ROW GET THE SUM AND ADD IT TO THE GRANDTOTAL
		for (int rowNum = 0; rowNum < myArray.length; rowNum++) {

			double rowSum = calcRowSum(myArray[rowNum]);
			
			//MAKE SURE WE DON'T USE A ROW THAT HAS NO INPUTS ( A.K.A: IS SET TO UNSET_VALUE)
			if (rowSum != UNSET_VALUE) {
				grandTotal = rowSum + grandTotal;			

				//PRINT OUT THE SUM OF THE ROW
				int r = rowNum +1; //ADD ONE BECAUSE THE ARRAY STARTS AT ZERO AND WE WANT TO PRINT OUT FROM 1
				System.out.println("ROW: " + r + " = " + rowSum);
			}
		}
		
		//PRINT OUT THE TOTALSUM
		System.out.println("SUM = " + grandTotal);

		//GET THE TOTAL NUMBER OF ELEMENTS IN THE 2D ARRAY
		totalElements = getTotalElementsAssignedByUser(myArray);
		
		//CHECK IF DIVIDING BY ZERO
		if (totalElements > 0) {
			//CALC AVERAGE OF THE WHOLE 2D ARRAY
			// REMEMBER THAT INT/INT WILL RETURN INT
			arrayAverage = grandTotal / totalElements;
			return arrayAverage;
		}

		return UNSET_VALUE;
	}
	
	
	
	// ************************************************************************************************
	// LOOP OVER ENTIRE 2D ARRAY AND SEE THE TOTAL VALUES THAT HAVE BEEN INPUTTED
	// IGNORE VALUES SET TO UNSET_VALUE
	// SAME AS THE BELOW BUT FOR INT
	// ************************************************************************************************
	private static int getTotalElementsAssignedByUser(int[][] myArray) {
		int totalNumElementsAssigned = 0;
		
		
		//LOOP OVER THE ROWS IN THE 2D ARRAY
		for (int rNum = 0; rNum < ROWS_MAX; rNum++) {
			//NOW LOOP OVER EACH COLUMN IN EACH ROW
			for (int cNum = 0; cNum < COLUMNS_MAX; cNum++) {
				//CHECK IF THE VALUES IS REAL AND NOT SOME UNSET VALUE
				if (myArray[rNum][cNum] != UNSET_VALUE) {
					//COUNT HOW MANY ELEMENTS HAVE BEEN INPUTTED AND 
					totalNumElementsAssigned = totalNumElementsAssigned + 1;
				}
			}
		}

		return totalNumElementsAssigned;
	}
	
	
	// ************************************************************************************************
	// LOOP OVER ENTIRE 2D ARRAY AND SEE THE TOTAL VALUES THAT HAVE BEEN INPUTTED
	// IGNORE VALUES SET TO UNSET_VALUE
	// SAME AS THE ABOVE BUT FOR A DOUBLE
	// ************************************************************************************************
	private static int getTotalElementsAssignedByUser(double[][] myArray) {
		int totalNumElementsAssigned = 0;
		for (int rNum = 0; rNum < ROWS_MAX; rNum++) {
			for (int cNum = 0; cNum < COLUMNS_MAX; cNum++) {
				if (myArray[rNum][cNum] != UNSET_VALUE) {
					totalNumElementsAssigned = totalNumElementsAssigned + 1;
				}
			}
		}

		return totalNumElementsAssigned;
	}

	private void printSumAndAverage() {
		double averageSentBack = calc2dArrayAverage(this.my2DArray);
		System.out.println("AVG = " + averageSentBack);
	}

	private void printSumAndAverageDouble() {
		double averageSentBack = calc2dArrayAverage(this.my2DArrayDouble);
		System.out.println("AVG = " + averageSentBack);
	}

	
	// ************************************************************************************************
	// PRINT OUT VALUES SET BY THE USER OF 2D ARRAY 
	// ************************************************************************************************
	public void print2DArray() {
		
		
		System.out.println("Has the integer values");
		
		
		//LOOP OVER THE 2D ARRAY
		//FIRST LOOP OVER THE ROWS IN THE ARRAY
		for (int rNum = 0; rNum < ROWS_MAX; rNum++) {
		
			//NOW FOR EACH ROW LOOP OVER EACH COLUMN IN THE ROW
			for (int cNum = 0; cNum < COLUMNS_MAX; cNum++) {
		
				
				if (my2DArray[rNum][cNum] != UNSET_VALUE) {
					if (cNum ==0) {	
						//IF THE FIRST ELEMENT IN THE ARRAY IS A REAL NUMBER FROM THE USER, PRINT A NEW LINE FIRST
						System.out.println();
						
					}
					System.out.print(my2DArray[rNum][cNum] +" ");
				}
				

			}
			

		}
		System.out.println();

	}

	
	
}
