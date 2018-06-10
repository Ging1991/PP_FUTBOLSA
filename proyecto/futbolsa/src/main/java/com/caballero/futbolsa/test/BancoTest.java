package com.caballero.futbolsa.test;

import com.caballero.futbolsa.negocios.Banco;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class BancoTest {
	
	public static void sumarDineroTest(Jugador jugador, Integer cantidad) {
		Banco.sumarDineroJugador(jugador, cantidad);
	}
	
	public static void restarDineroTest(Jugador jugador, Integer cantidad) {
		try {
			Banco.restarDineroJugador(jugador, cantidad);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Jugador jugador = Identificador.traerJugadorPorID(1);
		sumarDineroTest(jugador, 100);
		System.out.println(jugador.getDinero());
		System.out.println(Identificador.traerJugadorPorID(1).getDinero());
		restarDineroTest(jugador, 25);
		System.out.println(jugador.getDinero());
		System.out.println(Identificador.traerJugadorPorID(1).getDinero());
	}

}