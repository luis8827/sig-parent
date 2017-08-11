package sig.camunda.ejb;

import java.util.List;

import javax.ejb.Local;

import com.sig.camunda.bpm_dto.MyProcessInstance;

import sig.ejb.dto.descripcionDTO;

@Local
public interface InstanciasInterface {

	List<MyProcessInstance> listarInstancias();

	List<MyProcessInstance> listarInstanciasProceso(String proceso);

	void eliminarInstancia(String instancia);

	boolean updateDescription(descripcionDTO descripcion);

	boolean updateDescriptionAndPerson(descripcionDTO descripcion);

	void suspendInstance(String processInstanceId);

	void activateInstance(String processInstanceId);
}
