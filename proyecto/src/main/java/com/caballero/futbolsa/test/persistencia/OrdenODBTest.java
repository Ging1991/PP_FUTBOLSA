package com.caballero.futbolsa.test.persistencia;

import java.util.List;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.interfases.OrdenODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;
import com.caballero.futbolsa.persistencia.postgresql.OrdenODBPostgresql;

public class OrdenODBTest {

	public static void insertTest(Orden orden) {
		System.out.println("...Insert test iniciando");
		System.out.println(orden);
		OrdenODB odb = new OrdenODBPostgresql();
		odb.insert(orden);
		System.out.println("...Insert test finalizado");
	}

	public static void deleteTest(Orden orden) {
		System.out.println("...Delete test iniciando");
		System.out.println(orden);
		OrdenODB odb = new OrdenODBPostgresql();
		odb.delete(orden);
		System.out.println("...Delete test finalizado");
	}

	public static void updateCantidadTest(Orden orden) {
		System.out.println("...Update cantidad test iniciando");
		System.out.println(orden);
		OrdenODB odb = new OrdenODBPostgresql();
		odb.updateCantidad(orden);
		System.out.println("...Update cantidad test finalizado");
	}
	
	public static void selectByJugadorTest(Jugador jugador) {
		System.out.println("...Select by jugador test iniciando");
		System.out.println(jugador);
		OrdenODB odb = new OrdenODBPostgresql();
		List<Orden> ordenes = odb.selectByJugador(jugador);
		for (Orden orden : ordenes)
			System.out.println(orden);
		System.out.println("Cantidad: "+ordenes.size()+"ordenes");
		System.out.println("...Select by jugador test finalizado");
	}
	
	public static void selectByJugadorTipoTest(Jugador jugador, String tipo) {
		System.out.println("...Select by jugador y tipo cantidad test iniciando");
		System.out.println(jugador);
		System.out.println(tipo);
		OrdenODB odb = new OrdenODBPostgresql();
		List<Orden> ordenes = odb.selectByJugadorTipo(jugador, tipo);
		for (Orden orden : ordenes)
			System.out.println(orden);
		System.out.println("Cantidad: "+ordenes.size()+"ordenes");
		System.out.println("...Select by jugador y tipo test finalizado");
	}
	
	public static void selectByClubTipoTest(Club club, String tipo) {
		System.out.println("...Select by club y tipo cantidad test iniciando");
		System.out.println(club);
		System.out.println(tipo);
		OrdenODB odb = new OrdenODBPostgresql();
		List<Orden> ordenes = odb.selectByClubTipo(club, tipo);
		for (Orden orden : ordenes)
			System.out.println(orden);
		System.out.println("Cantidad: "+ordenes.size()+"ordenes");
		System.out.println("...Select by club y tipo test finalizado");
	}
	
	
	public static void main(String[] args) {
		Jugador jugador = Identificador.traerJugadorPorID(1);
		//Club club = Administrador.traerClubPorID(1);
		Orden orden = new Orden(-1, 1, 1, 10, 10, "V", "A", false);
		insertTest(orden);
		//orden.setCantidad(99);
		//updateCantidadTest(orden);
		//deleteTest(orden);
		//selectByJugadorTest(jugador);
		selectByJugadorTipoTest(jugador, "V");
		//selectByClubTipoTest(club, "C");
		
	}

}