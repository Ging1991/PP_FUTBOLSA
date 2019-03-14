package com.caballero.futbolsa.vista.componentes;

import com.caballero.futbolsa.MyUI;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;

public class Publicidad extends Image{
	private static final long serialVersionUID = 1L;
	
	public Publicidad () {
		super(null, new ClassResource("/publicidad.png"));
		String url = "https://www.youtube.com/watch?v=dWPevlPw9IU"; // Gameplay de Silent Hill
		
		addClickListener(e -> {
			MyUI ui = (MyUI) UI.getCurrent();
			ui.getPage().open(url, "_blank");
		});
	}

}