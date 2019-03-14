package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.tablas.TablaRankingClubes;
import com.vaadin.ui.VerticalLayout;

public class PaginaRankingClubes extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static final String NOMBRE = "PaginaRankingClubes";
	
	@Override
	public VerticalLayout setContenido() {
		VerticalLayout contenido = new VerticalLayout();		
		contenido.addComponent(new TablaRankingClubes());
		return contenido;
	}

}