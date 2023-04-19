//método de Steepest Descent para minimizar la función f(x, y) = 4x^2 - 4xy + 2y^2.

public class Steepest_descent_de_una_funcion {


	//Primero, definimos la función de la que queremos encontrar el mínimo:
	public static double f(double x, double y) {
	    return 4 * x * x - 4 * x * y + 2 * y * y;
	}

	//Luego, implementamos la función que calcula la gradiente de la función en un punto dado (x, y):
	public static double[] grad(double x, double y) {
	    double[] res = new double[2];
	    res[0] = 8 * x - 4 * y;
	    res[1] = -4 * x + 4 * y;
	    return res;
	}

	//A continuación, definimos la función de actualización del "guess" o suposición que utilizaremos 
	//para encontrar el mínimo de la función. En este caso, utilizaremos una tasa de aprendizaje (learning rate) de 0.1:
	public static double[] updateGuess(double[] guess, double[] grad, double learningRate) {
	    double[] newGuess = new double[2];
	    newGuess[0] = guess[0] - learningRate * grad[0];
	    newGuess[1] = guess[1] - learningRate * grad[1];
	    return newGuess;
	}

	//Finalmente, implementamos el método de Steepest Descent propiamente dicho. En este caso, 
	//usaremos un guess inicial de (x, y) = (2, 2) y realizaremos 100 iteraciones:

	
	public static void main(String[] args) {
	    double[] guess = {2, 2};
	    double learningRate = 0.1;

	    for (int i = 0; i < 100; i++) {
	        double[] grad = grad(guess[0], guess[1]);
	        guess = updateGuess(guess, grad, learningRate);
	    }

	    System.out.println("Minimum found at x = " + guess[0] + ", y = " + guess[1] + " with value " + f(guess[0], guess[1]));
	}


}
