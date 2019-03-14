package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaActualizarBiografia;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class BloquePerfilDeJugador extends Panel{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	public BloquePerfilDeJugador(Jugador jugador) {
		super("Perfil del jugador: "+jugador.getUsuario());
		VerticalLayout izquierda = crearPanelAvatar(jugador);
		VerticalLayout derecha = new VerticalLayout();
		derecha.addComponent(crearPanelDatos(jugador));
		derecha.addComponent(crearPanelBiografia(jugador));
		
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setSplitPosition(25, Sizeable.UNITS_PERCENTAGE);
		
		panel.setFirstComponent(izquierda);
		panel.setSecondComponent(derecha);
		setContent(panel);
	}
	
	private Panel crearPanelDatos(Jugador jugador) {
		String usuario = "Nombre de usuario del jugador: " + jugador.getUsuario();
		String efectivo = "Dinero en efectivo: $"+jugador.getEfectivo();
		String posicion = "Posicion dentro del ranking: N°"+jugador.getPosicion();
		
		VerticalLayout datos = new VerticalLayout();
		datos.addComponent(new Label(usuario));
		datos.addComponent(new Label(efectivo));
		datos.addComponent(new Label(posicion));
		
		Panel panel = new Panel("Ficha de jugador");
		panel.setContent(datos);
		return panel;
	}
	
	private Panel crearPanelBiografia(Jugador jugador) {
		VerticalLayout contenido = new VerticalLayout();
		contenido.addComponent(new Label(jugador.getBiografia()));

		// Solo coloco el boton editar si el jugador activo esta mirando su propio perfil
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugadorActivo = (Jugador) ui.getSesion("jugador_activo");
		
		if (jugador.getJugador_id() == jugadorActivo.getJugador_id()) {
			Button btEditar = new Button("Editar biografía");
			btEditar.addClickListener(e -> {
				ui.irPagina(PaginaActualizarBiografia.NOMBRE);
			});
			btEditar.setWidth("100%");			
			contenido.addComponent(btEditar);
		}
		
		Panel panel = new Panel("Biografía del jugador");
		panel.setContent(contenido);
		return panel;
	}
	
	private VerticalLayout crearPanelAvatar(Jugador jugador) {
		Image avatar = new Image(null, new ClassResource("/avatar.jpg"));	
		avatar.setWidth("100%");

		VerticalLayout ret = new VerticalLayout();
		ret.addComponent(avatar);
		return ret;
	}

}