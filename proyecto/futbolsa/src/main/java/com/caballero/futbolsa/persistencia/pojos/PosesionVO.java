package com.caballero.futbolsa.persistencia.pojos;

public class PosesionVO {

	private Integer jugador_id, cantidad;
	private String nombre;
	
	public PosesionVO(Integer jugador_id, Integer cantidad, String nombre) {
		this.jugador_id = jugador_id;
		this.cantidad = cantidad;
		this.nombre = nombre;
	}
	
	public Integer getJugador_id() {
		return jugador_id;
	}
	public void setJugador_id(Integer jugador_id) {
		this.jugador_id = jugador_id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}