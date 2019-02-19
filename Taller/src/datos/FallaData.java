package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Falla;

public class FallaData {
	
	PreparedStatement st;
	ResultSet rs;
	
	public Falla getOne(Falla falla) throws SQLException {
		Falla f = null;
		st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM fallas WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setInt(1, falla.getId());
			
			if (rs.next()) {
				//Mapeo la falla encontrada
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				
				//Creo la falla mapeada
				f = new Falla(id, descripcion);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return f;
	}
	
	public List<Falla> getAll() throws SQLException {
		List<Falla> fallas = new ArrayList<>();
		Statement st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM fallas";
			st = ConnectionFactory.getInstancia().getCon().createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//Mapeo la falla encontrada
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				
				//Creo la falla mapeada y la agrego a la lista 
				Falla f = new Falla(id, descripcion);
				fallas.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return fallas;
	}
	
	public void actualizarFalla(Falla falla) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "UPDATE fallas SET descripcion=? WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, falla.getDescripcion());
			st.setInt(2, falla.getId());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
	
	public void crearFalla(Falla falla) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "INSERT INTO fallas (descripcion) VALUES (?)";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, falla.getDescripcion());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
}
