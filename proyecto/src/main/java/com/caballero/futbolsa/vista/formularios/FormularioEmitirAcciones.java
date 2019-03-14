package com.caballero.futbolsa.vista.formularios;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Presidencia;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.componentes.ValidadorNumerico;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;

public class FormularioEmitirAcciones extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField inCantidad, inPrecio;
	private Jugador inJugador;
	private ComboBox inTipo;
	private Club inClub;	
	
	public FormularioEmitirAcciones(Jugador jugador, Club club) {
		setCaption("Emision y absorcion de acciones del club "+club.getNombre());
		inJugador = jugador;
		inClub = club;
		inTipo = crearListaTipoOperacion();
		
		inCantidad = new TextField("Cantidad");
		inCantidad.addValidator(new ValidadorNumerico());
		inCantidad.setValue("100");
		
		inPrecio = new TextField("Precio unitario $");
		inPrecio.addValidator(new ValidadorNumerico());
		inPrecio.setValue(club.getCotizacion().toString());
		
		Button btAceptar = new Button("Confirmar");
		btAceptar.addClickListener(e -> {
			emitirAcciones();
		});
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inTipo);
		formulario.addComponent(inCantidad);
		formulario.addComponent(inPrecio);
		formulario.addComponent(btAceptar);		
		setContent(formulario);
	}
		
	private void emitirAcciones() {
		try {
			Integer cantidad = new Integer(inCantidad.getValue());
			Integer precio = new Integer(inPrecio.getValue());
			String operacion = (String) inTipo.getValue();
			MyUI ui = (MyUI) UI.getCurrent();
			
			if (operacion.equals("E"))	
				Presidencia.emitirAcciones(inJugador, inClub, cantidad, precio);
			else
				Presidencia.absorverAcciones(inJugador, inClub, cantidad, precio);
			
			ui.irPagina(PaginaPrincipal.NOMBRE);
				
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}
	
	private ComboBox crearListaTipoOperacion() {
		ComboBox lista = new ComboBox("Tipo de operación");
		lista.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		
		String venta = "E";
		String compra = "A";
		
		lista.addItem(venta);
		lista.addItem(compra);
		lista.setItemCaption(venta, "Emisión");
		lista.setItemCaption(compra, "Absorción");
		lista.setValue(venta);
		return lista;
	}
	
}