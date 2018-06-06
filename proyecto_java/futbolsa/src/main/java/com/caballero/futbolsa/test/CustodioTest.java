package com.caballero.futbolsa.test;

import java.util.List;

import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Custodio;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;

public class CustodioTest {
	
	public static void asignarPosesionTest(Jugador jugador, Club club, Integer cantidad) {
		try {
			Custodio.asignarPosesionDeAccion(jugador, club, cantidad);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getPosesionesByJugadorTest(Jugador jugador) {
		List<Posesion> posesiones = Custodio.getPosesionesDeJugador(jugador);
		
		System.out.println("Lista de todos las posesiones:");
		for (Posesion posesion : posesiones)
			System.out.println(posesion.getJugador_id()+"-"+posesion.getClub_id()+"-"+posesion.getCantidad());
		System.out.println("Fin de la lista:"+posesiones.size()+" posesiones");
	}
	
	public static void getPosesionesVOByJugadorTest(Jugador jugador) {
		List<PosesionVO> posesiones = Custodio.getPosesionesVODeJugador(jugador);
		
		System.out.println("Lista de todos las posesiones:");
		for (PosesionVO posesion : posesiones)
			System.out.println(posesion.getJugador_id()+"-"+posesion.getNombre()+"-"+posesion.getCantidad());
		System.out.println("Fin de la lista:"+posesiones.size()+" posesiones");
	}
	
	public static void main(String[] args) {
		String nombre = "Carlos";
		
		try {
			//Identificador.registrarJugador(nombre, "123");
			//Administrador.crearClub("River");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Jugador jugador = Identificador.getJugadorByNombre(nombre);
		Club club = new Club(1, "Boca");
		asignarPosesionTest(jugador, club, 10);
		getPosesionesByJugadorTest(jugador);
		getPosesionesVOByJugadorTest(jugador);
		
	}

}