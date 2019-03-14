package com.caballero.futbolsa.test.negocios;

import java.util.List;

import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Custodio;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojosVo.PosesionVO;

public class CustodioTest {
	
	public static void sumarAccionesTest(Jugador jugador, Club club, Integer cantidad) throws Exception {
		System.out.println("...Sumar acciones test inicializando");
		System.out.println(jugador);
		System.out.println(club);
		Custodio.sumarAcciones(jugador, club, cantidad);
		System.out.println("...Sumar acciones test finalizando");
	}

	public static void restarAccionesTest(Jugador jugador, Club club, Integer cantidad) throws Exception {
		System.out.println("...Restar acciones test inicializando");
		System.out.println(jugador);
		System.out.println(club);
		Custodio.restarAcciones(jugador, club, cantidad);
		System.out.println("...Restar acciones test finalizando");
	}

	public static void traerAccionesDeJugadorTest(Jugador jugador) {
		System.out.println("...Traer acciones de jugador test inicializando");
		System.out.println(jugador);
		List<Posesion> acciones = Custodio.traerAccionesDeJugador(jugador);
		for (Posesion posesion : acciones)
			System.out.println(posesion);
		System.out.println("Cantidad: "+ acciones.size() +" posesiones distintas");
		System.out.println("...Traer acciones de jugador test finalizando");
	}

	public static void traerAccionesDeJugadorClubTest(Jugador jugador, Club club) throws Exception {
		System.out.println("...Traer acciones de jugador y club test inicializando");
		System.out.println(jugador);
		System.out.println(club);
		System.out.println(Custodio.traerAccionesDeJugadorClub(jugador, club));
		System.out.println("...Traer acciones de jugador y club  test finalizando");
	}
		
	public static void traerAccionesVODeJugadorTest(Jugador jugador) {
		System.out.println("...Traer acciones VO de jugador test inicializando");
		System.out.println("Jugador: "+jugador.getUsuario());
		List<PosesionVO> acciones = Custodio.traerAccionesVODeJugador(jugador);
		for (PosesionVO posesion : acciones)
			System.out.println(posesion);
		System.out.println("Cantidad: "+ acciones.size() +" posesiones distintas");
		System.out.println("...Traer acciones VO de jugador test finalizando");
	}
	
	public static void main(String[] args) {	
		try {
			Jugador jugador = Identificador.traerJugadorPorID(1);
			Club club = Administrador.traerClubPorID(1);
			sumarAccionesTest(jugador, club, 100);
			//restarAccionesTest(jugador, club, 150);
			traerAccionesVODeJugadorTest(jugador);
			//traerAccionesDeJugadorTest(jugador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}