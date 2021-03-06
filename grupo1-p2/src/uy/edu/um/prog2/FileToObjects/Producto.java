package uy.edu.um.prog2.FileToObjects;

import uy.edu.um.prog2.adt.ListaEnlazadaSimple.MiListaEnlazada;
import uy.edu.um.prog2.Exceptions.RubroException;

public class Producto {
	private String nombre;
	private String nombreFantasia;
	private int nProd;
	private int nHab;
	private String estado;
	private Clase	clase;
	private Pais	pais;
	private Marca	marca;
	private	Empresa	empresa;
	private	MiListaEnlazada<Rubro>	rubro;

	public Producto(String nombre, String nombreFantasia, String estado, Clase clase, Pais pais, Marca marca,
			Empresa empresa, MiListaEnlazada<Rubro> rubro, int nProd,int nHab) throws RubroException {
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.estado = estado;
		this.clase = clase;
		this.pais = pais;
		this.marca = marca;
		this.empresa = empresa;
		this.nProd = nProd;
		this.nHab = nHab;
		if(rubro.tamanio() > 2 || rubro.tamanio() == 0) {
			throw new RubroException("Excedio cantidad de rubros.");
		} else {
			this.rubro = rubro;
		}
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getNombreFantasia() {
		return nombreFantasia;
	}
	public String getEstado() {
		return estado;
	}
	public Clase getClase() {
		return clase;
	}
	public Pais getPais() {
		return pais;
	}
	public Marca getMarca() {
		return marca;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public MiListaEnlazada<Rubro> getRubro() {
		return rubro;
	}
	public int getnProd() {
		return nProd;
	}

	public int getnHab() {
		return nHab;
	}
	@Override
	public int hashCode() {
		int result = 1;
		result = (nHab + nProd + nombre).hashCode();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nHab != other.nHab)
			return false;
		if (nProd != other.nProd)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
}
