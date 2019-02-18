package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Articulo;
import entidades.Orden;

public class OrdenData {
	
	PreparedStatement st;
	ResultSet rs;
	ArticuloData al;
	
	public Orden getOneById(Orden orden) throws SQLException {
		Orden o = null;
		st = null;
		rs = null;
		al = new ArticuloData();
		
		try {
			String sql = "SELECT * FROM ordenes WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setInt(1, orden.getId());
			
			if (rs.next()) {
				//Mapeo la orden encontrada
				int id = rs.getInt("id");
				Date fechaIngreso = rs.getDate("fecha_ingreso");
				Date fechaRevision = rs.getDate("fecha_revision");
				Date fechaAviso = rs.getDate("fecha_aviso");
				Date fechaRetiro = rs.getDate("fecha_retiro");
				String estado = rs.getString("estado");
				String observaciones = rs.getString("observaciones");
				String accesorios = rs.getString("accesorios");
				int prioridad = rs.getInt("prioridad");
				
				int id_articulo = rs.getInt("id_articulo");
				Articulo articulo = al.getOneById(id_articulo);
				
				//Creo la orden mapeada
				o = new Orden(id, fechaIngreso, fechaRevision, fechaAviso, fechaRetiro, estado, observaciones, accesorios, prioridad, articulo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return o;
	}
	
	public List<Orden> getAll() throws SQLException {
		List<Orden> ordenes = new ArrayList<>();
		Statement st = null;
		rs = null;
		al = new ArticuloData();
		
		try {
			String sql = "SELECT * FROM ordenes";
			st = ConnectionFactory.getInstancia().getCon().createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//Mapeo la orden encontrada
				int id = rs.getInt("id");
				Date fechaIngreso = rs.getDate("fecha_ingreso");
				Date fechaRevision = rs.getDate("fecha_revision");
				Date fechaAviso = rs.getDate("fecha_aviso");
				Date fechaRetiro = rs.getDate("fecha_retiro");
				String estado = rs.getString("estado");
				String observaciones = rs.getString("observaciones");
				String accesorios = rs.getString("accesorios");
				int prioridad = rs.getInt("prioridad");
				
				int id_articulo = rs.getInt("id_articulo");
				Articulo articulo = al.getOneById(id_articulo);
				
				//Creo la orden mapeada
				Orden o = new Orden(id, fechaIngreso, fechaRevision, fechaAviso, fechaRetiro, estado, observaciones, accesorios, prioridad, articulo);
				ordenes.add(o);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return ordenes;
	}
	
	public void actualizarOrden(Orden orden) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "UPDATE ordenes SET fecha_ingreso=?, fecha_revision=?, fecha_aviso=?, "
					   + " fecha_retiro=?, estado=?, observaciones=?, accesorios=?, prioridad=?, articulo=? WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setDate(1, new java.sql.Date(orden.getFechaIngreso().getTime()));
			st.setDate(2, new java.sql.Date(orden.getFechaRevision().getTime()));
			st.setDate(3, new java.sql.Date(orden.getFechaAviso().getTime()));
			st.setDate(4, new java.sql.Date(orden.getFechaRetiro().getTime()));
			st.setString(5, orden.getEstado());
			st.setString(6, orden.getObservaciones());
			st.setString(7, orden.getAccesorios());
			st.setInt(8, orden.getPrioridad());
			st.setInt(9, orden.getArticulo().getId());
			st.setInt(10, orden.getId());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();

		}
	}
	
	public void crearOrden(Orden orden) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "INSERT INTO ordenes (fecha_ingreso, fecha_revision, fecha_aviso, fecha_retiro, estado, "
					+ " observaciones, accesorios, prioridad, articulo) VALUES (?,?,?,?,?,?,?,?,?)";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setDate(1, new java.sql.Date(orden.getFechaIngreso().getTime()));
			st.setDate(2, new java.sql.Date(orden.getFechaRevision().getTime()));
			st.setDate(3, new java.sql.Date(orden.getFechaAviso().getTime()));
			st.setDate(4, new java.sql.Date(orden.getFechaRetiro().getTime()));
			st.setString(5, orden.getEstado());
			st.setString(6, orden.getObservaciones());
			st.setString(7, orden.getAccesorios());
			st.setInt(8, orden.getPrioridad());
			st.setInt(9, orden.getArticulo().getId());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();

		}
	}
}
