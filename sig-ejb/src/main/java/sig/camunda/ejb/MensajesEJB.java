package sig.camunda.ejb;


import java.util.List;



import javax.ejb.Stateless;

import com.sig.camunda.bpm_dto.MyEventSubscription;
import com.sig.camunda.bpm_lib.CamundaEngine;


@Stateless
public class MensajesEJB implements MensajesInterface{

	@Override
	public List<MyEventSubscription> listarMensajes(String instancia) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getEvents(instancia);
		
	}

	@Override
	public void completarMensaje(MyEventSubscription Evento) {

		CamundaEngine camunda = new CamundaEngine();
		camunda.fireEvent(Evento);
	}
}
