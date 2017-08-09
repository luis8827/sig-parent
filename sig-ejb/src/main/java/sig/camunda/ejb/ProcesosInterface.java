package sig.camunda.ejb;


import java.util.List;
import java.util.Map;

import javax.ejb.Local;



@Local
public interface ProcesosInterface {

	List<String> listarProcesos();

	Map<String, Object> iniciarProceso(String NombreProceso);
	
	Map<String, Object> iniciarProceso(String NombreProceso,Map<String, Object> variables);
}
