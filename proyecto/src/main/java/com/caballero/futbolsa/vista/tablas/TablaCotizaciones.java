package com.caballero.futbolsa.vista.tablas;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Cotizador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.ClubVO;
import com.caballero.futbolsa.vista.paginas.PaginaOperar;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TablaCotizaciones extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public TablaCotizaciones(Jugador jugador) {
		List<ClubVO> clubes = Cotizador.traerCotizaciones();	
		
		if (clubes.size()>0) {
			Table tabla = new Table("Cotizaciones actuales");
			tabla.addContainerProperty("Club", String.class, null);
			tabla.addContainerProperty("Cotización",  String.class, null);
			tabla.addContainerProperty("Div victoria",  String.class, null);
			tabla.addContainerProperty("Div empate",  String.class, null);
			tabla.addContainerProperty("Div derrota",  String.class, null);
			tabla.addContainerProperty("Pedido",  String.class, null);
			tabla.addContainerProperty("Ofrecido",  String.class, null);
			
			if (jugador != null) {			
				tabla.addContainerProperty("Comprar",  Button.class, null);
				tabla.addContainerProperty("Vender",  Button.class, null);
			}
			
			for (ClubVO club : clubes)
				agregarItem(tabla, club, jugador);
			
			tabla.setPageLength(tabla.size());
			addComponent(tabla);
			setComponentAlignment(tabla, Alignment.MIDDLE_CENTER);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void agregarItem(Table tabla, ClubVO club, Jugador jugador) {
		Object itemID = tabla.addItem();
		Item registro = tabla.getItem(itemID);
		
		String nombre = club.getClub();
		String cotizacion = "$"+club.getCotizacion();
		String div_victoria = "$"+club.getDiv_victoria();
		String div_empate = "$"+club.getDiv_empate();
		String div_derrota = "$"+club.getDiv_derrota();
		String pedido = club.getCantidad_compra() +"/$"+club.getPrecio_compra();
		String ofrecido = club.getCantidad_venta() +"/$"+club.getPrecio_venta();
				
		registro.getItemProperty("Club").setValue(nombre);
		registro.getItemProperty("Cotización").setValue(cotizacion);
		registro.getItemProperty("Div victoria").setValue(div_victoria);
		registro.getItemProperty("Div empate").setValue(div_empate);
		registro.getItemProperty("Div derrota").setValue(div_derrota);
		registro.getItemProperty("Pedido").setValue(pedido);
		registro.getItemProperty("Ofrecido").setValue(ofrecido);
		
		if (jugador != null) {
			Button comprar = new Button("Comprar");
			comprar.addClickListener(e ->{
				comprarAcciones(club);
			});
			
			Button vender = new Button("Vender");
			vender.addClickListener(e ->{
				venderAcciones(club);
			});
			
			registro.getItemProperty("Comprar").setValue(comprar);				
			registro.getItemProperty("Vender").setValue(vender);
		}
	}
	
	private void comprarAcciones(ClubVO club) {
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("colocar_orden_operacion", "C");
		ui.setSesion("colocar_orden_club_id", club.getClub_id());
		ui.setSesion("colocar_orden_cantidad", 1);
		ui.setSesion("colocar_orden_precio", club.getCotizacion());
		ui.irPagina(PaginaOperar.NOMBRE);
	}
	
	private void venderAcciones(ClubVO club) {
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("colocar_orden_operacion", "V");
		ui.setSesion("colocar_orden_club_id", club.getClub_id());
		ui.setSesion("colocar_orden_cantidad", 1);
		ui.setSesion("colocar_orden_precio", club.getCotizacion());
		ui.irPagina(PaginaOperar.NOMBRE);
	}
	
}