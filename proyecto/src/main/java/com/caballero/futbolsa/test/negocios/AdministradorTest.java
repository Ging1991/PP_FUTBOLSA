package com.caballero.futbolsa.test.negocios;

import java.util.List;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.pojos.Club;

public class AdministradorTest {

	public static void nombreDeClubLibreTest(String nombre) {
		System.out.println("...Nombre de club libre test: "+nombre+" iniciando");
		try {
			System.out.println("Nombre libre: "+Administrador.nombreDeClubLibre(nombre));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("...Nombre de club libre test: "+nombre+" finalizando");
	}
	
	public static void crearClubTest(String nombre) {
		try {
			System.out.println("...Crear club test: "+nombre+" iniciando");
			Administrador.crearClub(nombre);
			System.out.println("...Crear club test: "+nombre+" terminando");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void traerClubesTest() {
		System.out.println("...Traer clubes test iniciando");
		List<Club> clubes = Administrador.traerClubes();
		for (Club club : clubes)
			System.out.println(club);
		System.out.println("Cantidad: "+clubes.size()+" clubes");
		System.out.println("...Traer clubes test terminando");
	}
	
	public static void traerClubPorIDTest(Integer id) {
		System.out.println("...Traer club por ID test: "+id+" iniciando");
		System.out.println(Administrador.traerClubPorID(id));
		System.out.println("...Traer club por ID test: "+id+" finalizando");
	}
	
	public static void main(String[] args) {
		/*String nombre = "Real Madrid";
		nombreDeClubLibreTest(nombre);
		crearClubTest(nombre);
		traerClubPorIDTest(1);
		traerClubesTest();*/
		
		String []nombres = {"Argentinos Juniors",
				"Aldosivi",
				"Banfield",
				"Belgrano",
				"Boca Juniors",
				"Colon",
				"Huracan",
				"Independiente",
				"Lanus",
				"Newells Old Boys",
				"Patronato",
				"River Plate",
				"Rosario Central",
				"San Lorenzo",
				"San Martin",
				"Talleres",
				"Tigre",
				"Tucuman",
				"Union",
				"Velez Sarfield",
				"Gimnasia de la Plata",
				"Godoy Cruz",
				"Estudiantes",
				"Defensa y Justicia",
				"Racing"};
		
		for (String string : nombres)
			System.out.println("insert into fut_clubes (nombre) values('"+string+"');");
		
		
		
	}

}