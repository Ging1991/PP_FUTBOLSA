package com.caballero.futbolsa.vista.formularios;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class FormularioCrearClub extends Panel {
	private static final long serialVersionUID = 1L;
	public TextField inNombre;
	
	public FormularioCrearClub() {
		setCaption("Crear club");
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inNombre = new TextField("Nombre "));
		
		Button btAceptar = new Button("Aceptar");
		btAceptar.addClickListener(e -> {
			crear();
		});
		
		formulario.addComponent(btAceptar);		
		setContent(formulario);
	}
		
	private void crear() {
		String nombre = inNombre.getValue();

		try {
			Administrador.crearClub(nombre);
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}

}