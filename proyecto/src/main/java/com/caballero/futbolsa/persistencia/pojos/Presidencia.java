package com.caballero.futbolsa.persistencia.pojos;

import java.sql.Date;

public class Presidencia {
	private Integer club_id, presidente;
	private Date fecha_inicio, fecha_fin;

	public Presidencia(Integer club_id, Integer presidente, Date fecha_inicio, Date fecha_fin) {
		super();
		this.club_id = club_id;
		this.presidente = presidente;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	@Override
	public String toString() {
		String ret = "club ID: "+club_id;
		ret = ret + ", presidente: " + presidente;
		ret = ret + ", inicio: " + fecha_inicio;
		ret = ret + ", fin: " + fecha_fin;
		return ret;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public Integer getPresidente() {
		return presidente;
	}

	public void setPresidente(Integer presidente) {
		this.presidente = presidente;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

}