package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.PosesionODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;
import com.caballero.futbolsa.persistencia.postgresql.PosesionODBPostgresql;

public class Custodio {
	
	public static void sumarAcciones(Jugador jugador, Club club, Integer cantidad) {
		PosesionODB odb = new PosesionODBPostgresql();
		Posesion posesion = odb.selectByJugadorClub(jugador, club);
		
		if (posesion == null)
			odb.insert(new Posesion(jugador.getJugador_id(), club.getClub_id(), cantidad));
		else {
			Integer actual = posesion.getCantidad();
			posesion.setCantidad(actual + cantidad);
			odb.updateCantidad(posesion);
		}
	}
	
	public static void restarAcciones(Jugador jugador, Club club, Integer cantidad) throws Exception {
		PosesionODB odb = new PosesionODBPostgresql();
		Posesion posesion = odb.selectByJugadorClub(jugador, club);
		
		if (posesion == null)
			throw new Exception("El jugador no tiene ninguna accion de "+club.getNombre());
			
		if (posesion.getCantidad() < cantidad)
			throw new Exception("El jugador no tiene suficientes acciones de "+club.getNombre()+", solo tiene "+posesion.getCantidad());
			
		if (posesion.getCantidad() == cantidad)
			odb.delete(posesion);
		else {
			posesion.setCantidad(posesion.getCantidad() - cantidad);
			odb.updateCantidad(posesion);
		}
	}
	
	public static List<Posesion> traerAccionesDeJugador(Jugador jugador) {
		PosesionODB odb = new PosesionODBPostgresql();
		return odb.selectByJugador(jugador);
	}

	public static List<PosesionVO> traerAccionesVODeJugador(Jugador jugador) {
		PosesionODB odb = new PosesionODBPostgresql();
		return odb.selectVOByJugador(jugador);
	}
		
	public static Posesion traerAccionesDeJugadorClub (Jugador jugador, Club club) {
		PosesionODB odb = new PosesionODBPostgresql();
		return odb.selectByJugadorClub(jugador, club);
	}
	
}