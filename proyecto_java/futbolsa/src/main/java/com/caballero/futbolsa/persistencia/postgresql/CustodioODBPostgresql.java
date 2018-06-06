package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.CustodioODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Posesion;
import com.caballero.futbolsa.persistencia.pojos.PosesionVO;

public class CustodioODBPostgresql extends ODB implements CustodioODB{

	@Override
	public void insertPosesion(Posesion posesion) {
		Integer jugador = posesion.getJugador_id();
		Integer club = posesion.getClub_id();
		Integer cantidad = posesion.getCantidad();
		String consulta = "insert into fut_posesiones (jugador_id, club_id, cantidad) ";
		consulta = consulta + "values ("+jugador+", "+club+", "+cantidad+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void deletePosesion(Posesion posesion) {
		Integer jugador = posesion.getJugador_id();
		Integer club = posesion.getClub_id();
		String consulta = "delete from fut_posesiones ";
		consulta = consulta + "where (jugador_id = "+jugador+" and club_id = "+club+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void updatePosesion(Posesion posesion) {
		Integer jugador = posesion.getJugador_id();
		Integer club = posesion.getClub_id();
		Integer cantidad = posesion.getCantidad();
		String consulta = "update fut_posesiones ";
		consulta = consulta + "set cantidad = "+cantidad+" "; 
		consulta = consulta + "where (jugador_id = "+jugador+" and club_id = "+club+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Posesion> selectPosesionByJugador(Jugador jugador) {
		List<Posesion> posesiones = new ArrayList<Posesion>();
		String comandoSQL = "select jugador_id, club_id, cantidad from fut_posesiones ";
		comandoSQL = comandoSQL + "where (jugador_id = "+jugador.getJugador_id()+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				posesiones.add(new Posesion(
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getInt("cantidad")));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return posesiones;	
	}

	@Override
	public Posesion selectPosesionByJugadorClub(Jugador jugador, Club club) {
		Posesion posesion = null;
		String comandoSQL = "select jugador_id, club_id, cantidad from fut_posesiones ";
		comandoSQL = comandoSQL + "where (jugador_id = "+jugador.getJugador_id()+" and club_id = "+club.getClub_id()+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				posesion = new Posesion(
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getInt("cantidad"));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return posesion;
	}

	@Override
	public List<PosesionVO> selectPosesionVOByJugador(Jugador jugador) {
		List<PosesionVO> posesiones = new ArrayList<PosesionVO>();
		String comandoSQL = "select jugador_id, nombre, cantidad from fut_v_posesiones ";
		comandoSQL = comandoSQL + "where (jugador_id = "+jugador.getJugador_id()+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				posesiones.add(new PosesionVO(
						resultados.getInt("jugador_id"),
						resultados.getInt("cantidad"),
						resultados.getString("nombre")));
			
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