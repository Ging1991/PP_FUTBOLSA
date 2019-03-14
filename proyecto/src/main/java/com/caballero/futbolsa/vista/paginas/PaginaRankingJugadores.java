package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.tablas.TablaRankingJugadores;
import com.vaadin.ui.VerticalLayout;

public class PaginaRankingJugadores extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static final String NOMBRE = "PaginaRankingJugadores";
	
	@Override
	public VerticalLayout setContenido() {
		VerticalLayout contenido = new VerticalLayout();		
		contenido.addComponent(new TablaRankingJugadores());
		return contenido;
	}

}