import java.util.Arrays;

public class steepest_descent_x1x2y {



    public static void main(String[] args) {
        double[][] points = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // Ejemplo de conjunto de puntos

        double[] result = steepestDescent(points);
        System.out.println(Arrays.toString(result));
    }

    public static double[] steepestDescent(double[][] points) {
        double[] guess = {0, 0, 0}; // Adivinanza inicial
        double[] gradient = new double[3]; // Gradiente inicial
        double stepSize = 0.0000001; // Tamaño de paso
        int iterations = 10000; // Número de iteraciones

        for (int i = 0; i < iterations; i++) {
            gradient = gradient(points, guess);
            guess = subtract(guess, multiply(gradient, stepSize));
        }

        return guess;
    }

    public static double[] gradient(double[][] points, double[] guess) {
        double[] gradient = {0, 0, 0};
        

        for(int i=0;i<points.length;i++){
        	double[] fila_i = points[i];
            double error = error(guess, fila_i);
            gradient[0] += error * points[i][0];
            gradient[1] += error * points[i][1];
            gradient[2] += error * points[i][2];
        	
        }

        return gradient;
    }

    //va calculando el error por cada una de las filas de puntos
    public static double error(double[] guess, double[] point) {
        double error = 0;

        for (int i = 0; i < guess.length; i++) {
            error += Math.pow(guess[i] - point[i], 2);
        }

        return error;
    }

    public static double[] subtract(double[] a, double[] b) {
        double[] result = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }

        return result;
    }

    public static double[] multiply(double[] a, double b) {
        double[] result = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * b;
        }

        return result;
    }


}



