package sig.camunda.ejb;

import java.util.Map;

public interface UsuariosInterface {

	Map<String, Object> listarUsuarios();
	Map<String, Object> getUsuarios();
}