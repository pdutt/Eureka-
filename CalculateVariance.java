///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: CalculateVariance.java
//
// Summary: Calculates the variance of a list of funds using every possible weight
// range (0-100 %). Returns the best possible value based on lowest variance.
//
// The mean, standard deviations, and range of data points are calculated based on 
// individual funds and then used in the covariance and variance formulas. All 
// possible weight ranges are also calculated here. 
//
///////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/*
 * NOTE: Right now--> individual fund means and standard deviations are calculated 
 * based on the number of data points used for that particular fund. Ex. each fund that
 * is compared will also be compared based on number of data points. THe fund with 
 * the larger amount of data points will match the amount of data points given by the 
 * smaller fund. This means that each pair of funds that is calculated will have different 
 * periods of data points in general. 
 * 
 * Fund A (10 pts) vs Fund B (12 pts)--> 10
 * Fund B (12 pts) vs Fund C (6 pts)-->6
 * Fund A (10 pts) vs Fund C (6 pts)-->6
 * 
 * so the first case wont use the same data points as the second two cases...
 * I can change this so that every fund is compared ahead of time and
 * all funds use the same data points. 
 * 
 * ALSO-- I have NOT filtered by year. So if Fund A starts in 2010 , and Fund B
 * starts in 2003... the calculations will start at the start date of each fund. Can 
 * modify based on date later. 
 */public class CalculateVariance {
	
	public static ArrayList<ArrayList<Double>> listOfListOfWeights = new ArrayList<ArrayList<Double>>();
	public static ArrayList<VarianceInfo> listOfVariances = new ArrayList<VarianceInfo>();
	
	
	/*
	 * Executes entire calculation of variances. Lists all possible variances using the random
	 * weight generator. THe variance formula calls the co-variance formula, as well as 
	 * utilizes the sum, mean, and standard deviation formulas for each individual fund. 
	 * 
	 * NOTE: This is a STATIC class. When using the tester class, testGenerateRandomWeights
	 * will pre-populate CalculateVariance.listOfListOfWeights so comment that out before
	 * testing general execution. 
	 * 
	 */
	public static ArrayList<VarianceInfo> Execute(ArrayList<Fund> listOfFunds, int numberOfWeightCombos){
		
		//populates listOfListOfWeights
		generateRandomWeights(listOfFunds.size(), numberOfWeightCombos);
		
		//ArrayList<ArrayList<Double>> listOfWeights = new ArrayList<ArrayList<Double>>();
		for(int i=0; i<listOfListOfWeights.size();i++){
			
			//finds variance
			double variance = findVariance(listOfFunds, listOfListOfWeights.get(i));
			//System.out.println(variance);
			//finds returns
			double returns = findReturn(listOfFunds, listOfListOfWeights.get(i));
			//System.out.println(returns);
			//creates Variance Info object
			VarianceInfo vInfo = new VarianceInfo(variance, returns, listOfListOfWeights.get(i));
			
			//adds variance info to new list (includes weights) if rate of retrn is at least 7%
			// and checks to see that variance is not NaN
			if(checkReturns(vInfo) && checkVariance(vInfo)){
			listOfVariances.add(vInfo);
			}
		}
		//sorts list by returns in ascending order
		sortReturnsAscending();
		//sorts list by variances in ascending order
		sortVariancesAscending();
		//returns list
		return listOfVariances;
	}
	
	/*
	 * Creates a list of every possible weight for the given number of funds, contingent on the
	 * total adding up to 100 (percent). Uses a recursive method to call every possibility, 
	 * and then calls the sum method
	 */
	public static void listAllPossibleWeightsUsingPermutations (double range, double numberOfFunds, ArrayList<Double> listOfWeights, ArrayList<ArrayList<Double>> listOfListOfWeights){
		if(range==0){
			//calls sum function to print arrays that only add up to 100
			if(sum(listOfWeights)==true){// && checkZeros(listOfWeights)==true){
			listOfListOfWeights.add(listOfWeights);
			System.out.println(listOfWeights);
			}
		}
		else{
			for(double i=0; i<numberOfFunds; i++){
				listOfWeights.add(i);
				listAllPossibleWeightsUsingPermutations(range-1, numberOfFunds, listOfWeights, listOfListOfWeights);
				listOfWeights.remove(listOfWeights.size()-1);
			} 
		}
	}
	
	/*
	 * Creates random weights using the random weight generator. Generates different 
	 * weights based on number of funds used, then sums up total weights and
	 * divides each weight by total to calculate random percentage for each fund.
	 * The list of 1000 is stored in an array list, and then used to compare
	 * each possibility of weights for the variance formula and the return formula. 
	 */
	public static void generateRandomWeights(double numberOfFunds, int numberOfWeightCombos){
		
		
		double value = 0;
		
		//populates list with random numbers
		for(int i=0; i<numberOfWeightCombos; i++){
			double sum =0;
			ArrayList<Double> weights = new ArrayList<Double>();
 			for(int j=0; j<numberOfFunds; j++){
				value = Math.random();
				weights.add(value);
				sum+= value;
			}
 			for(int k=0; k<weights.size(); k++){
 				weights.set(k, weights.get(k)/sum);
 			}
 			listOfListOfWeights.add(weights);
		}
		}
	
	/*
	 * TODO --  See note below. 
	 * Computes the final returns of a group of funds-- based on the weights that are assigned to each fund.
	 * Uses the averages of each fund, multiplies it by the weight, and finds the average of the computed averages
	 * for all funds put together for a final return. This is stored in a VarianceInfo object. 
	 */
	public static double findReturn(ArrayList<Fund> funds, ArrayList<Double> weights){
		double sum=0;
		
		for(int i=0; i<funds.size() && i<weights.size(); i++){
			sum += (findMean(funds.get(i), funds.get(i).getPercentageOfGrowth().size()))*weights.get(i);
		}
		return sum;
	}
	
	/*
	 * Finds the variance with formula from: (http://www.ewp.rpi.edu/hartford/~youneh/INVII/Week%204/mv_analysis_2up.pdf)
	 * TODO Standard Dev is a parameter that needs to be defined beforehand, but we don't necessarily know how many
	 * data points to use to calculate this because when comparing funds in a later part of the formula (co variance), 
	 * the averages and number of data points used are all based on the smallest amount of data points between
	 * two funds. SO for now, i'm going to create the standard deviations based on all data points for each individual
	 * fund. If needed, I can change it to a minimum range based on year/min data points between all funds, etc. 
	 */
	public static double findVariance(ArrayList<Fund> funds, ArrayList<Double> weights){
		double sum1 =0;
		double sum2 =0;
		double total =0;
		
		//finds first summation 
		for(int i=1; i< weights.size() && i<= funds.size(); i++){
			double weightSquared = Math.pow(weights.get(i),2);
			double stnDevSquared = Math.pow(findStandardDeviation(funds.get(i), funds.get(i).getPercentageOfGrowth().size()),2);
			
			sum1+=weightSquared*stnDevSquared;	
		}
		//finds second summation
		for(int i=0; i < weights.size(); i++){
			for(int j=i+1; j < weights.size(); j++){
				double weight = 2*weights.get(i)*weights.get(j);
				double covariance = getCovariance(funds.get(i), funds.get(j));
				
				sum2 += weight*covariance; 
			}
					}
		total = sum1 +sum2;
		total = Math.sqrt(total);
		return total;
		
	}
	
	/*
	 * convert to percentages
	 */
	public static void convertToPercentages(ArrayList<Double> arr){
		for(int i=0; i<arr.size(); i++){
			//arr.get(i)=arr.get(i)*0.01;
		}
	}
	/*TODO
	 * takes out zeros from list of weights (return list without zeros,
	 *  but have it still include the non-zero values in the list)
	 */
	public static boolean checkZeros(ArrayList<Double> arr){
		double count = 1;
		 for(int i=0; i<arr.size(); i++){
			 if (arr.get(i)==0){
				 count=0.0;
			 }
			 if (count==0){
				 return false;
			 }
		 }
		return true; 
	}
	
	/*TODO
	 *finds the standard deviation of each fund for variance formula 
	 *(This is based on the raw data points for each fund--> formula
	 *found on https://en.wikipedia.org/wiki/Standard_deviation)
	 */
	public static double findStandardDeviation(Fund fund, int dataRange){
		double summation=0;
		double mean = findMean(fund, dataRange);
		
		for(int i=0; i<dataRange;i++){
			summation += Math.pow((fund.getPercentageOfGrowth().get(i)-mean), 2);
		}
		summation = summation/(dataRange-1);
		summation = Math.sqrt(summation);
		return summation;
	}
	
	/*
	 * finds covariance (called by variance method)
	 * TODO double check that this loop is coded correctly --> used two 'for' loops
	 * even though there is only one summation in the formula. This ensures that every
	 * fund will be compared to each other. 
	 */
	public static double getCovariance(Fund fund1, Fund fund2){
		//fields to calculate covariance
		double x=0;
		double y=0;
		double multiplier = 0;
		double total = 0;
		
		//calls method to find number of data points to compare against
		int numberOfDataPoints = findNumberOfDataPoints(fund1, fund2);
		
		//finds fixed mean of each fund
		double meanX = findMean(fund1, numberOfDataPoints);
		double meanY= findMean(fund2, numberOfDataPoints);
		
		for(int i=0; i<numberOfDataPoints; i++){
			for(int j=i+1; j<numberOfDataPoints; j++){
				
				x = fund1.getPercentageOfGrowth().get(i);
				y = fund2.getPercentageOfGrowth().get(j);
				x = x-meanX;
				y = y-meanY;
				
				multiplier=x*y;
				total+=multiplier;
			}
		}
		//finds mean by dividing summation by number of data points
		total = total/(numberOfDataPoints-1);
		//returns mean
		return total;
	}
	
	/*
	 * finds number of data points to use when comparing two funds. Ex. 
	 * If fund A has 12 data points and fund B has 10... pick the fund 
	 * with the fewest data points (fund B)--> so the formula will 
	 * compare both funds based on the first 10 data points.
	 * 
	 * impediments: (Check for start date of info?) If Fund A starts in
	 * 2000 and Fund B starts in 2005... does that make a difference? 
	 * 
	 */
	public static int findNumberOfDataPoints(Fund fund1, Fund fund2){
		int total =0;
		int total2 = 0;
		
		for(int i=0; i<=fund1.getPercentageOfGrowth().size(); i++){
			total+=1;
		}
		for(int j=0; j<=fund2.getPercentageOfGrowth().size(); j++){
			total2+=1;
		}
		if (total<total2){
		return total-1;
		}
		else{
			return total2-1;
		}
	}
	
	/*
	 * Displays best result based on lowest variance.
	 * Call method ONLY after calling the execute method--> this will ensure that 
	 * variances are already sorted by lowest to highest.
	 */
	public static void getOptimalResult(){
		
		double weight =0.0;
		double returnValue = listOfVariances.get(0).getReturn();
		
		returnValue = returnValue*10000;
		returnValue = Math.round(returnValue);
		returnValue=returnValue/100;
		
		
		System.out.println("Optimal Variance is: "+listOfVariances.get(0).getVariance());
		System.out.println("Estimated Percentage of Returns: "+ returnValue+"%");
		System.out.println("Distribution of weights: ");
		for(int i=0; i< listOfVariances.get(0).getWeights().size(); i++){
			weight = listOfVariances.get(0).getWeights().get(i)*10000;
			weight = Math.round(weight);
			weight = weight/100;
			System.out.print("Fund "+(i+1)+": " +weight+"%");
			System.out.println();
		}
		System.out.println();
		
	}
	
	/*
	 * finds the mean based on number of data points for each fund.
	 * 
	 * TODO Need to eventually modify so that program can have
	 * different start values... ex. if Fund A has data from 2000-2010
	 * and we want values from 2003-2010... need to be able to shift
	 * values extracted based on a start date of 2003 rather than 2000.
	 */
	public static double findMean(Fund fund, int numberOfDataPoints){
		double sum =0;
		double mean =0;
		
		for(int i=0; i<numberOfDataPoints; i++){
			sum+= fund.getPercentageOfGrowth().get(i);
			
		}
		mean = sum/numberOfDataPoints;
		return mean;
	}
	/*
	 * filters through possible fund-weight distributions and only displays 
	 * percentages that add up to 100.
	 */
	public static boolean sum(ArrayList<Double> list){
		int sum=0;
		for(int i=0; i<list.size();i++){
			sum+=list.get(i);
		}
		//System.out.println(sum);
		if (sum==100){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * returns list of list of weights 
	 */
	public void returnListOfListOfWeights(){
		for(int i=0; i<listOfListOfWeights.size();i++){
			System.out.print("[ ");
			for(int j=0; j<listOfListOfWeights.get(i).size();j++){
				System.out.print(listOfListOfWeights.get(i).get(j)+", ");
			}
			System.out.println("]");
			
		}
	}
	
	/*
	 * checks Variance to be under a certain number, and that the variance is not NaN
	 */
	public static boolean checkVariance(VarianceInfo vInfo){
		if (!Double.isNaN(vInfo.getVariance()) && vInfo.getVariance()<=2.0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * checks returns to be above a certain percentage
	 */
	public static boolean checkReturns(VarianceInfo vInfo){
		if (vInfo.getReturn()>=0.04){
			return true;
		}
		return false;
	}
	
	/*
	 * sort return list
	 */
	public static VarianceInfo[] sortReturnsAscending()
	{
		
	VarianceInfo[] arr = new VarianceInfo[listOfVariances.size()];
	//populate array w values from list of variances
	for(int i=0; i<arr.length; i++){
		arr[i] = listOfVariances.get(i);
	}
	//sort array
	   for (int i = arr.length - 1; i >= 0; i--)
	   {
	      for (int j = 1; j <= i; j++)
	      {
	         if (arr[j-1].getReturn()> arr[j].getReturn())
	         {
	              VarianceInfo temp = arr[j-1];
	              arr[j-1]=arr[j];
	              arr[j]=temp;
	   } 
	         } 
	      }
	   //re-populate list with values in order
	   for(int i=0; i<arr.length; i++){
		   listOfVariances.set(i,arr[i]);
	   }
	   return arr;
 }

	/*
	 * sort variance list
	 */
	public static VarianceInfo[] sortVariancesAscending()
	{
		
	VarianceInfo[] arr = new VarianceInfo[listOfVariances.size()];
	//populate array w values from list of variances
	for(int i=0; i<arr.length; i++){
		arr[i] = listOfVariances.get(i);
	}
	//sort array
	   for (int i = arr.length - 1; i >= 0; i--)
	   {
	      for (int j = 1; j <= i; j++)
	      {
	         if (arr[j-1].getVariance()> arr[j].getVariance())
	         {
	              VarianceInfo temp = arr[j-1];
	              arr[j-1]=arr[j];
	              arr[j]=temp;
	   } 
	         } 
	      }
	   //re-populate list with values in order
	   for(int i=0; i<arr.length; i++){
		   listOfVariances.set(i,arr[i]);
	   }
	   return arr;
 }

}
