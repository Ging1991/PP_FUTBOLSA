package com.caballero.futbolsa.test.negocios;

import com.caballero.futbolsa.negocios.Identificador;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class IdentificadorTest {
	
	public static void traerJugadorPorUsuarioTest(String usuario) {
		System.out.println("...Traer jugador por usuario test: "+usuario+" iniciando");
		System.out.println(Identificador.traerJugadorPorUsuario(usuario));
		System.out.println("...Traer jugador por usuario test: "+usuario+" finalizando");
	}
	
	public static void traerJugadorPorIDTest(Integer id) {
		System.out.println("...Traer jugador por ID test: "+id+" iniciando");
		System.out.println(Identificador.traerJugadorPorID(id));
		System.out.println("...Traer jugador por ID test: "+id+" finalizando");
	}
	
	public static void nombreDeUsuarioLibreTest(String usuario) {
		System.out.println("...Nombre de usuario libre test: "+usuario+" iniciando");
		try {
			System.out.println("Nombre libre: "+Identificador.nombreDeUsuarioLibre(usuario));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("...Nombre de usuario libre test: "+usuario+" finalizando");
	}
	
	public static void registrarJugadorTest(String usuario, String password) {
		System.out.println("...Registrar jugador test: "+usuario+" iniciando");
		try {
			Identificador.registrarJugador(usuario, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("...Registrar jugador test: "+usuario+" finalizando");
	}
	
	public static void iniciarSesionTest(String usuario, String password) {
		try {
			System.out.println("...Iniciar sesion test: "+usuario+"-"+password+" iniciando");
			Jugador jugador = null;
			jugador = Identificador.iniciarSesion(usuario, password);
			if (jugador != null)
				System.out.println("Inicio de sesion exitoso");
			else
				System.out.println("Fallo el inicio de sesion");
			System.out.println("...Iniciar sesion test: "+usuario+"-"+password+" finalizando");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String usuario = "Vegeta";
		String password = "123";
		nombreDeUsuarioLibreTest(usuario);
		registrarJugadorTest(usuario, password);
		traerJugadorPorUsuarioTest(usuario);
		traerJugadorPorIDTest(1);
		iniciarSesionTest(usuario, password);
	}

}