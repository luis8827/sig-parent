package sig.camunda.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_dto.MyProcessInstance;
import com.sig.camunda.bpm_lib.CamundaEngine;

import sig.ejb.dto.descripcionDTO;

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
		camunda.deleteInstance(instancia);
	}

	@Override
	public boolean updateDescription(descripcionDTO descripcion) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.updateDescription(descripcion.getProcessDefinitionKey(), descripcion.getBusinessKey(),
				descripcion.getDescription());
	}

	@Override
	public boolean updateDescriptionAndPerson(descripcionDTO descripcion) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.updateDescriptionAndPerson(descripcion.getProcessDefinitionKey(), descripcion.getBusinessKey(),
				descripcion.getDescription(), descripcion.getPerson());

	}

	@Override
	public void suspendInstance(String processInstanceId) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.suspendInstance(processInstanceId);
	}

	@Override
	public void activateInstance(String processInstanceId) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.activateInstance(processInstanceId);
	}

}
