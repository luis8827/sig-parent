package sig.camunda.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.ejb.Stateless;

import com.sig.camunda.bpm_lib.CamundaEngine;


@Stateless
public class ProcesosEJB implements ProcesosInterface {

	@Override
	public List<String> listarProcesos() {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getProcessDefinitions();
	}

	@Override
	public Map<String, Object> iniciarProceso(String NombreProceso) {
		CamundaEngine camunda = new CamundaEngine();
		Map<String, Object> proceso = new HashMap<String, Object>();
		proceso.put("idProceso", camunda.processCreate(NombreProceso, "", "", ""));
		return proceso;
	}

}
