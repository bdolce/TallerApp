package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Articulo;
import entidades.Cliente;
import entidades.Marca;
import entidades.Tipo;

public class ArticuloData {

	PreparedStatement st;
	ResultSet rs;
	ClienteData cd;
	MarcaData md;
	TipoData td;

	public ArticuloData() {
		cd = new ClienteData();
		md = new MarcaData();
		td = new TipoData();
	}

	public Articulo getOneById(Articulo articulo) throws SQLException {
		Articulo a = null;
		st = null;
		rs = null;


		try {
			String sql = "SELECT * FROM articulos WHERE id =?";

			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setInt(1, articulo.getId());
			rs = st.executeQuery();

			if (rs.next()) {
				//Mapeo el articulo encontrado
				int id = rs.getInt("id");
				String modelo = rs.getString("modelo");
				String serie = rs.getString("serie");

				//Mapeo las entidades dentro del articulo
				Cliente c = new Cliente();
				c.setId(rs.getInt("id_cliente"));
				Cliente cliente = cd.getOneById(c);

				Marca m = new Marca();
				m.setId(rs.getInt("id_marca"));
				Marca marca = md.getOne(m);

				Tipo t = new Tipo();
				t.setId(rs.getInt("id_tipo"));
				Tipo tipo = td.getOne(t);

				//Creo el articulo mapeado
				a = new Articulo(id, modelo, serie, cliente, marca, tipo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return a;
	}

	public List<Articulo> getAllByCliente(Articulo articulo) throws SQLException {
		List<Articulo> articulos = new ArrayList<>();
		st = null;
		rs = null;

		try {
			String sql = "SELECT * FROM articulos WHERE id_cliente=?";
			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setInt(1, articulo.getCliente().getId());

			while (rs.next()) {
				//Mapeo el articulo encontrado
				int id = rs.getInt("id");
				String modelo = rs.getString("modelo");
				String serie = rs.getString("serie");

				//Mapeo las entidades dentro del articulo
				Cliente c = new Cliente();
				c.setId(rs.getInt("id_cliente"));
				Cliente cliente = cd.getOneById(c);

				Marca m = new Marca();
				m.setId(rs.getInt("id_marca"));
				Marca marca = md.getOne(m);

				Tipo t = new Tipo();
				t.setId(rs.getInt("id_tipo"));
				Tipo tipo = td.getOne(t);

				//Creo el articulo mapeado y lo agrego a la lista
				Articulo a = new Articulo(id, modelo, serie, cliente, marca, tipo);
				articulos.add(a);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return articulos;
	}

	public List<Articulo> getAll() throws SQLException {
		List<Articulo> articulos = new ArrayList<>();
		Statement st = null;
		rs = null;

		try {
			String sql = "SELECT * FROM articulos";
			st = ConnectionFactory.getInstancia().getConn().createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				//Mapeo el articulo encontrado
				int id = rs.getInt("id");
				String modelo = rs.getString("modelo");
				String serie = rs.getString("serie");

				//Mapeo las entidades dentro del articulo
				Cliente c = new Cliente();
				c.setId(rs.getInt("id_cliente"));
				Cliente cliente = cd.getOneById(c);

				Marca m = new Marca();
				m.setId(rs.getInt("id_marca"));
				Marca marca = md.getOne(m);

				Tipo t = new Tipo();
				t.setId(rs.getInt("id_tipo"));
				Tipo tipo = td.getOne(t);

				//Creo el articulo mapeado y lo agrego a la lista
				Articulo a = new Articulo(id, modelo, serie, cliente, marca, tipo);
				articulos.add(a);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}

		return articulos;
	}

	public void actualizarArticulo(Articulo articulo) throws SQLException {
		st = null;
		rs = null;

		try {
			String sql = "UPDATE articulos SET modelo=?, serie=?, id_cliente=?, id_marca=?, id_tipo=? WHERE id=?";

			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setString(1, articulo.getModelo());
			st.setString(2, articulo.getSerie());
			st.setInt(3, articulo.getCliente().getId());
			st.setInt(4, articulo.getMarca().getId());
			st.setInt(5, articulo.getTipo().getId());
			st.setInt(6, articulo.getId());
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}

	public void crearArticulo(Articulo articulo) throws SQLException {
		st = null;
		rs = null;

		try {
			String sql = "INSERT INTO articulos (modelo, serie, id_cliente, id_marca, id_tipo) VALUES (?,?,?,?,?)";

			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setString(1, articulo.getModelo());
			st.setString(2, articulo.getSerie());
			st.setInt(3, articulo.getCliente().getId());
			st.setInt(4, articulo.getMarca().getId());
			st.setInt(5, articulo.getTipo().getId());
			st.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
}
