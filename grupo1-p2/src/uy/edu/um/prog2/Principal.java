package uy.edu.um.prog2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Reporte oReporte=new Reporte();
		Scanner sc = new Scanner(System.in);
		int accion = 0;
		boolean bError = true;
		do {
			do {
				try {
					System.out.println("Elija el reporte que quiere realizar : ");
					System.out.println("1- 20 empresas que disponen de mayor cantidad de productos habilitados");
					System.out.println("2- 10 marcas por país que tienen mayor cantidad de productos habilitados");
					System.out.println("3- 10 países que disponen la mayor cantidad de productos habilitados");
					System.out.println("4- 20 clases por país que tienen mayor cantidad de productos habilitados");
					System.out.println("0- SALIR");
					accion = sc.nextInt();
					bError = false;
				} catch (InputMismatchException e) {
					System.out.println("\n" + "Ingrese solo numeros.");
					bError = true;
					sc.next();
				}
				if (!bError && (accion > 4 || accion < 0)) {
					System.out.println("\n" + "Ingrese un numero valido.");
				}
			} while ((accion > 4 || accion < 0) || bError);

			switch (accion) {
			case 1:
//				oReporte.reporte1();
				break;
			case 2:
				oReporte.reporte2();
				break;
			case 3:
//				oReporte.reporte3();
				break;
			case 4:
				oReporte.reporte4();
				break;
			}

		} while (accion != 0);
		sc.close();
	}

}
