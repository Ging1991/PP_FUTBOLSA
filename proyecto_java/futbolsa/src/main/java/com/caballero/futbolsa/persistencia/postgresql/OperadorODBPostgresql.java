package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.OperadorODB;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public class OperadorODBPostgresql extends ODB implements OperadorODB{

	@Override
	public void insertOrden(Orden orden) {
		String consulta = "";
		consulta = consulta + "insert into fut_ordenes (jugador_id, club_id, tipo, cantidad, precio) ";
		consulta = consulta + "values ("+ orden.getJugador_id() +", ";
		consulta = consulta + orden.getClub_id() + ", ";
		consulta = consulta + "'" + orden.getTipo() + "', ";
		consulta = consulta + orden.getCantidad()+ ", ";
		consulta = consulta + orden.getPrecio() + ");";
		
		ejecutarSQL(consulta);
	}

	@Override
	public List<Orden> selectOrdenByJugador(Jugador jugador) {
		List<Orden> ordenes = new ArrayList<Orden>();
		String comandoSQL = "select orden_id, jugador_id, club_id, tipo, cantidad, precio ";
		comandoSQL = comandoSQL + "from fut_ordenes where jugador_id = "+jugador.getJugador_id()+";";
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				ordenes.add(new Orden(
						resultados.getInt("orden_id"),
						resultados.getInt("jugador_id"),
						resultados.getInt("club_id"),
						resultados.getString("tipo"),
						resultados.getInt("cantidad"),
						resultados.getInt("precio")));
			
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