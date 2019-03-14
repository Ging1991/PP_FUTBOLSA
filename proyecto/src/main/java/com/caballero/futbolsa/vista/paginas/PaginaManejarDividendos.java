package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.formularios.FormularioDividendos;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaManejarDividendos extends PaginaBase {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaManejarDividendos";
	
	public PaginaManejarDividendos() {	}

	@Override
	public VerticalLayout setContenido() {
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		Club club = (Club) ui.getSesion("manejar_club");
		System.out.println(jugador);
		System.out.println(club);
		
		VerticalLayout contenido = new VerticalLayout();		
		if (jugador != null && club != null)
			contenido.addComponent(new FormularioDividendos(jugador, club));
		return contenido;
	}

}