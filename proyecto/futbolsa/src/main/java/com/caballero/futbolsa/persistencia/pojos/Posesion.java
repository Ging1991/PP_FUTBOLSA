package com.caballero.futbolsa.persistencia.pojos;

public class Posesion {
	private Integer jugador_id, club_id, cantidad;

	public Posesion(Integer jugador_id, Integer club_id, Integer cantidad) {
		this.jugador_id = jugador_id;
		this.club_id = club_id;
		this.cantidad = cantidad;
	}

	public Integer getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(Integer jugador_id) {
		this.jugador_id = jugador_id;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
		
}