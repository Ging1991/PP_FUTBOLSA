package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;

public interface PosesionODB {
	
	public void insert(Posesion posesion);
	
	public void delete(Posesion posesion);
	
	public void updateCantidad(Posesion posesion);
	
	public List<Posesion> selectByJugador(Jugador jugador);
	
	public List<Posesion> selectByClub(Club club);
	
	public Posesion selectByJugadorClub(Jugador jugador, Club club) throws Exception;
	
}