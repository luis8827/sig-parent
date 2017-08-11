package sig.rest.controller;



import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sig.camunda.ejb.InstanciasInterface;
import sig.camunda.ejb.VariablesInterface;
import sig.ejb.dto.descripcionDTO;
import sig.rest.dto.RespuestaDTO;;

@Stateless
@LocalBean
@Path("/instancias")
@Produces("application/json")
public class InstanciasController {
	@EJB
	private InstanciasInterface objInstancia;

	@EJB
	private VariablesInterface objVariables;

	public InstanciasController() {
	}

	@GET
	@Path("/proceso/{proceso}")
	public RespuestaDTO listarInstanciasProceso(@PathParam("proceso") String proceso) {
		System.out.println("listarInstanciasProceso");

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objInstancia.listarInstanciasProceso(proceso));
		rpta.setSuccess(true);

		return rpta;
	}

	@GET
	@Path("/listar")
	public RespuestaDTO listarInstancias() {
		System.out.println("listarInstanciasProceso");

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objInstancia.listarInstancias());
		rpta.setSuccess(true);
		return rpta;
	}

	@DELETE
	@Path("/{instancia}")
	public RespuestaDTO eliminarInstancia(@PathParam("instancia") String instancia) {
		System.out.println("eliminarInstancia");
		RespuestaDTO rpta = new RespuestaDTO();

		objInstancia.eliminarInstancia(instancia);
		rpta.setSuccess(true);
		return rpta;
	}

	// ler variables de una instancia

	@GET
	@Path("/instancia/{instancia}/variables/")
	public RespuestaDTO listarVariablesInstancia(@PathParam("instancia") String instancia) {
		System.out.println("listarVariablesInstancia");

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objVariables.getVariables(instancia));
		rpta.setSuccess(true);
		return rpta;
	}
	// cambiar valores de una instancia

	@PUT
	@Path("/updateDescription")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO updateDescription(descripcionDTO descripcion) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();

		if (objInstancia.updateDescription(descripcion)) {
			rpta.setSuccess(true);
		} else {

			rpta.setSuccess(false);
		}

		return rpta;

	}

	@PUT
	@Path("/updateDescriptionAndPerson")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO updateDescriptionAndPerson(descripcionDTO descripcion) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();

		if (objInstancia.updateDescriptionAndPerson(descripcion)) {
			rpta.setSuccess(true);
		} else {

			rpta.setSuccess(false);
		}

		return rpta;
	}

	@PUT
	@Path("/sustenderInstancia/{instancia}")
	public RespuestaDTO suspendInstance(@PathParam("instancia") String instancia) {
		RespuestaDTO rpta = new RespuestaDTO();

		objInstancia.suspendInstance(instancia);
				
				rpta.setSuccess(true);
		return rpta;
	}

	@PUT
	@Path("/activateInstance/{instancia}")
	public RespuestaDTO activateInstance(@PathParam("instancia") String instancia) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();
		
		objInstancia.activateInstance(instancia);
		rpta.setSuccess(true);
		return rpta;
	}

}
