package com.caballero.futbolsa.persistencia.pojos;

public class Jugador {
	
	private Integer jugador_id, dinero;
	private String usuario, password;

	public Jugador(Integer jugador_id, String usuario, String password, Integer dinero) {
		this.jugador_id = jugador_id;
		this.dinero = dinero;
		this.usuario = usuario;
		this.password = password;
	}
	
	public Integer getJugador_id() {
		return jugador_id;
	}
	public void setJugador_id(Integer jugador_id) {
		this.jugador_id = jugador_id;
	}
	public Integer getDinero() {
		return dinero;
	}
	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}