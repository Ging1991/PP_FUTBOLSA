package com.caballero.futbolsa.vista.componentes;

import java.util.List;
import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.caballero.futbolsa.vista.paginas.PaginaRegistrarResultado;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class BloqueOpcionesDeAdministrador extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	
	public BloqueOpcionesDeAdministrador() {
		MyUI ui = (MyUI) UI.getCurrent();

		Button btRankJugadores = new Button("Actualizar ranking de jugadores");
		btRankJugadores.addClickListener(e -> {
			Administrador.actualizarRankingJugadores();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		
		Button btEstadoDeJuego = new Button("Verificar estado del juego");
		btEstadoDeJuego.addClickListener(e -> {
			System.out.println("Verificar estado del juego");
		});
		
		Button btIngresarResultado = new Button("Ingresar resultado de partido");
		btIngresarResultado.addClickListener(e -> {
			ui.irPagina(PaginaRegistrarResultado.NOMBRE);
		});
		
		Button btCobrarImpuestos = new Button("Cobrar impuestos a los jugadores");
		btCobrarImpuestos.addClickListener(e -> {
			System.out.println("Cobrando impuestos a los jugadores");
		});
		
		Button btRankClubes = new Button("Actualizar ranking de clubes");
		btRankClubes.addClickListener(e -> {
			Administrador.actualizarRankingClubes();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		
		Button btActualizarPresidente = new Button("Actualizar todos los presidentes de clubes");
		btActualizarPresidente.addClickListener(e -> {
			List<Club> clubes = Administrador.traerClubes();
			for (Club club : clubes)
				Administrador.elegirPresidente(club);
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		
		btActualizarPresidente.setWidth("100%");
		btRankJugadores.setWidth("100%");
		btRankClubes.setWidth("100%");
		btCobrarImpuestos.setWidth("100%");
		btIngresarResultado.setWidth("100%");
		btEstadoDeJuego.setWidth("100%");
		addComponent(btActualizarPresidente);
		addComponent(btRankJugadores);
		addComponent(btRankClubes);
		addComponent(btCobrarImpuestos);
		addComponent(btIngresarResultado);
		addComponent(btEstadoDeJuego);
	}

}