package sig.rest.dto;

import java.util.Map;

public class RespuestaDTO {
	private boolean success;
	private Map<String, Object> data;

	public RespuestaDTO(boolean success, Map<String, Object> data) {
		super();
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
