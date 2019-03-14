package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.NotificacionODBVO;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojosVo.NotificacionVO;

public class NotificacionODBVOPostgresql extends ODB implements NotificacionODBVO{
	private String tabla = "fut_v_notificaciones";
	
	@Override
	public List<NotificacionVO> selectByJugador(Jugador jugador) {
		String condicion = "jugador_id = "+jugador.getJugador_id();
		return selectByCondicion(condicion);
	}
	
	private List<NotificacionVO> selectByCondicion(String condicion) {
		String campos = "notificacion_id, jugador_id, usuario, noticia_id, contenido, fecha";
		String comandoSQL = "select " + campos + " from " + tabla + " where (" + condicion + ");";
		List<NotificacionVO> notificaciones = new ArrayList<NotificacionVO>();
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				notificaciones.add(new NotificacionVO(
						resultados.getInt("notificacion_id"),
						resultados.getInt("jugador_id"),						
						resultados.getInt("noticia_id"),
						resultados.getString("usuario"),
						resultados.getString("contenido"),
						resultados.getDate("fecha")
						));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return notificaciones;	
	}

}