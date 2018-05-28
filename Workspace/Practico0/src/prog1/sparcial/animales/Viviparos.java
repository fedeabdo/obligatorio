package prog1.sparcial.animales;

public abstract class Viviparos extends Animal {
	
	public Viviparos(String id, int edad) {
		super(id, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract int obtenerEtapaVida();

}
