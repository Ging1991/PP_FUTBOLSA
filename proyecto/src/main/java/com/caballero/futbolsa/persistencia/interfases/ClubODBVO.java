package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;

import com.caballero.futbolsa.persistencia.pojosVo.ClubVO;

public interface ClubODBVO {

	public List<ClubVO> select();

	public List<ClubVO> selectByRanking();
	
}
