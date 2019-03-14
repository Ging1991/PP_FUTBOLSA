package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.PosesionODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;

public class PosesionODBPostgresql extends ODB implements PosesionODB{
	private String tabla = "fut_posesiones";
	
	@Override
	public void insert(Posesion posesion) {
		Integer jugador = posesion.getJugador_id();
		Integer club = posesion.getClub_id();
		Integer cantidad = posesion.getCantidad();
		String consulta = "insert into fut_posesiones (jugador_id, club_id, cantidad) ";
		consulta = consulta + "values ("+jugador+", "+club+", "+cantidad+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Posesion posesion) {
		Integer jugador = posesion.getJugador_id();
		Integer club = posesion.getClub_id();
		String consulta = "delete from fut_posesiones ";
		consulta = consulta + "where (jugador_id = "+jugador+" and club_id = "+club+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void updateCantidad(Posesion posesion) {
		Integer jugador = posesion.getJugador_id();
		Integer club = posesion.getClub_id();
		Integer cantidad = posesion.getCantidad();
		String consulta = "update fut_posesiones ";
		consulta = consulta + "set cantidad = "+cantidad+" "; 
		consulta = consulta + "where (jugador_id = "+jugador+" and club_id = "+club+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Posesion> selectByJugador(Jugador jugador) {
		String condicion = "jugador_id = "+jugador.getJugador_id();  
		return selectByCondicion(condicion);
	}

	@Override
	public List<Posesion> selectByClub(Club club) {
		String condicion = "club_id = "+club.getClub_id();  
		return selectByCondicion(condicion);
	}
	
	@Override
	public Posesion selectByJugadorClub(Jugador jugador, Club club) throws Exception {
		Posesion posesion = null;
		String condicion = "jugador_id = "+jugador.getJugador_id()+" and club_id = "+club.getClub_id();  
		List<Posesion> posesiones = selectByCondicion(condicion);
		
		if (posesiones.size()>1)
			throw new Exception("Inconsistencia en la base de datos: solo puede haber una cantidad por cada par jugador-club");
		
		if (posesiones.size() == 1)
			posesion = posesiones.get(0);
		
		return posesion;
	}

	private List<Posesion> selectByCondicion(String condicion) {
		String campos = "jugador_id, club_id, cantidad";
		String comandoSQL = "select " + campos + " from " + tabla + " where (" + condicion + ");";
		List<Posesion> posesiones = new ArrayList<Posesion>();
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				posesiones.add(new Posesion(
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getInt("cantidad"))
						);
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return posesiones;	
	}
	
}