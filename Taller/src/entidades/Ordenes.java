package entidades;

import java.io.Serializable;
import java.util.Date;

public class Ordenes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2335039265025063924L;
	private int id;
	private Date fecha_ingreso;
	private Date fecha_revision;
	private Date fecha_aviso;
	private Date fecha_retiro;
	private String estado;
	private String observaciones;
	private String accesorios;
	private int prioridad;
	private Articulo articulo;
	
	public Ordenes(Date fecha_ingreso, String observaciones, String accesorios, int prioridad, Articulo articulo) {
		this.fecha_ingreso = fecha_ingreso;
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

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_revision() {
		return fecha_revision;
	}

	public void setFecha_revision(Date fecha_revision) {
		this.fecha_revision = fecha_revision;
	}

	public Date getFecha_aviso() {
		return fecha_aviso;
	}

	public void setFecha_aviso(Date fecha_aviso) {
		this.fecha_aviso = fecha_aviso;
	}

	public Date getFecha_retiro() {
		return fecha_retiro;
	}

	public void setFecha_retiro(Date fecha_retiro) {
		this.fecha_retiro = fecha_retiro;
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
