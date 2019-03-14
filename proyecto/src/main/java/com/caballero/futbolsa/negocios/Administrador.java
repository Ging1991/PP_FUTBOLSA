package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.interfases.ClubODBVO;
import com.caballero.futbolsa.persistencia.interfases.JugadorODB;
import com.caballero.futbolsa.persistencia.interfases.ResultadoODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Resultado;
import com.caballero.futbolsa.persistencia.pojosVo.ClubVO;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBVOPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.JugadorOBDPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.ResultadoODBPostgresql;

public class Administrador {

	public static boolean nombreDeClubLibre(String nombre) {
		ClubODB odb = new ClubODBPostgresql();
		return odb.selectByNombre(nombre) == null;
	}
	
	public static void crearClub (String nombre) throws Exception {
		if (!nombreDeClubLibre(nombre))
			throw new Exception("Ya existe un club con el nombre: "+nombre);
		
		Club club = new Club(-1, nombre, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1);
		ClubODB odb = new ClubODBPostgresql();
		odb.insert(club);
	}
	
	public static List<Club> traerClubes() {
		ClubODB odb = new ClubODBPostgresql();
		return odb.select();
	}
	
	public static Club traerClubPorID(Integer id) {
		ClubODB odb = new ClubODBPostgresql();
		return odb.selectByID(id);	
	}

	public static void actualizarRankingJugadores() {
		JugadorODB odb = new JugadorOBDPostgresql();
		odb.actualizarPosiciones();
	}

	public static void actualizarRankingClubes() {
		ClubODB odb = new ClubODBPostgresql();
		odb.actualizarPosiciones();
	}
	
	public static List<Jugador> traerJugadoresByRanking() {
		JugadorODB odb = new JugadorOBDPostgresql();
		return odb.selectByRanking();
	}

	public static List<ClubVO> traerClubesByRanking() {
		ClubODBVO odbvo = new ClubODBVOPostgresql();
		return odbvo.selectByRanking();
	}
	
	public static void elegirPresidente(Club club) {
		ClubODB odb = new ClubODBPostgresql();
		odb.elegirPresidente(club);
	}
	
	public static void registrarResultado(Club local, Club visitante, Integer golesLocal, Integer golesVisitante) throws Exception{
		Resultado resultado = new Resultado(-1, local.getClub_id(), visitante.getClub_id(), golesLocal, golesVisitante);
		ResultadoODB odb = new ResultadoODBPostgresql();
		odb.insert(resultado);
		
		if (golesLocal == golesVisitante) {
			PagadorResultado.manejarEmpate(local);
			PagadorResultado.manejarEmpate(visitante);
		} else if (golesLocal > golesVisitante) {
			PagadorResultado.manejarVictoria(local);
			PagadorResultado.manejarDerrota(visitante);
		} else {
			PagadorResultado.manejarVictoria(visitante);
			PagadorResultado.manejarDerrota(local);
		}
	}

}