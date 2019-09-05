package arrayProjects;

import java.util.Arrays;

public class SortComparison_3 {

	public SortComparison_3() {
		
	}

	public static void main(String[] args) {
		
		SortComparison_3 s= new SortComparison_3();
		
		ClassRoomGrades roomgrades1= new ClassRoomGrades(10500);
		roomgrades1.readInputFile("./students1000.txt");
		s.timeTheSorts(roomgrades1);
		
	
		ClassRoomGrades roomgrades2= new ClassRoomGrades(10500);
		roomgrades2.readInputFile("./students1000.txt");
		s.timeTheSorts(roomgrades2);
		
		ClassRoomGrades roomgrades3= new ClassRoomGrades(10500);
		roomgrades3.readInputFile("./students1000.txt");
		s.timeTheSorts(roomgrades3);
		


	}

	
	private void timeTheSorts(ClassRoomGrades a) {

		long start = 0, end = 0, diff_sort = 0, diff_bubble = 0;
	
		// SORT USING ARRAY SORT
		start = System.currentTimeMillis();
		Arrays.sort(a.getAllStudentsArray());
		end= System.currentTimeMillis();
		diff_sort= end-start;

		// BUBBLE SORT
		start = System.currentTimeMillis();
		a.bubbleSort();
		end= System.currentTimeMillis();
		diff_bubble= end-start;
		
		
		System.out.println("Java sort time:"+ diff_sort + " Bubble sort time: " + diff_bubble);
		if ( diff_sort <diff_bubble) {
			System.out.println("Java Sort is faster");
		}else if (diff_bubble < diff_sort) {
			System.out.println("Bubble Sort is faster");
		}else {
			System.out.println("Both sorts took the same time");
		}
		
		
	
	}
	
	
}
