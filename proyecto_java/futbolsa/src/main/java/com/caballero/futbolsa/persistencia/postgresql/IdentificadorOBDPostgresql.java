package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.IdentificadorOBD;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class IdentificadorOBDPostgresql extends ODB implements IdentificadorOBD{

	@Override
	public void insertJugador(Jugador jugador) {
		String consulta = "";
		consulta = consulta + "insert into fut_jugadores (usuario, password) ";
		consulta = consulta + "values ('"+ jugador.getUsuario() +"', '"+ jugador.getPassword() +"')";
		ejecutarSQL(consulta);
	}

	@Override
	public Jugador selectJugadorByUsuario(String usuario) {
		Jugador jugador = null;
		String comandoSQL = "select jugador_id, usuario, password, dinero from fut_jugadores where usuario = '"+usuario+"';";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				jugador = new Jugador(
						resultados.getInt("jugador_id"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						resultados.getInt("dinero"));
			
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
	public List<Jugador> selectJugadorTodos() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		String comandoSQL = "select jugador_id, usuario, password, dinero from fut_jugadores;";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				jugadores.add(new Jugador(
						resultados.getInt("jugador_id"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						resultados.getInt("dinero")
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

}