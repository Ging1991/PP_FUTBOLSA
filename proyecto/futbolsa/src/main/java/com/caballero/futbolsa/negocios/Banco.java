package com.caballero.futbolsa.negocios;

import com.caballero.futbolsa.persistencia.interfases.JugadorODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.postgresql.JugadorOBDPostgresql;

public class Banco {

	public static void sumarDineroJugador (Jugador jugador, Integer cantidad) {
		jugador.setDinero(jugador.getDinero() + cantidad);
		JugadorODB odb = new JugadorOBDPostgresql();
		odb.updateDinero(jugador);
	}

	public static void restarDineroJugador (Jugador jugador, Integer cantidad) throws Exception {
		if (jugador.getDinero() < cantidad)
			throw new Exception("El jugador no tiene suficiente dinero");
		
		JugadorODB odb = new JugadorOBDPostgresql();
		jugador.setDinero(jugador.getDinero() - cantidad);
		odb.updateDinero(jugador);
	}

	public static void sumarDineroclub (Club club, Integer cantidad) {
		
	}

	public static void restarDineroclub (Club club, Integer cantidad) {
		
	}

}