package sig.camunda.ejb;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface VariablesInterface {

	Map<String, Object> getVariables(String processInstanceId);

	void instanceSetVariableByTaskId(String bpmtaskid, String key, Object value);

	void instanceSetVariable(String bpmtaskid, Map<String, Object> variables);

	Object getVariable(String bpmtaskid, String variableName);
	
}
