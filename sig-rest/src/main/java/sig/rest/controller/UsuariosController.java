package sig.rest.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@LocalBean
@Path("/usuarios")
public class UsuariosController {
	public UsuariosController() {

	}
}
