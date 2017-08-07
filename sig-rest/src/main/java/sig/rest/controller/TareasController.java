package sig.rest.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@LocalBean
@Path("/tareas")
public class TareasController {
	public TareasController() {

	}
	
	@GET
	@Produces("application/json")
	public String listarTareas() {
		return null;
	}
	
	@PUT
	@Produces("application/json")
	public String aprobarTarea() {
		return null;
	}
}
