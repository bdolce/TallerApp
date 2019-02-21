package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Diagnostico;


public class DiagnosticoData {
	PreparedStatement st;
	ResultSet rs;

	public Diagnostico getOne(Diagnostico diagnostico) throws SQLException {
		Diagnostico d = null;
		st = null;
		rs = null;

		try {
			String sql = "SELECT * FROM diagnosticos WHERE id=?";

			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setInt(1, diagnostico.getId());
			rs = st.executeQuery();
			
			if (rs.next()) {
				//Mapeo el diagnostico encontrado
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");

				//Creo el diagnostico encontrado
				d = new Diagnostico(id, descripcion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return d;
	}

	public List<Diagnostico> getAll() throws SQLException {
		List<Diagnostico> diagnosticos = new ArrayList<>();
		Statement st = null;
		rs = null;

		try {
			String sql = "SELECT * FROM diagnosticos";
			st = ConnectionFactory.getInstancia().getConn().createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//Mapeo el diagnostico encontrado
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");

				//Creo el diagnostico mapeado y lo agrego a la lista
				Diagnostico d = new Diagnostico(id, descripcion);
				diagnosticos.add(d);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return diagnosticos;
	}

	public void actualizarDiagnostico(Diagnostico diagnostico) throws SQLException {
		st = null;
		rs = null;

		try {
			String sql = "UPDATE diagnosticos SET descripcion=? WHERE id=?";

			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setString(1, diagnostico.getDescripcion());
			st.setInt(2, diagnostico.getId());
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}

	public void crearDiagnostico(Diagnostico diagnostico) throws SQLException {
		st = null;
		rs = null;

		try {
			String sql = "INSERT INTO diagnosticos (descripcion) VALUES (?)";

			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setString(1, diagnostico.getDescripcion());
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
}
