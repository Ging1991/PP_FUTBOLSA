package com.caballero.futbolsa.persistencia.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.NoticiaODB;
import com.caballero.futbolsa.persistencia.pojos.Noticia;

public class NoticiaODBPostgresql extends ODB implements NoticiaODB{

	private String tabla = "fut_noticias";
	
	@Override
	public Integer insert(Noticia noticia) {
		String comandoSQL = "select insertar_noticia('"+noticia.getContenido()+"') as noticia_id;";
		Integer noticia_id = null;
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			if (resultados.next())
				noticia_id = resultados.getInt("noticia_id");
				
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
		
		return noticia_id;
	}

	@Override
	public Noticia selectByID(Integer id) throws Exception {
		Noticia noticia = null;
		String condicion = "noticia_id = "+id;
		List<Noticia> noticias = selectByCondicion(condicion);
				
		if (noticias.size()>1)
			throw new Exception("Inconsistencia en la base de datos: solo puede haber una noticia por cada ID");
		
		if (noticias.size() == 1)
			noticia = noticias.get(0);

		return noticia;
	}
	
	private List<Noticia> selectByCondicion(String condicion) {
		String campos = "noticia_id, contenido, fecha";
		String comandoSQL = "select " + campos + " from " + tabla + " where (" + condicion + ");";
		List<Noticia> noticias = new ArrayList<Noticia>();
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next())
				noticias.add(new Noticia(
						resultados.getInt("noticia_id"),
						resultados.getString("contenido"),
						resultados.getDate("fecha"))
						);
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return noticias;	
	}
	
}