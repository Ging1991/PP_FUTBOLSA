package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.pojos.Club;

public class ClubODBPostgresql extends ODB implements ClubODB{

	@Override
	public void insert (Club club) {
		String consulta = "";
		consulta = consulta + "insert into fut_clubes (nombre) ";
		consulta = consulta + "values ('"+ club.getNombre() +"')";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Club> select () {
		List<Club> clubes = new ArrayList<Club>();
		String comandoSQL = "select club_id, nombre from fut_clubes;";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				clubes.add(new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre")));
			}
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return clubes;
	}

	@Override
	public Club selectByNombre(String nombre) {
		Club club = null;
		String comandoSQL = "select club_id, nombre from fut_clubes where nombre = '"+nombre+"';";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				club = new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return club;
	}

	@Override
	public Club selectByID(Integer id) {
		Club club = null;
		String comandoSQL = "select club_id, nombre from fut_clubes where club_id = '"+id+"';";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				club = new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return club;
	}

}