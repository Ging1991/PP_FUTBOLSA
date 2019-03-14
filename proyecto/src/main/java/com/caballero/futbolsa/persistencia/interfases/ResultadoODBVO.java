package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojosVo.ResultadoVO;

public interface ResultadoODBVO {
	
	public List<ResultadoVO> selectUltimos();

}
