package sig.ejb.common;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface Bar {

	String Saludar();
	Map<String, Object> iniciarProceso(String proceso);
	List<String> listaInstancias(String proceso);
	
}
