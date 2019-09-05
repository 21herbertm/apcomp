package arrayProjects;
import java.util.Random; 
public class EZ_8 {

	public EZ_8() {
		
	}

	public static void main(String[] args) {
		double sum=0;
		int numNeededForGreaterThenOne=0;
		EZ_8 ez= new EZ_8();
		for (int programNum=0; programNum < MAX_PROGRAM_RUN; programNum++) {
			for (int nTriesNum=0; nTriesNum<N_TRIES;nTriesNum++) {

				sum=0;
				numNeededForGreaterThenOne=0;
				while ( sum <1) {
					numNeededForGreaterThenOne++;
					double randNum=ez.generateDecRandom(0.0,1.0);

					//System.out.println("Random num:" + randNum);

					sum+=randNum;

				}
				//System.out.println("Num needed" + numNeededForGreaterThenOne);
				ez.numNeededArray[nTriesNum]= numNeededForGreaterThenOne;
			}

			double sumOfNums=0.0;
			for( int i=0; i<N_TRIES; i++) {
				sumOfNums+=ez.numNeededArray[i];
				//System.out.println("Num needed" + ez.numNeededArray[i] );
			}
			double averageOfNumsNeeded= sumOfNums/N_TRIES;

			System.out.println("ANSWER e or aprox " + averageOfNumsNeeded);
		}
	}

	
	double generateDecRandom(double min, double max) {
	    Random r = new Random();
	    
	    //MULTIPLY BY 10 AND DEVIDE TO MAKE A FRACTION
	    
	    return (r.nextInt((int)((max-min)*10+1))+min*10) / 10.0;
	}
	
	
	
	private int numNeededArray []= new int[N_TRIES];
	private static final int N_TRIES=10; 
	private static final int MAX_PROGRAM_RUN=1000;
}
