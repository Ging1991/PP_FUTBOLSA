package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.OrdenODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.postgresql.OrdenODBPostgresql;

public class Agente {

	public static void colocarOrdenDeVenta(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {

		// Chequeo si tiene suficientes acciones para realizar la venta
		Posesion posesion = Custodio.traerAccionesDeJugadorClub(jugador, club);
		if (posesion == null)
			throw new Exception("No tiene ninguna accion de "+club.getNombre()+" para vender");
		if (cantidad > posesion.getCantidad())
			throw new Exception("No tiene suficientes acciones de "+club.getNombre()+" para vender");
		
		// Cancelo con ordenes de compra existentes
		Orden venta = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), "V", cantidad, precio);
		OrdenODB odb = new OrdenODBPostgresql();
		List<Orden> ordenes = odb.selectByClubTipo(club, "C");

		for (Orden compra : ordenes) {
			if (compra.getPrecio() >= venta.getPrecio())
				venta = Operador.ejecutarVenta(venta, compra);
			if (venta == null)
				break;
		}
		
		// guardo la orden si quedo algo
		if (venta != null)
			odb.insert(venta);
	}

	public static void colocarOrdenDeCompra(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		OrdenODB odb = new OrdenODBPostgresql();
		
		// Chequeo si tiene suficiente dinero para prometer la compra
		Integer dinero = jugador.getDinero();
		List<Orden> ordenesJugador = traerOrdenesDeJugador(jugador);
		
		for (Orden orden : ordenesJugador)
			if (orden.getTipo().equals("C"))
				dinero = dinero - ( orden.getPrecio() * orden.getCantidad() );
		
		if (dinero < (cantidad * precio) )
			throw new Exception("No tiene suficientes fondos para hacer esta compra");
		
		// Cancelo con ordenes de venta existentes
		Orden compra = new Orden(-1, jugador.getJugador_id(), club.getClub_id(), "C", cantidad, precio);
		List<Orden> ordenes = odb.selectByClubTipo(club, "V");

		for (Orden venta : ordenes) {
			if (venta.getPrecio() <= compra.getPrecio())
				compra = Operador.ejecutarCompra(compra, venta);
			if (compra == null)
				break;
		}
				
		// guardo la orden si quedo algo
		if (compra != null)
			odb.insert(compra);
	}

	public static List<Orden> traerOrdenesDeJugador(Jugador jugador) {
		OrdenODB odb = new OrdenODBPostgresql();
		return odb.selectByJugador(jugador);		
	}
	
	public static void cancelarOrden(Orden orden) {
		OrdenODB odb = new OrdenODBPostgresql();
		odb.delete(orden);
	}
	
}