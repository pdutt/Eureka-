///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: Fund.java
//
// Summary: Fund objects that stores the name, weight, mean, standard deviation,
//          and list of the data points (percentage of growth)
// 
//			Note: 
//
//			TODO Should also include boolean for whether or not it is a bond 
//			or stock. This will determine the ratio at which certain funds
//			are compared against each other. 
//
//			TODO Also need to include negative numbers in percentageOfGrowth
//			list. 
// 
//
///////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;


public class Fund {
	
	//properties of a fund
	String name;
	double weight;
	double mean;
	double standardDeviation;
	ArrayList<Double> percentageOfGrowth = new ArrayList<Double>();
	
	//constructor
	public Fund(String name, ArrayList<Double> percentageOfGrowth){
		this.name = name;
		this.percentageOfGrowth = percentageOfGrowth;
	}
	
	/*
	 * returns name of fund
	 */
	
	public String getName(){
		return name;
	}
	
	/*
	 * sets name
	 */
	public void setName(String name){
		this.name = name;
	}

	/*
	 * gets list of percentage of growth
	 */
	
	public ArrayList<Double> getPercentageOfGrowth(){
		return percentageOfGrowth;
	}
	
	/*
	 * gets mean (average) of all data points
	 */
	
	public double getMean(){
		return mean;
	}
	
	/*
	 * sets the fund's mean value
	 */
	public void setMean(double mean){
		this.mean = mean;
	}
	/*
	 * sets the standard deviation of the fund based on certain values
	 */
	
	/*
	 * Checks to see if stock or bond
	 */
	public boolean isStock(){
		if (name.contains("stock")){
			return true;
		}
		else{
			return false;
		}
	}
}
