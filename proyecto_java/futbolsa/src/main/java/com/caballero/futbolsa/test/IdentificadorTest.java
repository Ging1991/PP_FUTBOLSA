package com.caballero.futbolsa.test;

import java.util.List;
import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class IdentificadorTest {
	
	public static Jugador getJugadorByUsuarioTest(String usuario) {
		return Identificador.getJugadorByNombre(usuario);
	}
	
	public static void getTodosLosJugadoresTest() {
		List<Jugador> jugadores = Identificador.getTodosLosJugadores();
		System.out.println("Lista de todos los jugadores:");
		for(Jugador jugador: jugadores)
			System.out.println(jugador.getUsuario());
		System.out.println("Fin de la lista:"+jugadores.size()+" jugadores");
	}
	
	public static void registrarJugadorTest(String usuario, String password) {
		try {
			Identificador.registrarJugador(usuario, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void iniciarSesionTest(String usuario, String password) {
		Jugador jugador = null;
		
		try {
			jugador = Identificador.iniciarSesion(usuario, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if (jugador != null)
			System.out.println("Inicio de sesion exitoso");
		else
			System.out.println("Fallo el inicio de sesion");
	}

	public static void main(String[] args) {
		String nombre = "Jorge";
		registrarJugadorTest(nombre, "123");
		System.out.println(getJugadorByUsuarioTest(nombre).getUsuario());
		getTodosLosJugadoresTest();
	}

}