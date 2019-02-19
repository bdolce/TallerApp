package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Tipo;

public class TipoData {
	PreparedStatement st;
	ResultSet rs;

	public Tipo getOne(Tipo tipo) throws SQLException {
		Tipo t = null;
		st = null;
		rs = null;

		try {
			String sql = "SELECT * FROM tipos WHERE id=?";

			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setInt(1, tipo.getId());
			rs = st.executeQuery();

			if (rs.next()) {
				//Mapeo el tipo encontrado
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");

				//Creo el tipo mapeado
				t = new Tipo(id, descripcion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return t;
	}

	public List<Tipo> getAll() throws SQLException {
		List<Tipo> tipos = new ArrayList<>();
		Statement st = null;
		rs = null;

		try {
			String sql = "SELECT * FROM tipos";
			st = ConnectionFactory.getInstancia().getCon().createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				//Mapeo el tipo encontrado
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");

				//Creo el tipo mapeado y lo agrego a la lista
				Tipo t = new Tipo(id, descripcion);
				tipos.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return tipos;
	}

	public void actualizarTipo(Tipo tipo) throws SQLException {
		st = null;
		rs = null;

		try {
			String sql = "UPDATE tipos SET descripcion=? WHERE id=?";

			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, tipo.getDescripcion());
			st.setInt(2, tipo.getId());
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}

	public void crearTipo(Tipo tipo) throws SQLException {
		st = null;
		rs = null;

		try {
			String sql = "INSERT tipos (descripcion) VALUES (?)";

			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, tipo.getDescripcion());
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
}
