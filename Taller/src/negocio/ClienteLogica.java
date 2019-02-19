package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.ClienteData;
import entidades.Cliente;

public class ClienteLogica {
	
	private ClienteData cd;
	
	public ClienteLogica() {
		this.cd = new ClienteData();
	}
	
	public Cliente getOneByApellido(Cliente cliente) throws SQLException {
		return cd.getOneByApellido(cliente);
	}
	
	public Cliente getOneById(Cliente cliente) throws SQLException {
		return cd.getOneById(cliente);
	}
	
	public List<Cliente> getAll() throws SQLException {
		return cd.getAll();
	}
	
	public void actualizarCliente(Cliente cliente) throws SQLException {
		cd.actualizarCliente(cliente);
	}
	
	public void crearCliente(Cliente cliente) throws SQLException {
		cd.crearCliente(cliente);
	}

}
