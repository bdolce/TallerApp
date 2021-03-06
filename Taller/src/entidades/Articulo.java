package entidades;

import java.io.Serializable;

public class Articulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5073187171268604339L;
	private int id;
	//private String descripcion; //cuando se usaria esto? si la desc es el tipo basicamente
	private String modelo;
	private String serie;
	private Cliente cliente;
	private Marca marca;
	private Tipo tipo;
	
	public Articulo(int id, String modelo, String serie, Cliente cliente, Marca marca, Tipo tipo) {
		this.id = id;
		this.modelo = modelo;
		this.serie = serie;
		this.cliente = cliente;
		this.marca = marca;
		this.tipo = tipo;
	}
	
	public Articulo(int id, String modelo, String serie, Marca marca, Tipo tipo) {
		this.id = id;
		this.modelo = modelo;
		this.serie = serie;
		this.marca = marca;
		this.tipo = tipo;
	}

	public Articulo(Cliente cliente, Marca marca, Tipo tipo, String modelo) {
		this.cliente = cliente;
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
	}

	public Articulo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.getId() + " - " + tipo.getDescripcion() + " " + marca.getNombre();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
