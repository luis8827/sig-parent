package sig.camunda.ejb;

import java.util.Map;

import javax.ejb.Local;
@Local
public interface UsuariosInterface {

	
	Map<String, Object> listarUsuarios();
	Map<String, Object> getUsuario();
}
