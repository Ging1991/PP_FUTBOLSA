package com.caballero.futbolsa.test.negocios;

import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.negocios.Presidencia;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class PresidenciaTest {
	
	public static void esPresidenteTest(Jugador jugador, Club club) throws Exception {
		System.out.println("...Es presidente test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario()+", Club: "+club.getNombre());
		System.out.println("Es presidente:"+Presidencia.esPresidente(jugador, club));
		System.out.println("...Es presidente test finalizado");
	}
	
	public static void emitirAccionesTest(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		System.out.println("...Emitir acciones test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario()+", Club: "+club.getNombre());
		Presidencia.emitirAcciones(jugador, club, cantidad, precio);
		System.out.println("...Emitir acciones test finalizado");
	}
	
	public static void absorverAccionesTest(Jugador jugador, Club club, Integer cantidad, Integer precio) throws Exception {
		System.out.println("...Absorver acciones test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario()+", Club: "+club.getNombre());
		Presidencia.absorverAcciones(jugador, club, cantidad, precio);
		System.out.println("...Absorver acciones test finalizado");
	}
	
	public static void definirDividendoVictoriaTest(Jugador jugador, Club club, Integer cantidad) throws Exception {
		System.out.println("...Definir dividendo de victoria test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario()+", Club: "+club.getNombre()+", Precio: $"+cantidad);
		Presidencia.definirDividendoDeVictoria(jugador, club, cantidad);
		System.out.println("...Definir dividendo de victoria test finalizado");
	}
	
	public static void definirDividendoEmpateTest(Jugador jugador, Club club, Integer cantidad) throws Exception {
		System.out.println("...Definir dividendo de empate test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario()+", Club: "+club.getNombre()+", Precio: $"+cantidad);
		Presidencia.definirDividendoDeEmpate(jugador, club, cantidad);
		System.out.println("...Definir dividendo de empate test finalizado");
	}
	
	public static void definirDividendoDerrotaTest(Jugador jugador, Club club, Integer cantidad) throws Exception {
		System.out.println("...Definir dividendo de derrota test iniciando");
		System.out.println("Jugador: "+jugador.getUsuario()+", Club: "+club.getNombre()+", Precio: $"+cantidad);
		Presidencia.definirDividendoDeDerrota(jugador, club, cantidad);
		System.out.println("...Definir dividendo de derrota test finalizado");
	}
	
	public static void main(String[] args) {
		try {
			Jugador jugador = Identificador.traerJugadorPorID(3);
			Club club = Administrador.traerClubPorID(1);
			//Integer cantidad = 1;
			Integer precio = 60;
			//esPresidenteTest(jugador, club);
			//emitirAccionesTest(jugador, club, cantidad, precio);
			//absorverAccionesTest(jugador, club, cantidad, precio);
			//definirDividendoVictoriaTest(jugador, club, precio);
			//definirDividendoEmpateTest(jugador, club, precio);
			definirDividendoDerrotaTest(jugador, club, precio);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}