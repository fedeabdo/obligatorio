package prog1.sparcial.animales;

public class Caballo extends Viviparos {
	private char raza;

	public Caballo(String id, int edad) {
		super(id, edad);
		// TODO Auto-generated constructor stub
	}
	
	public final int obtenerEtapaVida() {
		int nExit = -1; //0 es cria; 1 es adulto; 3 es senior.
		if(0<getEdad() && getEdad()<3) {
			nExit = 0;
		}else if(3<=getEdad() && getEdad()<18) {
			nExit = 1;
		}else if(getEdad()>=18) {
			nExit = 3;
		}
		return nExit;
	}
	
	public char getRaza() {
		return raza;
	}

	public void setRaza(char raza) {
		this.raza = raza;
	}
	
}
