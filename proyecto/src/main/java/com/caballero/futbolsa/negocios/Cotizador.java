package com.caballero.futbolsa.negocios;

import java.util.List;
import com.caballero.futbolsa.persistencia.interfases.ClubODB;
import com.caballero.futbolsa.persistencia.interfases.ClubODBVO;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojos.Operacion;
import com.caballero.futbolsa.persistencia.pojosVo.ClubVO;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBPostgresql;
import com.caballero.futbolsa.persistencia.postgresql.ClubODBVOPostgresql;

public class Cotizador {
	
	public static List<ClubVO> traerCotizaciones() {
		ClubODBVO odbvo = new ClubODBVOPostgresql();
		return odbvo.select();
	}
	
	public static void actualizarCotizacion(Club club, Operacion operacion) {
		club.setCotizacion(operacion.getPrecio());
		ClubODB odb = new ClubODBPostgresql();
		odb.updateCotizacion(club);
	}

}