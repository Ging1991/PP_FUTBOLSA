package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.NoticiaODB;
import com.caballero.futbolsa.persistencia.interfases.NotificacionODB;
import com.caballero.futbolsa.persistencia.interfases.NotificacionODBVO;
import com.caballero.futbolsa.persistencia.interfases.PosesionODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Noticia;
import com.caballero.futbolsa.persistencia.pojos.Notificacion;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojosVo.NotificacionVO;
import com.caballero.futbolsa.persistencia.postgresql.NoticiaODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.NotificacionODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.NotificacionODBVOPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.PosesionODBPostgresql;

public class Notificador {

	public static Noticia guardarNoticia(String contenido) throws Exception {
		NoticiaODB odb = new NoticiaODBPostgresql();
		Noticia noticia = new Noticia(-1, contenido, null);
		Integer noticia_id = odb.insert(noticia);
		noticia = odb.selectByID(noticia_id);
		return noticia;
	}
	
	public static List<NotificacionVO> traerNotificaciones(Jugador jugador) {
		NotificacionODBVO odbvo = new NotificacionODBVOPostgresql();
		return odbvo.selectByJugador(jugador);		
	}
	
	public static void eliminarNotificacion(Notificacion notificacion) {
		NotificacionODB odb = new NotificacionODBPostgresql();
		odb.delete(notificacion);
	}
	
	public static void notificarAccionistas(Club club, Noticia noticia) {
		PosesionODB odb = new PosesionODBPostgresql();
		List<Posesion> posesiones = odb.selectByClub(club);
	
		for (Posesion posesion : posesiones)
			notificarJugador(posesion.getJugador_id(), noticia);
	}
	
	private static void notificarJugador(Integer jugador_id, Noticia noticia) {
		NotificacionODB odb = new NotificacionODBPostgresql();
		Notificacion notificacion = new Notificacion(-1, jugador_id, noticia.getNoticia_id());
		odb.insert(notificacion);
	}

}