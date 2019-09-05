package arrayProjects;
import java.io.*; 
import java.util.*;


/*******************************************************************************************************************************/
//THIS CLASS WILL HOUSE ALL THE THE STUDENTS IN AN ARRAY
//IT USES THE StudentGrades CLASS IN AN ARRAY
//THE STUDENT INFORMATION IS ONE LINE IN A FILE WITH THE FOLLOWING FORMAT:
//NAME GRADE1 GRADE2 GRADE3 GRADE4 GRADE5
//
//THE MEMORY FOR THE STUDENT ARRAY IS ALLOCATED JUST BEFORE READING IN THE FILE, BY COUNTING THE NUMBER OF LINES  
/*******************************************************************************************************************************/

public class ClassRoomGrades {
	
	

	
	//WILL ALLOCATE SPACE DEPENDING ON THE NUMBER OF ROWS IN THE FILE INSTEAD OF DOING private StudentGrades   allStudentsArray[]= new StudentGrades[MAX_STUDENTS];
	//ARRAYS ARE REALLY NO FUN BECAUSE THE NUMBER OF OBJECTS CAN NOT BE CHANGED ONCE IT IS CREATED //private StudentGrades   allStudentsArray[]= new StudentGrades[MAX_STUDENTS];
	//...REALLY SHOULD USE THE COLLECTION ARRAYLIST INSTEAD
	private StudentGrades   allStudentsArray[];
	

	//private static final int MAX_STUDENTS =25;

	//WILL READ THIS IN SO THAT NEXT PROGRAM CAN READ IN 1000 LINES
	private int max_students;
	
	
	ClassRoomGrades (int max){
		max_students=max;
	}
	
	/*******************************************************************************************************************************/
	//READ INPUT FILE AND ASSIGN MEMORY IN THE ARRARY FOR IT. ASSUME ONE LINE IS ONE STUDENTGRADE OBJECT 
	//1)OPEN FILE
	//2)ALLOCATE THE CORRECT AMOUNT FOR THE NUMBER OF LINES IN THE FILE, DON'T GO OVER MAX
	//3)READ IN FILE LINE BY LINE
	//4)IF NOT OVER THE LENGTH OF ARRAY ALREADY ALLOCATED, SET THE ROW TO A NEW STUDENTGRADE OBJECT 
	//5)IF OVER THE LENGTH OF THE ARRAY, IGNORE THE LINE
	/*******************************************************************************************************************************/
	
	public void readInputFile(String fileName) {
		File file = new File(fileName); 
	
		try {
			
			
			//ALLOCATE MEMORY FOR THE #LINES OF THE FILE BY USING THE FUNCTION BELOW 
			addMemoryForFileLength(file);
			
			//OPEN FILE
			BufferedReader br = new BufferedReader(new FileReader(file)); 

			String inputStr="";
			int row=0;
			
			
			//READ ONE LINE OF THE FILE
			while ((inputStr = br.readLine()) != null) {
				

				//MAKE SURE WE HAVE ASSIGNED ENOUGH MEMORY BY CHECKING LENGTH OF ARRAY 
				if (row <allStudentsArray.length) {
					
					//SPLIT IN THE INPUT BY SPACE INTO AN ARRAY OF STRINGS
					String[] fileInputStrArray = inputStr.split(" ");		
					
					
					allStudentsArray[row]= new StudentGrades(fileInputStrArray);
			
				}else {
					System.out.println("Number of lines are over the allocated amount : "+max_students +" ....not reading in");
				}
				row++;
			} 
		} catch (NumberFormatException | IOException e) {
			System.err.println("file Not found");
		}
	}
	
	
	/*******************************************************************************************************************************/
	//INSTEAD OF HARD CODING THE VALUE OF MEMORY IN THE ARRAY
	//ADD MEMORY TO ALLSTUDENTSARRAY DEPENDING ON HOW MANY LINES ARE IN THE FILE
	//EACH LINE IS ONE STUDENT
	//IF THE NUMBER OF LINES ARE OVER THE MAX STUDENTS ALLOWED, RESET TO MAX_STUDENTS
	
	/*******************************************************************************************************************************/
	public void addMemoryForFileLength(File file)  {
		
		//COUNT HOW MANY LINES ARE IN THE FILE... THIS IS HOW MANY ELEMENTS WE WILL HAVE IN OUR ARRAY
		int rowCount=0;
		try{
			//OPEN THIE FILE
			BufferedReader br = new BufferedReader(new FileReader(file)); 

		
			//INCREASE THE ROWCOUNT UNTIL THE END OF FILE
			while ((br.readLine()) != null) {			
				rowCount++;
			} 
			
			//JUST DOING THIS BECAUSE THE INSTRUCTIONS SAID DON'T GO OVER THE MAX...BUT REALLY i CAN ADD AS MUCH MEMORY AS i WANT
			//IF THE ROWCOUNT IS OVER THE MAX...LIMIT IT TO THE MAX
			if (rowCount > max_students) {
				System.out.println("The number of lines in the file are over the Max allowed...Setting to Max amount");
				rowCount = max_students;
			}
			
		
			//NOW THAT i HAVE THE ROWCOUNT I CAN NEW THE ARRAY OF STUDENTGRADES
			//THIS IS IN TWO PARTS 
			
			//1) ALLOCATE SPACE FOR THE ARRAY 
			allStudentsArray= new StudentGrades[rowCount];
			
			//2) ALLOCATE MEMORY FOR EACH SLOT THE ARRAY OF STUDENTS SO THEY WILL NOT BE NULL
			for (int row =0; row< rowCount; row ++) {
				allStudentsArray[row]= new StudentGrades();
			}

		} catch (NumberFormatException | IOException e) {
			System.err.println("file Not found");
		}
	
	
	
	}
	
