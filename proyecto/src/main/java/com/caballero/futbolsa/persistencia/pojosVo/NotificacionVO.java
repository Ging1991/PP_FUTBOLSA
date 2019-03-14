package com.caballero.futbolsa.persistencia.pojosVo;

import java.sql.Date;

public class NotificacionVO {
	private Integer notificacion_id, jugador_id, noticia_id;
	private String jugador, contenido;
	private Date fecha;

	public NotificacionVO(Integer notificacion_id, Integer jugador_id, Integer noticia_id, String jugador,
			String contenido, Date fecha) {
		this.notificacion_id = notificacion_id;
		this.jugador_id = jugador_id;
		this.noticia_id = noticia_id;
		this.jugador = jugador;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "NotificacionVO [notificacion_id=" + notificacion_id + ", jugador_id=" + jugador_id + ", noticia_id="
				+ noticia_id + ", jugador=" + jugador + ", contenido=" + contenido + ", fecha=" + fecha + "]";
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

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}