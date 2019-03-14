package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.OperacionODB;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Operacion;

public class OperacionODBPostgresql extends ODB implements OperacionODB{

	@Override
	public void insert(Operacion operacion) {
		Integer vendedor = operacion.getVendedor();
		Integer comprador = operacion.getComprador();
		Integer club = operacion.getClub();
		Integer cantidad = operacion.getCantidad();
		Integer precio = operacion.getPrecio();
		boolean emision = operacion.isEmision();
		
		String consulta = "insert into fut_operaciones (vendedor, comprador, club, cantidad, precio, emision) ";
		consulta = consulta + "values ("+vendedor+", "+comprador+", "+club+", "+cantidad+", "+precio+", "+emision+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Operacion> selectByJugador(Jugador jugador) {
		List<Operacion> operaciones = new ArrayList<Operacion>();
		Integer jugador_id = jugador.getJugador_id();
		
		String comandoSQL = "select operacion_id, vendedor, comprador, club, cantidad, precio, emision, fecha ";
		comandoSQL = comandoSQL + "from fut_operaciones ";
		comandoSQL = comandoSQL + "where comprador = "+jugador_id+" or vendedor = "+jugador_id+";";
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				operaciones.add(new Operacion(
						resultados.getInt("operacion_id"),
						resultados.getInt("vendedor"),
						resultados.getInt("comprador"),
						resultados.getInt("club"),
						resultados.getInt("cantidad"),
						resultados.getInt("precio"),
						resultados.getDate("fecha"),
						resultados.getBoolean("emision")
						));
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return operaciones;
	}

}