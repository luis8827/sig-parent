package sig.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<String> getUsuarios() {
		System.out.println("getUsuarios");
		return objUsuarios.listarUsuarios();
	}

	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Map<String, Object> login(UsuarioDTO usuario) throws Exception {
		System.out.println("login");

		Map<String, Object> respuesta = new HashMap<String, Object>();

		if (objUsuarios.loginUsuario(usuario.getUsuario(), usuario.getPassword())) {
			respuesta.put("success", "true");
		} else {
			respuesta.put("success", "false");
		}
		return respuesta;
	}

	@POST
	@Path("/crear")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Map<String, Object> crearUsuario(usuarioDTO usuario) throws Exception {
		System.out.println("crearUsuario");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		objUsuarios.createUser(usuario);
		respuesta.put("success", "true");
		return respuesta;
	}

	@POST
	@Path("/autoriza_crear")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Map<String, Object> autorizaCrearInstancia(UsuarioProcesoDTO usuarioproceso) throws Exception {
		System.out.println("autorizaCrearInstancia");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		objUsuarios.userAuthorizationCreate(usuarioproceso.getUsuario(), usuarioproceso.getProceso());
		respuesta.put("success", "true");
		return respuesta;

	}
	@POST
	@Path("/autoriza_lectura")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Map<String, Object> autorizaLeerInstancia(UsuarioProcesoDTO usuarioproceso) throws Exception {
		System.out.println("autorizaCrearInstancia");
		Map<String, Object> respuesta = new HashMap<String, Object>();
		objUsuarios.userAuthorizationRead(usuarioproceso.getUsuario(), usuarioproceso.getProceso());
		respuesta.put("success", "true");
		return respuesta;

	}
}
