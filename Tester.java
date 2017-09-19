///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: Tester.java
//
// Summary: Tester class tests the following methods in Calculate Variance and Chart--> 
//          
//			{testChart: tests input of data points and visualization of graph}
//          {SSN: User identification }
//          {User's Age: Used for calculation of years that interest will accumulate}
//			{User's Retirement Age: Used for calculation of years that interest will accumulate}
//			{Yearly Contribution: Used to calculate how much their money increases each year}
//			{Rate: Usually a fixed number that determines growth of investment}
//			{Years: Years calculated based on user's age and retirement age}
// 
//			The user's total return is calculated here based on the fields above. 
//
///////////////////////////////////////////////////////////////////////////////////////////


import java.util.ArrayList;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Tester {

	
	public static ArrayList<Fund> funds = new ArrayList<Fund>();
	
	/*
	 * Display chart
	 */
	public static void testChart(){
		Chart exampleChart = new Chart();
	    XYChart chart1 = exampleChart.getChart();
	    new SwingWrapper<XYChart>(chart1).displayChart();
	 
	}
	/*
	 * Tests execution of entire calculatian of variance (displays different variances)
	 */
	public static void testExecution(){
		
		//dummy list
		
		
		//create dummy funds
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();
		ArrayList<Double> dataPoints2 = new ArrayList<Double>();
		ArrayList<Double> dataPoints3 = new ArrayList<Double>();
		ArrayList<Fund> funds = new ArrayList<Fund>();
		
		//populates list of funds with dummy data
		for(int i=0; i<3; i++){
			ArrayList<Double> dataPoints = new ArrayList<Double>();
			for(int j=0; j<20; j++){
				//generates random numbers between 0-15
				dataPoints.add(Math.floor((Math.random() * 18)-9));
			}
			Fund fund = new Fund(String.valueOf(i), dataPoints);
			funds.add(fund);
		}
		
		//test execution
		CalculateVariance.Execute(funds);
		//System.out.println(CalculateVariance.listOfVariances.size());
		System.out.println("_____________________________________________________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("     VARIANCE               RETURNS                              FUND A                      FUND B                     FUND C");
		for(int i=0; i<CalculateVariance.listOfVariances.size(); i++){
			double roundedVariance = CalculateVariance.listOfVariances.get(i).getVariance();
			System.out.println("__________________________________________________________________________________________________________________________________________________");
			System.out.print(roundedVariance+"        ");
			System.out.print(CalculateVariance.listOfVariances.get(i).getReturn()+"%                ");
			for(int j=0; j<CalculateVariance.listOfVariances.get(i).getWeights().size(); j++){
				double value=0;
				value = CalculateVariance.listOfVariances.get(i).getWeights().get(j);
				//TODO just showing values in terms of percentages 
				//value = value*100;
				//value = Math.round(value);
				System.out.print(value+"%        ");
			}
			System.out.println();
		}
		
	}
	/*
	 * generates random weights
	 */
	public static void testGenerateRandomWeights(){
		double numberOfFunds = 3;
		
		System.out.println("TEST CASE-->[Generates random weight options]: ");
		CalculateVariance.generateRandomWeights(numberOfFunds);
	}
	
	/*
	 * Tests that the list of weights generated are stored
	 */
	public static void testStorageOfWeights(){
		
		ArrayList<ArrayList<Double>> listOfWeights = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> weights = new ArrayList<Double>();
		
		CalculateVariance.listAllPossibleWeightsUsingPermutations(3, 100, weights, listOfWeights);
		
		}
	
	
	/*
	 * Tests covariance based on randomly generated dummy data.
	 */
	public static void testGetCovariance(){

		//creates dummy lists of data points
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();
		ArrayList<Double> dataPoints2 = new ArrayList<Double>();
				
		//populates both lists with random numbers (random range of values as well)
		for (int i=0; i<1000; i++){
			dataPoints1.add(Math.floor(Math.random()*11));
		}
		for (int i=0; i<1000; i++){
			dataPoints2.add(Math.floor(Math.random()*11));
		}
				
		//creates two dummy funds
		Fund fund1 = new Fund("Fund A", dataPoints1);
		Fund fund2 = new Fund("Fund B", dataPoints2);
		
		System.out.println("TEST CASE-->[Calculates Co-variance]: "+ CalculateVariance.getCovariance(fund1, fund2));
	}
	
	/*
	 * Tests individual funds' standard deviations based on dummy data. 
	 */
	public static void testFindStandardDeviation(){
		
		//creates dummy list of data points
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();
		
		//populates list with random numbers (random range of values as well)
		for (int i=0; i<1000; i++){
			dataPoints1.add(Math.floor(Math.random()*11));
		}
		
		//creates a dummy fund
		Fund fund = new Fund("Fund A", dataPoints1);
		
		//calls findStandardDeviation method
		System.out.println("TEST CASE--> [Standard Deviation (Individual Fund)]: "+CalculateVariance.findStandardDeviation(fund, fund.getPercentageOfGrowth().size()));
	}
	
	/*
	 * Tests number of data points used for co-variance formula. 
	 * Compares two funds based on amount of data points and cuts off
	 * one fund based on the other (smallest) fund's data points. 
	 */
	public static void testFindNumberOfDataPoints(){
		
		//creates dummy lists of data points
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();
		ArrayList<Double> dataPoints2 = new ArrayList<Double>();
		
		//populates both lists with random numbers (random range of values as well)
		for (int i=0; i<Math.floor(Math.random()*100); i++){
			dataPoints1.add(Math.floor(Math.random()*11));
		}
		for (int i=0; i<Math.floor(Math.random()*100); i++){
			dataPoints2.add(Math.floor(Math.random()*11));
		}
		
		//creates two dummy funds
		Fund fund1 = new Fund("Fund A", dataPoints1);
		Fund fund2 = new Fund("Fund B", dataPoints2);
		
		//calls function and prints value (number of data points to be used)
		System.out.println("TEST CASE-->[Number of Data Points]: "+CalculateVariance.findNumberOfDataPoints(fund1, fund2));
		
	}
	
	/*
	 * 
	 */
	public static void testSum(){
		
	}
	
	/*
	 * 
	 */
	public static void testMean(){
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();

		//adds random data points from 0-10
		//for (int i=0; i<Math.floor(Math.random()*100); i++){
			//dataPoints1.add(Math.floor(Math.random()*11));
		//}
		//manual entry if necessary 
		
		dataPoints1.add(2.3);
		dataPoints1.add(1.3);
		dataPoints1.add(1.5);
		dataPoints1.add(1.8);
		dataPoints1.add(2.0);
		dataPoints1.add(4.9);
		dataPoints1.add(0.9);
		dataPoints1.add(2.4);
		dataPoints1.add(4.8);
		dataPoints1.add(5.6);
		dataPoints1.add(9.0);
		dataPoints1.add(1.3);
		
		
		Fund fund = new Fund("Fund A", dataPoints1);
		System.out.println("TEST CASE-->[Mean (Individual Fund)]: "+CalculateVariance.findMean(fund, dataPoints1.size()-1));
	}
	@SuppressWarnings("null")
	public static void testVariance(){
		
		
		ArrayList<Double> weights = new ArrayList<Double>();
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();
		ArrayList<Double> dataPoints2 = new ArrayList<Double>();
		ArrayList<Double> dataPoints3 = new ArrayList<Double>();
		ArrayList<Fund> funds = new ArrayList<Fund>();
		
		//populates list of funds with dummy data
		/*for(int i=0; i<10; i++){
			ArrayList<Double> dataPoints = new ArrayList<Double>();
			for(int j=0; j<20; j++){
				//generates random numbers between 0-15
				dataPoints.add(Math.floor(Math.random() * 16));
			}
			Fund fund = new Fund(String.valueOf(i), dataPoints);
			funds.add(fund);
			
			
		}*/
		
		dataPoints1.add(2.3);
		dataPoints1.add(1.3);
		dataPoints1.add(1.5);
		dataPoints1.add(1.8);
		dataPoints1.add(2.0);
		dataPoints1.add(4.9);
		dataPoints1.add(0.9);
		dataPoints1.add(2.4);
		dataPoints1.add(4.8);
		dataPoints1.add(5.6);
		dataPoints1.add(9.0);
		dataPoints1.add(1.3);
		
		dataPoints2.add(1.2);
		dataPoints2.add(1.3);
		dataPoints2.add(5.9);
		dataPoints2.add(6.9);
		dataPoints2.add(7.2);
		dataPoints2.add(4.8);
		dataPoints2.add(2.1);
		dataPoints2.add(9.0);
		dataPoints2.add(3.2);
		
		dataPoints3.add(2.4);
		dataPoints3.add(2.5);
		dataPoints3.add(2.8);
		dataPoints3.add(2.9);
		dataPoints3.add(3.0);
		dataPoints3.add(1.4);
		dataPoints3.add(1.2);
		dataPoints3.add(0.9);
		dataPoints3.add(4.8);
		dataPoints3.add(4.0);
		dataPoints3.add(3.9);
		dataPoints3.add(1.2);
		dataPoints3.add(3.9);
		dataPoints3.add(5.0);
		dataPoints3.add(4.7);
		dataPoints3.add(3.9);
		
		Fund fund1 = new Fund("Fund A", dataPoints1);
		Fund fund2 = new Fund("Fund B", dataPoints2);
		Fund fund3 = new Fund("Fund C", dataPoints3);
		
		funds.add(fund1);
		funds.add(fund2);
		funds.add(fund3);
		
		weights.add(56.0);
		weights.add(12.0);
		weights.add(32.0);
		
		System.out.println("TEST CASE-->[Calculates Variance]: "+CalculateVariance.findVariance(funds, weights));
		
		/*ArrayList<Double> listOfWeights = new ArrayList<Double>();
		CalculateVariance.listAllPossibleWeightsUsingPermutations(3, 100, listOfWeights);
		for(int i=0; i<CalculateVariance.listOfListOfWeights.size();i++){
			System.out.println("TEST CASE-->[Calculates Variance]: "+CalculateVariance.findVariance(funds, CalculateVariance.listOfListOfWeights.get(i)));
		}*/
		
		/*
		 * tests sort method for listOfVariances
		 */
		
		
		
	}
}
