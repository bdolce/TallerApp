package entidades;

public class Diagnostico {
	private int id;
	private String descripcion;
	
	public Diagnostico(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public Diagnostico(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
