package com.caballero.futbolsa.test;

import java.util.List;

import com.caballero.futbolsa.negocios.Agente;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public class AgenteTest {
	
	public static void colocarVentaTest(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		try {
			Agente.colocarOrdenDeVenta(jugador, club, cantidad, precio);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void colocarCompraTest(Jugador jugador, Club club, Integer cantidad, Integer precio) {
		try {
			Agente.colocarOrdenDeCompra(jugador, club, cantidad, precio);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void traerOrdenesDeJugadorTest(Jugador jugador) {
		List<Orden> ordenes = Agente.traerOrdenesDeJugador(jugador);
		System.out.println("Lista de ordenes de :"+jugador.getUsuario());
		for (Orden orden : ordenes)
			System.out.println(orden.getOrden_id()+"-"+orden.getJugador_id()+"-"+orden.getClub_id()+"- "+orden.getTipo()+" -"+orden.getCantidad()+"- $"+orden.getPrecio());
		System.out.println("Fin de la lista:"+ordenes.size()+" ordenes");
	}

	public static void main(String[] args) {
		Jugador jugador1 = Identificador.traerJugadorPorID(1);
		Jugador jugador2 = Identificador.traerJugadorPorID(2);
		Club club = new Club(1, "Boca");
		
		//colocarVentaTest(jugador1, club, 50, 10);
		colocarCompraTest(jugador2, club, 25, 10);
		traerOrdenesDeJugadorTest(jugador1);
		traerOrdenesDeJugadorTest(jugador2);
		
	
	}

}