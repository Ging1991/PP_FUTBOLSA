package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.formularios.FormularioIngresarResultado;
import com.vaadin.ui.VerticalLayout;

public class PaginaRegistrarResultado extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaRegistrarResultado";
	
	public PaginaRegistrarResultado() {}

	@Override
	public VerticalLayout setContenido() {		
		VerticalLayout contenido = new VerticalLayout();
		contenido.addComponent(new FormularioIngresarResultado());
		return contenido;
	}

}