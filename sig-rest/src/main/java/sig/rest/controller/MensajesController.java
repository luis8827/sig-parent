package sig.rest.controller;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sig.camunda.bpm_dto.MyEventSubscription;
import sig.camunda.ejb.MensajesInterface;
import sig.rest.dto.RespuestaDTO;

@Stateless
@LocalBean
@Path("/mensajes")
@Produces("application/json")
public class MensajesController {

	@EJB
	private MensajesInterface objInterface;

	public MensajesController() {
	}

	@GET
	@Path("/instancia/{instancia}")
	public RespuestaDTO listarMensajes(@PathParam("instancia") String instancia) {
		System.out.println("listarMensajes");
		
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objInterface.listarMensajes(instancia));
		rpta.setSuccess(true);

		return rpta;
	}

	@PUT
	@Path("/completar")
	@Consumes({MediaType.APPLICATION_JSON})
	public RespuestaDTO  completarMensaje(MyEventSubscription Evento) throws Exception{
		System.out.println("completarMensaje");
		objInterface.completarMensaje(Evento);

		RespuestaDTO rpta = new RespuestaDTO();		
		rpta.setSuccess(true);
		return rpta;
	}
	
}
