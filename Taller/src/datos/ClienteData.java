package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;

public class ClienteData {

	PreparedStatement st;
	ResultSet rs;
	
	public Cliente getOneByApellido(Cliente cliente) throws SQLException {	
		Cliente c = null;
		st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM clientes WHERE apellido=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, cliente.getApellido());
			rs = st.executeQuery();
			
			if (rs.next()) {	
				//Mapeo el cliente encontrado
				int id = rs.getInt("id");
				String apellido = rs.getString("apellido");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				String email = rs.getString("email");
				
				//Creo el cliente mapeado
				c = new Cliente(id, apellido, nombre, direccion, telefono, email);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return c;
	}

	public List<Cliente> getAll() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM clientes";
			st = ConnectionFactory.getInstancia().getCon().createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				//Mapeo el cliente encontrado
				int id = rs.getInt("id");
				String apellido = rs.getString("apellido");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				String email = rs.getString("email");
				
				//Creo el cliente mapeado y lo agrego a la lista
				Cliente c = new Cliente(id, apellido, nombre, direccion, telefono, email);
				clientes.add(c);
			}			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return clientes;
	
}

	public void actualizarCliente() {
		// TODO Auto-generated method stub
		
	}

	public void crearCliente() {
		// TODO Auto-generated method stub
		
	}

}
