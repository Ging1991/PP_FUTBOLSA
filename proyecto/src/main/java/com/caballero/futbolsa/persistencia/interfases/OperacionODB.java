package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Operacion;

public interface OperacionODB {

	public void insert (Operacion operacion);;
	
	public List<Operacion> selectByJugador (Jugador jugador);
	
}