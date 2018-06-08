package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Cabecera extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	private Image logo;
	private MenuBar menu;
	
	private Cabecera (){
		menu = crearBarraMenu();
		
		logo = new Image(null, new ClassResource("/logo.jpg"));
		logo.addClickListener(e -> {
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

		MyUI aplicacionUI = (MyUI) UI.getCurrent();
		Jugador usuario = new Jugador(1, "", "", 1);

		// Si esta logueado
		if (usuario != null) {
			barra.addItem("Operar acciones", e -> {
			//	aplicacionUI.irPagina(PaginaOperar.NOMBRE);
			});
			barra.addItem("Cerrar sesión", e -> {
				aplicacionUI.setSesion("jugador", null);
			//	aplicacionUI.irPagina(PaginaPrincipal.NOMBRE);
			});
			
		// si no esta logueado
		}		
		return barra;
	}

	static public Cabecera getCabecera() {
		return new Cabecera();
	}
	
	public void actualizarCabecera() {
		removeComponent(menu);
		addComponent(menu = crearBarraMenu());
		menu.setWidth("80%");
		setComponentAlignment(menu, Alignment.TOP_CENTER);
	}
	
}