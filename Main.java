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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Main {

	public static void main(String[] args) throws IOException {
		
	    
		//creates new instance of User Input 
		//(try to make this static?)
		UserInput input = new UserInput();

		//Tester methods
		//Tester.testMean();
		//Tester.testFindNumberOfDataPoints();
		//Tester.testFindStandardDeviation();
		///Tester.testGetCovariance();
		//Tester.testVariance();
		//Tester.testGenerateRandomWeights();
		input.read();
		Tester.testExecution(1000);//number used is number of data points needed to test graph
		Tester.testChart();
		
		//Tester.testStorageOfWeights();
			
		//executes user input
		//input.executeUserInput();
		
	}

}


