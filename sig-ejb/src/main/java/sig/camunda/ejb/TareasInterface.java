package sig.camunda.ejb;

import java.util.List;

import javax.ejb.Local;

import com.sig.camunda.bpm_dto.MyTask;

import sig.ejb.dto.TareaDTO;

@Local
public interface TareasInterface {

	List<MyTask> listarTareasPendientes(String instancia);

	List<MyTask> listarTareasPendientesUsuario(String Persona);

	void completarTarea(String tarea);

	void asignarUsurioTarea(String tarea, String persona);

	List<MyTask> taskListByUserAndInstanceId(String processInstanceId, String person);

	List<MyTask> taskListByProcessInstanceId(String processInstanceId);

	List<MyTask> historyTaskListByUser(String processInstanceId, String person);

	void taskComplete(TareaDTO tarea);

	void taskComplete2(TareaDTO tareas);

	void taskClaim(TareaDTO tarea);

	void taskUpdateDescription(TareaDTO tarea);

	void taskDelegate(TareaDTO tarea);
}
