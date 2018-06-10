package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.componentes.Cabecera;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPrincipal extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaPrincipal";
	
	public PaginaPrincipal() {

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addComponent(Cabecera.getCabecera());
	}

}
