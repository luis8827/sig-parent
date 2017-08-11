package sig.rest.dto;

import java.util.Map;

public class RespuestaDTO {
	private boolean success;
	private Object data;
	private String mensaje;
	
	
	public RespuestaDTO() {
		super();
	}
	public RespuestaDTO(boolean success, Object data, String mensaje) {
		super();
		this.success = success;
		this.data = data;
		this.mensaje = mensaje;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	 

	
	
	
}
