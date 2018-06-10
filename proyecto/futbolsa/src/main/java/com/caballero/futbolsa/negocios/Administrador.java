package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBPostgresql;

public class Administrador {

	public static void crearClub (String nombre) throws Exception {
		if (!nombreDeClubLibre(nombre))
			throw new Exception("Ya existe un club con el nombre: "+nombre);
		
		Club club = new Club(-1, nombre);
		ClubODB odb = new ClubODBPostgresql();
		odb.insert(club);
	}
	
	public static boolean nombreDeClubLibre(String nombre) {
		ClubODB odb = new ClubODBPostgresql();
		return odb.selectByNombre(nombre) == null;
	}
	
	public static List<Club> traerClubes() {
		ClubODB odb = new ClubODBPostgresql();
		return odb.select();
	}
	
	public static Club traerClubPorID(Integer id) {
		ClubODB odb = new ClubODBPostgresql();
		return odb.selectByID(id);	
	}
	
	public static void eliminarClub (Club club) throws Exception {

	}
	
}