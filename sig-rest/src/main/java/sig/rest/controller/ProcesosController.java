package sig.rest.controller;

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
import sig.rest.dto.RespuestaDTO;

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
	@Path("/{usuario}")
	public RespuestaDTO listarProcesos(@PathParam("usuario") String usuario) {
		System.out.println("listarProcesos");
		
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objProceso.listarProcesos(usuario));
		rpta.setSuccess(true);

		return rpta;
	}

//	@GET
//	@Path("/iniciar/{idproceso}")
//	public Map<String, Object> iniciarProceso2(@PathParam("idproceso") String idproceso) {
//		System.out.println("iniciarProceso2");
//		return objProceso.iniciarProceso(idproceso);
//	}

	@POST
	@Path("/iniciar")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO iniciarProceso(procesoDTO proceso) throws Exception {
		System.out.println("iniciarProceso");
		
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objProceso.iniciarProcesos(proceso));
		rpta.setSuccess(true);

		return rpta;
	}

}
