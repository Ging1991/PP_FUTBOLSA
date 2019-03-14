package com.caballero.futbolsa.vista.formularios;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class FormularioRegistrarUsuario extends Panel {
	private static final long serialVersionUID = 1L;
	public TextField inUsuario, inPassword;
	
	public FormularioRegistrarUsuario() {
		setCaption("Registrar jugador");
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inUsuario = new TextField("Usuario: "));
		formulario.addComponent(inPassword = new TextField("Password: "));
		
		Button btAceptar = new Button("Aceptar");
		btAceptar.addClickListener(e -> {
			registrar();
		});
		
		formulario.addComponent(btAceptar);		
		setContent(formulario);
	}
		
	private void registrar() {
		String usuario = inUsuario.getValue();
		String password = inPassword.getValue();
		
		Jugador jugador;
		
		try {
			Identificador.registrarJugador(usuario, password);
			jugador = Identificador.traerJugadorPorUsuario(usuario);
			MyUI ui = (MyUI) UI.getCurrent();
			ui.setSesion("jugador_activo", jugador);
			ui.irPagina(PaginaPrincipal.NOMBRE);
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}

}