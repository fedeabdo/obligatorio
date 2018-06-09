package uy.edu.um.prog2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import uy.edu.um.prog2.Exceptions.EspecificacionesException;
import uy.edu.um.prog2.Exceptions.InvalidFile;
import uy.edu.um.prog2.Exceptions.RubroException;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.Tree.*;

import static uy.edu.um.prog2.Especificaciones.especificar;

public class FileToObjects {
	private HashTable<Long, Empresa> empresas;
	private HashTable<String, Pais> paises;
	private HashTable<String, Clase> clases;
	private HashTable<String, Producto> productos;
	int cantProductos;

	public FileToObjects() {
		empresas = new HashCerrado<>(1400, true);
		paises = new HashCerrado<>(100, true);
		clases = new HashCerrado<>(800, true);
		productos = new HashCerrado<>(60000, true);
		cantProductos = 0;
	}

	public void loadFiles(String dir) throws IOException, InvalidFile{
		String encodedData = "UTF8"; // Codificacion del archivo. UTF-8 en nuestro caso.
		File fileDir= new File(dir); // En el obligatorio dirDatos = tabla_datos.csv
		BufferedReader b;
		try {
			b = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), encodedData));
		}catch(FileNotFoundException e) {
			throw new InvalidFile();
		}
		String readLine = "";

		readLine = b.readLine(); // lee la 1era linea. La lee con " extras al principio y final.
		readLine = readLine.substring(1, readLine.length() - 1); // Para solucionarlo hacemos un substring de ese String
																	// sacando esas " extras
		String[] nombreCol = readLine.split("\";\""); // \" representa " , lo hacemos para separar los ; entre columnas
														// y los ; usados dentro de una misma columna
		HashCerrado<String, Integer> fieldsCol = new HashCerrado<>(nombreCol.length + 10, true); // Hash de todas las
																									// columnas de los
																									// datos
		for (int i = 0; i < nombreCol.length; i++) {
			try {
				fieldsCol.insertar(nombreCol[i], i);
			} catch (ElementoYaExistenteException e) {
				e.getStackTrace();
			}
		}

		String[] especificaciones = new String[11]; // Estas son los nombres de las columnas que nos interesan en este
													// caso.
		especificaciones[0] = "nombre";
		especificaciones[1] = "nom_fantasia";
		especificaciones[2] = "idprod";
		especificaciones[3] = "rubro";
		especificaciones[4] = "empresa";
		especificaciones[5] = "idclase";
		especificaciones[6] = "clase";
		especificaciones[7] = "marca";
		especificaciones[8] = "pais";
		especificaciones[9] = "estado";
		especificaciones[10] = "ruc";
		int[] indEspCol = null;
		try {
			indEspCol = especificar(especificaciones, fieldsCol); // a este metodo le ponemos como argumento las
																	// columnas que queremos conocer su indice. Devuelve
																	// un vector con los indices de las respectivas
																	// columnas interesadas.
		} catch (EspecificacionesException e2) {
			e2.printStackTrace();
		}
		String[] fields = null;
		readLine = b.readLine(); // leemos la 2da linea
		int i=0;
		while (readLine != null) {
			i++;
			System.out.print(i);
			readLine = readLine.substring(1, readLine.length() - 1); // sacamos las comillas extras
			fields = readLine.split("\";\""); // separamos
			String nombre = fields[indEspCol[0]];
			String nombreFantasia = fields[indEspCol[1]];
			Integer idProd = Integer.valueOf(fields[indEspCol[2]]);
			String rubro = fields[indEspCol[3]];
			String empresa = fields[indEspCol[4]];
			Integer idClase = Integer.valueOf(fields[indEspCol[5]]);
			String clase = fields[indEspCol[6]];
			String marca = fields[indEspCol[7]];
			String pais = fields[indEspCol[8]];
			String estado = fields[indEspCol[9]];
			Long ruc = Long.valueOf(fields[indEspCol[10]]);

			Empresa oEmpresa = vEmpresa(empresa, ruc);
			Clase oClase = vClase(idClase, clase);
			Pais oPais = vPais(pais);
			Marca oMarca = new Marca(marca);
			MiListaEnlazada<Rubro> oRubro = getRubro(rubro);
			Producto producto = null;
			try {
				producto = new Producto(nombre, nombreFantasia, estado, oClase, oPais, oMarca, oEmpresa, oRubro);
			} catch (RubroException e1) {
				e1.printStackTrace();
			}
			try {
				productos.insertar((Integer.toString(idProd) + nombre), producto);
				System.out.println(Integer.toString(idProd) + nombre);					//prueba
				cantProductos++;
				if (estado == "HABILITADO") {
					oEmpresa.agregarProducto();
					oMarca.agregarProductoHabilitado();
				}
				oPais.agregarMarca(oMarca);
			} catch (ElementoYaExistenteException e) {
				System.out.println();
				e.printStackTrace();
			}
			readLine = b.readLine();
		}
		b.close();		
	}

	public int getCantProductos() {
		return cantProductos;
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
		Empresa oEmpresa = new Empresa(empresa, ruc);
		if (!empresas.pertenece(ruc)) {
			try {
				empresas.insertar(ruc, oEmpresa);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		} else {
			oEmpresa = empresas.obtener(ruc);
		}
		return oEmpresa;
	}

	private Clase vClase(Integer idClase, String clase) {
		Clase oClase = null;
		Clase oClaseEnHash = clases.obtener(Integer.toString(idClase) + clase);
		if (oClaseEnHash==null) {
			oClase = new Clase(idClase, clase);
			try {
				clases.insertar(Integer.toString(idClase) + clase, oClase);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		} else {
			oClase = oClaseEnHash;
		}
		return oClase;
	}

	private Pais vPais(String pais) {
		Pais oPais = new Pais(pais);
		if (!paises.pertenece(pais)) {
			try {
				paises.insertar(pais, oPais);
			} catch (ElementoYaExistenteException e) {
				e.printStackTrace();
			}
		} else {
			oPais = paises.obtener(pais);
		}
		return oPais;
	}

	public HashTable<Long, Empresa> getEmpresas() {
		return empresas;
	}

	public HashTable<String, Pais> getPaises() {
		return paises;
	}

	public HashTable<String, Clase> getClases() {
		return clases;
	}

	public HashTable<String, Producto> getProductos() {
		return productos;
	}

}
