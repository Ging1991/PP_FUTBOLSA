package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Operador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PanelOrdenesPendientes extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public PanelOrdenesPendientes() {
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		if (jugador != null) {
			List<Orden> ordenes = Operador.getOrdenesDeJugador(jugador);
			for (Orden orden : ordenes)
				addComponent(new Label(orden.getOrden_id()+"-"+orden.getJugador_id()+"-"+orden.getClub_id()+"-"+orden.getCantidad()+"- $"+orden.getPrecio()));
		}
	}

}