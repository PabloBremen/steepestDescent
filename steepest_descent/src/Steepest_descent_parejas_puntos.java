import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Steepest_descent_parejas_puntos {
	
	
	public static double error(double[] x, double[] y, double m, double b) {
	    double sum = 0;
	    for (int i = 0; i < x.length; i++) {
	        double predictedY = m * x[i] + b;
	        double difference = y[i] - predictedY;
	        sum += difference * difference;
	    }
	    return sum;
	}
	
	
	public static double[] gradient(double[] x, double[] y, double m, double b) {
	    double dm = 0;
	    double db = 0;
	    for (int i = 0; i < x.length; i++) {
	        double predictedY = m * x[i] + b;
	        double difference = y[i] - predictedY;
	        dm += -2 * x[i] * difference;
	        db += -2 * difference;
	    }
	    return new double[] {dm, db};
	}
	
	public static Recta steepestDescent(double[] x, double[] y) {
		
	    double m = 0;
	    double b = 0;
	    double stepSize = .0001;
	    int numIterations = 10000;
	    for (int i = 0; i < numIterations; i++) {
	        double[] grad = gradient(x, y, m, b);
	        double dm = grad[0];
	        double db = grad[1];
	        m -= stepSize * dm;
	        b -= stepSize * db;
	        
	        System.out.println("Iteration %d: m=%.2f, b=%.2f, error=%.2f\n"+ "i:" + i +"m: "+  m +"b:" +  b +"error: "+  error(x, y, m, b));
	    }
	    Recta miRecta=new Recta(m,b);
	    return miRecta;
	    
	}
	
	public static void main(String[] args) {

		 //double[] x={1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		 //double[] y ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		 
		//double[] x = { 1, 2, 3, 4, 5 };
		//double[] y = { 1.5, 3.3, 5.2, 7.1, 8.8 };
		 
		// double[] x = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0, 31.0, 32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0, 40.0, 41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 47.0, 48.0, 49.0, 50.0, 51.0, 52.0, 53.0, 54.0, 55.0, 56.0, 57.0, 58.0, 59.0, 60.0, 61.0, 62.0, 63.0, 64.0, 65.0, 66.0, 67.0, 68.0, 69.0, 70.0, 71.0, 72.0, 73.0, 74.0, 75.0, 76.0, 77.0, 78.0, 79.0, 80.0, 81.0, 82.0, 83.0, 84.0, 85.0, 86.0, 87.0, 88.0, 89.0, 90.0, 91.0, 92.0, 93.0, 94.0, 95.0, 96.0, 97.0, 98.0, 99.0, 100.0};
		// double[] y = {1.0, 2.0, 1.5, 3.0, 2.5, 4.0, 3.5, 5.0, 4.5, 6.0, 5.5, 7.0, 6.5, 8.0, 7.5, 9.0, 8.5, 10.0, 9.5, 11.0, 10.5, 12.0, 11.5, 13.0, 12.5, 14.0, 13.5, 15.0, 14.5, 16.0, 15.5, 17.0, 16.5, 18.0, 17.5, 19.0, 18.5, 20.0, 19.5, 21.0, 20.5, 22.0,22.5, 23.5, 24.5, 25.5, 26.5, 27.5, 28.5, 29.5, 30.5, 31.5, 32.5, 33.5, 34.5, 35.5, 36.5, 37.5, 38.5, 39.5, 40.5, 41.5, 42.5, 43.5, 44.5, 45.5, 46.5, 47.5, 48.5, 49.5, 50.5, 51.5, 52.5, 53.5, 54.5, 55.5, 56.5, 57.5, 58.5, 59.5, 60.5, 61.5, 62.5, 63.5, 64.5, 65.5, 66.5, 67.5, 68.5, 69.5, 70.5, 71.5, 72.5, 73.5, 74.5, 75.5, 76.5, 77.5, 78.5, 79.5, 80.5, 81.5, 82.5, 83.5, 84.5, 85.5, 86.5, 87.5, 88.5, 89.5, 90.5, 91.5, 92.5, 93.5, 94.5, 95.5, 96.5, 97.5, 98.5, 99.5, 100.5};

		double[] x = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0};
		double[] y = {2.0, 1.0, 4.0, 2.5, 6.0, 5.5, 7.0, 9.5, 10.0, 12.0, 14.0, 15.5, 16.0, 18.0, 19.5, 22.0, 21.0, 23.5, 25.0, 24.5};


		Recta miRecta = new Recta();

		miRecta = steepestDescent(x, y);

		XYSeries originalData = new XYSeries("Puntos originales");
		for (int i = 0; i < x.length; i++) {
			originalData.add(x[i], y[i]);
		}

		XYSeries fittedLine = new XYSeries("Línea ajustada");
		for (double i = x[0]; i <= x[x.length - 1]; i += 0.1) {
			double predictedY = miRecta.getM() * i + miRecta.getB();
			fittedLine.add(i, predictedY);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(originalData);
		dataset.addSeries(fittedLine);

		XYDataset xyDataset = dataset;
		XYSplineRenderer renderer = new XYSplineRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.BLUE);

		XYPlot plot = new XYPlot(xyDataset, null, null, renderer);

        //ChartFrame chartFrame = new ChartFrame("Ajuste de línea recta", plot);
        
        
        // create a chart
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Chart Title",
            "X",
            "Y",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        
        
        
        ChartFrame chartFrame = new ChartFrame("titulo", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
		
		
	
		
	}

	    
		

}


	
	





