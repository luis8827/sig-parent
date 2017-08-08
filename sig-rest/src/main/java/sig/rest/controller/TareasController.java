package sig.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sig.camunda.bpm_dto.MyTask;

import sig.camunda.ejb.TareasInterface;

@Stateless
@LocalBean
@Path("/tareas")
public class TareasController {

	@EJB
	private TareasInterface objTarea;

	public TareasController() {

	}

	@GET
	@Path("/listar/instancia/{instancia}")
	@Produces("application/json")
	public List<MyTask> listarTareasPendientes(@PathParam("instancia") String instancia) {
		return objTarea.listarTareasPendientes(instancia);

	}

	@GET
	@Path("/listar/persona/{persona}")
	@Produces("application/json")
	public List<MyTask> listarTareasPendientesUsuario(@PathParam("persona") String persona) {
		return objTarea.listarTareasPendientesUsuario(persona);

	}

	@PUT
	@Path("/completar/tarea/{tarea}")
	@Produces("application/json")
	public Map<String, Object> complearTarea(@PathParam("tarea") String tarea) {
		objTarea.completarTarea(tarea);
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("respuesta", "se completo tarea");
		return respuesta;
	}

	@PUT
	@Path("/asignar/tarea/{tarea}/persona/{persona}")
	@Produces("application/json")
	public Map<String, Object> asignarUsuarioTarea(@PathParam("tarea") String tarea,@PathParam("persona") String persona) {
		objTarea.asignarUsurioTarea(tarea, persona);

		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("respuesta", "se asigno");
		return respuesta;
	}
}
