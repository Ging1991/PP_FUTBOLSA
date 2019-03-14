package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.EmisionVO;
import com.caballero.futbolsa.persistencia.pojosVo.PosesionVO;

public interface PosesionODBVO {
	
	public List<PosesionVO> selectByJugador(Jugador jugador);
	
	public EmisionVO selectEmisionByClub(Club club);

}
