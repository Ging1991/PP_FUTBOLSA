package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.NotificacionVO;

public interface NotificacionODBVO {

	public List<NotificacionVO> selectByJugador(Jugador jugador);
	
}