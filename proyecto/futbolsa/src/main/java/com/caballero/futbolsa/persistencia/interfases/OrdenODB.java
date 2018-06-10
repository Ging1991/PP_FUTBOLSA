package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public interface OrdenODB {

	public void insert(Orden orden);
	
	public void delete(Orden orden);
	
	public void updateCantidad(Orden orden);
	
	public List<Orden> selectByJugador(Jugador jugador);

	public List<Orden> selectByJugadorTipo(Jugador jugador, String tipo);
	
	public List<Orden> selectByClubTipo(Club club, String tipo);
			
}