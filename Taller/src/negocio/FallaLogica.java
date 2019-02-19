package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.FallaData;
import entidades.Falla;

public class FallaLogica {

	private FallaData fd;
	
	public FallaLogica() {
		fd = new FallaData();
	}
	
	public Falla getOne(Falla falla) throws SQLException {
		return fd.getOne(falla);
	}
	
	public List<Falla> getAll() throws SQLException {
		return fd.getAll();
	}
	
	public void actualizarFalla(Falla falla) throws SQLException {
		fd.actualizarFalla(falla);
	}
	
	public void crearFalla(Falla falla) throws SQLException {
		fd.crearFalla(falla);
	}
}
