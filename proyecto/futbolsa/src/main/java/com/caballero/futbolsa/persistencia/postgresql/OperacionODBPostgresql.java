package com.caballero.futbolsa.persistencia.postgresql;

import java.util.List;

import com.caballero.futbolsa.persistencia.ODB;
import com.caballero.futbolsa.persistencia.interfases.OperacionODB;
import com.caballero.futbolsa.persistencia.pojos.Jugador;
import com.caballero.futbolsa.persistencia.pojos.Operacion;

public class OperacionODBPostgresql extends ODB implements OperacionODB{

	@Override
	public void insert(Operacion operacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Operacion> selectOperacionByJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		return null;
	}

}
