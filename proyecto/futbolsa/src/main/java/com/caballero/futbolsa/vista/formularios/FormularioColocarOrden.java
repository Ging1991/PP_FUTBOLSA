package com.caballero.futbolsa.vista.formularios;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Agente;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
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

		inClub = new ComboBox("Seleccione un club");
		inClub.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		List<Club> clubes = Administrador.traerClubes();
		for (Club club : clubes) {
			inClub.addItem(club);
			inClub.setItemCaption(club, club.getNombre());
		}
		inClub.setValue(clubes.iterator().next());

		inTipo = new ComboBox("Tipo de operación");
		inTipo.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		String venta = "V";
		String compra = "C";
		inTipo.addItem(venta);
		inTipo.addItem(compra);
		inTipo.setItemCaption(venta, "Venta");
		inTipo.setItemCaption(compra, "Compra");
		inTipo.setValue(compra);
		
		Button btAceptar = new Button("Confirmar");
		btAceptar.addClickListener(e -> {
			colocarOrden();
		});
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inTipo);
		formulario.addComponent(inClub);
		formulario.addComponent(inCantidad = new TextField("Cantidad"));
		formulario.addComponent(inPrecio = new TextField("Precio"));		
		formulario.addComponent(btAceptar);		
		setContent(formulario);
	}
		
	private void colocarOrden() {
		String tipo = (String) inTipo.getValue();
		Club club = (Club) inClub.getValue();
		Integer cantidad = new Integer(inCantidad.getValue());
		Integer precio = new Integer(inPrecio.getValue());

		if (tipo.equals("V"))
			try {
				Agente.colocarOrdenDeVenta(jugador, club, cantidad, precio);
			} catch (Exception e) {
				Notification.show(e.getMessage());
				e.printStackTrace();
			}
		else
			try {
				Agente.colocarOrdenDeCompra(jugador, club, cantidad, precio);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		MyUI ui = (MyUI) UI.getCurrent();
		ui.irPagina(PaginaPrincipal.NOMBRE);
	}
}