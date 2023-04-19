import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficadorDePuntos {
	    private XYSeriesCollection dataset;
	    
	    public GraficadorDePuntos(double[] x, double[] y) {
	        // Crear el conjunto de datos con los puntos originales
	        dataset = new XYSeriesCollection();
	        XYSeries puntos = new XYSeries("Puntos");
	        for (int i = 0; i < x.length; i++) {
	            puntos.add(x[i], y[i]);
	        }
	        dataset.addSeries(puntos);
	        
	        //ChartFactory.create
	        
	        // Crear el gráfico y mostrarlo en una ventana
	        ChartFrame frame = new ChartFrame("Gráfico de puntos", 
	                ChartFactory.createXYLineChart(
	                        "Puntos", "X", "Y", dataset, 
	                        PlotOrientation.VERTICAL, true, true, false));
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
	    public void agregarNuevaFuncion(double[] x, double[] y, String titulo) {
	        // Crear una nueva serie de puntos con los nuevos datos
	        XYSeries puntosNuevos = new XYSeries(titulo);
	        for (int i = 0; i < x.length; i++) {
	            puntosNuevos.add(x[i], y[i]);
	        }
	        dataset.addSeries(puntosNuevos);
	    }
	    
}