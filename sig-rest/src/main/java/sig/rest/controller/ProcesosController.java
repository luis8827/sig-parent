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

import com.sig.camunda.bpm_dto.MyEventSubscription;

import sig.camunda.ejb.ProcesosInterface;

@Stateless
@LocalBean
@Path("/procesos")
public class ProcesosController {

	@EJB
	private ProcesosInterface objProceso;

	public ProcesosController() {
	}

	@GET
	@Path("/")
	@Produces("application/json")
	public List<String> listarProcesos() {
		System.out.println("listarProcesos");
		return objProceso.listarProcesos();
	}

	@GET
	@Path("/iniciar/{idproceso}")
	@Produces("application/json")
	public Map<String, Object> iniciarProceso(@PathParam("idproceso") String idproceso) {
		System.out.println("iniciarProceso");
		return objProceso.iniciarProceso(idproceso);
	}

	@POST
	@Path("/iniciar/{idproceso}")
	@Consumes({ MediaType.APPLICATION_JSON })
	// @Produces("application/json")
	@Produces({ MediaType.TEXT_PLAIN })
	public String iniciarProcesoVariables(@PathParam("idproceso") String idproceso, Map<String, Object> variables)
			throws Exception {
		System.out.println("iniciarProceso");

		// return objProceso.iniciarProceso(idproceso,Evento);
		return "creo";
	}

}
