package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.OrdenODBVO;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.OrdenVO;

public class OrdenODBVOPostgresql extends ODB implements OrdenODBVO{

	@Override
	public List<OrdenVO> selectByJugador(Jugador jugador) {
		List<OrdenVO> ordenes = new ArrayList<OrdenVO>();
		String comandoSQL = "select orden_id, jugador_id, club_id, club, tipo, cantidad, precio, estado, es_emision, cotizacion ";
		comandoSQL = comandoSQL + "from fut_v_ordenes where jugador_id = "+jugador.getJugador_id()+";";
		

		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				ordenes.add(new OrdenVO(
						resultados.getInt("orden_id"),
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getInt("cantidad"),
						resultados.getInt("cotizacion"),
						resultados.getInt("precio"),
						resultados.getString("club"),
						resultados.getString("tipo"),
						resultados.getString("estado"),
						resultados.getBoolean("es_emision")
						));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return ordenes;
	}

	@Override
	public List<OrdenVO> selectByClubEmision(Club club) {
		String campos = "orden_id, jugador_id, club_id, club, tipo, cantidad, precio, estado, es_emision, cotizacion";
		String tabla = "fut_v_ordenes";
		String condicion = "club_id = "+club.getClub_id()+" and es_emision = true";
		
		String comandoSQL = "select "+campos+" from "+tabla+" where "+condicion+";";
		List<OrdenVO> ordenes = new ArrayList<OrdenVO>();

		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				ordenes.add(new OrdenVO(
						resultados.getInt("orden_id"),
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getInt("cantidad"),
						resultados.getInt("cotizacion"),
						resultados.getInt("precio"),
						resultados.getString("club"),
						resultados.getString("tipo"),
						resultados.getString("estado"),
						resultados.getBoolean("es_emision")
						));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return ordenes;
	}
	
}