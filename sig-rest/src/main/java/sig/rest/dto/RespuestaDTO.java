package sig.rest.dto;

import java.util.Map;

public class RespuestaDTO {
	private boolean success;
	private Object data;
	public RespuestaDTO() {
		super();
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

	
	
	
}
