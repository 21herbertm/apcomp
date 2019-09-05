package arrayProjects;



/*******************************************************************************************************************************/
//CLASS FOR ONE STUDENT AND THEIR GRADES
//TO USE ARRAY SORT MUST MAKE THIS CLASS IMPLEMENT TEMPLATE COMPARABLE
/*******************************************************************************************************************************/


/*
 * IN ORDER FOR THIS CLASS TO BE SORTABLE BY THE JAVA LIBS, WE MUST HAVE implents Comparable.....
 */
public class StudentGrades implements Comparable<StudentGrades> {

	//PRIVATE MEMBERS**************************************************************************
	private static final int MAX_GRADES=5;
	private double [] Grades = new double[MAX_GRADES];
	private double Average;
	private String Name;
	private int gradeAssigned=0;

	
	/*******************************************************************************************************************************/
	// THIS IS THE CONSTRUCTOR, IT JUST INITALIZES THE NEW FOR THE GRADES IS IN THE VARIABLE DECLARATION
	/*******************************************************************************************************************************/
	public StudentGrades() {		
		Name ="";
		Average=0.0;
		gradeAssigned=0;
	}

	
	
	
	/*******************************************************************************************************************************/
	//THIS IS ANOTHER CONSTRUCTOR WHERE AN ARRAY IS SENT IN AS INPUT
	//CONSTRUCTOR WHERE THE GRADE ARRAY IS FILLED
	/*******************************************************************************************************************************/
	public StudentGrades(String [] fileInputStrArray) {
	
		Name =fileInputStrArray[0];
		Average=0.0;
		gradeAssigned=0;

		
		
		//LOOP OVER THE INPUT ARRAY OR STRINGS, CONVERT IT AN PUT IT IN GRADES ARRAY OF DOUBLES
		for ( int i =0 ; i<MAX_GRADES; i++) {
			//THE GRADES START AT ARRAY SLOT 1, BECASE  NAME IS IN SLOT 0
			double num=Double.parseDouble(fileInputStrArray[i+1]);
			Grades[i]=num;
		}
		
		
	}

	/*******************************************************************************************************************************/
	//THIS IS NEEDED FOR THE JAVA LIB TO WORK ON THIS FOR SORT
	// FOR THE ARRAY SORT TO WORK NEED TO OVERRIDE THIS CLASS
	//TAKE IN A STUDENTGRADE AND COMPARE TO THIS AVERAGE
	/*******************************************************************************************************************************/
	@Override
	public int compareTo(StudentGrades o) {
		
		
		//THIS ALLOWS THE JAVA LIB TO PASS IN ANOTHER CLASS JUST LIKE THIS AND COMPARE IT
		
		//CHECK IF EITHER IS NULL
		if ((o == null) || (this == null)) {
			return -1;
		}
		
		
		//I DON'T KNOW WHY I NEEDED THIS BUT THE COMPLIER DID NOT LIKE double... IT WANTED Double
		Double d1 =new Double  (this.getAverage());
		Double d2 = new Double (o.getAverage() ); 
		
		
		//COMPARE THIS TO THE INPUT GETAVERAGE
	    if (this.getAverage()>o.getAverage())
	    	return -1;
	    if  (this.getAverage()<o.getAverage())
	    	return 1;
	    else 
	    	return 0;

	   
	}

	
	/*******************************************************************************************************************************/
	//CALCULATE THE AVERAGE FROM THE GRADES ARRAY
	/*******************************************************************************************************************************/
	public void calcAverage() {
		
		//LOCAL VAR FOR SUM
		double gradeSum=0;
		
		//LOOP OVER THE GRADES ARRAY
		for (int i =0; i< Grades.length ; i++) {
			//GET THE TOTAL SUM
			gradeSum= gradeSum + Grades[i];
		}
		//CALC AVERAGE AND SET THE CLASS MEMBER VAR TO IT
		Average= gradeSum/ (Grades.length);
	}
	

	/*******************************************************************************************************************************/
	//GETTER FOR PRIVATE MEMBER AVERAGE
	/*******************************************************************************************************************************/
	double  getAverage(){
		return Average;
	}
	

	/*******************************************************************************************************************************/
	//GETTER FOR PRIVATE MEMBER NAME
	/*******************************************************************************************************************************/
	public String getName() {
		return Name;
	}

	

	/*******************************************************************************************************************************/
	//SETTER FOR PRIVATE MEMBER NAME
	/*******************************************************************************************************************************/
	public void setName(String name) {
		Name = name;
	}


	/*******************************************************************************************************************************/
	//GETTER FOR PRIVATE MEMBER GRADES
	/*******************************************************************************************************************************/
	public double[] getGrades() {
		return Grades;
	}


	/*******************************************************************************************************************************/
	//SETTER FOR PRIVATE MEMBER GRADES WITH AN ARRAY
	/*******************************************************************************************************************************/
	public void setGrades(double[] grades) {
		Grades = grades;
	}
	public void setOneGrade(int g) {
		Grades[gradeAssigned] = g;
		gradeAssigned++;
	}


	/*******************************************************************************************************************************/
	//SETTER FOR PRIVATE MEMBER AVERAGE
	/*******************************************************************************************************************************/
	
	public void setAverage(double average) {
		Average = average;
	}

	
	
	/*******************************************************************************************************************************/
	//CONVERT CLASS TO A STRING SO THAT IT CAN BE PRINTED OUT EASIER
	//RETURNS A STRING
	/*******************************************************************************************************************************/
	public String toString() {
		if (Name =="") {
			return "";
		}
		String output= "Name: " + Name + " Average:" + Average ;
		if (Grades!=null){
			for (int row =0; row < MAX_GRADES; row++) {
			
					output +=  " Grade:" +  Grades[row];
			}
		}
		output += "\n";
		return output;
	}


}
