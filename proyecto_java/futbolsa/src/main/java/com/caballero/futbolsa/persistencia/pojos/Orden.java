package com.caballero.futbolsa.persistencia.pojos;

public class Orden {
	private Integer orden_id, jugador_id, club_id, cantidad, precio;
	private String tipo;
	
	public Orden(Integer orden_id, Integer jugador_id, Integer club_id, String tipo, Integer cantidad, Integer precio) {
		this.orden_id = orden_id;
		this.jugador_id = jugador_id;
		this.club_id = club_id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
	}

	public Integer getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(Integer orden_id) {
		this.orden_id = orden_id;
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

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}