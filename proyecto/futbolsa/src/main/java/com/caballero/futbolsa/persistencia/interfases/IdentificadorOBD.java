package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public interface IdentificadorOBD {

	public void insertJugador (Jugador jugador);
	
	public Jugador selectJugadorByUsuario (String usuario);
	
	public List<Jugador> selectJugadorTodos ();
	
}