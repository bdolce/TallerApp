package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.ArticuloData;
import entidades.Articulo;

public class ArticuloLogica {

	private ArticuloData ad;
	
	public ArticuloLogica() {
		ad = new ArticuloData();
	}
	
	public Articulo getOneById(Articulo articulo) throws SQLException {
		return ad.getOneById(articulo);
	}
	
	public List<Articulo> getAllByCliente(Articulo articulo) throws SQLException {
		return ad.getAllByCliente(articulo);
	}
	
	public List<Articulo> getAll() throws SQLException {
		return ad.getAll();
	}
	
	public void actualizarArticulo(Articulo articulo) throws SQLException {
		ad.actualizarArticulo(articulo);
	}
	
	public void crearArticulo(Articulo articulo) throws SQLException {
		ad.crearArticulo(articulo);
	}
	
	
}
