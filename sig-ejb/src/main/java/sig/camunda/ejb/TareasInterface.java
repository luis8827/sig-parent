package sig.camunda.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.sig.camunda.bpm_dto.MyTask;

@Local
public interface TareasInterface {

	List<MyTask> listarTareasPendientes(String instancia);

	List<MyTask> listarTareasPendientesUsuario(String Persona);

	void completarTarea(String tarea);

	void asignarUsurioTarea(String tarea, String persona);

	List<MyTask> taskListByUserAndInstanceId(String processInstanceId, String person);

	List<MyTask> taskListByProcessInstanceId(String processInstanceId);

	List<MyTask> historyTaskListByUser(String processInstanceId, String person);

	void taskComplete(String bpmtaskid, String varKey, Object varValue);

	void taskComplete(String bpmtaskid, Map<String, Object> variables);

	void taskClaim(String bpmtaskid, String person);

	void taskUpdateDescription(String bpmtaskid, String description);

	void taskDelegate(String bpmtaskid, String person);
}
