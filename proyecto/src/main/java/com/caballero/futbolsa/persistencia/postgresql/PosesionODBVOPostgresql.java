package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.PosesionODBVO;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.EmisionVO;
import com.caballero.futbolsa.persistencia.pojosVo.PosesionVO;

public class PosesionODBVOPostgresql extends ODB implements PosesionODBVO{

	@Override
	public List<PosesionVO> selectByJugador(Jugador jugador) {
		List<PosesionVO> posesiones = new ArrayList<PosesionVO>();
		String comandoSQL = "select jugador_id , club_id, cantidad, club, cotizacion from fut_v_posesiones ";
		comandoSQL = comandoSQL + "where (jugador_id = "+jugador.getJugador_id()+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				posesiones.add(new PosesionVO(
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getInt("cantidad"),
						resultados.getInt("cotizacion"),
						resultados.getString("club")));

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
	public EmisionVO selectEmisionByClub(Club club) {
		String campos = "club_id, club, sum(cantidad) as emision, cotizacion";
		String tabla = "fut_v_posesiones";
		String agrupacion = "club_id, club, cotizacion";
		String condicion = "club_id = "+ club.getClub_id();
		
		String comandoSQL = "select "+campos+" from "+tabla+" where "+condicion+" group by "+agrupacion+";";
		EmisionVO emision = null;
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				emision = new EmisionVO(
						resultados.getInt("club_id"),
						resultados.getInt("emision"),
						resultados.getInt("cotizacion"),
						resultados.getString("club")
						);

			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return emision;	
	}

}