package com.caballero.futbolsa.persistencia.pojos;

public class Notificacion {
	private Integer notificacion_id, jugador_id, noticia_id;

	public Notificacion(Integer notificacion_id, Integer jugador_id, Integer noticia_id) {
		this.notificacion_id = notificacion_id;
		this.jugador_id = jugador_id;
		this.noticia_id = noticia_id;
	}

	@Override
	public String toString() {
		return "Notificacion_id = "+notificacion_id+", Jugador_id = "+jugador_id+", Noticia_id = "+noticia_id;
	}

	public Integer getNotificacion_id() {
		return notificacion_id;
	}

	public void setNotificacion_id(Integer notificacion_id) {
		this.notificacion_id = notificacion_id;
	}

	public Integer getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(Integer jugador_id) {
		this.jugador_id = jugador_id;
	}

	public Integer getNoticia_id() {
		return noticia_id;
	}

	public void setNoticia_id(Integer noticia_id) {
		this.noticia_id = noticia_id;
	}

}