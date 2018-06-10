package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.paginas.PaginaAdministrador;
import com.caballero.futbolsa.vista.paginas.PaginaIniciarSesion;
import com.caballero.futbolsa.vista.paginas.PaginaOperar;
import com.caballero.futbolsa.vista.paginas.PaginaPerfil;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.caballero.futbolsa.vista.paginas.PaginaRegistrarJugador;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Cabecera extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	private Image logo;
	private MenuBar menu;
	private static Cabecera cabecera;
	
	private Cabecera (){
		menu = crearBarraMenu();
		
		logo = new Image(null, new ClassResource("/logo.jpg"));
		logo.addClickListener(e -> {
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		
		addComponent(logo);
		addComponent(menu);

		setComponentAlignment(logo, Alignment.TOP_CENTER);
		setComponentAlignment(menu, Alignment.TOP_CENTER);
		logo.setWidth("80%");
		menu.setWidth("80%");
	}

	private MenuBar crearBarraMenu() {
		MenuBar barra = new MenuBar();
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");

		// Si no esta logueado
		if (jugador == null) {
			barra.addItem("Iniciar sesion", e -> {ui.irPagina(PaginaIniciarSesion.NOMBRE);});
			barra.addItem("Registrar usuario", e -> {ui.irPagina(PaginaRegistrarJugador.NOMBRE);});
			
		// Si esta logeado
		} else {
			barra.addItem("Crear club", e -> {ui.irPagina(PaginaAdministrador.NOMBRE);});
			barra.addItem("Colocar orden", e -> {ui.irPagina(PaginaOperar.NOMBRE);});
			barra.addItem("Ver perfil", e -> {ui.irPagina(PaginaPerfil.NOMBRE);});
			barra.addItem(jugador.getUsuario()+"/Cerrar sesion", e -> {
				ui.setSesion("jugador_activo", null);
				ui.irPagina(PaginaPerfil.NOMBRE);
			});
			
		}
		
		return barra;
	}

	static public Cabecera getCabecera() {
		if (cabecera == null)
			return cabecera = new Cabecera();
		
		cabecera.actualizarCabecera();
		return cabecera;
	}
	
	public void actualizarCabecera() {
		removeComponent(menu);
		addComponent(menu = crearBarraMenu());
		menu.setWidth("80%");
		setComponentAlignment(menu, Alignment.TOP_CENTER);
	}
	
}