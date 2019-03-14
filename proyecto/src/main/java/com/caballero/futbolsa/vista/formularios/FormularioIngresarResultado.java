package com.caballero.futbolsa.vista.formularios;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.vista.componentes.ValidadorNumerico;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;

public class FormularioIngresarResultado extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField inGolesLocal, inGolesVisitante;
	private ComboBox inClubLocal, inClubVisitante;
		
	public FormularioIngresarResultado() {
		setCaption("Ingresar un nuevo resultado");
		
		// creo las listas con equipos
		List<Club> clubes = Administrador.traerClubes();
		
		inClubLocal = new ComboBox("Club local");
		inClubLocal.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		for (Club club : clubes) {
			inClubLocal.addItem(club);
			inClubLocal.setItemCaption(club, club.getNombre());
		}
		inClubLocal.setValue(clubes.iterator().next());
		
		inClubVisitante = new ComboBox("Club visitante");
		inClubVisitante.setItemCaptionMode(ItemCaptionMode.EXPLICIT);
		for (Club club : clubes) {
			inClubVisitante.addItem(club);
			inClubVisitante.setItemCaption(club, club.getNombre());
		}
		inClubVisitante.setValue(clubes.iterator().next());

		Button btAceptar = new Button("Confirmar");
		btAceptar.addClickListener(e -> {
			registrarResultado();
		});
		
		inGolesLocal = new TextField("Goles local");
		inGolesLocal.setValue("0");
		inGolesLocal.addValidator(new ValidadorNumerico());

		inGolesVisitante = new TextField("Goles visitante");
		inGolesVisitante.setValue("0");
		inGolesVisitante.addValidator(new ValidadorNumerico());
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inClubLocal);
		formulario.addComponent(inGolesLocal);
		formulario.addComponent(inClubVisitante);
		formulario.addComponent(inGolesVisitante);
		formulario.addComponent(btAceptar);		
		setContent(formulario);
	}
		
	private void registrarResultado() {
		try {
			Club clubLocal = (Club) inClubLocal.getValue();
			Club clubVisitante = (Club) inClubVisitante.getValue();
			Integer golesLocal = new Integer(inGolesLocal.getValue());
			Integer golesVisitante = new Integer(inGolesVisitante.getValue());		
			Administrador.registrarResultado(clubLocal, clubVisitante, golesLocal, golesVisitante);
			
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}
	
}