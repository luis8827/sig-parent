package sig.camunda.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_dto.MyTask;
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
		//
		CamundaEngine camunda = new CamundaEngine();

		camunda.taskAssignee(tarea, persona);
	}

	@Override
	public List<MyTask> taskListByUserAndInstanceId(String processInstanceId, String person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyTask> taskListByProcessInstanceId(String processInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyTask> historyTaskListByUser(String processInstanceId, String person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void taskComplete(String bpmtaskid, String varKey, Object varValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskComplete(String bpmtaskid, Map<String, Object> variables) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskClaim(String bpmtaskid, String person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskUpdateDescription(String bpmtaskid, String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskDelegate(String bpmtaskid, String person) {
		// TODO Auto-generated method stub

	}

}
