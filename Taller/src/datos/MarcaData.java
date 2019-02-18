package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Marca;

public class MarcaData {
	
	PreparedStatement st;
	ResultSet rs;
	
	public Marca getOne(Marca marca) throws SQLException {
		Marca m = null;
		st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM marcas WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setInt(1, marca.getId());
			
			if (rs.next()) {
				//Mapeo la marca encontrada
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				//Creo la Marca mapeada
				m = new Marca(id, nombre);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return m;
	}
	
	public List<Marca> getAll() throws SQLException {
		List<Marca> marcas = new ArrayList<>();
		Statement st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM marcas";
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//Mapeo la marca encontrada
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				//Creo la Marca mapeada y la agrego a la lista
				Marca m = new Marca(id, nombre);
				marcas.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return marcas;
	}
	
	public void actualizarMarca(Marca marca) throws SQLException {
		st = null;
		rs = null;
				
		try {
			String sql = "UPDATE marcas SET nombre=? WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, marca.getNombre());
			st.setInt(2, marca.getId());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
	
	public void crearMarca(Marca marca) throws SQLException {
		st = null;
		rs = null;
				
		try {
			String sql = "INSERT INTO marcas (nombre) VALUES (?)";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, marca.getNombre());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
}
