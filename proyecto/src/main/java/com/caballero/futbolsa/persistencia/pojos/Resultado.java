package com.caballero.futbolsa.persistencia.pojos;

public class Resultado {
	private Integer resultado_id, club_local, club_visitante, goles_local, goles_visitante;

	public Resultado(Integer resultado_id, Integer club_local, Integer club_visitante, Integer goles_local,
			Integer goles_visitante) {
		this.resultado_id = resultado_id;
		this.club_local = club_local;
		this.club_visitante = club_visitante;
		this.goles_local = goles_local;
		this.goles_visitante = goles_visitante;
	}
	
	@Override
	public String toString() {
		String ret = "[resultado_id = "+resultado_id+"] ";
		ret += "club_local = " + club_local + ", ";
		ret += "club_visitante = "+ club_visitante + ", ";
		ret += "goles_local = " + goles_local + ", ";
		ret += "goles_visitante=" + goles_visitante; 
		return ret;
	}

	public Integer getResultado_id() {
		return resultado_id;
	}

	public void setResultado_id(Integer resultado_id) {
		this.resultado_id = resultado_id;
	}

	public Integer getClub_local() {
		return club_local;
	}

	public void setClub_local(Integer club_local) {
		this.club_local = club_local;
	}

	public Integer getClub_visitante() {
		return club_visitante;
	}

	public void setClub_visitante(Integer club_visitante) {
		this.club_visitante = club_visitante;
	}

	public Integer getGoles_local() {
		return goles_local;
	}

	public void setGoles_local(Integer goles_local) {
		this.goles_local = goles_local;
	}

	public Integer getGoles_visitante() {
		return goles_visitante;
	}

	public void setGoles_visitante(Integer goles_visitante) {
		this.goles_visitante = goles_visitante;
	}
		
}