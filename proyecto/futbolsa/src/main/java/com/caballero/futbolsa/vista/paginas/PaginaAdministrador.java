package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.componentes.Cabecera;
import com.caballero.futbolsa.vista.componentes.PanelClubes;
import com.caballero.futbolsa.vista.formularios.FormularioCrearClub;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaAdministrador extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaAdministrador";
	
	public PaginaAdministrador() {

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addComponent(Cabecera.getCabecera());
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		
		if (jugador == null) {
			Notification.show("Debe estar logeado antes de entrar a la pagina de administrador");
			ui.irPagina(PaginaIniciarSesion.NOMBRE);
		}
		else {
			addComponent(new FormularioCrearClub());
			addComponent(new PanelClubes());
		}
	}

}