package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;

public interface ClubODB {
	
	public void insert (Club club);
	
	public List<Club> select ();

	public Club selectByNombre (String nombre);
			
	public Club selectByID(Integer id);
		
}