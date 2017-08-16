package sig.camunda.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.sig.camunda.bpm_lib.CamundaEngine;
import com.sig.camunda.bpm_lib.CamundaAuthentication;

import sig.ejb.dto.procesoDTO;
import sig.ejb.dto.variableDTO;

@Stateless
public class ProcesosEJB implements ProcesosInterface {

	@Override
	public List<String> listarProcesos(String usuario) {
		CamundaEngine camunda = new CamundaEngine();

		CamundaAuthentication auth = new CamundaAuthentication();
		List<String> lista_permitida = new ArrayList<>();

		for (String proceso : camunda.getProcessDefinitions()) {
			if (auth.isAuthorizationReadProcessInstance(usuario, proceso) || auth.isAuthorizationReadProcessDefinition(usuario, proceso)) {
				lista_permitida.add(proceso);
			}
		}

		return lista_permitida;
	}

	@Override
	public Map<String, Object> iniciarProceso(String NombreProceso) {
		CamundaEngine camunda = new CamundaEngine();
		Map<String, Object> proceso = new HashMap<String, Object>();
		proceso.put("idProceso", camunda.processCreate(NombreProceso, "", "", ""));
		return proceso;
	}

	@Override
	public Map<String, Object> iniciarProcesos(procesoDTO proceso) {
		CamundaEngine camunda = new CamundaEngine();
		CamundaAuthentication auth = new CamundaAuthentication();
		Map<String, Object> resultado = new HashMap<String, Object>();

		if (auth.isAuthorizationCreateProcessInstance(proceso.getPerson(), proceso.getIdproceso())) {
			Map<String, Object> variables = new HashMap<String, Object>();

			for (variableDTO v : proceso.getVariables()) {
				variables.put(v.getNombre(), v.getValor());
			}
			resultado.put("idinstancia", camunda.processCreate(proceso.getIdproceso(), proceso.getBusinessKey(),
					proceso.getDescription(), proceso.getPerson(), variables));
		}

		return resultado;
	}
}
