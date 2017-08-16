package sig.rest.dto;

public class UsuarioProcesoDTO {

	private String usuario;
	private String proceso;

	public UsuarioProcesoDTO() {		
		
	}
	
	public UsuarioProcesoDTO(String usuario, String proceso) {
		super();
		this.usuario = usuario;
		this.proceso = proceso;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getProceso() {
		return proceso;
	}

}
