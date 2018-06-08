package com.caballero.futbolsa.test;

import java.util.List;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.negocios.Operador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public class OperadorTest {

	public static void colocarCompraTest(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		Operador.colocarOrdenDeCompra(jugador, club, cantidad, precio);
	}

	public static void colocarVentaTest(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		Operador.colocarOrdenDeCompra(jugador, club, cantidad, precio);
	}
	
	public static void getTodosLasOrdenesByJugadorTest(Jugador jugador) {
		List<Orden> ordenes = Operador.getOrdenesDeJugador(jugador);
		System.out.println("Lista de todos las ordenes:");
		for (Orden orden : ordenes)
			System.out.println(orden.getOrden_id()+"-"+orden.getJugador_id()+"-"+orden.getClub_id()+"-"+orden.getCantidad()+"- $"+orden.getPrecio());
		System.out.println("Fin de la lista:"+ordenes.size()+" ordenes");
	}
	
	public static void main(String[] args) {
		Jugador jugador = Identificador.getJugadorByNombre("Carlos");
		Club club = new Club(2, "Boca");
		colocarCompraTest(jugador, club, 50, 10);
		colocarVentaTest(jugador, club, 100, 5);
		getTodosLasOrdenesByJugadorTest(jugador);
	}

}