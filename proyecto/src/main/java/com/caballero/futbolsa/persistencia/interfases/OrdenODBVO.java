package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.OrdenVO;

public interface OrdenODBVO {
	
	public List<OrdenVO> selectByJugador(Jugador jugador);

	public List<OrdenVO> selectByClubEmision(Club club);
	
}