package sig.camunda.ejb;


import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_dto.MyProcessInstance;
import com.sig.camunda.bpm_lib.CamundaEngine;

@Stateless
public class InstanciasEJB implements InstanciasInterface {

	@Override
	public List<MyProcessInstance> listarInstancias() {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getProcessInstances();
	}

	@Override
	public List<MyProcessInstance> listarInstanciasProceso(String proceso) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getProcessInstances(proceso);
	}

	@Override
	public void eliminarInstancia(String instancia) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.processDelete(instancia);
	}

	@Override
	public Map<String, Object> getVariables(String processInstanceId) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getVariables(processInstanceId);
	}
	
	

}
