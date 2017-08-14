package sig.rest.dto;

import java.util.Map;

public class variableDTO {

	private String bpmtaskid;
	private Map<String, Object> variables;
	private String key;
	private Object value;
	public variableDTO() {
		super();
	}
	public String getBpmtaskid() {
		return bpmtaskid;
	}
	public void setBpmtaskid(String bpmtaskid) {
		this.bpmtaskid = bpmtaskid;
	}
	public Map<String, Object> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
