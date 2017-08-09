package sig.camunda.ejb;

import java.util.List;

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
		//
		CamundaEngine camunda = new CamundaEngine();

		System.out.println("completar tarea desde lib");
		camunda.taskComplete(tarea, "var2:", "2");
	}

	@Override
	public void asignarUsurioTarea(String tarea, String persona) {
		//
		CamundaEngine camunda = new CamundaEngine();

		camunda.taskAssignee(tarea, persona);
	}

}
