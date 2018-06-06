package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Club;

public interface AdministradorOBD {

	public void insertClub (Club club);
	
	public Club selectClubByNombre (String nombre);
	
	public List<Club> selectClubTodos ();
}