package sig.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sig.camunda.bpm_dto.MyProcessInstance;

import sig.camunda.ejb.InstanciasInterface;;

@Stateless
@LocalBean
@Path("/instancias")
@Produces("application/json")
public class InstanciasController {
	@EJB
	private InstanciasInterface objInstancia;

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
		respuesta.put("respuesta", "se elimino");
		return respuesta;
	}

}
