package negocio;

import java.sql.SQLException;

import datos.UsuarioData;
import entidades.Usuario;

public class UsuarioLogica {
	
	private UsuarioData ud;
	
	public UsuarioLogica() {
		ud = new UsuarioData();
	}

	public Usuario getOne(Usuario usuario) throws SQLException {
		return ud.getOne(usuario);
	}
	
	public void crearUsuario(Usuario usuario) throws SQLException {
		ud.crearUsuario(usuario);
	}
	
	public boolean validarUsuario(Usuario usuario) throws Exception {
		return ud.validarUsuario(usuario);
	}


}
