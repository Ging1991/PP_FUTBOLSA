package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.tablas.TablaPosesiones;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPosesiones extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaPosesiones";
	
	public PaginaPosesiones() {	}
		
	@Override
	public VerticalLayout setContenido() {
		VerticalLayout contenido = new VerticalLayout();
				
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		
		if (jugador != null)
			contenido.addComponent(new TablaPosesiones(jugador));
		
		return contenido;
	}

}