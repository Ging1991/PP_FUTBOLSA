package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PanelClubes extends VerticalLayout{
	private static final long serialVersionUID = 1L;

	public PanelClubes() {
		List<Club> clubes = Administrador.getTodosLosClubes();
		for (Club club : clubes)
			addComponent(new Label(club.getNombre()));
	}
	
}