package sig.camunda.ejb;

import java.util.List;
import javax.ejb.Stateless;
import com.sig.camunda.bpm_lib.CamundaAuthentication;
import sig.ejb.dto.usuarioDTO;

@Stateless
public class UsuariosEJB implements UsuariosInterface {

	@Override
	public List<String> listarUsuarios() {
		CamundaAuthentication auth = new CamundaAuthentication();
		return auth.getUsers();
	}

	@Override
	public boolean loginUsuario(String usuario, String pass) {
		CamundaAuthentication auth = new CamundaAuthentication();
		return auth.loginUser(usuario, pass);
	}

	@Override
	public void createUser(usuarioDTO usuario) {
		CamundaAuthentication auth = new CamundaAuthentication();
		auth.createUser(usuario.getUsername(),usuario.getFirstName() ,usuario.getLastName(),usuario.getPassword(),usuario.getEmail());
	}

	@Override
	public void userAuthorizationCreate(String user, String resource) {
		CamundaAuthentication auth = new CamundaAuthentication();
		auth.userAuthorizationCreate(user, resource);
	}

	@Override
	public void userAuthorizationRead(String user, String resource) {
		CamundaAuthentication auth = new CamundaAuthentication();
		auth.userAuthorizationRead(user, resource);
	}

}
