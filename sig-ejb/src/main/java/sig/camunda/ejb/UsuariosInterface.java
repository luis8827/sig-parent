package sig.camunda.ejb;

import java.util.List;

import javax.ejb.Local;

import sig.ejb.dto.usuarioDTO;

@Local
public interface UsuariosInterface {

	List<String> listarUsuarios();

	boolean loginUsuario(String usuario, String pass);

	void createUser(usuarioDTO usuario);

	void userAuthorizationCreate(String user, String resource);

	void userAuthorizationRead(String user, String resource);

}
