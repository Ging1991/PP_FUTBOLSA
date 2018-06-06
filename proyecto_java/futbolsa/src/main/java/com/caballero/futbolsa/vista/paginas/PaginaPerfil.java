package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.vista.componentes.PanelOrdenesPendientes;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPerfil extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static final String NOMBRE = "PaginaPerfil";
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		MyUI ui = (MyUI) UI.getCurrent();
		addComponent(new PanelOrdenesPendientes());
		Button btVolver = new Button("Volver");
		btVolver.addClickListener(e -> {
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		addComponent(btVolver);
		
	}

}