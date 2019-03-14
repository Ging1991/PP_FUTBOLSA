package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.NotificacionODB;
import com.caballero.futbolsa.persistencia.interfases.NotificacionODBVO;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Notificacion;
import com.caballero.futbolsa.persistencia.pojosVo.NotificacionVO;
import com.caballero.futbolsa.persistencia.postgresql.NotificacionODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.NotificacionODBVOPostgresql;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class BloqueNotificaciones extends VerticalLayout{
	private static final long serialVersionUID = 1L;

	public BloqueNotificaciones(Jugador jugador) {
		NotificacionODBVO odbvo = new NotificacionODBVOPostgresql();
		List<NotificacionVO> notificaciones = odbvo.selectByJugador(jugador);
		
		for (NotificacionVO notificacionVO : notificaciones)
			addComponent(formarNotificacion(notificacionVO));
	}
	
	@SuppressWarnings("deprecation")
	private Panel formarNotificacion(NotificacionVO notificacionVO) {
		Label lb_noticia = new Label(notificacionVO.getContenido());

		Button bt_eliminar = new Button("Eliminar");
		bt_eliminar.addClickListener(e->{
			Notificacion notificacion = new Notificacion(notificacionVO.getNotificacion_id(), -1, -1);
			NotificacionODB odb = new NotificacionODBPostgresql();
			odb.delete(notificacion);
		});
		bt_eliminar.setWidth("100%");
		
		HorizontalSplitPanel bloque = new HorizontalSplitPanel();
		bloque.setFirstComponent(lb_noticia);
		bloque.setSecondComponent(bt_eliminar);
		bloque.setSplitPosition(80, Sizeable.UNITS_PERCENTAGE);
		Panel panel = new Panel("Notificacion para accionistas");
		panel.setContent(bloque);
		return panel;	
	}
		
}