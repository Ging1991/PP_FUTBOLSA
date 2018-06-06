package com.caballero.futbolsa.vista.paginas;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class PaginaPrincipal extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaPrincipal";
	
	public PaginaPrincipal() {

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		
		if (jugador == null) {
			Label label = new Label("Ningun jugador activo");
			Button btIngresar = new Button("Ingresar o registrarse");
			btIngresar.addClickListener(e -> {
				ui.irPagina(PaginaIdentificacion.NOMBRE);
			});
			
			addComponent(label);
			addComponent(btIngresar);			
		} else {
			Label label = new Label("Jugador activo: "+jugador.getUsuario());			

			Button btSalir = new Button("Cerrar sesion");
			btSalir.addClickListener(e -> {
				ui.setSesion("jugador_activo", null);
				this.enter(event);
			});

			Button btCrearClub = new Button("Crear club");
			btCrearClub.addClickListener(e -> {
				ui.irPagina(PaginaAdministrador.NOMBRE);
			});

			Button btOperar = new Button("Colocar orden");
			btOperar.addClickListener(e -> {
				ui.irPagina(PaginaOperar.NOMBRE);
			});

			Button btPerfil= new Button("Ver perfil");
			btPerfil.addClickListener(e -> {
				ui.irPagina(PaginaPerfil.NOMBRE);
			});
			
			addComponent(label);
			addComponent(btSalir);
			addComponent(btCrearClub);
			addComponent(btOperar);
			addComponent(btPerfil);
		}
		
		//addComponent(new PanelJugadores());
				
	}

}
