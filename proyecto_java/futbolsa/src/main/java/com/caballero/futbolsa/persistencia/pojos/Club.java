package com.caballero.futbolsa.persistencia.pojos;

public class Club {
	private Integer club_id;
	private String nombre;
	
	public Club(Integer club_id, String nombre) {
		this.club_id = club_id;
		this.nombre = nombre;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}