package com.caballero.futbolsa.test;

import java.util.List;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Club;

public class AdministradorTest {

	public static boolean nombreLibreTest(String nombre) {
		return Administrador.nombreDeClubLibre(nombre);
	}
	
	public static void getTodosLosClubesTest() {
		List<Club> clubes = Administrador.getTodosLosClubes();
		System.out.println("Lista de todos los clubes:");
		for (Club club : clubes)
			System.out.println(club.getNombre());
		System.out.println("Fin de la lista:"+clubes.size()+" clubes");
	}
	
	public static void crearClubTest(String nombre) {
		try {
			Administrador.crearClub(nombre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String nombre = "River";
		System.out.println("Nombre libre: " + nombreLibreTest(nombre));
		crearClubTest(nombre);
		getTodosLosClubesTest();
	}

}