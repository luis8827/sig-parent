package sig.camunda.ejb;

import java.util.List;

import javax.ejb.Local;

import com.sig.camunda.bpm_dto.MyTask;

@Local
public interface TareasInterface {

	List<MyTask> listarTareasPendientes(String instancia);

	List<MyTask> listarTareasPendientesUsuario(String Persona);

	void completarTarea(String tarea);

	void asignarUsurioTarea(String tarea, String persona);


}
