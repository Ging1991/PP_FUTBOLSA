package com.caballero.futbolsa.persistencia.postgresql;

import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.ResultadoODB;
import com.caballero.futbolsa.persistencia.pojos.Resultado;

public class ResultadoODBPostgresql extends ODB implements ResultadoODB{
	private String tabla = "fut_resultados";

	@Override
	public void insert(Resultado resultado) {
		String parametros = "club_local, club_visitante, goles_local, goles_visitante";
		String valores = "";
		valores += resultado.getClub_local()+", ";
		valores += resultado.getClub_visitante()+", ";
		valores += resultado.getGoles_local()+", ";
		valores += resultado.getGoles_visitante();
				
		String consulta = "insert into " + tabla + " (" + parametros + ") values ("+valores+")";
		ejecutarSQL(consulta);
	}

}