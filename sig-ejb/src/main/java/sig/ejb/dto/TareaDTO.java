package sig.ejb.dto;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author bog { "bpmtaskid":"", "varKey":"", "varValue":"", "variables":{},
 *         "person":"", "description":"", }
 */

public class TareaDTO {

	private String bpmtaskid;
	private String varKey;
	private Object varValue;
	private List<variableDTO> variables;
	private String person;
	private String description;

	public TareaDTO() {
		super();
	}

	public TareaDTO(String bpmtaskid, String varKey, Object varValue, List<variableDTO> variables, String person,
			String description) {
		super();
		this.bpmtaskid = bpmtaskid;
		this.varKey = varKey;
		this.varValue = varValue;
		this.variables = variables;
		this.person = person;
		this.description = description;
	}

	public String getBpmtaskid() {
		return bpmtaskid;
	}

	public void setBpmtaskid(String bpmtaskid) {
		this.bpmtaskid = bpmtaskid;
	}

	public String getVarKey() {
		return varKey;
	}

	public void setVarKey(String varKey) {
		this.varKey = varKey;
	}

	public Object getVarValue() {
		return varValue;
	}

	public void setVarValue(Object varValue) {
		this.varValue = varValue;
	}

	public List<variableDTO> getVariables() {
		return variables;
	}

	public void setVariables(List<variableDTO> variables) {
		this.variables = variables;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
