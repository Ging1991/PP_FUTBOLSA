package com.caballero.futbolsa.persistencia.pojos;

public class Jugador {	
	private Integer jugador_id, efectivo, posicion;
	private String usuario, password, avatar, biografia;
	private boolean administrador;

	public Jugador(Integer jugador_id, Integer efectivo, Integer posicion, String usuario, String password,
			String avatar, String biografia, boolean administrador) {
		this.jugador_id = jugador_id;
		this.efectivo = efectivo;
		this.posicion = posicion;
		this.usuario = usuario;
		this.password = password;
		this.avatar = avatar;
		this.biografia = biografia;
		this.administrador = administrador;
	}
	
	@Override
	public String toString() {
		String ret = "jugador ID: "+jugador_id;
		ret = ret + ", usuario: " + usuario;
		ret = ret + ", password: " + password;
		ret = ret + ", efectivo: " + efectivo;
		ret = ret + ", posicion: " + posicion;
		return ret;
	}

	public Integer getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(Integer jugador_id) {
		this.jugador_id = jugador_id;
	}

	public Integer getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(Integer efectivo) {
		this.efectivo = efectivo;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

}