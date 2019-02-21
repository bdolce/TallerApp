package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Usuario;

public class UsuarioData {
	
	PreparedStatement st = null;
	ResultSet rs = null;
	
	public Usuario getOne(Usuario usuario) throws SQLException {
		
		Usuario u = null;
		st = null;
		rs = null;
		
		try {
			String sql = "SELECT * FROM usuarios WHERE username=?";
			
			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setString(1, usuario.getUsername());
			rs = st.executeQuery();
			
			if (rs.next()) {	
				//Mapeo el usuario encontrado
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				u = new Usuario(id, username, password);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
		
		return u;
	}
	
	public void crearUsuario(Usuario usuario) throws SQLException {
		st = null;
		rs = null;
		
		try {
			String sql = "INSERT INTO usuarios (username,password,email) VALUES (?,?,?)";
			String hashedPassword = PasswordStorage.createHash(usuario.getPassword());
			
			st = ConnectionFactory.getInstancia().getConn().prepareStatement(sql);
			st.setString(1, usuario.getUsername());
			st.setString(2, hashedPassword);
			st.setString(3, usuario.getEmail());
			st.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			ConnectionFactory.getInstancia().releaseConn();
		}
	}
	
	public boolean validarUsuario(Usuario usuario) throws Exception {
		Usuario u = getOne(usuario);
		if (usuario.getUsername().equals(u.getUsername()) &&
				PasswordStorage.verifyPassword(usuario.getPassword(), u.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}
