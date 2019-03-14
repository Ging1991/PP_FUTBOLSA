package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public interface ClubODB {
	
	public void insert (Club club);
	
	public void updateEfectivo (Club club);

	public void updateCotizacion (Club club);
	
	public void updateDivVictoria (Club club);
	
	public void updateDivEmpate (Club club);
	
	public void updateDivDerrota (Club club);
		
	public List<Club> select ();
	
	public List<Club> selectByRanking();

	public Club selectByNombre (String nombre);
			
	public Club selectByID(Integer id);
	
	public List<Club> selectByPresidente (Jugador presidente);
	
	public void actualizarPosiciones();

	public void elegirPresidente(Club club);
}