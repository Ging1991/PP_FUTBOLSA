package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;

public interface CustodioODB {
	
	public void insertPosesion(Posesion posesion);
	
	public void deletePosesion(Posesion posesion);
	
	public void updatePosesion(Posesion posesion);
	
	public List<Posesion> selectPosesionByJugador(Jugador jugador);
	
	public List<PosesionVO> selectPosesionVOByJugador(Jugador jugador);
	
	public Posesion selectPosesionByJugadorClub(Jugador jugador, Club club);

}