	/*******************************************************************************************************************************/
	//CALCULATE THE AVERAGE FOR ALL THE STUDENTGRADE OBJECTS IN THE ARRAY
	/*******************************************************************************************************************************/
	public void setAllAverages( ) {
		int row=0;	
		//LOOP OVER THE WHOLE ARRAY
		while (row<allStudentsArray.length) {
			//MAKE SURE IT IS NOT NULL ( CAN'T CALL A MEMEBER OF A CLASS IF NO MEMORY HAS BEEN ALLOCATED AND IT'S NULL)
			if ( allStudentsArray[row] != null) {
				//CALL THE FUNCTION CALCAVERAGE THAT IS IN THE STUDENTGRADES AVERAGE
				allStudentsArray[row].calcAverage();
			}
			row++;
		}
		
	}
	
	
	/*******************************************************************************************************************************/
	//USE A BUBBLE SORT. A BUBBLE SORT WORKS BY COMPARING EACH ELEMENT WITH THE ONE ABOVE IT AND SWITCHING IT IF IT IF THE UPPER VALUE IS LESS 
	//THIS ALLOWS THE VALUES TO "BUBBLE" UP ONE BY ONE
	// ANOTER WORDS
	//FOR THE LENGTH OF THE ARRAY,
	//COMPARE THE PREVIOUS ROW WITH THE ONE ABOVE IT
	//IF IT NEEDS TO BE SWITCHED USE A TEMP OBJECT TO HOLD THE UPPERROW WHILE YOU COPY THE LOWERROW INTO IT
	/*******************************************************************************************************************************/
	void bubbleSort() {
	      int arrayLenth = allStudentsArray.length;
	      StudentGrades  temp = null;

	      //FOR A BUBBLE SORT, LOOP OVER THE ARRAY
	      for(int lowerRow = 0; lowerRow < arrayLenth; lowerRow++) {
	    	  //NOW COMPARE THE ELEMENT WITH THE ELEMENT ABOVE IT ( ARRAY SLOT 0 COMPARED TO ARRAY SLOT 1)
	    	  //IF THE UPPER AVERAGE IS LESS THEN ... SWITCH IT 
	         for(int upperRow=1; upperRow < (arrayLenth-lowerRow); upperRow++) {
	            if(allStudentsArray[upperRow-1].getAverage() < allStudentsArray[upperRow].getAverage()) {
	            	
	            	
	            	//DO A SWITCHAROO USING A TEMP OBJECT TO HOLD THE LOWER
	               temp = allStudentsArray[upperRow-1] ;
	               allStudentsArray[upperRow-1]=allStudentsArray[upperRow] ;
	               allStudentsArray[upperRow]=temp;
	            }
	         }
	      }
	   }
	
	
	/*******************************************************************************************************************************/
	//toString will convert the entire object to a String so that it can be printed out easily
	/*******************************************************************************************************************************/	
	public String toString() {
		
		String output="";
		
		//ALWAYS CHECK FOR NULL BECAUSE MEMORY IS ALLOCATED FROM FILE READ
		if (allStudentsArray!=null){
			for (int row =0; row < allStudentsArray.length; row++) {
				if (allStudentsArray[row] !=null){
					output +=  allStudentsArray[row].toString();
				}
			}
		}
		output += "\n";
		return output;
	}
	
	//GETTER FOR THE MEMBER ALLSTUDENTSARRAY
	public StudentGrades[] getAllStudentsArray() {
		return allStudentsArray;
	}

	//SETTER FOR ALL STUDENTS ARRAY
	public void setAllStudentsArray(StudentGrades[] allStudentsArray) {
		this.allStudentsArray = allStudentsArray;
	}


	//GETTER FOR MAXSTUDENTS
	public int getMaxStudents() {
		return max_students;
	}

	/*******************************************************************************************************************************/
	//MAIN PROGRAM 
	/*******************************************************************************************************************************/
	
	
	public static void main(String[] args) {
		try {
			
			//NEW THIS CLASS
			ClassRoomGrades  allMyStudentsGrades= new ClassRoomGrades(25);
			
			//CREATE THE MEMORY FOR THE ARRAY AND READ THE INFO FROM FILE  
			allMyStudentsGrades.readInputFile("./studentGrades.txt");
			
			//SET THE AVERAGE FOR ALL STUDENTS
			allMyStudentsGrades.setAllAverages();
			
			//SORT USING ARRAY SORT
			Arrays.sort(allMyStudentsGrades.allStudentsArray);
			System.out.println(allMyStudentsGrades.toString());
		
			//BUBBLE SORT
			allMyStudentsGrades.bubbleSort();
			System.out.println(allMyStudentsGrades.toString());
		}catch ( Exception e) {
			System.err.println(e.toString());
		}

		
	}

}
