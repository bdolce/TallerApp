package entidades;

import java.io.Serializable;
import java.util.Date;

public class Orden implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2335039265025063924L;
	private int id;
	private Date fechaIngreso;
	private Date fechaRevision;
	private Date fechaAviso;
	private Date fechaRetiro;
	private String estado;
	private String observaciones;
	private String accesorios;
	private int prioridad;
	private Articulo articulo;
	
	public Orden(int id, Date fechaIngreso, Date fechaRevision, Date fechaAviso, Date fechaRetiro, String estado,
			String observaciones, String accesorios, int prioridad, Articulo articulo) {
		super();
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaRevision = fechaRevision;
		this.fechaAviso = fechaAviso;
		this.fechaRetiro = fechaRetiro;
		this.estado = estado;
		this.observaciones = observaciones;
		this.accesorios = accesorios;
		this.prioridad = prioridad;
		this.articulo = articulo;
	}

	public Orden(Date fechaIngreso, String observaciones, String accesorios, int prioridad, Articulo articulo) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.observaciones = observaciones;
		this.accesorios = accesorios;
		this.prioridad = prioridad;
		this.articulo = articulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public Date getFechaAviso() {
		return fechaAviso;
	}

	public void setFechaAviso(Date fechaAviso) {
		this.fechaAviso = fechaAviso;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getAccesorios() {
		return accesorios;
	}

	public void setAccesorios(String accesorios) {
		this.accesorios = accesorios;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	

}
