package prog1.sparcial;

import java.util.ArrayList;

import prog1.sparcial.animales.Animal;
import prog1.sparcial.animales.Vaca;

public class Granja{

	private ArrayList<Animal> Animales;

	public void agregaAnimal(Animal oA) throws AnimalYaExiste {
		if( encontrarAnimal( oA.getId()) != -1 ) {
			AnimalYaExiste error1 = new AnimalYaExiste("El animal ya esta registrado.");
			throw error1;
		}
		Animales.add(oA);
	}

	public void actualizarGastoAlimentacion(String nIdAnimal, long nGasto) throws AnimalNoExiste{
		int i = encontrarAnimal( nIdAnimal );
		if( i == -1) {
			AnimalNoExiste error1 = new AnimalNoExiste("El animal no existe.");
			throw error1;
		}
		Animales.get(i).setGastoAlimenticio(nGasto);
	}
	
	public void actualizarGastoVeterinario(String nIdAnimal, long nGasto) throws AnimalNoExiste {
		int i = encontrarAnimal( nIdAnimal );
		if( i == -1) {
			AnimalNoExiste error = new AnimalNoExiste("El animal no existe.");
			throw error;
		}
		Animales.get(i).setGastoVeterinario(nGasto);
	}
	
	public float obtenerGastoAnual() {
		float fExit = 0;
		for( int i = 0 ; i<Animales.size() ; i++) {
			fExit = fExit + Animales.get(i).obtenerGastoAlimenticio() + Animales.get(i).obtenerGastoVeterinario();
		}
		return fExit;
	}
	
	public int obtenerProduccionLecheAnual() {
		int nExit = 0;
		Vaca oVaca = null;
		for(int i = 0; i<Animales.size(); i++) {
			if( Animales.get(i) instanceof Vaca ) {
				oVaca = (Vaca)Animales.get(i);
				nExit = nExit + oVaca.getProduccionLeche();
			}
		}
		return nExit;
	}
	
	private int encontrarAnimal(String nIdAnimal) {
		boolean bFor = false;
		int nExit = -1;
		for(int i=0;i<Animales.size() && bFor==false ;i++) {
			if(Animales.get(i).getId() == nIdAnimal) {
				bFor = true;
				nExit = i;
			}
		}
		return nExit;
	}
	

	// private ArrayList<String> valores;

	// public Granja(ArrayList<String> valores) {// boton derecho source. generar
	// usando carpetas
	//
	// super();
	// this.valores = valores;
	// }
	//
	// public ArrayList<String> getValores() {
	// return valores;
	// }
	//
	// public void setValores(ArrayList<String> valores) {
	// this.valores = valores;
	// }
	//
	// public static void main(String[] args) {//main
	//
	// System.out.println();//Sysout
	//
	// }
	//

}
