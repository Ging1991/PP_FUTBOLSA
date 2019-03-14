package com.caballero.futbolsa.persistencia.interfases;

import java.util.List;
import com.caballero.futbolsa.persistencia.pojos.Jugador;

public interface JugadorODB {

	public void insert (Jugador jugador);
	
	public void updateEfectivo (Jugador jugador);

	public void updateBiografia (Jugador jugador);
	
	public List<Jugador> select();
	
	public List<Jugador> selectByRanking();
	
	public Jugador selectByUsuario (String usuario);

	public Jugador selectByID(Integer id);
	
	public void actualizarPosiciones();
	
}