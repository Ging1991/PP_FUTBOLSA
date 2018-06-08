package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.IdentificadorOBD;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.postgresql.IdentificadorOBDPostgresql;

public class Identificador {

	public static Jugador getJugadorByNombre(String nombre) {
		IdentificadorOBD odb = new IdentificadorOBDPostgresql();
		return odb.selectJugadorByUsuario(nombre);
	}

	public static List<Jugador> getTodosLosJugadores() {
		IdentificadorOBD odb = new IdentificadorOBDPostgresql();
		return odb.selectJugadorTodos();
	}

	public static void registrarJugador(String nombre, String password) throws Exception {
		if (getJugadorByNombre(nombre) != null)
			throw new Exception("Ya existe un jugador registrado con el nombre: "+nombre);
		
		Jugador jugador = new Jugador(-1, nombre, password, -1);
		IdentificadorOBD obd = new IdentificadorOBDPostgresql();
		obd.insertJugador(jugador);
	}
	
	public static Jugador iniciarSesion(String nombre, String password) throws Exception {
		Jugador jugador = getJugadorByNombre(nombre);
		
		if (jugador == null)
			throw new Exception("No existe un jugador registrado con el nombre: "+nombre);
		
		if(!jugador.getPassword().equals(password))
			throw new Exception("Password incorrecta");
					
		return jugador;
	}
	
}