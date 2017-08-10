package sig.rest.controller;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sig.camunda.ejb.ProcesosInterface;
import sig.ejb.dto.*;

@Stateless
@LocalBean
@Path("/procesos")
@Produces("application/json")
public class ProcesosController {

	@EJB
	private ProcesosInterface objProceso;

	public ProcesosController() {
	}

	@GET
	@Path("/")
	public List<String> listarProcesos() {
		System.out.println("listarProcesos");
		return objProceso.listarProcesos();
	}

	@GET
	@Path("/iniciar/{idproceso}")
	public Map<String, Object> iniciarProceso2(@PathParam("idproceso") String idproceso) {
		System.out.println("iniciarProceso2");
		return objProceso.iniciarProceso(idproceso);
	}

	@POST
	@Path("/iniciar")
	@Consumes({ MediaType.APPLICATION_JSON })
	public  Map<String, Object> iniciarProceso(procesoDTO proceso) throws Exception {
		System.out.println("iniciarProceso");
		return objProceso.iniciarProcesos(proceso);
	}

}
