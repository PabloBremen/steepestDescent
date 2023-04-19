
public class main {
	
	public static double[] calculateYEstimated(double[] x, double m, double b) {
	    double[] yEstimated = new double[x.length];
	    for (int i = 0; i < x.length; i++) {
	        yEstimated[i] = m * x[i] + b;
	    }
	    return yEstimated;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//double[] x0={1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		//double[] x1={1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		double[] x0={  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1,1,1,1,1};
		double[] x1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0};
		double[] y = {2.0, 1.0, 4.0, 2.5, 6.0, 5.5, 7.0, 9.5, 10.0, 12.0, 14.0, 15.5, 16.0, 18.0, 19.5, 22.0, 21.0, 23.5, 25.0, 24.5};

		
		//double[] y ={2, 4, 6, 8, 10,12,14,16,18, 20, 22, 24, 26, 28, 30};
		//double[] y ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		double theta_0=0;
		double theta_1=0;
		int m=x0.length;
		double suma_theta0=0;
		double suma_theta1=0;
		double temp_0;
		double temp_1;
		double alpha=0.0001;
		int iteraciones=10000;
		
		for(int j=1;j<iteraciones;j++){
			for(int i=0;i<m;i++){
				suma_theta0 = theta_0*x0[i]+theta_1*x1[i]-y[i];
			}
			temp_0=theta_0-((alpha/m)*suma_theta0);

			for(int i=0;i<m;i++){
			    suma_theta1 = (((theta_0*x0[i]+theta_1*x1[i])-y[i]) * x1[i]);
			}
			temp_1=theta_1-((alpha/m)*suma_theta1);

			theta_0=temp_0;
			theta_1=temp_1;
			
		}
		System.out.println("iteraciones: " + iteraciones);
		System.out.println("alpha: " + alpha);
		System.out.println("theta_0: " + theta_0);
		System.out.println("theta_1: " + theta_1);
		
		GraficadorDePuntos migrafica=new GraficadorDePuntos(x1, y);
		
		double[] y_estimated=calculateYEstimated(x1, theta_1, theta_0);
		//Ahora agregamos otra grafica
		migrafica.agregarNuevaFuncion(x1, y_estimated,"Funcion estimada");
		
		//Ahora agregamos otra grafica, que no tiene nada que ver, solo por ver si se agrega o no
		double[] z={3.0, 2.0, 5.0, 2.0, 5.5, 6.8, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0};
		migrafica.agregarNuevaFuncion(x1, z,"Funcion si masme ");

	}

}
