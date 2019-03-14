package com.caballero.futbolsa.persistencia.interfases;

import com.caballero.futbolsa.persistencia.pojos.Notificacion;

public interface NotificacionODB {

	public void insert(Notificacion notificacion);
	
	public void delete(Notificacion notificacion);
	
}