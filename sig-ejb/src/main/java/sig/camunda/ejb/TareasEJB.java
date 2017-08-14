package sig.camunda.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_dto.MyTask;
import com.sig.camunda.bpm_lib.CamundaEngine;

import sig.ejb.dto.TareaDTO;
import sig.ejb.dto.variableDTO;

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
	public void taskComplete(TareaDTO tarea) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskComplete(tarea.getBpmtaskid(), tarea.getVarKey(), tarea.getVarValue());
	}

	@Override
	public void taskComplete2(TareaDTO tarea) {
		CamundaEngine camunda = new CamundaEngine();

		Map<String, Object> variables = new HashMap<String, Object>();
		for (variableDTO v : tarea.getVariables()) {
			variables.put(v.getNombre(), v.getValor());
		}
		camunda.taskComplete(tarea.getBpmtaskid(), variables);
	}

	@Override
	public void taskClaim(TareaDTO tarea) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskClaim(tarea.getBpmtaskid(), tarea.getPerson());
	}

	@Override
	public void taskUpdateDescription(TareaDTO tarea) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskUpdateDescription(tarea.getBpmtaskid(), tarea.getDescription());
	}

	@Override
	public void taskDelegate(TareaDTO tarea) {
		CamundaEngine camunda = new CamundaEngine();
		camunda.taskDelegate(tarea.getBpmtaskid(), tarea.getPerson());
	}

}
