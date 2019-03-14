package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.formularios.FormularioRegistrarUsuario;
import com.vaadin.ui.VerticalLayout;

public class PaginaRegistrarJugador extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaRegistrarJugador";
	
	public PaginaRegistrarJugador() {	}
		
	@Override
	public VerticalLayout setContenido() {
		VerticalLayout contenido = new VerticalLayout();
		FormularioRegistrarUsuario form = new FormularioRegistrarUsuario();
		contenido.addComponent(form);
		return contenido;
	}

}