package sig.rest.controller;



import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sig.camunda.ejb.TareasInterface;
import sig.rest.dto.RespuestaDTO;
import sig.rest.dto.TareaDTO;

@Stateless
@LocalBean
@Path("/tareas")
@Produces("application/json")
public class TareasController {

	@EJB
	private TareasInterface objTarea;

	public TareasController() {
	}

	@GET
	@Path("/listar/instancia/{instancia}")
	public RespuestaDTO listarTareasPendientes(@PathParam("instancia") String instancia) {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objTarea.listarTareasPendientes(instancia));
		rpta.setSuccess(true);

		return rpta;
	}

	@GET
	@Path("/listar/persona/{persona}")
	public RespuestaDTO listarTareasPendientesUsuario(@PathParam("persona") String persona) {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objTarea.listarTareasPendientesUsuario(persona));
		rpta.setSuccess(true);

		return rpta;
	}

	@PUT
	@Path("/completar/tarea/{tarea}")
	public RespuestaDTO complearTarea(@PathParam("tarea") String tarea) {

		objTarea.completarTarea(tarea);

		RespuestaDTO rpta = new RespuestaDTO();

		rpta.setSuccess(true);

		return rpta;
	}

	@PUT
	@Path("/asignar/tarea/{tarea}/persona/{persona}")
	public RespuestaDTO asignarUsuarioTarea(@PathParam("tarea") String tarea, @PathParam("persona") String persona) {
		objTarea.asignarUsurioTarea(tarea, persona);
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);

		return rpta;
	}

	@GET
	@Path("/taskListByUserAndInstanceId/instancia/{instancia}/persona/{persona}")
	public RespuestaDTO taskListByUserAndInstanceId(@PathParam("instancia") String instancia,
			@PathParam("persona") String persona) {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		rpta.setData(objTarea.taskListByUserAndInstanceId(instancia, persona));
		return rpta;
	}

	@GET
	@Path("/taskListByProcessInstanceId/instancia/{instancia}")
	public RespuestaDTO taskListByProcessInstanceId(@PathParam("instancia") String instancia) {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		rpta.setData(objTarea.taskListByProcessInstanceId(instancia));
		return rpta;

	}

	@GET
	@Path("/historyTaskListByUser/instancia/{instancia}/persona/{persona}")
	public RespuestaDTO historyTaskListByUser(@PathParam("instancia") String instancia,
			@PathParam("persona") String persona) {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		rpta.setData(objTarea.historyTaskListByUser(instancia, persona));
		return rpta;

	}

	/*
	 * @param tarea { "bpmtaskid":"", "varKey":"", "varValue":"" }
	 */
	@PUT
	@Path("/taskComplete")
	public RespuestaDTO taskComplete1(TareaDTO tarea) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		objTarea.taskComplete(tarea.getBpmtaskid(), tarea.getVarKey(), tarea.getVarValue());
		return rpta;
	}

	/**
	 * 
	 * @param tarea
	 *            { "bpmtaskid":"", "variables":{} }
	 */
	@PUT
	@Path("/taskComplete2")
	public RespuestaDTO taskComplete2(TareaDTO tarea) throws Exception {

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		objTarea.taskComplete(tarea.getBpmtaskid(), tarea.getVariables());
		return rpta;
	}

	/**
	 * 
	 * @param tarea
	 *            { "bpmtaskid":"", "person":"" }
	 */
	@PUT
	@Path("/taskClaim")
	public RespuestaDTO taskClaim(TareaDTO tarea) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		objTarea.taskClaim(tarea.getBpmtaskid(), tarea.getPerson());
		return rpta;
	}

	/**
	 * 
	 * @param tarea
	 *            { "bpmtaskid":"", "description":"" }
	 */
	@PUT
	@Path("/taskUpdateDescription")
	public RespuestaDTO taskUpdateDescription(TareaDTO tarea) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		objTarea.taskUpdateDescription(tarea.getBpmtaskid(), tarea.getDescription());
		return rpta;
	}

	/**
	 * 
	 * @param tarea
	 *            { "bpmtaskid":"", "person":"" }
	 */
	@PUT
	@Path("/taskDelegate")
	public RespuestaDTO taskDelegate(TareaDTO tarea) throws Exception {
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		objTarea.taskDelegate(tarea.getBpmtaskid(), tarea.getPerson());
		return rpta;
	}
}
