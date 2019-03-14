package com.caballero.futbolsa.test.negocios;

import java.util.List;

import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Agente;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public class AgenteTest {
	
	public static void colocarVentaTest(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		System.out.println("...Colocar venta test inicializando");
		System.out.println("Jugador: "+jugador.getUsuario()+", club: "+club.getNombre());
		Agente.colocarOrdenDeVenta(jugador, club, cantidad, precio);
		System.out.println("...Colocar venta test finalizando");
	}
	
	public static void colocarCompraTest(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		System.out.println("...Colocar compra test inicializando");
		System.out.println("Jugador: "+jugador.getUsuario()+", club: "+club.getNombre());
		Agente.colocarOrdenDeCompra(jugador, club, cantidad, precio);
		System.out.println("...Colocar compra test finalizando");
	}
	
	public static void colocarEmisionTest(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		System.out.println("...Colocar emision test inicializando");
		System.out.println("Jugador: "+jugador.getUsuario()+", club: "+club.getNombre());
		Agente.colocarOrdenEmision(club, cantidad, precio);
		System.out.println("...Colocar emision test finalizando");
	}
	
	public static void colocarAbsorcionTest(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		System.out.println("...Colocar absorcion test inicializando");
		System.out.println("Jugador: "+jugador.getUsuario()+", club: "+club.getNombre());
		Agente.colocarOrdenAbsorcion(club, cantidad, precio);
		System.out.println("...Colocar absorcion test finalizando");
	}
	
	public static void traerOrdenesDeJugadorTest(Jugador jugador) {
		System.out.println("...Traer ordenes de jugador test inicializando");
		System.out.println("Jugador: "+jugador.getUsuario());
		List<Orden> ordenes = Agente.traerOrdenesActivasDeJugador(jugador);
		for (Orden orden : ordenes)
			System.out.println(orden);
		System.out.println("Cantidad:"+ordenes.size()+" ordenes");
		System.out.println("...Traer ordenes de jugador test finalizando");
	}

	public static void main(String[] args) {
		try {
			Jugador carlos = Identificador.traerJugadorPorID(1);
			Jugador jorge = Identificador.traerJugadorPorID(3);
			Club velez = Administrador.traerClubPorID(1);
			Integer cantidad = 1;
			Integer precio = 1;
			
			colocarEmisionTest(carlos, velez, cantidad, precio);
			colocarAbsorcionTest(jorge, velez, cantidad, precio);
			
			//colocarCompraTest(jorge, velez, cantidad, precio);
			//colocarVentaTest(jorge, velez, cantidad, precio);
			//traerOrdenesDeJugadorTest(jugador2);
			//CustodioTest.traerAccionesVODeJugadorTest(jugador2);
			
			//colocarVentaTest(jugador1, club, 50, 10);
			//traerOrdenesDeJugadorTest(jugador1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}