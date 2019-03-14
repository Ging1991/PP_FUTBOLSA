package com.caballero.futbolsa.persistencia.pojos;

import java.sql.Date;

public class Cotizacion {
	private Integer club_id, precio;
	private Date fecha;
	
	public Cotizacion(Integer club_id, Integer precio, Date fecha) {
		this.club_id = club_id;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		String ret = "club ID: "+club_id;
		ret = ret + ", precio: " + precio;
		ret = ret + ", fecha: " + fecha;
		return ret;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}