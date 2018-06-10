package com.caballero.futbolsa.test;

import java.util.List;
import com.caballero.futbolsa.negocios.Custodio;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;

public class CustodioTest {
	
	public static void sumarAccionesTest(Jugador jugador, Club club, Integer cantidad) {
		try {
			Custodio.sumarAcciones(jugador, club, cantidad);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void restarAccionesTest(Jugador jugador, Club club, Integer cantidad) {
		try {
			Custodio.restarAcciones(jugador, club, cantidad);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void traerAccionesVOByJugadorTest(Jugador jugador) {
		List<PosesionVO> posesiones = Custodio.traerAccionesVODeJugador(jugador);
		
		System.out.println("Lista de todos las acciones que posee:");
		for (PosesionVO posesion : posesiones)
			System.out.println(posesion.getJugador_id()+"-"+posesion.getNombre()+"-"+posesion.getCantidad());
		System.out.println("Fin de la lista:"+posesiones.size()+" posesiones");
	}
	
	public static void main(String[] args) {		
		Jugador jugador = Identificador.traerJugadorPorID(1);
		Club club = new Club(3, "");
		//sumarAccionesTest(jugador, club, 100);
		restarAccionesTest(jugador, club, 140);
		traerAccionesVOByJugadorTest(jugador);
	}

}