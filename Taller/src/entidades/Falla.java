package entidades;

public class Falla {
	private int id;
	private String descripcion;
	
	public Falla(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public Falla(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesripcion() {
		return descripcion;
	}
	public void setDesripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
