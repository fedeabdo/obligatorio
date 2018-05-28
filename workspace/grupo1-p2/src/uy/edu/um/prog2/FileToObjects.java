package uy.edu.um.prog2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import uy.edu.um.prog2.Exceptions.RubroException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.Tree.*;

public class FileToObjects {
	private MyBinarySearchTree<Long, Empresa> empresas;
	private MyBinarySearchTree<String, Pais> paises;
	private MyBinarySearchTree<String, Clase> clases;
	private MyBinarySearchTree<Integer, Producto> productos;

	public FileToObjects() {
		empresas = new BSTImpl<>();
		paises = new BSTImpl<>();
		clases = new BSTImpl<>();
		productos = new BSTImpl<>();
	}

	public void fileToObjects() throws IOException, RubroException {
		File f = new File("tabla_datos.csv");

		BufferedReader b = new BufferedReader(new FileReader(f));

		String readLine = "";

		readLine = b.readLine();

		while ((readLine = b.readLine()) != null) {
			String[] fields = readLine.split(";");
			String nombre = String.valueOf(fields[0]);
			String nombreFantasia = String.valueOf(fields[1]);
			Integer idProd = Integer.valueOf(fields[2]);
			String rubro = String.valueOf(fields[3]);
			String empresa = String.valueOf(fields[5]);
			String clase = String.valueOf(fields[10]);
			String marca = String.valueOf(fields[12]);
			String pais = String.valueOf(fields[13]);
			String estado = String.valueOf(fields[20]);
			Long ruc = Long.valueOf(fields[23]);

			Empresa oEmpresa = new Empresa(empresa, ruc);
			Marca oMarca = new Marca(marca);
			Pais oPais = new Pais(pais);
			MiListaEnlazada<Rubro> oRubro = getRubro(rubro);
			Clase oClase = new Clase(clase);
			Producto producto = new Producto(nombre, nombreFantasia, estado, oClase, oPais, oMarca, oEmpresa, oRubro);
			productos.insert(idProd, producto);
			addToList(oEmpresa);
			addToList(oClase);
			addToList(oPais);
		}
		b.close();
	}

	private MiListaEnlazada<Rubro> getRubro(String rubro) {
		MiListaEnlazada<Rubro> lista = new ListaEnlazadaSimple<>();
		String readLine = "";
		String[] fields = readLine.split("-");
		for (int i = 0; i < fields.length; i++) {
			lista.agregar(new Rubro(String.valueOf(fields[i])));
		}
		return lista;
	}

	private void addToList(Object obj) {
		if (obj instanceof Empresa) {

			if (empresas != null) {
				if (!empresas.find(((Empresa) obj).getRuc()).equals(obj)) {
					empresas.insert(((Empresa) obj).getRuc(), (Empresa) obj);
				}
			} else {
				empresas.insert(((Empresa) obj).getRuc(), (Empresa) obj);
			}
		} else if (obj instanceof Pais) {
			if (paises != null) {
				if (!paises.find(((Pais) obj).getNombre()).equals(obj)) {
					paises.insert(((Pais) obj).getNombre(), (Pais) obj);
				}
			} else {
				paises.insert(((Pais) obj).getNombre(), (Pais) obj);
			}
		} else if (obj instanceof Clase) {
			if (clases != null) {
				if (!clases.find(((Clase) obj).getNombre()).equals(obj)) {
					clases.insert(((Clase) obj).getNombre(), (Clase) obj);
				}
			} else {
				clases.insert(((Clase) obj).getNombre(), (Clase) obj);
			}
		}

	}

	public MyBinarySearchTree<Long, Empresa> getEmpresas() {
		return empresas;
	}

	public MyBinarySearchTree<String, Pais> getPaises() {
		return paises;
	}

	public MyBinarySearchTree<String, Clase> getClases() {
		return clases;
	}

	public MyBinarySearchTree<Integer, Producto> getProductos() {
		return productos;
	}

}
