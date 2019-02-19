package entidades;

public class Tipo {
	private int id;
	private String descripcion;
	
	public Tipo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	public Tipo(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Tipo() {
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
	
	@Override
	public String toString() {
		return descripcion;
	}
	
	
}
