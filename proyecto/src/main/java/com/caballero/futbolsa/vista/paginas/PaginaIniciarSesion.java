package com.caballero.futbolsa.vista.paginas;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.formularios.FormularioIniciarSesion;
import com.vaadin.ui.VerticalLayout;

public class PaginaIniciarSesion extends PaginaBase {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaIniciarSesion";
	
	public PaginaIniciarSesion() {	}

	@Override
	public VerticalLayout setContenido() {
		FormularioIniciarSesion form = new FormularioIniciarSesion();
		VerticalLayout contenido = new VerticalLayout();
		contenido.addComponent(form);
		return contenido;
	}

}