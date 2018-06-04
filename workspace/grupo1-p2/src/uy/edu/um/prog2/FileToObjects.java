package uy.edu.um.prog2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import uy.edu.um.prog2.Exceptions.RubroException;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.Tree.*;

public class FileToObjects {
	private MiListaEnlazada<Empresa> empresas;
	private MyBinarySearchTree<String, Pais> paises;
	private MyBinarySearchTree<Integer, Clase> clases;
	private HashTable<Integer, Producto> productos;

	public FileToObjects() {
		empresas = new ListaEnlazadaSimple<>();
		paises = new BSTImpl<>();
		clases = new BSTImpl<>();
		productos = new HashCerrado<>(53000, true);
	}

	public void loadFiles() throws IOException {
		File f = new File("tabla_datos.csv");

		BufferedReader b = new BufferedReader(new FileReader(f));

		String readLine = null;

		readLine = b.readLine();
		while ((readLine = b.readLine()) != null) {
			String[] fields = readLine.split(";");
			String nombre = String.valueOf(fields[0].substring(1, fields[0].length()-1));
			String nombreFantasia = String.valueOf(fields[1].substring(1, fields[1].length()-1));
			Integer idProd = Integer.valueOf(fields[2].substring(1, fields[2].length()-1));
			String rubro = String.valueOf(fields[3].substring(1, fields[3].length()-1));
			String empresa = String.valueOf(fields[5].substring(1, fields[5].length()-1));
			Integer idClase = Integer.valueOf(fields[9].substring(1, fields[9].length()-1));
			String clase = String.valueOf(fields[10].substring(1, fields[10].length()-1));
			String marca = String.valueOf(fields[12].substring(1, fields[12].length()-1));
			String pais = String.valueOf(fields[13].substring(1, fields[13].length()-1));
			String estado = String.valueOf(fields[20].substring(1, fields[20].length()-1));
			Long ruc = Long.valueOf(fields[23].substring(1, fields[23].length()-1));

			
			Empresa oEmpresa = vEmpresa(empresa, ruc);
			Clase oClase = vClase(idClase, clase);
			Pais oPais = vPais(pais);
			Marca oMarca = new Marca(marca);
			MiListaEnlazada<Rubro> oRubro = getRubro(rubro);
			Producto producto = null;
			try {
				producto = new Producto(nombre, nombreFantasia, estado, oClase, oPais, oMarca, oEmpresa, oRubro);
			} catch (RubroException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				productos.insertar(idProd, producto);
				oEmpresa.agregarProducto();
			} catch (ElementoYaExistenteException e) {
				System.out.println();
				e.printStackTrace();
			}

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

	private Empresa vEmpresa(String empresa, Long ruc) {
		Empresa oEmpresa = null;
		if(empresas == null) {
			oEmpresa = new Empresa(empresa, ruc);
			empresas.agregar(oEmpresa);
		}else if (empresas.esta(new Empresa(empresa, ruc)) == null){
			oEmpresa = new Empresa(empresa, ruc);
			empresas.agregar(oEmpresa);
		}else {
			oEmpresa = empresas.esta(new Empresa(empresa, ruc));
		}
		return oEmpresa;
	}
	
	private Clase vClase(Integer idClase, String clase) {
		Clase oClase = null;
		if(clases == null) {
			oClase = new Clase(idClase, clase);
			clases.insert(idClase, oClase);
		}else if (clases.find(idClase) == null){
			oClase = new Clase(idClase, clase);
			clases.insert(idClase, oClase);
		}else {
			oClase = clases.find(idClase);
		}
		return oClase;
	}
	
	private Pais vPais(String pais) {
		Pais oPais = null;
		if(paises == null) {
			oPais = new Pais(pais);
			paises.insert(pais, oPais);
		}else if (paises.find(pais) == null){
			oPais = new Pais(pais);
			paises.insert(pais, oPais);
		}else {
			oPais = paises.find(pais);
		}
		return oPais;
	}
	public MiListaEnlazada<Empresa> getEmpresas() {
		return empresas;
	}

	public MyBinarySearchTree<String, Pais> getPaises() {
		return paises;
	}

	public MyBinarySearchTree<Integer, Clase> getClases() {
		return clases;
	}

	public HashTable<Integer, Producto> getProductos() {
		return productos;
	}

}
