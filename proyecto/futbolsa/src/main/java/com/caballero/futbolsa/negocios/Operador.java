package com.caballero.futbolsa.negocios;

import com.caballero.futbolsa.persistencia.interfases.OrdenODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.postgresql.OrdenODBPostgresql;

public class Operador {
	
	public static Orden ejecutarVenta(Orden venta, Orden compra) throws Exception {
		Jugador comprador = Identificador.traerJugadorPorID(compra.getJugador_id());
		Jugador vendedor = Identificador.traerJugadorPorID(venta.getJugador_id());
		Club club = Administrador.traerClubPorID(venta.getClub_id());
		
		Integer precio = ( venta.getPrecio() + compra.getPrecio() )/2;
		Integer cantidad = venta.getCantidad();
		if (cantidad > compra.getCantidad())
			cantidad = compra.getCantidad();
		
		Banco.restarDineroJugador(comprador, cantidad * precio);
		Custodio.sumarAcciones(comprador, club, cantidad);
		
		Banco.sumarDineroJugador(vendedor, cantidad * precio);
		Custodio.restarAcciones(vendedor, club, cantidad);
		
		compra.setCantidad(compra.getCantidad() - cantidad);
		venta.setCantidad(venta.getCantidad() - cantidad);
		
		OrdenODB odb = new OrdenODBPostgresql();
		if (compra.getCantidad() == 0)
			odb.delete(compra);
		else
			odb.updateCantidad(compra);
		
		if (venta.getCantidad() == 0)
			return null;
		else
			return venta;
	}
	
	public static Orden ejecutarCompra(Orden compra, Orden venta) throws Exception {
		System.out.println("Ejecutando compra");
		Jugador comprador = Identificador.traerJugadorPorID(compra.getJugador_id());
		Jugador vendedor = Identificador.traerJugadorPorID(venta.getJugador_id());
		Club club = Administrador.traerClubPorID(venta.getClub_id());
		
		Integer precio = ( venta.getPrecio() + compra.getPrecio() )/2;
		Integer cantidad = venta.getCantidad();
		if (cantidad > compra.getCantidad())
			cantidad = compra.getCantidad();
		
		Banco.restarDineroJugador(comprador, cantidad * precio);
		Custodio.sumarAcciones(comprador, club, cantidad);
		
		Banco.sumarDineroJugador(vendedor, cantidad * precio);
		Custodio.restarAcciones(vendedor, club, cantidad);
		
		compra.setCantidad(compra.getCantidad() - cantidad);
		venta.setCantidad(venta.getCantidad() - cantidad);
		
		OrdenODB odb = new OrdenODBPostgresql();
		if (venta.getCantidad() == 0)
			odb.delete(venta);
		else
			odb.updateCantidad(venta);
		
		if (compra.getCantidad() == 0)
			return null;
		else
			return compra;
		}

}