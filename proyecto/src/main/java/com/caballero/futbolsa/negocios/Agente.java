package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.OrdenODB;
import com.caballero.futbolsa.persistencia.interfases.OrdenODBVO;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojosVo.OrdenVO;
import com.caballero.futbolsa.persistencia.postgresql.OrdenODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.OrdenODBVOPostgresql;

public class Agente {

	public static void colocarOrdenDeVenta(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {

		// Chequeo si tiene suficientes acciones para realizar la venta
		Posesion posesion = Custodio.traerAccionesDeJugadorClub(jugador, club);
		if (posesion == null)
			throw new Exception("No tiene ninguna accion de "+club.getNombre()+" para vender");
		if (cantidad > posesion.getCantidad())
			throw new Exception("No tiene suficientes acciones de "+club.getNombre()+" para vender");
		
		// Cancelo con ordenes de compra existentes
		Orden venta = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), cantidad, precio, "V", "A", false);
		venta = Operador.ejecucionPreliminarDeVenta(venta);
		
		// Si quedo algo la guardo
		OrdenODB odb = new OrdenODBPostgresql();
		if (venta != null)
			odb.insert(venta);
	}

	public static void colocarOrdenDeCompra(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		// Chequeo si tiene suficiente dinero para prometer la compra
		Integer dinero = jugador.getEfectivo();
		List<Orden> ordenesJugador = traerOrdenesActivasDeJugador(jugador);
		
		for (Orden orden : ordenesJugador)
			if (orden.getTipo().equals("C"))
				dinero = dinero - ( orden.getPrecio() * orden.getCantidad() );
		
		if (dinero < (cantidad * precio) )
			throw new Exception("No tiene suficientes fondos para hacer esta compra");
		
		// Cancelo con ordenes de venta existentes
		Orden compra = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), cantidad, precio, "C", "A", false);
		compra = Operador.ejecucionPreliminarDeCompra(compra);
		
		OrdenODB odb = new OrdenODBPostgresql();
		if (compra != null)
			odb.insert(compra);
	}

	public static List<Orden> traerOrdenesActivasDeJugador(Jugador jugador) {
		OrdenODB odb = new OrdenODBPostgresql();
		return odb.selectByJugador(jugador);		
	}
	
	public static List<OrdenVO> traerOrdenesVOActivasDeJugador(Jugador jugador) {
		OrdenODBVO odbvo = new OrdenODBVOPostgresql();
		return odbvo.selectByJugador(jugador);		
	}
	
	public static List<OrdenVO> traerOrdenesVOActivasDeClub(Club club) {
		OrdenODBVO odbvo = new OrdenODBVOPostgresql();
		return odbvo.selectByClubEmision(club);
	}
		
	public static void cancelarOrden(OrdenVO orden) {
		Orden orden2 = new Orden(orden.getOrden_id(), 1, 1, 1, 1, "", "", true);
		OrdenODB odb = new OrdenODBPostgresql();
		odb.delete(orden2);
	}
	
	public static void colocarOrdenEmision(Club club, Integer cantidad, Integer precio) throws Exception {
		// Cancelo con ordenes de compra existentes
		Orden venta = new Orden(-1, 1, club.getClub_id(), cantidad, precio, "V", "A", true);
		venta = Operador.ejecucionPreliminarDeVenta(venta);
		
		// Si quedo algo la guardo
		OrdenODB odb = new OrdenODBPostgresql();
		if (venta != null)
			odb.insert(venta);
	}

	public static void colocarOrdenAbsorcion(Club club, Integer cantidad, Integer precio) throws Exception {
		// Cancelo con ordenes de compra existentes
		Orden compra = new Orden(-1, 1, club.getClub_id(), cantidad, precio, "C", "A", true);
		compra = Operador.ejecucionPreliminarDeCompra(compra);
		
		// Si quedo algo la guardo
		OrdenODB odb = new OrdenODBPostgresql();
		if (compra != null)
			odb.insert(compra);
	}

}