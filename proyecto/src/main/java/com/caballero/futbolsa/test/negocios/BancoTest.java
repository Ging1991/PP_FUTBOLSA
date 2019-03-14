package com.caballero.futbolsa.test.negocios;

import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Banco;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class BancoTest {
	
	public static void sumarDineroJugadorTest(Jugador jugador, Integer cantidad) {
		System.out.println("...Sumar dinero jugador test iniciando");
		System.out.println(jugador);
		Banco.sumarDineroJugador(jugador, cantidad);
		System.out.println("...Sumar dinero jugador test finalizado");
	}
	
	public static void sumarDineroClubTest(Club club, Integer cantidad) {
		System.out.println("...Sumar dinero club test iniciando");
		System.out.println(club);
		Banco.sumarDineroclub(club, cantidad);
		System.out.println("...Sumar dinero club test finalizado");
	}
		
	public static void restarDineroJugadorTest(Jugador jugador, Integer cantidad) throws Exception {
		System.out.println("...Restar dinero jugador test iniciando");
		System.out.println(jugador);
		Banco.restarDineroJugador(jugador, cantidad);
		System.out.println("...Sumar dinero jugador test finalizado");
	}
	
	public static void restarDineroClubTest(Club club, Integer cantidad) throws Exception {
		System.out.println("...Restar dinero club jugador test iniciando");
		System.out.println(club);
		Banco.restarDineroclub(club, cantidad);
		System.out.println("...Sumar dinero jugador club test finalizado");
	}
	
	public static void main(String[] args) {
		try {
			Jugador jugador = Identificador.traerJugadorPorID(1);
			sumarDineroJugadorTest(jugador, 100);
			restarDineroJugadorTest(jugador, 150);

			Club club = Administrador.traerClubPorID(1);		
			sumarDineroClubTest(club, 500);
			restarDineroClubTest(club, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}