package sig.rest.controller;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sig.camunda.ejb.UsuariosInterface;
import sig.ejb.dto.usuarioDTO;
import sig.rest.dto.RespuestaDTO;
import sig.rest.dto.UsuarioDTO;
import sig.rest.dto.UsuarioProcesoDTO;

@Stateless
@LocalBean
@Path("/usuarios")
@Produces("application/json")
public class UsuariosController {

	@EJB
	UsuariosInterface objUsuarios;

	public UsuariosController() {

	}

	@GET
	@Path("/lista")
	public RespuestaDTO getUsuarios() {
		System.out.println("getUsuarios");

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setData(objUsuarios.listarUsuarios());
		rpta.setSuccess(true);

		return rpta;

	}

	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO login(UsuarioDTO usuario) throws Exception {
		System.out.println("login");

		RespuestaDTO rpta = new RespuestaDTO();

		rpta.setSuccess(objUsuarios.loginUsuario(usuario.getUsuario(), usuario.getPassword()));

		return rpta;
	}

	@POST
	@Path("/crear")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO crearUsuario(usuarioDTO usuario) throws Exception {
		System.out.println("crearUsuario");

		objUsuarios.createUser(usuario);

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		return rpta;
	}

	@POST
	@Path("/autoriza_crear")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO autorizaCrearInstancia(UsuarioProcesoDTO usuarioproceso) throws Exception {
		System.out.println("autorizaCrearInstancia");

		objUsuarios.userAuthorizationCreate(usuarioproceso.getUsuario(), usuarioproceso.getProceso());

		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		return rpta;
	}

	@POST
	@Path("/autoriza_lectura")
	@Consumes({ MediaType.APPLICATION_JSON })
	public RespuestaDTO autorizaLeerInstancia(UsuarioProcesoDTO usuarioproceso) throws Exception {
		System.out.println("autorizaCrearInstancia");

		objUsuarios.userAuthorizationRead(usuarioproceso.getUsuario(), usuarioproceso.getProceso());
		RespuestaDTO rpta = new RespuestaDTO();
		rpta.setSuccess(true);
		return rpta;
	}
}
