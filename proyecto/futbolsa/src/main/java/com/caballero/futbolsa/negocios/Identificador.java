package com.caballero.futbolsa.negocios;

import com.caballero.futbolsa.persistencia.interfases.JugadorODB;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.postgresql.JugadorOBDPostgresql;

public class Identificador {

	public static void registrarJugador(String usuario, String password) throws Exception {
		if (traerJugadorPorUsuario(usuario) != null)
			throw new Exception("Ya existe un jugador registrado con el nombre de usuario: "+usuario);
		
		Jugador jugador = new Jugador(-1, usuario, password, -1);
		JugadorODB odb = new JugadorOBDPostgresql();
		odb.insert(jugador);
	}
	
	public static Jugador iniciarSesion(String usuario, String password) throws Exception {
		Jugador jugador = traerJugadorPorUsuario(usuario);
		
		if (jugador == null)
			throw new Exception("No existe un jugador registrado con el nombre de usuario: "+usuario);
		
		if(!jugador.getPassword().equals(password))
			throw new Exception("Password incorrecta");
					
		return jugador;
	}
	
	public static Jugador traerJugadorPorUsuario(String usuario) {
		JugadorODB odb = new JugadorOBDPostgresql();
		return odb.selectByUsuario(usuario);
	}
	
	public static Jugador traerJugadorPorID(Integer id) {
		JugadorODB odb = new JugadorOBDPostgresql();
		return odb.selectByID(id);
	}
	
}