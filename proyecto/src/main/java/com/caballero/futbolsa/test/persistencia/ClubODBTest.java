package com.caballero.futbolsa.test.persistencia;

import java.util.List;
import com.caballero.futbolsa.negocios.Administrador;
import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBPostgresql;

public class ClubODBTest {

	public static void insertTest(String nombre) {
		System.out.println("...Insert test: "+nombre+" iniciando");
		Club club = new Club(-1, nombre, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1);
		ClubODB odb = new ClubODBPostgresql();
		odb.insert(club);
		System.out.println("...Insert test: "+nombre+" finalizado");
	}
	
	public static void updateEfectivoTest(Club club) {
		System.out.println("...Update efectivo test iniciando");
		System.out.println(club);
		ClubODB odb = new ClubODBPostgresql();
		odb.updateEfectivo(club);
		System.out.println("...Update efectivo test finalizado");
	}

	
	public static void selectTest() {
		System.out.println("...Select test iniciando");
		ClubODB odb = new ClubODBPostgresql();
		List<Club> clubes = odb.select();
		for (Club club : clubes)
			System.out.println(club);
		System.out.println("Cantidad: "+clubes.size()+" clubes");
		System.out.println("...Select test finalizado");
	}
	
	public static void selectByNombreTest(String nombre) {
		System.out.println("...Select by nombre test: "+nombre+" iniciando");
		ClubODB odb = new ClubODBPostgresql();
		System.out.println(odb.selectByNombre(nombre));
		System.out.println("...Select by nombre test: "+nombre+" finalizado");
	}
	
	public static void selectByIDTest(Integer id) {
		System.out.println("...Select by ID test: "+id+" iniciando");
		ClubODB odb = new ClubODBPostgresql();
		System.out.println(odb.selectByID(id));
		System.out.println("...Select by ID test: "+id+" finalizado");
	}
	
	public static void main(String[] args) {
		//String nombre = "Barcelona";
		//insertTest(nombre);
		//selectByNombreTest(nombre);
		//selectByIDTest(1);
		//selectTest();
		Club club = Administrador.traerClubPorID(1);
		club.setEfectivo(500);
		updateEfectivoTest(club);
	}

}