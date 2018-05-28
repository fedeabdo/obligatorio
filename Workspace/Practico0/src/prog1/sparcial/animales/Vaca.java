package prog1.sparcial.animales;

public class Vaca extends Viviparos {

	private int produccionLeche = 0;

	public Vaca(String id, int edad) {
		super(id, edad);
		// TODO Auto-generated constructor stub
	}	

	public final int obtenerEtapaVida() {
		int nExit = -1; //0 es cria; 1 es adulto; 3 es senior.
		if(0<getEdad() && getEdad()<2) {
			nExit = 0;
		}else if(2<=getEdad() && getEdad()<15) {
			nExit = 1;
		}else if(getEdad()>=15) {
			nExit = 3;
		}
		return nExit;
	}

	public int getProduccionLeche() {
		return produccionLeche;
	}

	public boolean setProduccionLeche(int produccionLeche) {
		boolean bExit = false;
		if(obtenerEtapaVida()==1) {
			this.produccionLeche = produccionLeche;
			bExit=true;
		}
		return bExit;
	}
}
