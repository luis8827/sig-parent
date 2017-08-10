package sig.camunda.ejb;


import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import sig.ejb.dto.procesoDTO;



@Local
public interface ProcesosInterface {

	List<String> listarProcesos(String usuario);

	Map<String, Object> iniciarProceso(String NombreProceso);
	
	Map<String, Object> iniciarProcesos(procesoDTO proceso);
}
