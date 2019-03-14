package com.caballero.futbolsa.persistencia.pojosVo;

public class PosesionVO {
	private Integer jugador_id, club_id, cantidad, cotizacion;
	private String club;

	public PosesionVO(Integer jugador_id, Integer club_id, Integer cantidad, Integer cotizacion, String club) {
		this.jugador_id = jugador_id;
		this.club_id = club_id;
		this.cantidad = cantidad;
		this.cotizacion = cotizacion;
		this.club = club;
	}
	
	@Override
	public String toString() {
		String ret = "jugador ID: "+jugador_id;
		ret = ret + ", club_id: " + club_id;
		ret = ret + ", club: " + club;
		ret = ret + ", cantidad: " + cantidad;
		ret = ret + ", cotizacion: " + cotizacion;
		return ret;
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
	public Integer getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Integer cotizacion) {
		this.cotizacion = cotizacion;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
}