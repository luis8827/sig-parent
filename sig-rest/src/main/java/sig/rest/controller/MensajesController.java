package sig.rest.controller;

import java.util.List;

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

@Stateless
@LocalBean
@Path("/mensajes")
public class MensajesController {

	@EJB
	private MensajesInterface objInterface;

	public MensajesController() {
	}

	@GET
	@Path("/instancia/{instancia}")
	@Produces("application/json")
	public List<MyEventSubscription> listarMensajes(@PathParam("instancia") String instancia) {
		System.out.println("listarMensajes");
		return objInterface.listarMensajes(instancia);
	}

	@PUT
	@Path("/completar")
	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces("application/json")
	@Produces({MediaType.TEXT_PLAIN})
	public String  completarMensaje(MyEventSubscription Evento) throws Exception{
		System.out.println("completarMensaje");
		objInterface.completarMensaje(Evento);
				        
		return "completo";
	}
	
}
