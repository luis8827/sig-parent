package sig.camunda.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.sig.camunda.bpm_dto.MyProcessInstance;

@Local
public interface InstanciasInterface {

	List<MyProcessInstance> listarInstancias();

	List<MyProcessInstance> listarInstanciasProceso(String proceso);

	void eliminarInstancia(String instancia);
	
	Map<String,Object> getVariables(String processInstanceId);
}
