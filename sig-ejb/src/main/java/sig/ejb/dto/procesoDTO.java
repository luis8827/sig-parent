package sig.ejb.dto;

import java.util.List;
import java.util.Map;

public class procesoDTO {

	private String idproceso;
	private String businessKey;
	private String description;
	private String person;
	private List<variableDTO> variables;

	public procesoDTO(String idproceso, String businessKey, String description, String person,
			List<variableDTO> variables) {
		super();
		this.idproceso = idproceso;
		this.businessKey = businessKey;
		this.description = description;
		this.person = person;
		this.variables = variables;
	}

	public procesoDTO() {
		super();
	}

	public String getIdproceso() {
		return idproceso;
	}

	public void setIdproceso(String idproceso) {
		this.idproceso = idproceso;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public List<variableDTO> getVariables() {
		return variables;
	}

	public void setVariables(List<variableDTO> variables) {
		this.variables = variables;
	}

}
