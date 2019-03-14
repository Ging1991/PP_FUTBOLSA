package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.componentes.BloqueOpcionesDeAdministrador;
import com.caballero.futbolsa.vista.formularios.FormularioCrearClub;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

public class PaginaAdministrador extends PaginaBase{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaAdministrador";
	
	public PaginaAdministrador() {}

	@SuppressWarnings("deprecation")
	@Override
	public VerticalLayout setContenido() {
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setFirstComponent(new FormularioCrearClub());
		panel.setSecondComponent(new BloqueOpcionesDeAdministrador());
		panel.setSplitPosition(50, Sizeable.UNITS_PERCENTAGE);

		VerticalLayout contenido = new VerticalLayout();
		contenido.addComponent(panel);
		return contenido;
	}

}