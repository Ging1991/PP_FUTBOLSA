package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.formularios.FormularioIniciarSesion;
import com.caballero.futbolsa.vista.formularios.FormularioRegistrarUsuario;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

public class PaginaIdentificacion extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaIdentificacion";
	
	public PaginaIdentificacion() {

	}
		
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setFirstComponent(new FormularioIniciarSesion());
		panel.setSecondComponent(new FormularioRegistrarUsuario());
		addComponent(panel);
	}

}