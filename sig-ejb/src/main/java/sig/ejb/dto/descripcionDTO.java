package sig.ejb.dto;

public class descripcionDTO {

	private String processDefinitionKey;
	private String businessKey;
	private String description;
	private String person;

	public descripcionDTO(String processDefinitionKey, String businessKey, String description, String person) {
		super();
		this.processDefinitionKey = processDefinitionKey;
		this.businessKey = businessKey;
		this.description = description;
		this.person = person;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
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

}
