package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.PaginaBase;
import com.caballero.futbolsa.vista.tablas.TablaCotizaciones;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPrincipal extends PaginaBase {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaPrincipal";
	
	public PaginaPrincipal() {}

	public VerticalLayout setContenido() {
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		VerticalLayout especifico = new TablaCotizaciones(jugador);;
		return especifico;
	}	

}