package com.caballero.futbolsa.vista.formularios;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Presidencia;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.vista.componentes.ValidadorNumerico;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class FormularioDividendos extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField inVictoria, inEmpate, inDerrota;
	private Club inClub;
	private Jugador inJugador;
	
	public FormularioDividendos(Jugador jugador, Club club) {
		setCaption("Manejar dividendos del club "+club.getNombre());
		inClub = club;
		inJugador = jugador;
		
		Button btGuardar = new Button("Guardar cambios");
		btGuardar.addClickListener(e -> {
			guardarCambios();
		});
		
		FormLayout formulario = new FormLayout();
		formulario.addComponent(inVictoria = new TextField("Dividendos por victoria "));
		formulario.addComponent(inEmpate = new TextField("Dividendos por empate "));
		formulario.addComponent(inDerrota = new TextField("Dividendos por derrota "));
		inVictoria.setValue(club.getDiv_victoria().toString());
		inVictoria.addValidator(new ValidadorNumerico());
		inEmpate.setValue(club.getDiv_empate().toString());
		inEmpate.addValidator(new ValidadorNumerico());
		inDerrota.setValue(club.getDiv_derrota().toString());
		inDerrota.addValidator(new ValidadorNumerico());
		
		formulario.addComponent(btGuardar);		
		setContent(formulario);
	}
		
	private void guardarCambios() {
		try {
			Integer div_victoria = new Integer(inVictoria.getValue());
			Integer div_empate = new Integer(inEmpate.getValue());
			Integer div_derrota = new Integer(inDerrota.getValue());

			if (div_victoria != inClub.getDiv_victoria())
				Presidencia.definirDividendoDeVictoria(inJugador, inClub, div_victoria);
			
			if (div_empate != inClub.getDiv_empate())
				Presidencia.definirDividendoDeEmpate(inJugador, inClub, div_empate);
			
			if (div_derrota!= inClub.getDiv_derrota())
				Presidencia.definirDividendoDeDerrota(inJugador, inClub, div_derrota);
			
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
				
		} catch (Exception e) {
			Notification.show(e.getMessage());
		}
	}
	
}