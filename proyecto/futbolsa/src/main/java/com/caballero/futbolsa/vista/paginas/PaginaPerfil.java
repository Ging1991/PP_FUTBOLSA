package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.componentes.Cabecera;
import com.caballero.futbolsa.vista.componentes.PanelOrdenesPendientes;
import com.caballero.futbolsa.vista.componentes.PanelPosesiones;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPerfil extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static final String NOMBRE = "PaginaPerfil";
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addComponent(Cabecera.getCabecera());

		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		addComponent(new Label("Dinero: $"+jugador.getDinero()));
		addComponent(new PanelPosesiones(jugador));
		addComponent(new PanelOrdenesPendientes(jugador));
		Button btVolver = new Button("Volver");
		btVolver.addClickListener(e -> {
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		addComponent(btVolver);
	}

}