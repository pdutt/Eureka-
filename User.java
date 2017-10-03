///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: User.java
//
// Summary: Stores all user information--> 
//          {Name: User identification}
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

import java.lang.Math;

public class User {

	//field values for user 
	public String name;
	public int SocialSecurityNumber;
	public double age; 
	public double retirementAge;
	public double yearlyContribution;
	public double rate;
	public double years;
	public VarianceInfo varianceInfo;
	
	//constructor
	public User(String name, int SSN, double age, double retirementAge, double yearlyContribution, double rate){
		this.name = name;
		SocialSecurityNumber = SSN;
		this.age = age;
		this.retirementAge = retirementAge; 
		this.yearlyContribution = yearlyContribution;
		this.rate = rate;
		years = retirementAge-age;
	}
	/*
	 * returns User's name
	 */
	public String getName(){
		return name;
	}
	
	/*
	 * sets user's name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/*
	 * sets user's variance info
	 */
	public void setVarianceInfo(VarianceInfo vInfo){
		varianceInfo = vInfo;
	}
	/*
	 * calculates user's total return
	 */
	public double totalReturn(){
		double totalReturn = 0.0;
		
		double x = 1+rate;
		double y = years+1;
		double z = Math.pow(x, y);
		
		z = z-x;
		z = z/rate;
		totalReturn = z*yearlyContribution;
		
		return totalReturn;
	}
	/*
	 * calls method in fund management that delivers optimal fund 
	 * TODO: Call Function
	 */
	public int[] optimalFundAllocation(){
		int[] arr = new int[15];
		return arr;
	}
}
