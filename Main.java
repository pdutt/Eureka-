///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: Main.java
//
// Summary: Main method for calling all user test cases, as well as user input for funds.
//			
//			The risk of funds are contingent on the average variance and returns that are
//			predicted based on previous data for each individual fund. The variance 
//			is calculated with randomly generated weights (percentages) that are tested
//			on each group of funds. The returns are then created based on the different
//			averages for each fund (using previous data points as well), and their respective
//			weight percentages. High values of returns are paired with low variance values
//			in order to create the optimal investment portfolio.
//			
//			sources: 
//
//			(Variance) http://www.ewp.rpi.edu/hartford/~youneh/INVII/Week%204/mv_analysis_2up.pdf
//			(Co-variance) http://ci.columbia.edu/ci/premba_test/c0331/s7/s7_5.html
//
///////////////////////////////////////////////////////////////////////////////////////////

import java.io.IOException;

/*
 * TODO Important Note: Try changing number of data points to be inserted in graph.
 * Variance significantly decreases as more data points are added. 
 * 
 * TODO A good indicator of percentages chosen are if the data points with
 * the biggest weight percentage distribution has the least variety
 * in data (smallest variance).
 */

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * TODO: Create list of user objects (with user info) and use their input (years until retirement) to determine allocation
		 * of stocks vs bonds when distributing total investment.
		 */
	    
		//creates new instance of User Input 
		//(try to make this static?)
		UserInput input = new UserInput();
		
		Tester.testExecution(250);//number used is number of data points needed to test graph
		//Tester methods
		Tester.testMean();
		//Tester.testFindNumberOfDataPoints();
		Tester.testFindStandardDeviation();
		Tester.testGetCovariance();
		Tester.testVariance();
		//Tester.testGenerateRandomWeights();
		//input.read(1000); // integer parameter = number of data points on graph 
		Tester.testChart();
		
		//Tester.testStorageOfWeights();
			
		//executes user input
		//input.executeUserInput();
		
	}

}


