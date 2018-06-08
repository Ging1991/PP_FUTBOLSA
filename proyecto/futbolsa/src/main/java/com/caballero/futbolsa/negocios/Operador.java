package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.OperadorODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.postgresql.OperadorODBPostgresql;

public class Operador {

	public static void colocarOrdenDeCompra(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		Orden orden = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), "C", cantidad, precio);
		OperadorODB odb = new OperadorODBPostgresql();
		odb.insertOrden(orden);
	}

	public static void colocarOrdenDeVenta(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		// Chequeo si tiene suficientes acciones para realizar la venta
		Posesion posesion = Custodio.getPosesionDeJugadorDeClub(jugador, club);
		if (posesion == null)
			throw new Exception("No tiene ninguna accion de "+club.getNombre()+" para vender");
		if (cantidad > posesion.getCantidad())
			throw new Exception("No tiene suficientes acciones de "+club.getNombre()+" para vender");
		
		// Cancelo con ordenes de compra existentes
		Orden venta = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), "V", cantidad, precio);
		OperadorODB odb = new OperadorODBPostgresql();
		List<Orden> ordenes = odb.selectOrdenByClubByTipo(club, "C");

		for (Orden compra : ordenes)
			if (compra.getPrecio() >= precio)
				venta = vender(venta, compra);
		
		// guardo la orden si quedo algo
		if (venta != null)
			odb.insertOrden(venta);
	}

	public static List<Orden> getOrdenesDeJugador(Jugador jugador) {
		OperadorODB odb = new OperadorODBPostgresql();
		return odb.selectOrdenByJugador(jugador);		
	}
	
	public static void cancelarOrden(Orden orden) {
		OperadorODB odb = new OperadorODBPostgresql();
		odb.deleteOrden(orden);
	}

	// devuelve lo que queda de la orden si es que queda algo
	public static Orden vender(Orden venta, Orden compra) {
		if (venta == null)
			return null;
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
}