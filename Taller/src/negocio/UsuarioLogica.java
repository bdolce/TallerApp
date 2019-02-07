package negocio;

import datos.UsuarioData;
import entidades.Usuario;

public class UsuarioLogica {
	
	private UsuarioData ud;
	
	public UsuarioLogica() {
		ud = new UsuarioData();
	}

	public Usuario getOne(Usuario usuario) {
		return ud.getOne(usuario);
	}
	
	public void crearUsuario(Usuario usuario) {
		ud.crearUsuario(usuario);
	}
	
	public boolean validarUsuario(Usuario usuario) {
		return ud.validarUsuario(usuario);
	}


}
