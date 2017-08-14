package sig.camunda.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_dto.MyTask;
import com.sig.camunda.bpm_lib.CamundaAuthentication;
import com.sig.camunda.bpm_lib.CamundaEngine;

@Stateless
public class TareasEJB implements TareasInterface {

	@Override
	public List<MyTask> listarTareasPendientes(String instancia) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.taskListByProcessInstanceId(instancia);
	}

	@Override
	public List<MyTask> listarTareasPendientesUsuario(String Persona) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.taskListByUser(Persona);
	}

	@Override
	public void completarTarea(String tarea) {
		CamundaEngine camunda = new CamundaEngine();
		System.out.println("completar tarea desde lib");
		camunda.taskComplete(tarea);
	}

	@Override
	public void asignarUsurioTarea(String tarea, String persona) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskAssignee(tarea, persona);
	}

	///////////////////// 77
	@Override
	public List<MyTask> taskListByUserAndInstanceId(String processInstanceId, String person) {
		CamundaEngine camunda = new CamundaEngine();

		return camunda.taskListByUserAndInstanceId(processInstanceId, person);
	}

	@Override
	public List<MyTask> taskListByProcessInstanceId(String processInstanceId) {

		CamundaEngine camunda = new CamundaEngine();

		return camunda.taskListByProcessInstanceId(processInstanceId);
	}

	@Override
	public List<MyTask> historyTaskListByUser(String processInstanceId, String person) {

		CamundaEngine camunda = new CamundaEngine();

		return camunda.historyTaskListByUser(processInstanceId, person);
	}

	@Override
	public void taskComplete(String bpmtaskid, String varKey, Object varValue) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskComplete(bpmtaskid, varKey, varValue);
	}

	@Override
	public void taskComplete(String bpmtaskid, Map<String, Object> variables) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskComplete(bpmtaskid, variables);
	}

	@Override
	public void taskClaim(String bpmtaskid, String person) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskClaim(bpmtaskid, person);
	}

	@Override
	public void taskUpdateDescription(String bpmtaskid, String description) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskUpdateDescription(bpmtaskid, description);
	}

	@Override
	public void taskDelegate(String bpmtaskid, String person) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskDelegate(bpmtaskid, person);
	}

}
