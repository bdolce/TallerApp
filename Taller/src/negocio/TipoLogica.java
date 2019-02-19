package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.TipoData;
import entidades.Tipo;

public class TipoLogica {
	
	private TipoData td;

	public TipoLogica() {
		td = new TipoData();
	}
	
	public Tipo getOne(Tipo tipo) throws SQLException {
		return td.getOne(tipo);
	}
	
	public List<Tipo> getAll() throws SQLException {
		return td.getAll();
	}
	
	public void actualizarTipo(Tipo tipo) throws SQLException {
		td.actualizarTipo(tipo);
	}
	
	public void crearTipo(Tipo tipo) throws SQLException {
		td.crearTipo(tipo);
	}

}
