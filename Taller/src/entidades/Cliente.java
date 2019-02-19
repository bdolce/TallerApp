package entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6208379818286784486L;
	private int id;
	private String apellido;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	
	public Cliente(int id, String apellido, String nombre, String direccion, String telefono, String email) {
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Cliente(String apellido, String nombre, String direccion, String telefono, String email) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public Cliente() {
		this.apellido = null;
		this.nombre = null;
		this.direccion = null;
		this.telefono = null;
		this.email = null;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return (apellido +" "+ nombre);
	}
	
	
}
