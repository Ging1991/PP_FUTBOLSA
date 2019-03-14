package com.caballero.futbolsa.test.negocios;

import java.util.List;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.negocios.Operador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Operacion;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public class OperadorTest {
	
	public static void guardarOperacionTest(Operacion operacion) {
		System.out.println("...Guardar operacion test iniciando");
		System.out.println(operacion);
		Operador.guardarOperacion(operacion);
		System.out.println("...Guardar operacion test finalizado");
	}

	public static void ejecucionPreliminarCompraTest(Orden compra) throws Exception {
		System.out.println("...Ejecucion preliminar de compra test iniciando");
		System.out.println(compra);
		System.out.println(Operador.ejecucionPreliminarDeCompra(compra));
		System.out.println("...Ejecucion preliminar de compra test finalizado");
	}

	public static void ejecucionPreliminarVentaTest(Orden venta) throws Exception {
		System.out.println("...Ejecucion preliminar de venta test iniciando");
		System.out.println(venta);
		System.out.println(Operador.ejecucionPreliminarDeVenta(venta));
		System.out.println("...Ejecucion preliminar de venta test finalizado");
	}
	
	public static void traerOperacionesDeJugadorTest(Jugador jugador) throws Exception {
		System.out.println("...Traer operaciones de jugador test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario());
		List<Operacion> operaciones = Operador.traerOperacionesDeJugador(jugador);
		for (Operacion operacion : operaciones)
			System.out.println(operacion);
		System.out.println("Cantidad: "+operaciones.size()+" operaciones");
		System.out.println("...Traer operaciones de jugador test finalizando");
	}
	
	public static void main(String[] args) {
		try {
			Jugador jugador = Identificador.traerJugadorPorID(1);
			Integer comprador = 4;
			Integer vendedor = 4;
			Integer club = 1;
			Integer cantidad = 1;
			Integer precio = 1;
			String tipo = "C";
			String estado = "A";
			boolean emision = false;
					
			Operacion operacion = new Operacion(vendedor, comprador, club, cantidad, precio, emision);
			guardarOperacionTest(operacion);
			
			Orden compra = new Orden(-1, comprador, club, cantidad, precio, tipo, estado, emision);
			ejecucionPreliminarCompraTest(compra);
			
			Orden venta = new Orden(-1, vendedor, club, cantidad, precio, tipo, estado, emision);
			ejecucionPreliminarVentaTest(venta);
			
			traerOperacionesDeJugadorTest(jugador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}

}