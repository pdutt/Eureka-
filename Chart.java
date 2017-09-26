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



public class Chart {
	
	public XYChart getChart() {
		 
	    // Create Chart
	    XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Returns").yAxisTitle("Variance").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	    chart.getStyler().setAxisTitlesVisible(false);
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
	 
	    // Series 
	    
	    //x-values for returns and y-values for variances
	    double[] returns = new double[CalculateVariance.listOfVariances.size()];
	    double[] variances = new double[CalculateVariance.listOfVariances.size()];
	    
	    //populates x-values with data from Calculate Variance class
	    for(int i=0; i<returns.length; i++){
	    	returns[i]=CalculateVariance.listOfVariances.get(i).getReturn();
	    }
	    
	  //populates y-values with data from Calculate Variance class
	    for(int j=0; j<variances.length; j++){
	    	variances[j]=CalculateVariance.listOfVariances.get(j).getVariance();
	    }
	    
	    chart.addSeries("a", variances, returns);
	    //chart.addSeries("b", returns, variances);
	    //chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
	    //chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });
	 
	    return chart;
	  }
	
	
}
