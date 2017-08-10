package sig.rest.dto;

import java.util.Map;

public class RespuestaDTO {
	private boolean success;
	private Map<String, Object> variables;
	public RespuestaDTO(boolean success, Map<String, Object> variables) {
		super();
		this.success = success;
		this.variables = variables;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Object> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
	
	
	
}
