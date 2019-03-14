package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public class ClubODBPostgresql extends ODB implements ClubODB{

	@Override
	public void insert (Club club) {
		String consulta = "";
		consulta = consulta + "insert into fut_clubes (nombre) ";
		consulta = consulta + "values ('"+ club.getNombre() +"')";
		ejecutarSQL(consulta);
	}

	@Override
	public void updateEfectivo(Club club) {
		Integer id = club.getClub_id();
		Integer efectivo = club.getEfectivo();
		String consulta = "update fut_clubes ";
		consulta = consulta + "set efectivo = "+efectivo+" "; 
		consulta = consulta + "where (club_id = "+id+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void updateCotizacion(Club club) {
		Integer id = club.getClub_id();
		Integer cotizacion = club.getCotizacion();
		String consulta = "update fut_clubes ";
		consulta = consulta + "set cotizacion = "+cotizacion+" "; 
		consulta = consulta + "where (club_id = "+id+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public void updateDivVictoria(Club club) {
		Integer id = club.getClub_id();
		Integer dividendo = club.getDiv_victoria();
		String consulta = "update fut_clubes ";
		consulta = consulta + "set div_victoria = "+dividendo+" "; 
		consulta = consulta + "where (club_id = "+id+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public void updateDivEmpate(Club club) {
		Integer id = club.getClub_id();
		Integer dividendo = club.getDiv_empate();
		String consulta = "update fut_clubes ";
		consulta = consulta + "set div_empate = "+dividendo+" "; 
		consulta = consulta + "where (club_id = "+id+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public void updateDivDerrota(Club club) {
		Integer id = club.getClub_id();
		Integer dividendo = club.getDiv_derrota();
		String consulta = "update fut_clubes ";
		consulta = consulta + "set div_derrota = "+dividendo+" "; 
		consulta = consulta + "where (club_id = "+id+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public List<Club> select () {
		List<Club> clubes = new ArrayList<Club>();
		String campos = "club_id, nombre, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		
		String comandoSQL = "select "+campos+" from fut_clubes;";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				clubes.add(new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"),
						resultados.getInt("cotizacion"),
						resultados.getInt("presidente"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta")
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
	public List<Club> selectByRanking () {
		String campos = "club_id, nombre, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		String tabla = "fut_clubes";
		String condicion = "posicion<11";
		String comandoSQL = "select "+campos+" from "+tabla+" where "+condicion+";";  
		
		List<Club> clubes = new ArrayList<Club>();
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				clubes.add(new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"),
						resultados.getInt("cotizacion"),
						resultados.getInt("presidente"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta")
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
	public Club selectByNombre(String nombre) {
		Club club = null;
		String campos = "club_id, nombre, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		
		String comandoSQL = "select "+campos+" from fut_clubes where nombre = '"+nombre+"';";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				club = new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"),
						resultados.getInt("cotizacion"),
						resultados.getInt("presidente"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta")
						);
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return club;
	}

	@Override
	public Club selectByID(Integer id) {
		Club club = null;
		String campos = "club_id, nombre, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		
		String comandoSQL = "select "+campos+" from fut_clubes where club_id = '"+id+"';";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				club = new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"),
						resultados.getInt("cotizacion"),
						resultados.getInt("presidente"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta")
						);
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return club;
	}

	@Override
	public List<Club> selectByPresidente (Jugador presidente) {
		List<Club> clubes = new ArrayList<Club>();
		Integer presidente_id = presidente.getJugador_id();
		String campos = "club_id, nombre, presidente, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion, "
				+"cantidad_venta, cantidad_compra, precio_compra, precio_venta";
		
		String comandoSQL = "select "+campos+" from fut_clubes where presidente = "+presidente_id+";";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				clubes.add(new Club(
						resultados.getInt("club_id"),
						resultados.getString("nombre"),
						resultados.getInt("cotizacion"),
						resultados.getInt("presidente"),
						resultados.getInt("efectivo"),
						resultados.getInt("div_victoria"),
						resultados.getInt("div_empate"),
						resultados.getInt("div_derrota"),
						resultados.getInt("posicion"),
						resultados.getInt("cantidad_venta"),
						resultados.getInt("cantidad_compra"),
						resultados.getInt("precio_compra"),
						resultados.getInt("precio_venta")
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
	public void actualizarPosiciones () {
		String consulta = "select calcular_ranking_clubes()";
		ejecutarSQL(consulta);
	}

	@Override
	public void elegirPresidente (Club club) {
		String consulta = "select elegir_presidente("+club.getClub_id()+");";
		ejecutarSQL(consulta);
	}
	
}