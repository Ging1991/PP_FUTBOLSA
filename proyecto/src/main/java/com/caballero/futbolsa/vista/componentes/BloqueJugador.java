package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class BloqueJugador extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public BloqueJugador(Jugador jugador) {
		Image avatar = new Image(null, new ClassResource("/avatar.jpg"));	
		avatar.setWidth("100%");
		String nombre = "Jugador: " + jugador.getUsuario();
		String efectivo = "Dinero: $"+jugador.getEfectivo();
		String posicion = "Posicion: "+jugador.getPosicion();
		addComponent(avatar);
		addComponent(new Label(nombre));
		addComponent(new Label(efectivo));
		addComponent(new Label(posicion));
	}

}