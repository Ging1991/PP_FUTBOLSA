package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.componentes.Cabecera;
import com.caballero.futbolsa.vista.formularios.FormularioIniciarSesion;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class PaginaIniciarSesion extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaIniciarSesion";
	
	public PaginaIniciarSesion() {	}
		
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		addComponent(Cabecera.getCabecera());
		FormularioIniciarSesion form = new FormularioIniciarSesion();
		form.setWidth("80%");
		addComponent(form);
	}

}