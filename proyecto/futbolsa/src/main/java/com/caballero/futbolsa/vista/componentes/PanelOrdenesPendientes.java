package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.negocios.Operador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PanelOrdenesPendientes extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public PanelOrdenesPendientes(Jugador jugador) {
		addComponent(new Label("ORDENES PENDIENTES"));
		List<Orden> ordenes = Operador.getOrdenesDeJugador(jugador);

		for (Orden orden : ordenes) {
			Label label = new Label(orden.getOrden_id()+"-"+orden.getJugador_id()+"-"+orden.getClub_id()+"-"+orden.getCantidad()+"- $"+orden.getPrecio());
			Button cancelar = new Button("Cancelar orden");
			cancelar.addClickListener(e -> {
				Operador.cancelarOrden(orden);
			});
			HorizontalLayout layout = new HorizontalLayout();
			layout.addComponent(label);
			layout.addComponent(cancelar);
			addComponent(layout);
		}
	}

}