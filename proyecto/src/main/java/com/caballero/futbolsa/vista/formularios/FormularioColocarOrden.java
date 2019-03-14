package com.caballero.futbolsa.vista.formularios;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Agente;
import com.caballero.futbolsa.negocios.Identificador;
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

public class FormularioColocarOrden extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField inCantidad, inPrecio;
	private Jugador jugador;
	private ComboBox inClub, inTipo;
		
	public FormularioColocarOrden(Jugador jugador) {
		this.jugador = jugador;
		setCaption("Colocar orden de Compra-Venta");
		
		// valores por defecto
		MyUI ui = (MyUI) UI.getCurrent();
		String operacion = (String) ui.getSesion("colocar_orden_operacion");
		Integer club_id = (Integer) ui.getSesion("colocar_orden_club_id");
		Integer cantidad = (Integer) ui.getSesion("colocar_orden_cantidad");
		Integer precio = (Integer) ui.getSesion("colocar_orden_precio");

		inClub = new ComboBox("Seleccione un club");
		inClub.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		List<Club> clubes = Administrador.traerClubes();
		for (Club club : clubes) {
			inClub.addItem(club);
			inClub.setItemCaption(club, club.getNombre());
		}
		inClub.setValue(clubes.iterator().next());

		// Coloco el club por defecto
		if (club_id != null) {
			for (Club club : clubes) {
				if (club.getClub_id() == club_id)
					inClub.setValue(club);
			}
		}
		
		inTipo = new ComboBox("Tipo de operación");
		inTipo.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		String venta = "V";
		String compra = "C";
		inTipo.addItem(venta);
		inTipo.addItem(compra);
		inTipo.setItemCaption(venta, "Venta");
		inTipo.setItemCaption(compra, "Compra");
		
		inTipo.setValue(compra);
		if (operacion != null) {
			if (operacion.equals("C"))
				inTipo.setValue(compra);
			else
				inTipo.setValue(venta);
		}
		
		
		
		Button btAceptar = new Button("Confirmar");
		btAceptar.addClickListener(e -> {
			colocarOrden();
		});
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inTipo);
		formulario.addComponent(inClub);
		formulario.addComponent(inCantidad = new TextField("Cantidad"));
		inCantidad.setValue("10");
		if (cantidad != null)
			inCantidad.setValue(cantidad.toString());
		inCantidad.addValidator(new ValidadorNumerico());
		formulario.addComponent(inPrecio = new TextField("Precio"));		
		inPrecio.setValue("1");
		if (precio != null)
			inPrecio.setValue(precio.toString());
		inPrecio.addValidator(new ValidadorNumerico());
		formulario.addComponent(btAceptar);		
		setContent(formulario);
	}
		
	private void colocarOrden() {
		MyUI ui = (MyUI) UI.getCurrent();
		String tipo = (String) inTipo.getValue();
		Club club = (Club) inClub.getValue();
		Integer cantidad = new Integer(inCantidad.getValue());
		Integer precio = new Integer(inPrecio.getValue());
		
		try {
			if (tipo.equals("V"))
				Agente.colocarOrdenDeVenta(jugador, club, cantidad, precio);
			else
				Agente.colocarOrdenDeCompra(jugador, club, cantidad, precio);
			
			Jugador jugadorActual = Identificador.traerJugadorPorID(jugador.getJugador_id());
			ui.setSesion("jugador_activo", jugadorActual);
			ui.irPagina(PaginaPrincipal.NOMBRE);
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}
	
}