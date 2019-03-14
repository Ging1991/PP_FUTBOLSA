package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.JugadorODB;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class JugadorOBDPostgresql extends ODB implements JugadorODB{

	@Override
	public void insert (Jugador jugador) {
		String consulta = "insert into fut_jugadores (usuario, password, avatar, biografia) ";
		consulta = consulta + "values ('"+ jugador.getUsuario() +"', '"+ jugador.getPassword() +"', '', '')";
		ejecutarSQL(consulta);
	}

	@Override
	public void updateEfectivo(Jugador jugador) {
		Integer id = jugador.getJugador_id();
		Integer efectivo = jugador.getEfectivo();
		String consulta = "update fut_jugadores ";
		consulta = consulta + "set efectivo = "+efectivo+" "; 
		consulta = consulta + "where (jugador_id = "+id+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void updateBiografia(Jugador jugador) {
		Integer jugador_id = jugador.getJugador_id();
		String biografia = jugador.getBiografia();
		String consulta = "update fut_jugadores ";
		consulta = consulta + "set biografia = '"+biografia+"' "; 
		consulta = consulta + "where (jugador_id = "+jugador_id+");";
		ejecutarSQL(consulta);
	}
		
	@Override
	public List<Jugador> select() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		String comandoSQL = "select jugador_id, usuario, password, efectivo, posicion, avatar, biografia, administrador from fut_jugadores;";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				jugadores.add(new Jugador(
						resultados.getInt("jugador_id"),
						resultados.getInt("efectivo"),
						resultados.getInt("posicion"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						resultados.getString("avatar"),
						resultados.getString("biografia"),
						resultados.getBoolean("administrador")
						));
			}
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return jugadores;
	}

	@Override
	public List<Jugador> selectByRanking() {
		String campos = "jugador_id, usuario, password, efectivo, posicion, avatar, biografia, administrador";
		String tabla = "fut_jugadores";
		String condicion = "posicion<11";
		String comandoSQL = "select "+campos+" from "+tabla+" where "+condicion+" order by posicion;";  
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				jugadores.add(new Jugador(
						resultados.getInt("jugador_id"),
						resultados.getInt("efectivo"),
						resultados.getInt("posicion"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						resultados.getString("avatar"),
						resultados.getString("biografia"),
						resultados.getBoolean("administrador")
						));
			}
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return jugadores;
	}

	@Override
	public Jugador selectByUsuario(String usuario) {
		Jugador jugador = null;
		String comandoSQL = "select jugador_id, usuario, password, efectivo, posicion, avatar, biografia, administrador from fut_jugadores where usuario = '"+usuario+"';";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				jugador = new Jugador(
						resultados.getInt("jugador_id"),
						resultados.getInt("efectivo"),
						resultados.getInt("posicion"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						resultados.getString("avatar"),
						resultados.getString("biografia"),
						resultados.getBoolean("administrador")
						);
								
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return jugador;
	}

	@Override
	public Jugador selectByID(Integer id) {
		Jugador jugador = null;
		String comandoSQL = "select jugador_id, usuario, password, efectivo, posicion, avatar, biografia, administrador from fut_jugadores where jugador_id = "+id+";";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				jugador = new Jugador(
						resultados.getInt("jugador_id"),
						resultados.getInt("efectivo"),
						resultados.getInt("posicion"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						resultados.getString("avatar"),
						resultados.getString("biografia"),
						resultados.getBoolean("administrador")
						);
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return jugador;
	}
	
	@Override
	public void actualizarPosiciones () {
		String consulta = "select calcular_ranking_jugadores()";
		ejecutarSQL(consulta);
	}
	
}