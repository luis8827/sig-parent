package sig.rest.dto;

public class UsuarioDTO {

	private String usuario;
	private String password;

	public UsuarioDTO(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public UsuarioDTO() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
