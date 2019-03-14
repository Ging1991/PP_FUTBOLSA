package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaAdministrador;
import com.caballero.futbolsa.vista.paginas.PaginaIniciarSesion;
import com.caballero.futbolsa.vista.paginas.PaginaNotificaciones;
import com.caballero.futbolsa.vista.paginas.PaginaOperar;
import com.caballero.futbolsa.vista.paginas.PaginaOrdenesDeJugador;
import com.caballero.futbolsa.vista.paginas.PaginaPerfil;
import com.caballero.futbolsa.vista.paginas.PaginaPosesiones;
import com.caballero.futbolsa.vista.paginas.PaginaPresidencia;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.caballero.futbolsa.vista.paginas.PaginaRankingClubes;
import com.caballero.futbolsa.vista.paginas.PaginaRankingJugadores;
import com.caballero.futbolsa.vista.paginas.PaginaRegistrarJugador;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MenuLateral extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public MenuLateral (Jugador jugador){
		if (jugador != null) {
			addComponent(new BloqueJugador(jugador));
			addComponent(crearMenuDeJugador(jugador));
		} else {
			addComponent(crearMenuAnonimo());
		}
	}

	private VerticalLayout crearMenuAnonimo() {
		MyUI ui = (MyUI) UI.getCurrent();
		
		Button ingresar = new Button("Iniciar sesión");
		ingresar.setWidth("100%");
		ingresar.addClickListener(e -> {
			ui.irPagina(PaginaIniciarSesion.NOMBRE);
		});
		
		Button registrar = new Button("Registrar jugador");
		registrar.setWidth("100%");
		registrar.addClickListener(e -> {
			ui.irPagina(PaginaRegistrarJugador.NOMBRE);
		});

		Button jugadoresRank = new Button("Ranking de jugadores");
		jugadoresRank.setWidth("100%");
		jugadoresRank.addClickListener(e -> {
			ui.irPagina(PaginaRankingJugadores.NOMBRE);
		});

		Button clubRank = new Button("Ranking de clubes");
		clubRank.setWidth("100%");
		clubRank.addClickListener(e -> {
			ui.irPagina(PaginaRankingClubes.NOMBRE);
		});
		
		VerticalLayout botones = new VerticalLayout();
		botones.addComponent(ingresar);
		botones.addComponent(registrar);
		botones.addComponent(jugadoresRank);
		botones.addComponent(clubRank);
		
		return botones;
	}
	
	private VerticalLayout crearMenuDeJugador(Jugador jugador) {
		MyUI ui = (MyUI) UI.getCurrent();
		
		Button administracion = new Button("Administración");
		administracion.setWidth("100%");
		administracion.addClickListener(e -> {
			ui.irPagina(PaginaAdministrador.NOMBRE);
		});
		
		Button perfil = new Button("Ver perfil");
		perfil.setWidth("100%");
		perfil.addClickListener(e -> {
			ui.setSesion("jugador_perfil", jugador);
			ui.irPagina(PaginaPerfil.NOMBRE);
		});		
		
		Button notificaciones = new Button("Notificaciones");
		notificaciones.setWidth("100%");
		notificaciones.addClickListener(e -> {
			ui.irPagina(PaginaNotificaciones.NOMBRE);
		});		
		
		Button operar = new Button("Colocar orden");
		operar.setWidth("100%");
		operar.addClickListener(e -> {
			ui.irPagina(PaginaOperar.NOMBRE);
		});
		
		Button ordenes = new Button("Mis ordenes");
		ordenes.setWidth("100%");
		ordenes.addClickListener(e -> {
			ui.irPagina(PaginaOrdenesDeJugador.NOMBRE);
		});
		
		Button posesiones = new Button("Mis posesiones");
		posesiones.setWidth("100%");
		posesiones.addClickListener(e -> {
			ui.irPagina(PaginaPosesiones.NOMBRE);
		});
				
		Button presidencia = new Button("Presidencia");
		presidencia.setWidth("100%");
		presidencia.addClickListener(e -> {
			ui.irPagina(PaginaPresidencia.NOMBRE);
		});
		
		Button jugadoresRank = new Button("Ranking de jugadores");
		jugadoresRank.setWidth("100%");
		jugadoresRank.addClickListener(e -> {
			ui.irPagina(PaginaRankingJugadores.NOMBRE);
		});

		Button clubRank = new Button("Ranking de clubes");
		clubRank.setWidth("100%");
		clubRank.addClickListener(e -> {
			ui.irPagina(PaginaRankingClubes.NOMBRE);
		});
		
		Button salir = new Button("Cerrar sesión");
		salir.setWidth("100%");
		salir.addClickListener(e -> {
			ui.setSesion("jugador_activo", null);
			ui.irPagina(PaginaRankingJugadores.NOMBRE);
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		
		VerticalLayout botones = new VerticalLayout();
		botones.addComponent(perfil);
		botones.addComponent(notificaciones);
		botones.addComponent(operar);
		botones.addComponent(ordenes);
		botones.addComponent(posesiones);
		botones.addComponent(presidencia);
		botones.addComponent(jugadoresRank);
		botones.addComponent(clubRank);
		
		if (jugador.isAdministrador())
			botones.addComponent(administracion);
		botones.addComponent(salir);
		
		return botones;
	}
	
}