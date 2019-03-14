package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Presidencia;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.EmisionVO;
import com.caballero.futbolsa.vista.paginas.PaginaManejarAcciones;
import com.caballero.futbolsa.vista.paginas.PaginaManejarDividendos;
import com.caballero.futbolsa.vista.tablas.TablaOrdenesDeClub;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class BloqueManejarClub extends Panel{
	private static final long serialVersionUID = 1L;
	
	public BloqueManejarClub(Jugador jugador, Club club) {
		super("Presidencia del club: "+club.getNombre());
		VerticalLayout dividendos = crearBloqueDividendos(club);
		VerticalLayout acciones = crearBloqueAcciones(club);
		TablaOrdenesDeClub ordenes = new TablaOrdenesDeClub(club);
		
		HorizontalSplitPanel panel = new HorizontalSplitPanel();
		panel.setFirstComponent(acciones);
		panel.setSecondComponent(dividendos);
		
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(panel);
		layout.addComponent(ordenes);
		setContent(layout);
	}

	private VerticalLayout crearBloqueDividendos(Club club) {
		Integer divVictoria = club.getDiv_victoria();
		Integer divEmpate = club.getDiv_empate();
		Integer divDerrota = club.getDiv_derrota();
		
		EmisionVO emisionVO = Presidencia.traerEmision(club);
		Integer emision = 0;
		if (emisionVO != null)
			emision = emisionVO.getEmision();
		
		String titulo = "Dividendos del club";
		String victoria= "VICTORIA: $"+divVictoria+" (Si gana deberá pagar: $"+(divVictoria*emision)+")";
		String empate = "EMPATE: $"+divEmpate+" (Si empata deberá pagar: $"+(divEmpate*emision)+")";
		String derrota = "DERROTA: $"+divDerrota+" (Si pierde deberá pagar: $"+(divDerrota*emision)+")";
		
		VerticalLayout dividendos = new VerticalLayout();
		dividendos.addComponent(new Label(titulo));
		dividendos.addComponent(new Label(victoria));
		dividendos.addComponent(new Label(empate));
		dividendos.addComponent(new Label(derrota));

		Button btModificar = new Button("Modificar dividendos");
		btModificar.setWidth("100%");
		btModificar.addClickListener(e -> {
			MyUI ui = (MyUI) UI.getCurrent();
			ui.setSesion("manejar_club", club);
			ui.irPagina(PaginaManejarDividendos.NOMBRE);
		});
		dividendos.addComponent(btModificar);

		return dividendos;
	}

	private VerticalLayout crearBloqueAcciones(Club club) {
		EmisionVO emisionVO = Presidencia.traerEmision(club);
		Integer emision = 0;
		if (emisionVO != null)
			emision = emisionVO.getEmision();
		
		Integer cotizacion = club.getCotizacion();
		Integer capital = cotizacion * emision;
		Integer posicion = club.getPosicion();
		
		String labEmision = "Cantidad de acciones emitidas: "+emision; 
		String labCotizacion = "Cotizacion actual por accion: $"+cotizacion; 
		String labCapital = "Capital social: $"+capital;
		String labPosicion = "Posicion en el ranking: N°"+posicion;

		VerticalLayout acciones = new VerticalLayout();
		acciones.addComponent(new Label(labEmision));
		acciones.addComponent(new Label(labCotizacion));
		acciones.addComponent(new Label(labCapital));
		acciones.addComponent(new Label(labPosicion));
		
		Button btEmitir = new Button("Manejar emision");
		btEmitir.setWidth("100%");
		btEmitir.addClickListener(e -> {
			MyUI ui = (MyUI) UI.getCurrent();
			ui.setSesion("manejar_club", club);
			ui.irPagina(PaginaManejarAcciones.NOMBRE);
		});
		acciones.addComponent(btEmitir);
		
		return acciones;
	}
	
}