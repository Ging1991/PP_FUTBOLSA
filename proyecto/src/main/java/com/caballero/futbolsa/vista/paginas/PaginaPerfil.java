package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.componentes.BloquePerfilDeJugador;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPerfil extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static final String NOMBRE = "PaginaPerfil";
	
	@Override
	public VerticalLayout setContenido() {
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_perfil");
		VerticalLayout contenido = new VerticalLayout();		
		if (jugador != null)
			contenido.addComponent(new BloquePerfilDeJugador(jugador));
		return contenido;
	}

}