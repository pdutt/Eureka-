///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: VarianceInfo.java
//
// Summary: Variance Info is an object that stores already calculated information 
//			uploaded using certain weights per fund, the expected variance, the expected 
//			return, as well as the list of the original funds used in the formulas. 
//			
//			A list of these Variance Info objects is generated in order to map out 
//			the most valuable returns and lowest variances in a chart. 
//			Main method for calling all user test cases, as well as user input for funds.
//			
//			
//			The risk of funds are contingent on the average variance and returns that are
//			predicted based on previous data for each individual fund. The variance 
//			is calculated with randomly generated weights (percentages) that are tested
//			on each group of funds. The returns are then created based on the different
//			averages for each fund (using previous data points 
//
///////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;


public class VarianceInfo {

	double variance;
	double returns;
	ArrayList<Double> weights = new ArrayList<Double>();
	
	//TODO: this list of funds is not populated yet -- do I need this at all?
	ArrayList<Fund> funds = new ArrayList<Fund>();
	
	public VarianceInfo(double variance, double returns, ArrayList<Double> weights){
		this.variance = variance;
		this.weights = weights;
		this.returns = returns;
	}
	
	/*
	 * returns the expected variance.
	 */
	public double getVariance(){
		return variance;
	}
	
	/*
	 * sets value of the variance. 
	 */
	public void setVariance(double variance){
		this.variance = variance;
	}
	
	/*
	 * returns list of weights. 
	 */
	public ArrayList<Double> getWeights(){
		return weights;
	}
	
	/*
	 * returns the expected return. 
	 */
	public double getReturn(){
		return returns;
	}
	
	/*
	 * sets the return. 
	 */
	public void setReturn(double returns){
		this.returns = returns;
	}
	
}
