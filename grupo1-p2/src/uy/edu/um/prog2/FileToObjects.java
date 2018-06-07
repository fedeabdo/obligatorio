package uy.edu.um.prog2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import uy.edu.um.prog2.Exceptions.EspecificacionesException;
import uy.edu.um.prog2.Exceptions.RubroException;
import uy.edu.um.prog2.adt.Hash.*;
import uy.edu.um.prog2.adt.Hash.Exceptions.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.ListaEnlazadaSimple.*;
import uy.edu.um.prog2.adt.Tree.*;

import static uy.edu.um.prog2.Especificaciones.especificar;

public class FileToObjects {
	private MiListaEnlazada<Empresa> empresas;
	private MiListaEnlazada<Pais> paises;
	private MyBinarySearchTree<Integer, Clase> clases;
	private HashTable<Integer, Producto> productos;
	int cantProductos;

	public FileToObjects() {
		empresas = new ListaEnlazadaSimple<>();
		paises = new ListaEnlazadaSimple<>();
		clases = new BSTImpl<>();
		productos = new HashCerrado<>(53000, true);
		cantProductos = 0;
	}

	public void loadFiles(String dir) throws IOException {
		String encodedData = "UTF8";							//Codificacion del archivo. UTF-8 en nuestro caso.
		File fileDir = new File(dir);									//En el obligatorio dirDatos = tabla_datos.csv
		BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir),encodedData));

		String readLine = null;

		readLine = b.readLine();									//lee la 1era liena. La lee con " extras al principio y final.
		readLine = readLine.substring(1, readLine.length()-1);		//Para solucionarlo hacemos un substring de ese Strng sacando esas " extras
		String[] nombreCol = readLine.split("\";\"");				// \" representa " , lo hacemos para separar los ; entre columnas y los ; usados dentro de una misma columna
		HashCerrado<String, Integer> fieldsCol = new HashCerrado<>(nombreCol.length + 10, true);	//Hash de todas las columnas de los datos
		for(int i = 0; i<nombreCol.length; i++) {
			try {
				fieldsCol.insertar(nombreCol[i], i);
			} catch (ElementoYaExistenteException e) {
				e.getStackTrace();
			}
		}
		
		String[] especificaciones = new String[11];				//Estas son los nombres de las columnas que nos interesan en este caso.
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
			indEspCol = especificar(especificaciones, fieldsCol);			//a este metodo le ponemos como argumento las columnas que queremos conocer su indice. Devuelve un vector con los indices de las respectivas columnas interesadas.
		} catch (EspecificacionesException e2) {
			e2.printStackTrace();
		}
		String[] fields = null;
		readLine = b.readLine();										//leemos la 2da linea
		while (readLine != null) {
			readLine = readLine.substring(1, readLine.length()-1);		//sacamos las comillas extras
			fields = readLine.split("\";\"");							//separamos
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				productos.insertar(idProd, producto);
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
		if (empresas == null) {
			empresas.agregar(oEmpresa);
		} else if (empresas.esta(oEmpresa) == null) {
			empresas.agregar(oEmpresa);
		} else {
			oEmpresa = empresas.esta(oEmpresa);
		}
		return oEmpresa;
	}

	private Clase vClase(Integer idClase, String clase) {
		Clase oClase = null;
		if (clases == null) {
			oClase = new Clase(idClase, clase);
			clases.insert(idClase, oClase);
		} else if (clases.find(idClase) == null) {
			oClase = new Clase(idClase, clase);
			clases.insert(idClase, oClase);
		} else {
			oClase = clases.find(idClase);
		}
		return oClase;
	}

	private Pais vPais(String pais) {
		Pais oPais = new Pais(pais);
		if (paises == null) {
			paises.agregar(oPais);
		} else if (paises.esta(oPais) == null) {
			paises.agregar(oPais);
		} else {
			oPais = paises.esta(oPais);
		}
		return oPais;
	}

	public MiListaEnlazada<Empresa> getEmpresas() {
		return empresas;
	}

	public MiListaEnlazada<Pais> getPaises() {
		return paises;
	}

	public MyBinarySearchTree<Integer, Clase> getClases() {
		return clases;
	}

	public HashTable<Integer, Producto> getProductos() {
		return productos;
	}

}
