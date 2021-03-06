///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: UserInput.java
//
// Summary: Class that determines prompts for user input. Right now, this is used for 
//			input of user's personal information to determine average growth of 
//			investment. The file input is used for uploading funds' data points
//			in order to determine the variance/return rate in the Calculate Variance
//			class.
//			
//
///////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.lang.Math;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class UserInput {
	
	User user;//creates new user object -- see User.java
	double yearlyDeposit;
	double age;
	double retirementAge;
	double rate = 0.07;
	String name;
	int SSN;
	
	/*
	 * executes calculations based on user input
	 */
	public void executeUserInput(){
		
	
	//creates scanner to read user input 
			Scanner scan = new Scanner(System.in);
			
			//prompts for name
			System.out.println("Enter name: ");
			name = scan.next();
			
			//prompts for SSN (MUST be an integer)
			System.out.println("Enter SSN: ");
			SSN = scan.nextInt();
			
			//prompts for monthly contribution and calculates yearly contribution
			System.out.println("Enter amount to put away monthly: ");
			yearlyDeposit = scan.nextDouble()*12;
			
			//prompts for user's age
			System.out.println("Enter age: ");
			age = scan.nextDouble();
			
			//prompts for user's predicted retirement age
			System.out.println("Enter retirement age: ");
			retirementAge = scan.nextDouble();
			
			//populates user values
			user = new User(name, SSN, age, retirementAge, yearlyDeposit,rate);
			
			//prints user's total balance
			System.out.println("Total Balance at the end of " +user.years+" years: "+ user.totalReturn());
	}
	
	/*
	 * populates fund objects based on excel data
	 */
	
		public void read(int numberOfDataPoints) throws IOException{
			File file = new File("/Users/pdutt/Documents/workspace/Eureka!/dummydata.txt");
		    Scanner scanner = new Scanner(file);
		    String temp = null;
		    String fund = null;
		    double valueOfFund = 0.0;
		    ArrayList<Double> listOfData = new ArrayList<Double>();
		    ArrayList<Fund> listOfFunds = new ArrayList<Fund>();
		    Fund newFund = null;
		    
		        while (scanner.hasNext()) {
		        	temp = scanner.next();
		            if (scanner.hasNext()&&!temp.substring(0,1).equals("F")){
		            	valueOfFund = Double.parseDouble(temp);
		            	listOfData.add(valueOfFund);
		                System.out.println(valueOfFund);
		                }
		            else 
		            	fund = temp;
		            	System.out.println(fund);
		            	newFund = new Fund(fund, listOfData);
		            	listOfFunds.add(newFund);
		            	listOfData = new ArrayList<Double>();
		            
		    }
		        CalculateVariance.Execute(listOfFunds, numberOfDataPoints);
		        CalculateVariance.getOptimalResult();

		    	System.out.println();
		    
		}
		//finds workbook instance of excel file
		//XSSFWorkbook workbook = new XSSFWorkbook (fs);
	

}
