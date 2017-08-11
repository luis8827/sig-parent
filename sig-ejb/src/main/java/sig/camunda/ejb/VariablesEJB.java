package sig.camunda.ejb;

import java.util.Map;

import com.sig.camunda.bpm_lib.CamundaEngine;

public class VariablesEJB implements VariablesInterface{

	@Override
	public Map<String, Object> getVariables(String processInstanceId) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getVariables(processInstanceId);
	}

	@Override
	public void instanceSetVariableByTaskId(String bpmtaskid, String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instanceSetVariable(String processInstanceId, Map<String, Object> variables) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getVariable(String executionId, String variableName) {
		// TODO Auto-generated method stub
		return null;
	}

}
