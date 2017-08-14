package sig.camunda.ejb;

import java.util.Map;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_lib.CamundaEngine;

@Stateless
public class VariablesEJB implements VariablesInterface{

	@Override
	public Map<String, Object> getVariables(String processInstanceId) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getVariables(processInstanceId);
	}

	@Override
	public void instanceSetVariableByTaskId(String bpmtaskid, String key, Object value) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.instanceSetVariableByTaskId(bpmtaskid, key, value);
	}

	@Override
	public void instanceSetVariable(String bpmtaskid, Map<String, Object> variables) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.instanceSetVariableByTaskId(bpmtaskid, variables);
	}

	@Override
	public Object getVariable(String processInstanceId, String variableName) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getVariable(processInstanceId, variableName);
		
	}

}
