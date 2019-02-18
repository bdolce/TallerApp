package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.MarcaData;
import entidades.Marca;

public class MarcaLogica {
	private MarcaData md;
	
	public MarcaLogica() {
		this.md = new MarcaData();
	}
	
	public Marca getOne(Marca marca) throws SQLException {
		return md.getOne(marca);
	}
	
	public List<Marca> getAll() throws SQLException {
		return md.getAll();
	}
	
	public void actualizarMarca(Marca marca) throws SQLException {
		md.actualizarMarca(marca);
	}
	
	public void crearMarca(Marca marca) throws SQLException {
		md.crearMarca(marca);
	}
}
