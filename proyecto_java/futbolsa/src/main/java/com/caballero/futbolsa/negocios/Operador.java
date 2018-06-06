package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.OperadorODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.postgresql.OperadorODBPostgresql;

public class Operador {

	public static void colocarOrdenDeCompra(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		Orden orden = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), "C", cantidad, precio);
		OperadorODB odb = new OperadorODBPostgresql();
		odb.insertOrden(orden);
	}

	public static void colocarOrdenDeVenta(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		Orden orden = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), "V", cantidad, precio);
		OperadorODB odb = new OperadorODBPostgresql();
		odb.insertOrden(orden);
	}

	public static List<Orden> getOrdenesDeJugador(Jugador jugador) {
		OperadorODB odb = new OperadorODBPostgresql();
		return odb.selectOrdenByJugador(jugador);		
	}
	
}