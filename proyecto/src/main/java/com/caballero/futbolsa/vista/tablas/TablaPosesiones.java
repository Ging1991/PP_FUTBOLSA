package com.caballero.futbolsa.vista.tablas;

import java.util.List;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Custodio;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.PosesionVO;
import com.caballero.futbolsa.vista.paginas.PaginaOperar;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TablaPosesiones extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public TablaPosesiones(Jugador jugador) {
		List<PosesionVO> posesiones = Custodio.traerAccionesVODeJugador(jugador);
		
		if (posesiones.size() > 0) {
			Table tabla = new Table("Acciones en su cartera");
			tabla.addContainerProperty("Club", String.class, null);
			tabla.addContainerProperty("Cantidad",  Integer.class, null);
			tabla.addContainerProperty("Cotizacion",  String.class, null);
			tabla.addContainerProperty("Total",  Integer.class, null);
			tabla.addContainerProperty("Comprar",  Button.class, null);
			tabla.addContainerProperty("Vender",  Button.class, null);
			
			for (PosesionVO posesion : posesiones)
				agregarItem(tabla, posesion);
			
			tabla.setPageLength(tabla.size());
			addComponent(tabla);
			setComponentAlignment(tabla, Alignment.MIDDLE_CENTER);
		} else
			addComponent(new Label("Usted no posee ninguna accion"));
	}

	@SuppressWarnings({"unchecked" })
	private void agregarItem(Table tabla, PosesionVO posesion) {
		Object itemID = tabla.addItem();
		Item registro = tabla.getItem(itemID);
		
		String club = posesion.getClub();
		Integer cantidad = posesion.getCantidad();
		Integer cotizacion = posesion.getCotizacion();
		
		registro.getItemProperty("Club").setValue(club);
		registro.getItemProperty("Cantidad").setValue(cantidad);
		registro.getItemProperty("Cotizacion").setValue("$"+cotizacion);
		registro.getItemProperty("Total").setValue(cantidad * cotizacion);
		
		Button comprar = new Button("Comprar");
		comprar.addClickListener(e ->{
			comprarAcciones(posesion);
		});
		comprar.setWidth("100%");
		registro.getItemProperty("Comprar").setValue(comprar);

		Button vender = new Button("Vender");
		vender.addClickListener(e ->{
			venderAcciones(posesion);
		});
		
		registro.getItemProperty("Vender").setValue(vender);
	}
	
	private void comprarAcciones(PosesionVO posesion) {
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("colocar_orden_operacion", "C");
		ui.setSesion("colocar_orden_club_id", posesion.getClub_id());
		ui.setSesion("colocar_orden_cantidad", posesion.getCantidad());
		ui.setSesion("colocar_orden_precio", posesion.getCotizacion());
		ui.irPagina(PaginaOperar.NOMBRE);
	}
	
	private void venderAcciones(PosesionVO posesion) {
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("colocar_orden_operacion", "V");
		ui.setSesion("colocar_orden_club_id", posesion.getClub_id());
		ui.setSesion("colocar_orden_cantidad", posesion.getCantidad());
		ui.setSesion("colocar_orden_precio", posesion.getCotizacion());
		ui.irPagina(PaginaOperar.NOMBRE);
	}
	
}