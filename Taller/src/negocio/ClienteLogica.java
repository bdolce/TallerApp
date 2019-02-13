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
	
	public List<Cliente> getAll() throws SQLException {
		return cd.getAll();
	}
	
	public void actualizarCliente() throws SQLException {
		cd.actualizarCliente();
	}
	
	public void crearCliente() throws SQLException {
		cd.crearCliente();
	}

}
