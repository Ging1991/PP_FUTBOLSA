package com.caballero.futbolsa.vista.formularios;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class FormularioIniciarSesion extends Panel{
	private static final long serialVersionUID = 1L;
	public TextField inUsuario;
	public PasswordField inPassword;
	
	public FormularioIniciarSesion() {
		setCaption("Iniciar sesion");
		
		Button btAceptar = new Button("Aceptar");
		btAceptar.addClickListener(e -> {
			iniciarSesion();
		});
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inUsuario = new TextField("Usuario "));
		formulario.addComponent(inPassword = new PasswordField("Password"));		
		formulario.addComponent(btAceptar);
		
		VerticalLayout contenido = new VerticalLayout();
		contenido.addComponent(formulario);
		contenido.setComponentAlignment(formulario, Alignment.MIDDLE_CENTER);
		contenido.setSizeFull();
		
		setContent(contenido);
		setWidth("100%");
	}
		
	private void iniciarSesion() {
		String usuario = inUsuario.getValue();
		String password = inPassword.getValue();
		Jugador jugador;
		
		try {
			jugador = Identificador.iniciarSesion(usuario, password);
			MyUI ui = (MyUI) UI.getCurrent();
			ui.setSesion("jugador_activo", jugador);
			ui.irPagina(PaginaPrincipal.NOMBRE);
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}

}