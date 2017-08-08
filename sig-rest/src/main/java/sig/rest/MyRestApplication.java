package sig.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import sig.rest.controller.InstanciasController;
import sig.rest.controller.ProcesosController;
import sig.rest.controller.TareasController;
import sig.rest.controller.UsuariosController;

@ApplicationPath("/camunda")
public class MyRestApplication extends	Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>>  classes= new HashSet<Class<?>>();
		
		classes.add(ProcesosController.class);
		classes.add(TareasController.class);
		classes.add(UsuariosController.class);
		classes.add(InstanciasController.class);
		
		return classes;
	}
	
	// @GET
	// @Produces("text/plain")
	// public String sayHello() {
	// return "hola mundo,";
	// }
//
//	@GET
//	@Path("{orderid}/")
//	@Produces("application/json")
//	 @Produces({"application/xml","application/json"})
//	@Produces("text/plain")
}
