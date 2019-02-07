package datos;

import entidades.Usuario;

public class UsuarioData {
	
	public Usuario getOne(Usuario usuario) {
		return null;
	}
	
	public void crearUsuario(Usuario usuario) {
		
	}
	
	public boolean validarUsuario(Usuario usuario) {
		if (usuario.getUsername().equals("bruno") && usuario.getPassword().equals("1234")) {
			return true;
		}
		else  {
			return false;
		}
	}

}
