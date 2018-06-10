package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;

public class PanelJugadores extends VerticalLayout{
	private static final long serialVersionUID = 1L;

	public PanelJugadores() {
/*		List<Jugador> jugadores = Identificador.getTodosLosJugadores();
		
		ComboBox lista = new ComboBox("Seleccione un jugador");
		lista.setItemCaptionMode(ItemCaptionMode.EXPLICIT_DEFAULTS_ID);

		for (Jugador jugador : jugadores) {
			lista.addItem(jugador.getJugador_id());
			lista.setItemCaption(jugador.getJugador_id(), jugador.getUsuario());
		}
		addComponent(lista);
		*/
	}

}