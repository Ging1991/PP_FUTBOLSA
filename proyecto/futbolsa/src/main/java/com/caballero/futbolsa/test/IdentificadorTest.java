package com.caballero.futbolsa.test;

import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class IdentificadorTest {
	
	public static Jugador traerJugadorPorUsuarioTest(String usuario) {
		return Identificador.traerJugadorPorUsuario(usuario);
	}
	
	public static Jugador traerJugadorPorIDTest(Integer id) {
		return Identificador.traerJugadorPorID(id);
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
		String nombre = "Cyntia";
		System.out.println(traerJugadorPorIDTest(1).getUsuario());
		registrarJugadorTest(nombre, "123");
		System.out.println(traerJugadorPorUsuarioTest(nombre).getUsuario());
		iniciarSesionTest(nombre, "123");
	}

}