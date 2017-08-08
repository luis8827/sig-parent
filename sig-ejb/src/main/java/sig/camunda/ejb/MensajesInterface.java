package sig.camunda.ejb;

import java.util.List;

import javax.ejb.Local;

import com.sig.camunda.bpm_dto.MyEventSubscription;

@Local
public interface MensajesInterface {

	List<MyEventSubscription> listarMensajes(String instancia);

	void completarMensaje(MyEventSubscription Evento);
}
