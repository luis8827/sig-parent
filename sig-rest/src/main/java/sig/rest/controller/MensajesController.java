package sig.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Produces("application/json")
public class MensajesController {

	@EJB
	private MensajesInterface objInterface;

	public MensajesController() {
	}

	@GET
	@Path("/instancia/{instancia}")
	public List<MyEventSubscription> listarMensajes(@PathParam("instancia") String instancia) {
		System.out.println("listarMensajes");
		return objInterface.listarMensajes(instancia);
	}

	@PUT
	@Path("/completar")
	@Consumes({MediaType.APPLICATION_JSON})
	public Map<String, Object>  completarMensaje(MyEventSubscription Evento) throws Exception{
		System.out.println("completarMensaje");
		objInterface.completarMensaje(Evento);
		
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("success", "exito");
		return respuesta;
	}
	
}
