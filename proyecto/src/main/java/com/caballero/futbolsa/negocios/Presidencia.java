package com.caballero.futbolsa.negocios;

import java.util.List;

import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.interfases.PosesionODBVO;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.EmisionVO;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.PosesionODBVOPostgresql;

public class Presidencia {

	public static void emitirAcciones(Jugador presidente, Club club, Integer cantidad, Integer precio) throws Exception {
		if (!esPresidente(presidente, club))
			throw new Exception("El jugador "+presidente.getUsuario()+" no es el presidente del club "+club.getNombre());
		Agente.colocarOrdenEmision(club, cantidad, precio);
	}

	public static void absorverAcciones(Jugador presidente, Club club, Integer cantidad, Integer precio) throws Exception {
		if (!esPresidente(presidente, club))
			throw new Exception("El jugador "+presidente.getUsuario()+" no es el presidente del club "+club.getNombre());
		Agente.colocarOrdenAbsorcion(club, cantidad, precio);
	}
	
	public static boolean esPresidente(Jugador jugador, Club club) {
		return jugador.getJugador_id() == club.getPresidente();	
	}

	public static void definirDividendoDeVictoria(Jugador presidente, Club club, Integer cantidad) throws Exception {
		if (!esPresidente(presidente, club))
			throw new Exception("El jugador "+presidente.getUsuario()+" no es el presidente del club "+club.getNombre());
		if (cantidad<0)
			throw new Exception("Los dividendos nunca pueden ser negativos");
		
		club.setDiv_victoria(cantidad);
		ClubODB odb = new ClubODBPostgresql();
		odb.updateDivVictoria(club);
	}

	public static void definirDividendoDeEmpate(Jugador presidente, Club club, Integer cantidad) throws Exception {
		if (!esPresidente(presidente, club))
			throw new Exception("El jugador "+presidente.getUsuario()+" no es el presidente del club "+club.getNombre());
		if (cantidad<0)
			throw new Exception("Los dividendos nunca pueden ser negativos");
		
		club.setDiv_empate(cantidad);
		ClubODB odb = new ClubODBPostgresql();
		odb.updateDivEmpate(club);
	}

	public static void definirDividendoDeDerrota(Jugador presidente, Club club, Integer cantidad) throws Exception {
		if (!esPresidente(presidente, club))
			throw new Exception("El jugador "+presidente.getUsuario()+" no es el presidente del club "+club.getNombre());
		if (cantidad<0)
			throw new Exception("Los dividendos nunca pueden ser negativos");
		
		club.setDiv_derrota(cantidad);
		ClubODB odb = new ClubODBPostgresql();
		odb.updateDivDerrota(club);
	}
	
	public static List<Club> traerClubesDePresidente(Jugador presidente) {
		ClubODB odb = new ClubODBPostgresql();
		return odb.selectByPresidente(presidente);
	}
	
	public static EmisionVO traerEmision(Club club) {
		PosesionODBVO odbvo = new PosesionODBVOPostgresql();
		return odbvo.selectEmisionByClub(club);
	}
	
}