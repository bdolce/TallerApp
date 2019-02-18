package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.OrdenData;
import entidades.Orden;

public class OrdenLogica {
	private OrdenData od;
	
	public OrdenLogica() {
		od = new OrdenData();
	}

	public Orden getOneById(Orden orden) throws SQLException {
		return od.getOneById(orden);
	}
	
	public List<Orden> getAll() throws SQLException {
		return od.getAll();
	}
	
	public void actualizarOrden(Orden orden) throws SQLException {
		od.actualizarOrden(orden);
	}
	
	public void crearOrden(Orden orden) throws SQLException {
		od.crearOrden(orden);
	}
}
