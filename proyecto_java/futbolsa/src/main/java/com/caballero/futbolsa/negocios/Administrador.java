package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.AdministradorOBD;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.postgresql.AdministradorOBDPostgresql;

public class Administrador {

	public static void crearClub (String nombre) throws Exception {
		if (nombre == null || nombre == "")
			throw new Exception("El nombre del club no puede estar vacio");
		
		if (!nombreDeClubLibre(nombre))
			throw new Exception("Ya existe un club con el nombre: "+nombre);
		
		Club club = new Club(-1, nombre);
		AdministradorOBD odb = new AdministradorOBDPostgresql();
		odb.insertClub(club);
	}
	
	public static boolean nombreDeClubLibre(String nombre) {
		AdministradorOBD obd = new AdministradorOBDPostgresql();
		return obd.selectClubByNombre(nombre) == null;
	}
	
	public static List<Club> getTodosLosClubes() {
		AdministradorOBD obd = new AdministradorOBDPostgresql();
		return obd.selectClubTodos();
		
	}
	
	public static void eliminarClub (Club club) throws Exception {

	}
	
}