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

	public Cliente getOneById(Cliente cliente) throws SQLException {	
		Cliente c = null;
		st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM clientes WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setInt(1, cliente.getId());
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
			} else {
				System.out.println("oi no hay nada wey ");
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
		rs = null;
		
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

	public void actualizarCliente(Cliente cliente) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "UPDATE clientes SET apellido=?, nombre=?, direccion=?, telefono=?, email=? WHERE id=?";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, cliente.getApellido());
			st.setString(2, cliente.getNombre());
			st.setString(3, cliente.getDireccion());
			st.setString(4, cliente.getTelefono());
			st.setString(5, cliente.getEmail());
			st.setInt(6, cliente.getId());
			st.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
	}

	public void crearCliente(Cliente cliente) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "INSERT INTO clientes (apellido, nombre, direccion, telefono, email) VALUES (?,?,?,?,?) ";
			
			st = ConnectionFactory.getInstancia().getCon().prepareStatement(sql);
			st.setString(1, cliente.getApellido());
			st.setString(2, cliente.getNombre());
			st.setString(3, cliente.getDireccion());
			st.setString(4, cliente.getTelefono());
			st.setString(5, cliente.getEmail());
			st.execute();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
	}

}
