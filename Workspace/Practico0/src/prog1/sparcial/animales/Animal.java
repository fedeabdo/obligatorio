package prog1.sparcial.animales;

import prog1.sparcial.GastoAnimal;

public abstract class Animal implements GastoAnimal{
	private String id;
	private int edad;
	private long gastoAlimenticio = 0;
	private long gastoVeterinario = 0;
	
	public Animal(String id, int edad) {
		super();
		this.id = id;
		this.edad = edad;
	}
	public void setGastoAlimenticio(long gastoAlimenticio) {
		this.gastoAlimenticio = gastoAlimenticio;
	}
	public void setGastoVeterinario(long gastoVeterinario) {
		this.gastoVeterinario = gastoVeterinario;
	}
	public long obtenerGastoVeterinario() {
		long lExit = gastoVeterinario;
		if(obtenerEtapaVida()==0) {
			lExit = lExit + lExit*(long)0.1;
		}else if(obtenerEtapaVida()==3) {
			lExit = lExit + lExit*(long)0.2;
		}
		return lExit;
	}

	public long obtenerGastoAlimenticio() {
		return gastoAlimenticio;
	}
	
	public abstract int obtenerEtapaVida();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
//	
//	public long obtenerGastoAlimentacionAnual() {
//		long lExit = 0;
//		for(int i = 0; i<Animales.size() ; i++) {
//			lExit = lExit + Animales.get(i).obtenerGastoAlimenticio();
//		}
//		return lExit;
//	}
//	public long obtenerGastoVeterinarioAnual() {
//		long lExit = 0;
//		for( int i = 0 ; i<Animales.size(); i++) {
//			lExit = lExit + Animales.get(i).obtenerGastoVeterinario();
//		}
//		return lExit;
//	}
	
}
