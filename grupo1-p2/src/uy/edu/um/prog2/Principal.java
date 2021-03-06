package uy.edu.um.prog2;

import java.util.InputMismatchException;
import java.util.Scanner;

import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.reportes.Reporte;

public class Principal {

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		Scanner sc = new Scanner(System.in);
		int accion = 0;
		boolean bError = true;
		Reporte oReporte = null;
		System.out.println("------------------------------------------------------------------");
		System.out.println("Para comenzar, ingrese el nombre del archivo que desea cargar");
		System.out.println("------------------------------------------------------------------");
		int cantidadErrores = 0;
		do {
			try {
				oReporte = new Reporte(sc.next());
				bError = false;
			} catch (InvalidFile e) {
				System.out.println("Ingrese un nombre de archivo valido.");
				bError = true;
				cantidadErrores++;
			}
		} while (bError && cantidadErrores != 3);

		if (cantidadErrores != 3) {
			do {
				do {
					try {
						System.out
								.println("--------------------------------------------------------------------------");
						System.out.println("A continuacion, elija el reporte que quiere realizar : ");
						System.out.println("1- Las 20 empresas que disponen de mayor cantidad de productos habilitados");
						System.out.println("2- Las 10 marcas por pa�s que tienen mayor cantidad de productos habilitados");
						System.out.println("3- Los 10 pa�ses que disponen la mayor cantidad de productos habilitados");
						System.out.println("4- Las 20 clases por pa�s que tienen mayor cantidad de productos habilitados");
						System.out.println("0- SALIR");
						System.out
								.println("--------------------------------------------------------------------------");
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
					oReporte.reporte1();
					break;
				case 2:
					oReporte.reporte2();
					break;
				case 3:
					oReporte.reporte3();
					break;
				case 4:
					oReporte.reporte4();
					break;
				}
				if (accion != 0) {
					do {
						System.out.println("--------------------------------");
						System.out.println("Desea realizar otro reporte?");
						System.out.println("1 - SI");
						System.out.println("2 - NO");
						System.out.println("--------------------------------");
						try {
							accion = sc.nextInt();
							bError = false;
						} catch (InputMismatchException e) {
							System.out.println("\n" + "Ingrese solo numeros.");
							bError = true;
							sc.next();
						}
						if (!bError && (accion > 2 || accion < 1)) {
							System.out.println("\n" + "Ingrese un numero valido.");
						}
					} while (bError || (accion > 2 || accion < 1));
				}

				if (accion == 2) {
					accion = 0;
				}

			} while (accion != 0);
		} else {
			System.out.println("Ha llegado al limite de ingresos erroneos.");
		}
		sc.close();
	}
}
