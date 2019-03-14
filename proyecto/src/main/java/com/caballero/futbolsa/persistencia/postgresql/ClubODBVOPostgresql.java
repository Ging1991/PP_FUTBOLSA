package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.ClubODBVO;
import com.caballero.futbolsa.persistencia.pojosVo.ClubVO;

public class ClubODBVOPostgresql extends ODB implements ClubODBVO{

	@Override
	public List<ClubVO> selectByRanking () {
		String campos = "club_id, club, presidente_id, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		String tabla = "fut_v_clubes";
		String condicion = "posicion < 11";
		String comandoSQL = "select "+campos+" from "+tabla+" where "+condicion+" order by posicion;";  
		
		List<ClubVO> clubes = new ArrayList<ClubVO>();
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				clubes.add(new ClubVO(
						resultados.getInt("club_id"),
						resultados.getInt("presidente_id"),
						resultados.getInt("cotizacion"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta"),
						resultados.getString("club"),
						resultados.getString("presidente")
						));
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
	public List<ClubVO> select () {
		List<ClubVO> clubes = new ArrayList<ClubVO>();
		String campos = "club_id, club, presidente_id, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		
		String comandoSQL = "select "+campos+" from fut_v_clubes;";  

		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				clubes.add(new ClubVO(
						resultados.getInt("club_id"),
						resultados.getInt("presidente_id"),
						resultados.getInt("cotizacion"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta"),
						resultados.getString("club"),
						resultados.getString("presidente")
						));
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

}