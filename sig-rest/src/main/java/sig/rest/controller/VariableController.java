package sig.rest.controller;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sig.camunda.ejb.VariablesInterface;
import sig.rest.dto.RespuestaDTO;
import sig.rest.dto.variableDTO;

@Stateless
@LocalBean
@Path("/variables")
@Produces("application/json")
public class VariableController {
	@EJB
	private VariablesInterface objVariable;

	public VariableController() {
	}

	@GET
	@Path("/getVariables/instancia/{instancia}")
	public RespuestaDTO getVariables(@PathParam("instancia") String instancia) {
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objVariable.getVariables(instancia));
		rpta.setSuccess(true);
		return rpta;
	}

	@PUT
	@Path("/instanceSetVariableByTaskId")
	public RespuestaDTO instanceSetVariableByTaskId(variableDTO variable) {
		RespuestaDTO rpta = new RespuestaDTO();

		objVariable.instanceSetVariableByTaskId(variable.getBpmtaskid(), variable.getKey(), variable.getValue());

		rpta.setSuccess(true);
		return rpta;
	}

	@PUT
	@Path("/instanceSetVariable")
	public RespuestaDTO instanceSetVariable(variableDTO variable) {
		RespuestaDTO rpta = new RespuestaDTO();
		objVariable.instanceSetVariable(variable.getBpmtaskid(), variable.getVariables());
		rpta.setSuccess(true);
		return rpta;
	}

	@GET
	@Path("/getVariable/instancia/{instancia}/variable/{nombre_variable}")
	public RespuestaDTO getVariable(@PathParam("instancia") String instancia,
			@PathParam("nombre_variable") String nombre_variable) {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objVariable.getVariable(instancia, nombre_variable));
		rpta.setSuccess(true);
		return rpta;
	}

}
