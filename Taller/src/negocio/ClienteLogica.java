package negocio;

import java.util.List;

import datos.ClienteData;
import entidades.Cliente;

public class ClienteLogica {
	
	private ClienteData cd;
	
	public ClienteLogica() {
		this.cd = new ClienteData();
	}
	
	public Cliente getOne(Cliente cliente) {
		return cd.getOne(cliente);
	}
	
	public List<Cliente> getAll() {
		return cd.getAll();
	}
	
	public void actualizarCliente() {
		cd.actualizarCliente();
	}
	
	public void crearCliente() {
		cd.crearCliente();
	}

}
