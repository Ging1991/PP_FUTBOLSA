package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.PosesionODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Noticia;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.postgresql.PosesionODBPostgresql;

public class PagadorResultado {
	private static Integer recompensaVictoria = 3000;
	private static Integer recompensaEmpate = 1000;
	private static Integer recompensaDerrota = 0;

	public static void manejarVictoria(Club club) throws Exception{
		String contenido = club.getNombre()+" gana su partido, por ello ha recibido $"+recompensaVictoria;
		contenido += ", pagará a sus accionistas $"+club.getDiv_victoria()+" por cada accion";
		pagarDividendos(club, recompensaVictoria, club.getDiv_victoria(), contenido);		
	}

	public static void manejarEmpate(Club club) throws Exception{
		String contenido = club.getNombre()+" empata su partido, por ello ha recibido $"+recompensaEmpate;
		contenido += ", pagará a sus accionistas $"+club.getDiv_empate()+" por cada accion";
		pagarDividendos(club, recompensaEmpate, club.getDiv_empate(), contenido);		
	}
	
	public static void manejarDerrota(Club club) throws Exception{
		String contenido = club.getNombre()+" pierde su partido, por ello ha recibido $"+recompensaDerrota;
		contenido += ", pagará a sus accionistas $"+club.getDiv_derrota()+" por cada accion";
		pagarDividendos(club, recompensaDerrota, club.getDiv_derrota(), contenido);
	}
	
	private static void pagarDividendos(Club club, Integer recompensa, Integer dividendo, String anuncio) throws Exception{
		Banco.sumarDineroclub(club, recompensa);

		PosesionODB odb = new PosesionODBPostgresql();
		List<Posesion> posesiones = odb.selectByClub(club);		
		for (Posesion posesion : posesiones) {
			Jugador jugador = Identificador.traerJugadorPorID(posesion.getJugador_id());
			Banco.restarDineroclub(club, dividendo*posesion.getCantidad());
			Banco.sumarDineroJugador(jugador, dividendo*posesion.getCantidad());	
		}
		
		Noticia noticia = Notificador.guardarNoticia(anuncio);
		Notificador.notificarAccionistas(club, noticia);
	}

}