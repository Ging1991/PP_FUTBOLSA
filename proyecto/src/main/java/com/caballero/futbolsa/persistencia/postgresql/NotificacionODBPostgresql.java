package com.caballero.futbolsa.persistencia.postgresql;

import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.NotificacionODB;
import com.caballero.futbolsa.persistencia.pojos.Notificacion;

public class NotificacionODBPostgresql extends ODB implements NotificacionODB{
	private String tabla = "fut_notificaciones";
	
	@Override
	public void insert(Notificacion notificacion) {
		String parametros = "noticia_id, jugador_id";
		String valores = notificacion.getNoticia_id()+", "+notificacion.getJugador_id(); 
		String consulta = "insert into "+tabla+" ("+parametros+") values ("+valores+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Notificacion notificacion) {
		String consulta = "delete from "+tabla+" where notificacion_id = "+notificacion.getNotificacion_id();	
		ejecutarSQL(consulta);
	}

}