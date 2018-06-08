package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public interface OperadorODB {

	public void insertOrden(Orden orden);
	
	public List<Orden> selectOrdenByJugador(Jugador jugador);

	public List<Orden> selectOrdenByJugadorByTipo(Jugador jugador, String tipo);
	
	public List<Orden> selectOrdenByClubByTipo(Club club, String tipo);
			
	public void deleteOrden(Orden orden);
	
}