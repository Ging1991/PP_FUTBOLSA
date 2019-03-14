package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.ResultadoODBVO;
import com.caballero.futbolsa.persistencia.pojosVo.ResultadoVO;

public class ResultadoODBVOPostgresql extends ODB implements ResultadoODBVO{
	private String tabla = "fut_v_resultados";

	@Override
	public List<ResultadoVO> selectUltimos() {
		String orden = "resultado_id";
		String condicion = "resultado_id<10";
		return selectByCondicionByOrden(condicion, orden);
	}

	private List<ResultadoVO> selectByCondicionByOrden(String condicion, String orden) {
		String campos = "resultado_id, club_local, local, club_visitante, visitante, goles_local, goles_visitante";
		String comandoSQL = "select " + campos + " from " + tabla + " where ("+condicion+") order by "+orden+";";
		List<ResultadoVO> resultados = new ArrayList<ResultadoVO>();
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet registros = sentencia.executeQuery(comandoSQL);			

			while (registros.next())
				resultados.add(new ResultadoVO(
						registros.getInt("resultado_id"),
						registros.getInt("club_local"),
						registros.getInt("club_visitante"),
						registros.getInt("goles_local"),
						registros.getInt("goles_visitante"),
						registros.getString("local"),
						registros.getString("visitante")
						));

			registros.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return resultados;	
	}

}