package com.caballero.futbolsa.vista.formularios;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;

public class FormularioEditarBiografia extends Panel {
	private static final long serialVersionUID = 1L;
	public TextArea inBiografia;
	public Jugador inJugador;
	
	public FormularioEditarBiografia(Jugador jugador) {
		setCaption("Editar biografia");
		inJugador = jugador;
		
		inBiografia = new TextArea();
		inBiografia.setValue(jugador.getBiografia());
		inBiografia.setWidth("100%");
		
		Button btGuardar = new Button("Guardar cambios");
		btGuardar.addClickListener(e -> {
			guardar();
		});
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inBiografia);
		formulario.addComponent(btGuardar);		
		setContent(formulario);
	}
		
	private void guardar() {
		try {
			String biografia = inBiografia.getValue();
			Jugador jugador = inJugador;
			jugador.setBiografia(biografia);
			Identificador.actualizarBiografia(jugador);
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}

}