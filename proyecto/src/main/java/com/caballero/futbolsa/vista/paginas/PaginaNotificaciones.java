package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.componentes.BloqueNotificaciones;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaNotificaciones extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaNotificaciones";
	
	public PaginaNotificaciones() {	}
		
	@Override
	public VerticalLayout setContenido() {
		VerticalLayout contenido = new VerticalLayout();
				
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		
		if (jugador != null)
			contenido.addComponent(new BloqueNotificaciones(jugador));
		
		return contenido;
	}

}