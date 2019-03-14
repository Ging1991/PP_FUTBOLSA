package com.caballero.futbolsa.vista;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.componentes.Logo;
import com.caballero.futbolsa.vista.componentes.MenuLateral;
import com.caballero.futbolsa.vista.componentes.Publicidad;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public abstract class PaginaBase extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	
	public abstract VerticalLayout setContenido();
	
	@SuppressWarnings("deprecation")
	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();

		MenuLateral menuLateral = crearMenuLateral();
		VerticalLayout visualizador = crearContenidoPagina();
		VerticalLayout publicidad = crearPublicidad();
		
		HorizontalSplitPanel panelContenido = new HorizontalSplitPanel();
		panelContenido.setFirstComponent(menuLateral);
		panelContenido.setSecondComponent(visualizador);
		panelContenido.setSplitPosition(20, Sizeable.UNITS_PERCENTAGE);
		
		HorizontalSplitPanel panelCompleto = new HorizontalSplitPanel();
		panelCompleto.setFirstComponent(panelContenido);
		panelCompleto.setSecondComponent(publicidad);
		panelCompleto.setSplitPosition(85, Sizeable.UNITS_PERCENTAGE);
		
		addComponent(panelCompleto);
	}

	private MenuLateral crearMenuLateral() {
		MyUI ui = (MyUI) UI.getCurrent();
		Jugador jugador = (Jugador) ui.getSesion("jugador_activo");
		MenuLateral menu = new MenuLateral(jugador);
		return menu;
	}
	
	private VerticalLayout crearContenidoPagina() {
		VerticalLayout ret = new VerticalLayout();
		VerticalLayout pagina = setContenido();
		pagina.setWidth("100%");
		Logo logo = new Logo();
		
		ret.addComponent(logo);
		ret.addComponent(pagina);
		ret.setComponentAlignment(logo, Alignment.TOP_CENTER);
		ret.setComponentAlignment(pagina, Alignment.MIDDLE_CENTER);
		ret.setWidth("100%");
		
		return ret;
	}
	
	private VerticalLayout crearPublicidad() {
		VerticalLayout ret = new VerticalLayout();
		Publicidad publicidad = new Publicidad();
		ret.addComponent(publicidad);
		return ret;
	}

}