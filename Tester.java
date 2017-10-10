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
	    XYChart chart1 = exampleChart.getChart1();
	    new SwingWrapper<XYChart>(chart1).displayChart();
	    
	    /*Chart exampleChart2 = new Chart();
	    XYChart chart2 = exampleChart2.getChart2();
	    new SwingWrapper<XYChart>(chart2).displayChart();
	*/
	}
	/*
	 * Tests execution of entire calculatian of variance (displays different variances)
	 */
	public static void testExecution(int numberOfDataPoints){
		
		//dummy list
		
		
		//create dummy funds
		ArrayList<Double> dataPoints1 = new ArrayList<Double>();
		ArrayList<Double> dataPoints2 = new ArrayList<Double>();
		ArrayList<Double> dataPoints3 = new ArrayList<Double>();
		ArrayList<Double> dataPoints4 = new ArrayList<Double>();
		ArrayList<Double> dataPoints5 = new ArrayList<Double>();
		ArrayList<Double> dataPoints6 = new ArrayList<Double>();
		ArrayList<Double> dataPoints7 = new ArrayList<Double>();
		ArrayList<Double> dataPoints8 = new ArrayList<Double>();
		ArrayList<Double> dataPoints9 = new ArrayList<Double>();
		ArrayList<Double> dataPoints10 = new ArrayList<Double>();
		ArrayList<Fund> funds = new ArrayList<Fund>();
		
		dataPoints1.add(0.1);
		dataPoints1.add(0.12);
		dataPoints1.add(0.04);
		dataPoints1.add(-0.12);
		dataPoints1.add(0.08);
		dataPoints1.add(0.09);
		dataPoints1.add(0.25);
		dataPoints1.add(0.10);
		dataPoints1.add(-0.04);
		dataPoints1.add(0.10);
		
		Fund fund1 = new Fund("Fund A", dataPoints1);
		funds.add(fund1);
		
		dataPoints2.add(0.20);
		dataPoints2.add(0.22);
		dataPoints2.add(0.065);
		dataPoints2.add(-0.30);
		dataPoints2.add(.25);
		dataPoints2.add(-.10);
		dataPoints2.add(.07);
		dataPoints2.add(.15);
		dataPoints2.add(-.05);
		dataPoints2.add(0.27);
		
		Fund fund2 = new Fund("Fund B", dataPoints2);
		funds.add(fund2);
		
		dataPoints3.add(0.14);
		dataPoints3.add(0.10);
		dataPoints3.add(0.25);
		dataPoints3.add(-.10);
		dataPoints3.add(0.05);
		dataPoints3.add(0.06);
		dataPoints3.add(0.40);
		dataPoints3.add(-.35);
		dataPoints3.add(0.13);
		dataPoints3.add(0.05);
		dataPoints3.add(0.35);
		dataPoints3.add(-0.12);
		
		Fund fund3 = new Fund("Fund C", dataPoints3);
		funds.add(fund3);
		
		dataPoints4.add(0.06);
		dataPoints4.add(0.10);
		dataPoints4.add(0.25);
		dataPoints4.add(-.10);
		dataPoints4.add(0.05);
		dataPoints4.add(0.06);
		dataPoints4.add(0.40);
		dataPoints4.add(-.35);
		dataPoints4.add(0.13);
		dataPoints4.add(0.05);
		dataPoints4.add(0.35);
		dataPoints4.add(-0.12);
		
		Fund fund4 = new Fund("Fund D", dataPoints4);
		funds.add(fund4);
		
		dataPoints5.add(0.10);
		dataPoints5.add(0.10);
		dataPoints5.add(0.25);
		dataPoints5.add(-.16);
		dataPoints5.add(0.05);
		dataPoints5.add(0.06);
		dataPoints5.add(0.40);
		dataPoints5.add(-.35);
		dataPoints5.add(0.06);
		dataPoints5.add(0.12);
		dataPoints5.add(0.34);
		dataPoints5.add(-0.04);
		
		Fund fund5 = new Fund("Fund E", dataPoints5);
		funds.add(fund5);
		
		dataPoints6.add(0.12);
		dataPoints6.add(-0.10);
		dataPoints6.add(0.25);
		dataPoints6.add(0.32);
		dataPoints6.add(-0.05);
		dataPoints6.add(-0.06);
		dataPoints6.add(0.40);
		dataPoints6.add(-.35);
		dataPoints6.add(0.13);
		dataPoints6.add(0.09);
		dataPoints6.add(0.34);
		dataPoints6.add(-0.10);
		
		Fund fund6 = new Fund("Fund F", dataPoints6);
		funds.add(fund6);
		
		dataPoints7.add(0.18);
		dataPoints7.add(0.08);
		dataPoints7.add(0.09);
		dataPoints7.add(-.10);
		dataPoints7.add(0.30);
		dataPoints7.add(-.20);
		dataPoints7.add(0.51);
		dataPoints7.add(-.35);
		dataPoints7.add(0.06);
		dataPoints7.add(0.09);
		dataPoints7.add(0.08);
		dataPoints7.add(-0.04);
		
		Fund fund7 = new Fund("Fund G", dataPoints7);
		funds.add(fund7);
		
		dataPoints8.add(0.20);
		dataPoints8.add(0.10);
		dataPoints8.add(-0.09);
		dataPoints8.add(-.16);
		dataPoints8.add(-0.05);
		dataPoints8.add(-0.20);
		dataPoints8.add(0.34);
		dataPoints8.add(-.35);
		dataPoints8.add(0.12);
		dataPoints8.add(-0.12);
		dataPoints8.add(0.34);
		dataPoints8.add(-0.04);
		
		Fund fund8 = new Fund("Fund H", dataPoints8);
		funds.add(fund8);
		
		dataPoints9.add(0.10);
		dataPoints9.add(0.10);
		dataPoints9.add(0.25);
		dataPoints9.add(0.17);
		dataPoints9.add(0.05);
		dataPoints9.add(0.16);
		dataPoints9.add(0.09);
		dataPoints9.add(-.15);
		dataPoints9.add(0.06);
		dataPoints9.add(0.22);
		dataPoints9.add(0.34);
		dataPoints9.add(-0.04);
		
		Fund fund9 = new Fund("Fund I", dataPoints9);
		funds.add(fund9);
		
		dataPoints10.add(-0.09);
		dataPoints10.add(-.08);
		dataPoints10.add(0.25);
		dataPoints10.add(-.10);
		dataPoints10.add(0.29);
		dataPoints10.add(0.29);
		dataPoints10.add(-0.40);
		dataPoints10.add(0.35);
		dataPoints10.add(0.36);
		dataPoints10.add(0.29);
		dataPoints10.add(0.34);
		dataPoints10.add(-0.04);
		
		Fund fund10 = new Fund("Fund J", dataPoints10);
		funds.add(fund10);
		
		
		//populates list of funds with dummy data
		/*for(int i=0; i<3; i++){
			ArrayList<Double> dataPoints = new ArrayList<Double>();
			for(int j=0; j<20; j++){
				//generates random numbers between 0-15
				dataPoints.add(Math.floor((Math.random() * 12)));
				
			}
			Fund fund = new Fund(String.valueOf(i), dataPoints);
			funds.add(fund);
		}
		*/
		//test execution
		CalculateVariance.Execute(funds, numberOfDataPoints);
		//return optimal result 
		
		
		//System.out.println(CalculateVariance.listOfVariances.size());
		System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("     VARIANCE               RETURNS                              FUND A                      FUND B                     FUND C                          FUND D                      FUND E                         FUND F                         FUND G                    FUND H                      FUND I                      FUND J" );
		for(int i=0; i<CalculateVariance.listOfVariances.size(); i++){
			double roundedVariance = CalculateVariance.listOfVariances.get(i).getVariance();
			System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
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
		CalculateVariance.getOptimalResult();
		
	}
	/*
	 * generates random weights
	 */
	public static void testGenerateRandomWeights(){
		double numberOfFunds = 3;
		
		System.out.println("TEST CASE-->[Generates random weight options]: ");
		CalculateVariance.generateRandomWeights(numberOfFunds,100000);
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
		
		dataPoints1.add(0.1);
		dataPoints1.add(0.12);
		dataPoints1.add(0.04);
		dataPoints1.add(-0.22);
		dataPoints1.add(0.16);
		dataPoints1.add(0.03);
		dataPoints1.add(0.04);
		dataPoints1.add(0.10);
		dataPoints1.add(-0.04);
		dataPoints1.add(0.10);
		
		dataPoints2.add(0.02);
		dataPoints2.add(0.22);
		dataPoints2.add(0.065);
		dataPoints2.add(-0.30);
		dataPoints2.add(.25);
		dataPoints2.add(-.10);
		dataPoints2.add(.07);
		dataPoints2.add(.1);
		dataPoints2.add(-.05);
		dataPoints2.add(0.2);
		
		
		dataPoints3.add(0.06);
		dataPoints3.add(0.10);
		dataPoints3.add(0.25);
		dataPoints3.add(-.10);
		dataPoints3.add(0.05);
		dataPoints3.add(0.06);
		dataPoints3.add(0.40);
		dataPoints3.add(-.35);
		dataPoints3.add(0.13);
		dataPoints3.add(0.05);
		dataPoints3.add(0.35);
		dataPoints3.add(-0.12);
		
		
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
