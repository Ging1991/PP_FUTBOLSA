package com.caballero.futbolsa.negocios;

import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.interfases.JugadorODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.JugadorOBDPostgresql;

public class Banco {

	public static void sumarDineroJugador (Jugador jugador, Integer cantidad) {
		jugador.setEfectivo(jugador.getEfectivo() + cantidad);
		JugadorODB odb = new JugadorOBDPostgresql();
		odb.updateEfectivo(jugador);
	}

	public static void restarDineroJugador (Jugador jugador, Integer cantidad) throws Exception {
		if (jugador.getEfectivo() < cantidad)
			throw new Exception("El jugador no tiene suficiente efectivo");
		
		JugadorODB odb = new JugadorOBDPostgresql();
		jugador.setEfectivo(jugador.getEfectivo() - cantidad);
		odb.updateEfectivo(jugador);
	}

	public static void sumarDineroclub (Club club, Integer cantidad) {
		club.setEfectivo(club.getEfectivo() + cantidad);
		ClubODB odb = new ClubODBPostgresql();
		odb.updateEfectivo(club);
	}

	public static void restarDineroclub (Club club, Integer cantidad) throws Exception {
		if (club.getEfectivo() < cantidad)
			throw new Exception("El club no tiene suficiente efectivo");
		
		club.setEfectivo(club.getEfectivo() + cantidad);
		ClubODB odb = new ClubODBPostgresql();
		odb.updateEfectivo(club);
	}

}