package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.negocios.Custodio;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PanelPosesiones extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public PanelPosesiones(Jugador jugador) {
		List<PosesionVO> posesiones = Custodio.getPosesionesVODeJugador(jugador);
		addComponent(new Label("ACCIONES QUE POSEE"));
		for (PosesionVO posesion : posesiones)
			addComponent(new Label(posesion.getNombre()+": "+posesion.getCantidad()));
	}

}