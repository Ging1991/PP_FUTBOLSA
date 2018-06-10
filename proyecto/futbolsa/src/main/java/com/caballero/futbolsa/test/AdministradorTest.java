package com.caballero.futbolsa.test;

import java.util.List;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Club;

public class AdministradorTest {

	public static boolean nombreLibreTest(String nombre) {
		return Administrador.nombreDeClubLibre(nombre);
	}
	
	public static void traerClubesTest() {
		List<Club> clubes = Administrador.traerClubes();
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
	
	public static Club traerClubPorIDTest(Integer id) {
		return Administrador.traerClubPorID(id);
	}
	
	public static void main(String[] args) {
		String nombre = "San Lorenzo";
		System.out.println("Nombre libre: " + nombreLibreTest(nombre));
		System.out.println("ID 1: "+traerClubPorIDTest(1).getNombre());
		crearClubTest(nombre);
		traerClubesTest();
	}

}