package com.caballero.futbolsa.test.persistencia;

import java.util.List;

import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.interfases.JugadorODB;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.postgresql.JugadorOBDPostgresql;

public class JugadorODBTest {

	public static void insertTest(String usuario, String password) {
		System.out.println("...Insert test: "+usuario+" iniciando");
		Jugador jugador = new Jugador(-1, 0, 0, usuario, password, "", "", false);
		JugadorODB odb = new JugadorOBDPostgresql();
		odb.insert(jugador);
		System.out.println("...Insert test: "+usuario+" finalizado");
	}

	public static void updateEfectivoTest(Jugador jugador) {
		System.out.println("...Update efectivo test iniciando");
		System.out.println(jugador);
		JugadorODB odb = new JugadorOBDPostgresql();
		odb.updateEfectivo(jugador);
		System.out.println("...Update efectivo test finalizado");
	}

	public static void selectByUsuarioTest(String usuario) {
		System.out.println("...Select By Usuario test: "+usuario+" iniciando");
		JugadorODB odb = new JugadorOBDPostgresql();
		System.out.println(odb.selectByUsuario(usuario));
		System.out.println("...Select By Usuario test: "+usuario+" finalizado");
	}
	
	public static void selectByIDTest(Integer ID) {
		System.out.println("...Select By ID test: "+ID+" iniciando");
		JugadorODB odb = new JugadorOBDPostgresql();
		System.out.println(odb.selectByID(ID));
		System.out.println("...Select By ID test: "+ID+" finalizado");
	}
	
	public static void selectTest() {
		System.out.println("...Select test iniciando");
		JugadorODB odb = new JugadorOBDPostgresql();
		List<Jugador> jugadores = odb.select();

		for (Jugador jugador : jugadores)
			System.out.println(jugador);
		
		System.out.println("Cantidad de jugadores: "+jugadores.size());
		System.out.println("...Select test finalizado");
	}
		
	public static void main(String[] args) {
		String usuario = "Rosa1";
		insertTest(usuario, "123");
		//selectByUsuarioTest(usuario);
		//selectByIDTest(1);		
		//selectTest();
		Jugador jugador = Identificador.traerJugadorPorID(1);
		jugador.setEfectivo(500);
		updateEfectivoTest(jugador);
	}

}