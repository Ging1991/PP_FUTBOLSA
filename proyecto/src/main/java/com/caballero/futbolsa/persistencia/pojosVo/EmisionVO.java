package com.caballero.futbolsa.persistencia.pojosVo;

public class EmisionVO {
	private Integer club_id, emision, cotizacion;
	private String club;
	
	public EmisionVO(Integer club_id, Integer emision, Integer cotizacion, String club) {
		this.club_id = club_id;
		this.emision = emision;
		this.cotizacion = cotizacion;
		this.club = club;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public Integer getEmision() {
		return emision;
	}

	public void setEmision(Integer emision) {
		this.emision = emision;
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