package com.caballero.futbolsa.vista.tablas;

import java.util.List;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojosVo.ClubVO;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class TablaRankingClubes extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public TablaRankingClubes() {
		List<ClubVO> clubes = Administrador.traerClubesByRanking();
		if (clubes.size()==0) {
			addComponent(new Label("No hay ningun club en el ranking"));
			return;
		}
		
		Table tabla = new Table("Ranking de clubes mejor administrados TOP 10");
		tabla.addContainerProperty("Posicion",  Integer.class, null);
		tabla.addContainerProperty("Club", String.class, null);
		tabla.addContainerProperty("Cotizacion",  String.class, null);
		tabla.addContainerProperty("Presidente", String.class, null);
		tabla.addContainerProperty("Efectivo",  String.class, null);
		tabla.addContainerProperty("Div victoria",  Integer.class, null);
		tabla.addContainerProperty("Div empate",  Integer.class, null);
		tabla.addContainerProperty("Div derrota",  Integer.class, null);

		for (ClubVO club : clubes)
			agregarItem(tabla, club);
	
		tabla.setPageLength(tabla.size());
		addComponent(tabla);
		setComponentAlignment(tabla, Alignment.MIDDLE_CENTER);
	}
	
	@SuppressWarnings("unchecked")
	private void agregarItem(Table tabla, ClubVO club) {
		Object itemID = tabla.addItem();
		Item registro = tabla.getItem(itemID);
		
		Integer posicion = club.getPosicion();
		String nombre = club.getClub();
		String cotizacion = "$"+club.getCotizacion();
		String presidente = club.getPresidente();
		String efectivo = "$"+club.getEfectivo();
		Integer div_victoria = club.getDiv_victoria();
		Integer div_empate = club.getDiv_empate();
		Integer div_derrota = club.getDiv_derrota();
		
		registro.getItemProperty("Posicion").setValue(posicion);
		registro.getItemProperty("Club").setValue(nombre);
		registro.getItemProperty("Cotizacion").setValue(cotizacion);
		registro.getItemProperty("Presidente").setValue(presidente);
		registro.getItemProperty("Efectivo").setValue(efectivo);
		registro.getItemProperty("Div victoria").setValue(div_victoria);
		registro.getItemProperty("Div empate").setValue(div_empate);
		registro.getItemProperty("Div derrota").setValue(div_derrota);
	}
	
	/*
	private void comprarAcciones(ClubVO club) {
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("colocar_orden_operacion", "C");
		ui.setSesion("colocar_orden_club_id", club.getClub_id());
		ui.setSesion("colocar_orden_cantidad", 1);
		ui.setSesion("colocar_orden_precio", club.getCotizacion());
		ui.irPagina(PaginaOperar.NOMBRE);
	}
	*/
	
}	