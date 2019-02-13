package entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8042470043434018830L;
	private int id;
	private String username;
	private String password;
	private String email;
	
	public Usuario(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
		this.email = null;
	}

	public Usuario(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Usuario() {
	
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
