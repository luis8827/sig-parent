package sig.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sig.camunda.bpm_dto.MyProcessInstance;
import com.sig.camunda.bpm_lib.CamundaEngine;

import sig.camunda.ejb.InstanciasInterface;
import sig.camunda.ejb.VariablesInterface;
import sig.ejb.dto.descripcionDTO;;

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
	public List<MyProcessInstance> listarInstanciasProceso(@PathParam("proceso") String proceso) {
		System.out.println("listarInstanciasProceso");
		return objInstancia.listarInstanciasProceso(proceso);
	}

	@GET
	@Path("/listar")
	public List<MyProcessInstance> listarInstancias() {
		System.out.println("listarInstancias");
		return objInstancia.listarInstancias();
	}

	@DELETE
	@Path("/{instancia}")
	public Map<String, Object> eliminarInstancia(@PathParam("instancia") String instancia) {
		System.out.println("eliminarInstancia");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", "true");
		objInstancia.eliminarInstancia(instancia);
		return respuesta;
	}

	// ler variables de una instancia

	@GET
	@Path("/instancia/{instancia}/variables/")
	public Map<String, Object> listarVariablesInstancia(@PathParam("instancia") String instancia) {

		System.out.println("listarVariablesInstancia");
		return objVariables.getVariables(instancia);
	}
	// cambiar valores de una instancia

	@PUT
	@Path("/updateDescription")
	public Map<String, Object> updateDescription(descripcionDTO descripcion) {

		Map<String, Object> respuesta = new HashMap<String, Object>();

		if (objInstancia.updateDescription(descripcion)) {
			respuesta.put("success", "true");
		}
		{
			respuesta.put("success", "false");
		}
		return respuesta;
	}

	@PUT
	@Path("/updateDescriptionAndPerson")
	public Map<String, Object> updateDescriptionAndPerson(descripcionDTO descripcion) {

		Map<String, Object> respuesta = new HashMap<String, Object>();

		if (objInstancia.updateDescriptionAndPerson(descripcion)) {
			respuesta.put("success", "true");
		}
		{
			respuesta.put("success", "false");
		}
		return respuesta;

	}

	@PUT
	@Path("/sustenderInstancia/{instancia}")
	public Map<String, Object> suspendInstance(@PathParam("instancia") String instancia) {

		Map<String, Object> respuesta = new HashMap<String, Object>();

		objInstancia.suspendInstance(instancia);
		respuesta.put("success", "true");
		return respuesta;
	}

	@PUT
	@Path("/activateInstance/{instancia}")
	public Map<String, Object> activateInstance(@PathParam("instancia") String instancia) {
		Map<String, Object> respuesta = new HashMap<String, Object>();

		objInstancia.activateInstance(instancia);
		respuesta.put("success", "true");
		return respuesta;
	}

}
