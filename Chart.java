///////////////////////////////////////////////////////////////////////////////////////////
//@author pdutt
//
// Main file Name: Main.java
// File Name: Chart.java
//
// Summary: Chart object used to create charts for Variance Info. This is a good way of 
//			using the data to create a visualization and predict better outcomes for the
//			users. 
//			
//			Note: Uses xchart-3.5.0.jar file to create graphs. --> saved in referenced
//			libraries. 
//
///////////////////////////////////////////////////////////////////////////////////////////

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.XChartSeriesColors;



public class Chart {
	
	//creates chart with two series (all data, and the best data points --> with certain filters set in place))
	public XYChart getChart1() {
		 
	    // Create Chart
	    XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Returns").yAxisTitle("Variance").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	    chart.getStyler().setAxisTitlesVisible(false);
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
	    chart.getStyler().setYAxisDecimalPattern("%");//comment out to get exact values TODO
	    //chart.getStyler().setPlotMargin(0);
	    chart.getStyler().setPlotContentSize(.95);
	    
	    // Series 
	    
	    //x-values for returns and y-values for variances
	    double[] returns = new double[CalculateVariance.listOfVariances.size()];
	    double[] variances = new double[CalculateVariance.listOfVariances.size()];
	    
	    double[]bestReturns = new double[CalculateVariance.listOfVariances.size()];
	    double[]bestVariances = new double[CalculateVariance.listOfVariances.size()];
	    
	    //populates BEST y-values with data from Calculate Variance class
	    for(int i=0; i<bestReturns.length; i++){
	    	if(CalculateVariance.listOfVariances.get(i).getReturn()>=0.07){
	    	bestReturns[i]=CalculateVariance.listOfVariances.get(i).getReturn();
	    	}
	    }
	    
	    //populates BEST x-values with data from Calculate Variance class
	    for(int j=0; j<bestVariances.length; j++){
	    	if(CalculateVariance.listOfVariances.get(j).getVariance()<=0.025){
	    	bestVariances[j]=CalculateVariance.listOfVariances.get(j).getVariance();
	    	}
	    }
	    
	    //populates y-values with data from Calculate Variance class
	    for(int i=0; i<returns.length; i++){
	    	returns[i]=CalculateVariance.listOfVariances.get(i).getReturn();
	    }
	    
	    //populates x-values with data from Calculate Variance class
	    for(int j=0; j<variances.length; j++){
	    	variances[j]=CalculateVariance.listOfVariances.get(j).getVariance();
	    }

	    chart.addSeries("a", variances, returns);
	    chart.addSeries("b", sortVariances(bestVariances), bestReturns);
	    
	    //chart.addSeries("b", returns, variances);
	    //chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
	    //chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });
	 
	    return chart;
	  }
	
	public XYChart getChart2() {
		 
	    // Create Chart
	    XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Returns").yAxisTitle("Variance").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	    chart.getStyler().setAxisTitlesVisible(false);
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
	 
	    // Series 
	    
	    //x-values for returns and y-values for variances
	    double[]bestReturns = new double[CalculateVariance.listOfVariances.size()];
	    double[]bestVariances = new double[CalculateVariance.listOfVariances.size()];
	    
	    //populates BEST y-values with data from Calculate Variance class
	    for(int i=0; i<bestReturns.length; i++){
	    	if(CalculateVariance.listOfVariances.get(i).getReturn()>=0.07){
	    	bestReturns[i]=CalculateVariance.listOfVariances.get(i).getReturn();
	    	}
	    }
	    
	    //populates BEST x-values with data from Calculate Variance class
	    for(int j=0; j<bestVariances.length; j++){
	    	if(CalculateVariance.listOfVariances.get(j).getVariance()<=0.025){
	    	bestVariances[j]=CalculateVariance.listOfVariances.get(j).getVariance();
	    	}
	    }
	   
		
	    chart.addSeries("a", sortVariances(bestVariances), bestReturns);
	    //chart.addSeries("b", returns, variances);
	    //chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
	    //chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });
	 
	    return chart;
	  }
	
	/*
	 * sorts bestVariances list in ascending order
	 */
	public double[] sortVariances(double[] bestVariances){
		double[] arr = new double[bestVariances.length];
		//populate array w values from list of variances
		for(int i=0; i<arr.length; i++){
			arr[i] = bestVariances[i];
		}
		//sort array
		   for (int i = arr.length - 1; i >= 0; i--)
		   {
		      for (int j = 1; j <= i; j++)
		      {
		         if (arr[j-1]> arr[j])
		         {
		              double temp = arr[j-1];
		              arr[j-1]=arr[j];
		              arr[j]=temp;
		   } 
		         } 
		   }
		   return arr;
	}
	
	
	
}
