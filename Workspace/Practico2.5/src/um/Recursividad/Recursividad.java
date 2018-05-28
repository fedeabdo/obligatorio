package um.Recursividad;

import um.Recursividad.Exceptions.ExceptionNumeroNoCorrespondiente;

public class Recursividad {
	public int factorial(int value) throws ExceptionNumeroNoCorrespondiente {
		int value0 = (value - 1);
		if (value < 0) {
			throw new ExceptionNumeroNoCorrespondiente("El numero debe ser entero y positivo.");
		}
		if (value == 0) {
			value = 1;
		} else if (value == 1) {
			value = 1; // redundante..
		} else if (value0 != 1) {
			value = value * factorial(value0);

		}
		return value;
	}

	public double pow(double value, int pow) {
		if(pow != 1) {
			value = value*pow(value,pow-1);
		}
		return value;
	}
	
	public int sumN(int n) throws ExceptionNumeroNoCorrespondiente { //Tomando la definicion de numeros naturales con el cero.
		if(n<0) {
			throw new ExceptionNumeroNoCorrespondiente("El numero tiene que ser natural inclusive el 0.");
		}
		if(n!=0) {
			n = n + sumN(n-1);
		}
		return n;
	}
}
