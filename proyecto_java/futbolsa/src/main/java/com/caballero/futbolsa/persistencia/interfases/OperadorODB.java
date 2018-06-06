package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public interface OperadorODB {

	public void insertOrden(Orden orden);
	
	public List<Orden> selectOrdenByJugador(Jugador jugador);
		
}