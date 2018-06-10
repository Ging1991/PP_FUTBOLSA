package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.componentes.Cabecera;
import com.caballero.futbolsa.vista.formularios.FormularioRegistrarUsuario;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class PaginaRegistrarJugador extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaRegistrarJugador";
	
	public PaginaRegistrarJugador() {	}
		
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addComponent(Cabecera.getCabecera());
		FormularioRegistrarUsuario form = new FormularioRegistrarUsuario();
		form.setWidth("80%");
		addComponent(form);
	}

}