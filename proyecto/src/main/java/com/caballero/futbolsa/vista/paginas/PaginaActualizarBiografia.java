package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.formularios.FormularioEditarBiografia;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaActualizarBiografia extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaActualizarBiografia";
	
	public PaginaActualizarBiografia() {}

	@Override
	public VerticalLayout setContenido() {
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");

		VerticalLayout contenido = new VerticalLayout();
		if (jugador != null)
			contenido.addComponent(new FormularioEditarBiografia(jugador));
		
		return contenido;
	}

}