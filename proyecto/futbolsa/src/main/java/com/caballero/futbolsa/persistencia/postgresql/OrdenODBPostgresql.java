package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.OrdenODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Orden;

public class OrdenODBPostgresql extends ODB implements OrdenODB{

	@Override
	public void insert(Orden orden) {
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
	public void delete(Orden orden) {
		String consulta = "delete from fut_ordenes where orden_id = "+orden.getOrden_id();	
		ejecutarSQL(consulta);
	}
	
	@Override
	public void updateCantidad(Orden orden) {
		Integer id = orden.getOrden_id();
		Integer cantidad = orden.getCantidad();
		String consulta = "update fut_ordenes ";
		consulta = consulta + "set cantidad = "+cantidad+" "; 
		consulta = consulta + "where (orden_id = "+id+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public List<Orden> selectByJugador(Jugador jugador) {
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

	@Override
	public List<Orden> selectByJugadorTipo(Jugador jugador, String tipo) {
		List<Orden> ordenes = new ArrayList<Orden>();
		String comandoSQL = "select orden_id, jugador_id, club_id, tipo, cantidad, precio ";
		comandoSQL = comandoSQL + "from fut_ordenes where jugador_id = "+jugador.getJugador_id()+" and tipo = '"+tipo+"';";
		
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

	@Override
	public List<Orden> selectByClubTipo(Club club, String tipo) {
		List<Orden> ordenes = new ArrayList<Orden>();
		String comandoSQL = "select orden_id, jugador_id, club_id, tipo, cantidad, precio ";
		comandoSQL = comandoSQL + "from fut_ordenes where club_id = "+club.getClub_id()+" and tipo = '"+tipo+"';";
		
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