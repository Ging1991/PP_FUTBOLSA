package com.caballero.futbolsa.vista.paginas;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Presidencia;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.componentes.BloqueManejarClub;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPresidencia extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaPresidencia";
	
	public PaginaPresidencia() {}

	@Override
	public VerticalLayout setContenido() {
		VerticalLayout contenido = new VerticalLayout();
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");		
		if (jugador != null) {
			List<Club> clubes = Presidencia.traerClubesDePresidente(jugador);
			if (clubes.size() == 0)
				contenido.addComponent(new Label("Ustede no es presidente de ningun Club"));
			for (Club club : clubes)
				contenido.addComponent(new BloqueManejarClub(jugador, club));
		}
		return contenido;
	}

}