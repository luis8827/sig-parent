package sig.rest.controller;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import sig.ejb.common.Bar;

@Stateless
@LocalBean
@Path("/procesos")
public class ProcesosController {

	@EJB
	private Bar objBar;
	
	public ProcesosController() {

	}

	@GET
	@Produces("application/json")
	public String listarProcesos() {

		return null;
	}

	@GET
	@Path("{idproceso}")
	@Produces("application/json")
	public String getProceso(@PathParam("idproceso") int idproceso) {

		return null;
	}

	@GET
	@Path("iniciar")
	@Produces("application/json")
	public Map<String, Object> iniciarProceso() {					
		return objBar.iniciarProceso("Process_1");
	}
	
	@GET
	@Path("listar/{proceso}")
	@Produces("application/json")
	public List<String> listarInstancias(@PathParam("proceso") String proceso) {					
		return objBar.listaInstancias(proceso);
	}

}
