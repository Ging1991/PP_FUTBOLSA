package com.caballero.futbolsa.vista.tablas;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaPerfil;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TablaRankingJugadores extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public TablaRankingJugadores() {
		List<Jugador> jugadores = Administrador.traerJugadoresByRanking();
		if (jugadores.size()==0) {
			addComponent(new Label("No hay ningun jugador en el Ranking"));
			return;
		}
		
		Table tabla = new Table("Ranking de jugadores TOP 10");
		tabla.addContainerProperty("Posicion",  Integer.class, null);
		tabla.addContainerProperty("Jugador",  String.class, null);
		tabla.addContainerProperty("Efectivo", String.class, null);
		tabla.addContainerProperty("Ver perfil",  Button.class, null);
		
		for (Jugador jugador : jugadores)
			agregarItem(tabla, jugador);
			
		tabla.setPageLength(tabla.size());
		addComponent(tabla);
		setComponentAlignment(tabla, Alignment.MIDDLE_CENTER);
	}
	
	@SuppressWarnings("unchecked")
	private void agregarItem(Table tabla, Jugador jugador) {
		Object itemID = tabla.addItem();
		Item registro = tabla.getItem(itemID);
		
		Integer posicion = jugador.getPosicion();
		String usuario = jugador.getUsuario();
		String efectivo = "$"+jugador.getEfectivo();
		Button perfil = new Button("Ver perfil");
		perfil.addClickListener(e ->{
			verPerfil(jugador);
		});
		
		registro.getItemProperty("Posicion").setValue(posicion);
		registro.getItemProperty("Jugador").setValue(usuario);
		registro.getItemProperty("Efectivo").setValue(efectivo);
		registro.getItemProperty("Ver perfil").setValue(perfil);
	}
	
	private void verPerfil(Jugador jugador) {
		MyUI ui = (MyUI) UI.getCurrent();
		ui.setSesion("jugador_perfil", jugador);
		ui.irPagina(PaginaPerfil.NOMBRE);
	}
	
}