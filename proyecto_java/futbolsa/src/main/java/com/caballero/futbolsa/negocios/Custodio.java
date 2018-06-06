package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.CustodioODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;
import com.caballero.futbolsa.persistencia.postgresql.CustodioODBPostgresql;

public class Custodio {

	public static List<Posesion> getPosesionesDeJugador(Jugador jugador) {
		CustodioODB odb = new CustodioODBPostgresql();
		return odb.selectPosesionByJugador(jugador);
	}

	public static List<PosesionVO> getPosesionesVODeJugador(Jugador jugador) {
		CustodioODB odb = new CustodioODBPostgresql();
		return odb.selectPosesionVOByJugador(jugador);
	}
		
	// La cantidad se asigna de forma relativa (se suma o resta a lo ya existente)
	public static void asignarPosesionDeAccion(Jugador jugador, Club club, Integer cantidad) throws Exception {
		CustodioODB odb = new CustodioODBPostgresql();
		Posesion posesionActual = odb.selectPosesionByJugadorClub(jugador, club);
		
		if (posesionActual==null) {
			if (cantidad>0)
				odb.insertPosesion(new Posesion(jugador.getJugador_id(), club.getClub_id(), cantidad));
		} else {
			Integer cantidadActual = posesionActual.getCantidad();
			Integer cantidadNueva = cantidadActual + cantidad;
			if (cantidadNueva<0)
				throw new Exception("No se puede quitar mas acciones de ese club a ese jugador de las que ya tiene");
			
			if (cantidadNueva == 0)
				odb.deletePosesion(posesionActual);
			else {
				posesionActual.setCantidad(cantidadNueva);
				odb.updatePosesion(posesionActual);
			}
		}
	}
	
}