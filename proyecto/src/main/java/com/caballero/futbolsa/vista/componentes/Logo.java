package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;

public class Logo extends Image{
	private static final long serialVersionUID = 1L;
	
	public Logo () {
		super(null, new ClassResource("/logo.png"));
		addClickListener(e -> {
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
	}

}