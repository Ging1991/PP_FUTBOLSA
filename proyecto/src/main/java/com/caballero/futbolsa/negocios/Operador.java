package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.OperacionODB;
import com.caballero.futbolsa.persistencia.interfases.OrdenODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Operacion;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.postgresql.OperacionODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.OrdenODBPostgresql;

public class Operador {

	public static List<Operacion> traerOperacionesDeJugador(Jugador jugador) {
		OperacionODB odb = new OperacionODBPostgresql();
		return odb.selectByJugador(jugador);
	}

	public static void guardarOperacion(Operacion operacion) {
		OperacionODB odb = new OperacionODBPostgresql();
		odb.insert(operacion);
		Club club = Administrador.traerClubPorID(operacion.getClub());
		Cotizador.actualizarCotizacion(club, operacion);
	}
	
	public static Orden ejecucionPreliminarDeVenta(Orden venta) throws Exception {
		Club club = Administrador.traerClubPorID(venta.getClub_id());
		OrdenODB odb = new OrdenODBPostgresql();
		List<Orden> compras = odb.selectByClubTipo(club, "C");
		
		for (Orden compra : compras) {
			venta = operarVenta(venta, compra);
			if (venta == null)
				break;
		}
		
		return venta;
	}

	public static Orden ejecucionPreliminarDeCompra(Orden compra) throws Exception {
		Club club = Administrador.traerClubPorID(compra.getClub_id());
		OrdenODB odb = new OrdenODBPostgresql();
		List<Orden> ventas = odb.selectByClubTipo(club, "V");
		
		for (Orden venta : ventas) {
			compra = operarCompra(compra, venta);
			if (compra == null)
				break;
		}
		
		return compra;
	}

	// La venta aun no esto en BD pero la compra si lo esta
	// ambas ordenes versan sobre el mismo club
	private static Orden operarVenta(Orden venta, Orden compra) throws Exception {
		if (!esPrecioCompatible(compra, venta))
			return venta;
		
		Integer cantidad = getCantidadJusta(compra, venta);
		Integer precioUnitario = getPrecioUnitario(compra, venta);
		Integer precio = cantidad * precioUnitario;
		Jugador jugadorComprador = Identificador.traerJugadorPorID(compra.getJugador_id());
		Jugador jugadorVendedor = Identificador.traerJugadorPorID(venta.getJugador_id());
		Club club = Administrador.traerClubPorID(compra.getClub_id());
		
		// Le doy el dinero al vendedor
		if (venta.isEsEmision())
			Banco.sumarDineroclub(club, precio);
		else
			Banco.sumarDineroJugador(jugadorVendedor, precio);	
		
		// Le quito dinero al comprador
		if (compra.isEsEmision())
			Banco.restarDineroclub(club, precio);
		else
			Banco.restarDineroJugador(jugadorComprador, precio);
		
		// Resto acciones al vendedor
		if (!venta.isEsEmision())
			Custodio.restarAcciones(jugadorVendedor, club, cantidad);
		
		// Sumo acciones al comprador
		if (!compra.isEsEmision())
			Custodio.sumarAcciones(jugadorComprador, club, cantidad);
		
		// Actualizo la compra en BD
		compra.setCantidad(compra.getCantidad() - cantidad);
		actualizarCantidadDeOrden(compra);
		
		// Guardo la operacion realizada
		guardarOperacionActual(compra, venta, cantidad, precioUnitario);
		
		// Devuelvo la venta
		venta.setCantidad(venta.getCantidad() - cantidad);
		if (venta.getCantidad() == 0)
			return null;
		else
			return venta;

	}
		
	// La compra aun no esta en BD pero la venta si lo esta
	// Compra y Venta versan sobre el mismo club
	private static Orden operarCompra(Orden compra, Orden venta) throws Exception {
		if (!esPrecioCompatible(compra, venta))
			return compra;
		
		Integer cantidad = getCantidadJusta(compra, venta);
		Integer precioUnitario = getPrecioUnitario(compra, venta);
		Integer precio = cantidad * precioUnitario;
		Jugador jugadorComprador = Identificador.traerJugadorPorID(compra.getJugador_id());
		Jugador jugadorVendedor = Identificador.traerJugadorPorID(venta.getJugador_id());
		Club club = Administrador.traerClubPorID(compra.getClub_id());
		
		// Le doy el dinero al vendedor
		if (venta.isEsEmision())
			Banco.sumarDineroclub(club, precio);
		else
			Banco.sumarDineroJugador(jugadorVendedor, precio);	
		
		// Le quito dinero al comprador
		if (compra.isEsEmision())
			Banco.restarDineroclub(club, precio);
		else
			Banco.restarDineroJugador(jugadorComprador, precio);
		
		// Resto acciones al vendedor
		if (!venta.isEsEmision())
			Custodio.restarAcciones(jugadorVendedor, club, cantidad);
		
		// Sumo acciones al comprador
		if (!compra.isEsEmision())
			Custodio.sumarAcciones(jugadorComprador, club, cantidad);
		
		// Actualizo la venta en BD
		venta.setCantidad(venta.getCantidad() - cantidad);
		actualizarCantidadDeOrden(venta);
		
		// Guardo la operacion realizada
		guardarOperacionActual(compra, venta, cantidad, precioUnitario);
		
		// Devuelvo la compra
		compra.setCantidad(compra.getCantidad() - cantidad);
		if (compra.getCantidad() == 0)
			return null;
		else
			return compra;
	}

	private static void actualizarCantidadDeOrden(Orden orden) {
		OrdenODB odb = new OrdenODBPostgresql();
		if (orden.getCantidad() == 0)
			odb.delete(orden);
		else
			odb.updateCantidad(orden);
	}
	
	private static boolean esPrecioCompatible(Orden compra, Orden venta) {
		Integer precioCompra = compra.getPrecio();
		Integer precioVenta = venta.getPrecio();
		return (precioCompra >= precioVenta);
	}
	
	private static Integer getPrecioUnitario(Orden compra, Orden venta) {
		Integer precioCompra = compra.getPrecio();
		Integer precioVenta = venta.getPrecio();
		return (precioCompra + precioVenta)/2;
	}
		
	private static Integer getCantidadJusta(Orden compra, Orden venta) {
		Integer cantidad = venta.getCantidad();
		if (cantidad > compra.getCantidad())
			cantidad = compra.getCantidad();
		return cantidad;
	}	
	
	private static void guardarOperacionActual(Orden compra, Orden venta, Integer cantidad, Integer precio) {
		boolean emision = compra.isEsEmision() || venta.isEsEmision();
		Integer club = compra.getClub_id();
		Integer vendedor = venta.getJugador_id();
		if (venta.isEsEmision())
			vendedor = 1;
		Integer comprador = compra.getJugador_id();
		if (compra.isEsEmision())
			comprador = 1;
		Operacion operacion = new Operacion(vendedor, comprador, club, cantidad, precio, emision);
		guardarOperacion(operacion);
	}	
	
}